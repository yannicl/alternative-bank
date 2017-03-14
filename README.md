# alternative-bank
Une fausse banque pour explorer les technologies Spring Cloud et autres

L'infrastructure de la banque est découpée en microservice. Chaque "serveur" sera un containeur docker ou une instance spring-boot.

## Instances métiers
* gui (user interface)
  * sommaire (sommaire des produits acquis)
  * acquisition (acquisition de produits)
  * virement (virement entre les produits acquis ou depuis/vers un autre compte)
  * login
  
* portrait-financier-store (service de persistance des produits acquis)
* transactions-store (service de persistance des transactions)
* sommaire-service (service du sommaire)
  * read sur portrait-financier-store
  * read sur transactions-store
* acquisition-service (service d'acquisition de produits)
  * write sur transactions-store
  * write sur portrait-financier-store
* virement-service (service de virement)
  * write sur transactions-store
  
## Instances d'infrastructure
  
* config-server (serveur de configuration)
* log-server (serveur d'aggrégation des logs)
* mysql-server (db)
* redis-server (cache)
* oauth2-serveur (serveur d'autorisation)


## Objets d'affaire
* Usager
  * id
  * username
  * password
* PortraitFinancier = Liste{ProduitDetenu extends Produit}
* Produit
  * code de produit
* ProduitDetenu
  * id
  * usager_id
  * date d'acquisition
* Transaction
  * id
  * date de transaction
  * produit_detenu_id
  * montant (tous les montants sont en $, la devise unique de la banque)
  * solde_avant_transaction
  * solde_apres_transaction
