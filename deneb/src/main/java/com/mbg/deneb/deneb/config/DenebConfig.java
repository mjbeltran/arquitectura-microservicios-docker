package com.mbg.deneb.deneb.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.mbg.deneb.deneb.services.SadrClient;

@Configuration
class DenebConfig {

	@Bean
	@RefreshScope
	SadrClient sadrClient(){
		return new SadrClient();
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}