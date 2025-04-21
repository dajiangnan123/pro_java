package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class Main {
    /**
     * docker-compose up -d
     * docker ps
     * docker-compose down
     * docker exec -it xxx /bin/bash
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
