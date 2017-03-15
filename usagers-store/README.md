curl http://localhos:8080/usagers

{
  "_embedded" : {
    "usagers" : [ ]
  },
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/usagers"
    },
    "profile" : {
      "href" : "http://localhost:8080/profile/usagers"
    }
  }
}

curl http://localhos:8080/usagers/search

{
  "_links" : {
    "findFirstByUsername" : {
      "href" : "http://localhost:8080/usagers/search/findFirstByUsername{?username}",
      "templated" : true
    },
    "self" : {
      "href" : "http://localhost:8080/usagers/search"
    }
  }
}

curl -X POST -H "Content-Type:application/json" -d '{"username": "user-1", "password": "pwd-1"}' localhost:8080/usagers

{
  "username" : "user-1",
  "password" : "pwd-1",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/usagers/1"
    },
    "usager" : {
      "href" : "http://localhost:8080/usagers/1"
    }
  }
}

curl http://localhost:8080/usagers/search/findFirstByUsername?username=user-1

{
  "username" : "user-1",
  "password" : "pwd-1",
  "_links" : {
    "self" : {
      "href" : "http://localhost:8080/usagers/1"
    },
    "usager" : {
      "href" : "http://localhost:8080/usagers/1"
    }
  }
}
