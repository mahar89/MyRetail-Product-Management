package com.myretail.productmanagement.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

@Service
public class ProductPriceService {

  private final WireMockServer wireMockServer = new WireMockServer();

  @PostConstruct
  public void init() {
    wireMockServer.start();
    configureFor("localhost", 8080);
    stubFor(get(urlPathMatching("/product/[0-9]+/price"))
        .willReturn(aResponse()
            .withStatus(200)
            .withHeader("Content-Type", "application/json")
            .withBody("{\"value\": \"12.56\",  \"currency\": \"USD\"}")));
  }

  @PreDestroy
  public void destroy() {
    wireMockServer.stop();
  }
}
