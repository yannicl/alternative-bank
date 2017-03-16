package com.alternative.bank.usagers;

import com.alternative.bank.objets.Usager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class UsagersStoreApplication {

	UsagersStoreApplication(UsagersRepository repository) {
		Usager user1 = new Usager();
		user1.setUsername("user1");
		user1.setPassword("passwd1");
		repository.save(user1);
	}

	public static void main(String[] args) {
		SpringApplication.run(UsagersStoreApplication.class, args);
	}
}
