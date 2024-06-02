package com.example.inmemorycaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class InMemoryCachingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(InMemoryCachingDemoApplication.class, args);
    }

}
