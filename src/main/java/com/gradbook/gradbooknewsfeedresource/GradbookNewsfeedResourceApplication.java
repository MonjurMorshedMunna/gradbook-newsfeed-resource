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
public class GradbookNewsfeedResourceApplication {


	public static void main(String[] args) {
		SpringApplication.run(GradbookNewsfeedResourceApplication.class, args);
	}
}
