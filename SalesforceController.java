package com.example.salesforceintegration.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalesforceController {

    private final OAuth2RestTemplate restTemplate;

    @Value("${salesforce.instance-url}")
    private String salesforceInstanceUrl;

    public SalesforceController(OAuth2RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/api/salesforce/accounts")
    public String getSalesforceAccounts() {
        String url = salesforceInstanceUrl + "/services/data/v50.0/sobjects/Account";
        return restTemplate.getForObject(url, String.class);
    }
}
