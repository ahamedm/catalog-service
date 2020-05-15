# catalog-service
Sample Simple Microservice

## SpringBoot Service
- Configuration
    - Refer `application.properties`
	- Default DB is H2
	- Event dispatch can be disabled with `event.sink=false`
- Tests
	- Unit Tests - `mvn test`
	- Integration Tests - `mvn verify`
		- Application Profile for tests is `itest`
		- Use spring-contract-stubrunner, with stubs for domain-evt-dispatch-service service

_Note_: Skip Tests with `-DskipTests` , `-Dit.skip=true`

## Dependencies
domain-evt-dispatch-service
