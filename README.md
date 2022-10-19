# Currency-converter

This application does the following
  * Quartz Scheduler - It fetches currency exchange rate from external API to local map in every hour.
  * REST Endpoint exposes to get the exchange rate 

## Prerequisite
Following tools required,
 * java 17
 * Maven 3.8

## Unit test
 ``` 
 mvn clean install
 mvn clean test
 ```

 ## API 

```
mvn spring-boot:run
```


 ### Using postman

 ``` 
 http://localhost:8080//exchange_amount
 ```
 Request :
```
{
    "from":"EUR",
    "to":"USD",
    "amount":"1"
}
```
Response:

```
{
    "from":"EUR",
    "to":"USD",
    "amount":"0.9",
    "rate":"0.9"
}
```

* For invalid input it returns `Invalid Input`



