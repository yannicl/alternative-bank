package com.alternative.bank;

import com.alternative.bank.objets.ProduitDetenu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class PortraitFinancierStoreApplication {

	private static Logger log = LoggerFactory.getLogger(PortraitFinancierStoreApplication.class);

	PortraitFinancierStoreApplication(PortraitFinancierRepository repository) {

		ProduitDetenu produitDetenu1 = new ProduitDetenu();
		produitDetenu1.setCodeProduit("EOP");
		produitDetenu1.setDateAcquisition(new Date());
		produitDetenu1.setUsager(1);

		ProduitDetenu produitDetenu2 = new ProduitDetenu();
		produitDetenu2.setCodeProduit("CHR");
		produitDetenu2.setDateAcquisition(new Date());
		produitDetenu2.setUsager(1);

		repository.save(produitDetenu1);
		repository.save(produitDetenu2);

	}

	public static void main(String[] args) {
		SpringApplication.run(PortraitFinancierStoreApplication.class, args);
		log.info("Portrait financier store started");
	}
}
