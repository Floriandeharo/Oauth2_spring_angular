package com.test.oauth2.backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class WebClientConfig {

	@Value("${spring.security.oauth2.resourceserver.opaque-token.introspection-uri}")
	private String introspectUri;
	
	@Bean
	public WebClient userInfoClient() {
		if (introspectUri == null || introspectUri.isEmpty()) {
            throw new IllegalArgumentException("The property 'spring.security.oauth2.resourceserver.opaque-token.introspect-uri' must be defined.");
        }
		return WebClient.builder().baseUrl(introspectUri).build();
	}
}
