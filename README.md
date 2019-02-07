Mattp
==================

Mattp is a simple http client library that focuses on simplicity.

It is best used when not every single feature of HTTP is needed, but 
rather when simple calls need to be done in a clean manner.


### Features
* Auto retrying
* Support for request methods: GET, HEAD, OPTION, TRACE, POST, PUT, DELETE, PATCH

### Example usage
```
MattpRequest mattpRequest = new MattpRequest("http://example.com/userEndpoint", MattpMethod.POST);
MattpRequestEnvoy<User> envoy = new MattpRequestEnvoy<>(
    mattpRequest,
    new MattpSerializedObjectReader<>(new UserSerializer())
);

RequestResponse<PovMatch> response = envoy.send();
response.throwExceptionIfFailed("failed to fetch pov match to record for version "+version);
Optional<User> user = response.getContent();
```


### What I learned
* The inner-workings of HTTP
* Using Optional<> for better API interfaces
