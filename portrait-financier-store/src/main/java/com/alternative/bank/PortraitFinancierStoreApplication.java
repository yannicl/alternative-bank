package com.alternative.bank;

import com.alternative.bank.objets.ProduitDetenu;
import com.alternative.bank.objets.TransactionMonetaire;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootApplication
public class PortraitFinancierStoreApplication {

	private static Logger log = LoggerFactory.getLogger(PortraitFinancierStoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PortraitFinancierStoreApplication.class, args);
		log.info("Portrait financier store started");
	}



	PortraitFinancierStoreApplication(PortraitFinancierRepository repository, TransactionMonetaireRepository trxRepository) {

		creerTransactions(trxRepository);
		creerProduitDetenu(repository);
	}

	public void creerTransactions(TransactionMonetaireRepository trxRepository) {

		long solde = 0;

		for (int i= 0; i < 50; i++) {

			long montant = (i + 1) * 1200;

			TransactionMonetaire trx = new TransactionMonetaire();
			trx.setProduitDetenuId(51);
			trx.setSoldeAvantTrx(new BigDecimal(solde / 100.0));
			trx.setMontant(new BigDecimal(montant / 100.0));
			solde += montant;
			trx.setSoldeAprestrx(new BigDecimal(solde / 100.0));
			trx.setDate(new Date());

			trxRepository.save(trx);

		}

	}

	public void creerProduitDetenu(PortraitFinancierRepository repository) {

		ProduitDetenu produitDetenu1 = new ProduitDetenu();
		produitDetenu1.setCodeProduit("EOP");
		produitDetenu1.setDateAcquisition(new Date());
		produitDetenu1.setUsagerId(1);
		produitDetenu1.setSolde(new BigDecimal(9653.25));

		ProduitDetenu produitDetenu2 = new ProduitDetenu();
		produitDetenu2.setCodeProduit("CHR");
		produitDetenu2.setDateAcquisition(new Date());
		produitDetenu2.setUsagerId(1);
		produitDetenu2.setSolde(new BigDecimal(123000.00));

		repository.save(produitDetenu1);
		repository.save(produitDetenu2);

	}


}
