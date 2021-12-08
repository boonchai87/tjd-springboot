package com.thaiitwork.controller;

import com.thaiitwork.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/public")
public class PublicController {

    @GetMapping("/greeting")
    public String index(@RequestParam(name="name",required=false) String name, Model model){
        model.addAttribute("name",name);
        return "greeting";
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/testCors")
    //@ResponseBody
    public ResponseEntity<User> testCors() {
        User u = User.builder().email("neng87@gmail.com").build();
        return ResponseEntity.ok(u);
    }

    @GetMapping("/indexCors")
    public String indexCors(){
        return "public/indexCors";
    }


    @GetMapping("/version")
    public String version(){
        return "1.0.1";
    }

    // Login form with error
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login.html";
    }

    @GetMapping("/register")
    public String register(){
        return "";
    }

    @PostMapping("/doRegister")
    public String doRegister(){
        return "";
    }

    @GetMapping("/test")
    //@ResponseBody
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("testsss");
    }

    @GetMapping("/getEnv")
    //@ResponseBody
    public ResponseEntity<Map> getEnv() {
        return ResponseEntity.ok(System.getenv());
    }

    @GetMapping("/getProp")
    //@ResponseBody
    public ResponseEntity<Map> getProp() {
        return ResponseEntity.ok(System.getProperties());
    }

    //@Value("${spring.datasource.url}") // looking in yml success
    //@Value("#{systemProperties['sun.desktop']}") // get from system properties
    @Value("${JDBC_DATABASE_URL}")
    private String bar;

    @GetMapping("/getEnvironment")
    //@ResponseBody
    public ResponseEntity<String> getEnv2() {
        return ResponseEntity.ok(bar);
    }
}
