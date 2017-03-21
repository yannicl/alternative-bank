```
curl --header "Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE0OTAxMDYzNzUsInVzZXJfbmFtZSI6Imd1aSIsImF1dGhvcml0aWVzIjpbIlJPTEVfdXNhZ2Vycy1yZWFkIl0sImp0aSI6IjJmODA0MTc0LTJmNmItNDE4Ny05NzhkLTNiZjQ4ODlkMDQ0NiIsImNsaWVudF9pZCI6ImZlaWduIiwic2NvcGUiOlsibWljcm9zZXJ2aWNlcyJdfQ.Us09Rh1zqujeEKVAN-p78_S07nsKYrdw7pdH8_jqYl8" http://localhost:8871/usagers

{
  "_embedded" : {
    "usagers" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8871/usagers"
    },
    "profile" : {
      "href" : "http://localhost:8871/profile/usagers"
    }
  }
}


curl -X POST -H "Content-Type:application/json" -d '{"username": "user-1", "password": "pwd-1"}' localhost:8871/usagers

{
  "username" : "user-1",
  "password" : "pwd-1",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8871/usagers/1"
    },
    "usager" : {
      "href" : "http://localhost:8871/usagers/1"
    }
  }
}

curl http://localhost:8871/usagers/search


{
  "_links" : {
    "findFirstByUsername" : {
      "href" : "http://localhost:8871/usagers/search/findFirstByUsername{?username}",
      "templated" : true
    },
    "self" : {
      "href" : "http://localhost:8871/usagers/search"
    }
  }
}


curl http://localhost:8871/usagers/search/findFirstByUsername?username=user-1


{
  "username" : "user-1",
  "password" : "pwd-1",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8871/usagers/1"
    },
    "usager" : {
      "href" : "http://localhost:8871/usagers/1"
    }
  }
}
```
