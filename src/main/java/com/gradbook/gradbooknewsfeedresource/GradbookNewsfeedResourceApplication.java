package com.gradbook.gradbooknewsfeedresource;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableResourceServer
@SpringBootApplication
@RestController
public class GradbookNewsfeedResourceApplication {

	
	@RequestMapping("/resource/endpoint")
	public String endPoint(Principal principal){
		return "Hello "+principal.getName()+"! Welcome to our resource";
	}
	
	
	@Bean
	public RemoteTokenServices tokenService(){
		RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl("http://localhost:9090/oauth/check_token");
		tokenService.setClientId("gradbook");
		tokenService.setClientSecret("gradbook");
		return tokenService;
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(GradbookNewsfeedResourceApplication.class, args);
	}
}
