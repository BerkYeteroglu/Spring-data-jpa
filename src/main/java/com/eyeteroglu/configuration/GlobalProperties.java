package com.eyeteroglu.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class GlobalProperties {
	
	@Value("${spring.datasource.url}") //application.properties de ne yazıyorsa tam olarak onu yazıyoruz
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
}
