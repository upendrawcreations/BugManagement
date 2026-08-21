package com.cineflow.bug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BugManagementApplication {
  public static void main(String[] args) { SpringApplication.run(BugManagementApplication.class, args); }
}
