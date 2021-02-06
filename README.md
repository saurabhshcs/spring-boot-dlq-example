# spring-boot-dlq-example
This application will contain simple an example of the basic configurations and producer along with consumer using RabbitMQ and DLQ Concept.


## Build project
`./gradlew build`

## Run Project
`./gradlew bootRun`

## RabbitMQ URL
`http://localhost:15672`

## RabbitMQ Default Login credential
`user_name = guest` and `password=guest`

## Message Producer API endpoint

## Use Cases
## Positive Scenario
`http://localhost:8081/produce?empName=emp1&empId=emp001&salary=50`

## Negative or Error or Exception scenario
`http://localhost:8081/produce?empName=emp1&empId=emp001&salary=-50`



