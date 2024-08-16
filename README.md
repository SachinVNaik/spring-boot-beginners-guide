# spring-boot-beginners-guide
A project containing basic and simple beginners guide for spring boot

# Using DTOs (Data Transfer Objects)
## How to send json response from a controller
Using the dto (data transfer objects) makes it easy to send the json response from any controller.<br>
Create a dto class with desired fields that required in response, for Ex: [Greet](./src/main/java/com/stormbreaker/mark85/dto/Greet.java) dto written here, Make sure your dto classes implements [Serializable](https://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html) interface.<br>
And this dto is used in the controller [HelloController](./src/main/java/com/stormbreaker/mark85/controller/HelloController.java), upon making a rest call this will return json output like below.

Example request
```shell
curl <host>:<port>/api/v1/greet
```

Example response
```json
{
  "status": 200,
  "message": "You are welcome here"
}
```