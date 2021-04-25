# demo
This is a Login/Registration CRUD API with JWT

#### Instructions

form *application.properties* change:  
```
  spring.datasource.username=  
  spring.datasource.password=
  spring.datasource.url=  
```

port: 8080


### registration
Method : POST  
Mapping : "/register"  
Request Body :  
```
{  
    "firstName" : "firstName1",  
    "lastName" : "lastName1",  
    "password" : "password1",  
    "username" : "username1"  
}
```

Response Body :  
```
{
    "id": 1,  
    "firstName": "firstName1",  
    "lastName": "lastName1",  
    "username": "username1". 
}
```


### login
Method : POST  
Mapping : "/authenticate"  
Request Body :  
```
{
    "username" : "username1",  
    "password" : "password1"  
}
```  

Response Body :  
```
{
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VybmFtZTEiLCJleHAiOjE2MTkzNzUyNTUsImlhdCI6MTYxOTM1NzI1NX0.RlCnD1yHS8fU4mjK-P2PPc7dIkuvyxERWBrCLKDWCGH1nLUtU6dXU3bAgj6ir6q_KyUOJEPnrvMhuNFDqljcNw"
}
```


### update current users password 
Method : PUT  
Mapping : "/users/update-password"  
Authorization -> Bearer Token : "USERS TOKEN"  
Request Body :  
```
newpassword
```  
Response Body :  
```
firstName1 you have updated your password!
```



### get users firstName & lastName by username
Method : GET  
Mapping : "/users/{username}"  
Authorization -> Bearer Token : "USERS TOKEN"  
Response Body :  
```
firstName1 lastName1
```



### delete current user
Method : DELETE  
Mapping : "/users"  
Authorization -> Bearer Token : "USERS TOKEN"  
Response Body :  
```
username1 Bye-bye!
```


