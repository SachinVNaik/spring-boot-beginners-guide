# spring-boot-beginners-guide
A project containing basic and simple beginners guide for spring boot

# Response
## Using DTOs (Data Transfer Objects)
### How to send json response from a controller
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

# Request

## Accepting a request body in POST calls
if we have a defined the contract of the request we can create a request body class and use that in the controller.
<br> it's better to use a request body class rather a `JsonNode` object, reason being 
- request body classes makes the validation easy
- if there are unnecessary parameters which you are not expecting in the request body, requests can be rejected easily with bad request.
- using the request body class makes it easier to access those fields anywhere in the project.  

for example [AddEmployeeRequestBody](./src/main/java/com/stormbreaker/mark85/requestbody/AddEmployeeRequestBody.java) used in the [EmployeeController](./src/main/java/com/stormbreaker/mark85/controller/EmployeeController.java)
this also helps us add validation on the request parameters, as it's done for firstName, lastName and email.
make sure to use `@Validated` annotation when accepting the request body so that the validation constraints are applied.

example request looks like
```java
    @PostMapping("/employee")
    public ResponseEntity<?> saveEmployee(
        @Validated @RequestBody AddEmployeeRequestBody request
    ) {
        // Your logic here
    }
```
