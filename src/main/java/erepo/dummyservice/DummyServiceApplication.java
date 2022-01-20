package erepo.dummyservice;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@RestController
public class DummyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyServiceApplication.class, args);
    }

    @GetMapping("/hello")
    public String helloWorld() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("Correlation-id: {}", MDC.get("correlation-id"));
        return "Hello "+ auth.getName();
    }

}
