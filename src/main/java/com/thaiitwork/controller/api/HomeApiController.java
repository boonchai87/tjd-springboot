package com.thaiitwork.controller.api;

import com.thaiitwork.config.WebConfig;
import com.thaiitwork.dto.JwtRequest;
import com.thaiitwork.dto.JwtResponse;
import com.thaiitwork.model.User;
import com.thaiitwork.repository.UserRepository;
import com.thaiitwork.service.UserDetailsService;
import com.thaiitwork.util.JwtTokenUtil;
import com.thaiitwork.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class HomeApiController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) throws Exception {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        user.setUserRole(WebConfig.USER_ROLE);
        user.setStatus(Status.ENABLE);
        user.setUpdated(new Date());
        user.setCreated(new Date());
        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/authenticate")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUserName(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new JwtResponse(token);
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
