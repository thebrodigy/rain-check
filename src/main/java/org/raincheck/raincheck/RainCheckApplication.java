package org.raincheck.raincheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RainCheckApplication {

    public static void main(String[] args) {
        SpringApplication.run(RainCheckApplication.class, args);
    }

}
