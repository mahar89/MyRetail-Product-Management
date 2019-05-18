package com.myretail.productmanagement;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log4j2
public class ProductManagementApp {

  public static void main(String[] args) {

    log.info("Initializing the Product Core Service");
    try {
      SpringApplication.run(ProductManagementApp.class, args);
      log.info("Product Core Service is up and running");

    } catch (Throwable t) {
      log.error("Failed to start the Product Core Service", t);
      throw new RuntimeException(t);
    }
  }
}