package com.example.jms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class JmsApplication {

  public static void main(String[] args) {
    SpringApplication.run(JmsApplication.class, args);
  }

}
