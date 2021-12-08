package com.thaiitwork.client;

import com.thaiitwork.model.User;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class UserWebClient {

    WebClient client = WebClient.create("http://localhost:8080");

    public void consume() {

        Mono<User> employeeMono = client.get()
                .uri("/userFlux/{id}", "1")
                .retrieve()
                .bodyToMono(User.class);

        //employeeMono.subscribe(System.out::println);

        Flux<User> employeeFlux = client.get()
                .uri("/userFlux")
                .retrieve()
                .bodyToFlux(User.class);

        employeeFlux.subscribe(System.out::println);
    }

    public static void main(String[] args) {
        UserWebClient employeeWebClient = new UserWebClient();
        employeeWebClient.consume();
    }
}
