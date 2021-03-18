package com.sidd.football.footballrank.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class AppConfig {
	
	@Value("${footballapi.url}")
	public String footballApiUrl;
	
	@Value("${footballapi.APIkey}")
	public String apiKey;

}
