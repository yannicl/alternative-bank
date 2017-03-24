package com.alternative.bank.gui;

import com.alternative.bank.api.oauth2.OAuth2TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.o;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan( basePackages = {"com.alternative.bank.gui", "com.alternative.bank.api.oauth2", "com.alternative.bank.api.usagers"})
public class GuiApplication {


	public static void main(String[] args) {

		ConfigurableApplicationContext app = SpringApplication.run(GuiApplication.class, args);

		OAuth2TokenService oAuth2TokenService = (OAuth2TokenService)app.getBean("oAuth2TokenService");
		oAuth2TokenService.initializeTemplate();
	}
}
