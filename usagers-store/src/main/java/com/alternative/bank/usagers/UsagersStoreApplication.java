package com.alternative.bank.usagers;

import com.alternative.bank.objets.Usager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
public class UsagersStoreApplication {

	private static Logger log = LoggerFactory.getLogger(UsagersStoreApplication.class);

	UsagersStoreApplication(UsagersRepository repository) {
		Usager user1 = new Usager();
		user1.setId(1);
		user1.setUsername("user1");
		user1.setPassword("79e262a81dd19d40ae008f74eb59edce"); // passwd is passwd1 in md5
		repository.save(user1);
	}

	public static void main(String[] args) {
		SpringApplication.run(UsagersStoreApplication.class, args);
		log.info("Usagers store started");
	}
}
