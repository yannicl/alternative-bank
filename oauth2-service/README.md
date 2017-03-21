curl -XPOST -k feign:feignsecret@localhost:8899/oauth/token \
  -d grant_type=password -d client_id=feign -d client_secret=feignsecret \
  -d username=gui -d password=guisecret

{"access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTAxMDYzNzUsInVzZXJfbmFtZSI6Imd1aSIsImF1dGhvcml0aWVzIjpbIlJPTEVfdXNhZ2Vycy1yZWFkIl0sImp0aSI6IjJmODA0MTc0LTJmNmItNDE4Ny05NzhkLTNiZjQ4ODlkMDQ0NiIsImNsaWVudF9pZCI6ImZlaWduIiwic2NvcGUiOlsibWljcm9zZXJ2aWNlcyJdfQ.Us09Rh1zqujeEKVAN-p78_S07nsKYrdw7pdH8_jqYl8","token_type":"bearer","expires_in":43199,"scope":"microservices","jti":"2f804174-2f6b-4187-978d-3bf4889d0446"}