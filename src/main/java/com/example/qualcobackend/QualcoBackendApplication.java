package com.example.qualcobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * QualcoBackendApplication--2
 */
@SpringBootApplication
@EnableCaching
public class QualcoBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(QualcoBackendApplication.class, args);
  }

}
