http://localhost:8872/

curl --header "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTA2MDAwOTEsInVzZXJfbmFtZSI6Imd1aSIsImF1dGhvcml0aWVzIjpbIlJPTEVfdXNhZ2Vycy1yZWFkIiwiUk9MRV9wb3J0cmFpdC1maW5hbmNpZXItcmVhZCJdLCJqdGkiOiI3YTE3ODAzNS0xYzE5LTQ0YTgtOTE0ZC04YWQwMDdkNTQzNWYiLCJjbGllbnRfaWQiOiJmZWlnbiIsInNjb3BlIjpbIm1pY3Jvc2VydmljZXMiXX0.i2SEOmoiMyJsPTsDsGb3_1E-ZUhWLyEKSh0z-QwlUsBVTOqK6fFNXsnLulArWv26cfBcFJMLjK3KhFPBNBww9BOCxYKv6Qs40y7SL7MNzkZRzJDcjgxvxTugREAjwO79XE4_BcOL0Kn0W00FDZEDRXNH14mw0JPzCAioP0X9aHlQ2H4N-VcB67zdWQIQXEOk7rAn00SqWuwEPBpWugnnz34RWkXH_GNnrK9zKSHQQ90g4B8mrB2E4zrq5hR2jE88FhaYBNLM4Lze_1eI56GXnOxyQpT-QU3tC6qeuM-QosyefPw4FXY18kE9RWWMT2NjaSjPmFIne0k2NF62dVmNDQ" http://localhost:8872/profile


DEMO

- Preparation, désactiver la sécurité dans module PortraitFinancierStoreOAuth2Configuration

curl -v "http://localhost:8872/usagers/1/detention"

- remarquer header application/hal+json
- remarquer _links

curl "http://localhost:8872/portraits/51/transaction"

Parler de la classe ProduitDetenuResource

Parler de TransactionMonetaireRepository