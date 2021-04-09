package com.example.cozycook.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.commons.dbcp2.BasicDataSource;

import java.net.URISyntaxException;

public class loginService {

  @Configuration
  public class MainConfig {

    @Bean
    public BasicDataSource dataSource() throws URISyntaxException {
      String dbUrl = System.getenv("JDBC_DATABASE_URL");
      String username = System.getenv("JDBC_DATABASE_USERNAME");
      String password = System.getenv("JDBC_DATABASE_PASSWORD");

      BasicDataSource basicDataSource = new BasicDataSource();
      basicDataSource.setUrl(dbUrl);
      basicDataSource.setUsername(username);
      basicDataSource.setPassword(password);

      return basicDataSource;
    }
  }
}
