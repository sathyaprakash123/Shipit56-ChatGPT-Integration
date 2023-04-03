package com.satconfluence.chatBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "com.satconfluence.POJO;com.satconfluence.chatBot")
public class ChatBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatBotApplication.class, args);
	}
	
	/*
	 * @Bean public Docket productApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage("com.satconfluence.chatBot")).build
	 * (); }
	 */

}
