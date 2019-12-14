package com.atps.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * this is theconfiguration for restTemplate
 * @Dipak
 *
 */
@Configuration
public class RestTempolateConfiguration {

	@Bean
	public RestTemplate buildRestTemplate() {
		return new RestTemplate();
	}
}
