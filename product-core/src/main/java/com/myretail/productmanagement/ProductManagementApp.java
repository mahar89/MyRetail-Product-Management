package com.myretail.productmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class ProductManagementApp {

  public static void main(String[] args) {

    log.info("Initializing the Product Core Service");
    try {
      ConfigurableApplicationContext context = SpringApplication.run(ProductManagementApp.class, args);
      log.info("Product Core Service is up and running");

    } catch (Throwable t) {
      log.error("Failed to start the Product Core Service", t);
      throw new RuntimeException(t);
    }
  }
}