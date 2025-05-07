package com.call.api.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Application-level configuration class for defining Spring beans.
 */
@Configuration
public class AppConfig {

    /**
     * Defines a RestTemplate bean that can be injected wherever HTTP requests
     * need to be made to external services.
     *
     * RestTemplate is a synchronous client to perform HTTP requests
     * and consume responses from a RESTful web service.
     *
     * @return a configured RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
