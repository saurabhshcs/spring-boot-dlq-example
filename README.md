# spring-boot-dlq-example
This application will contain simple an example of the basic configurations and producer along with consumer using RabbitMQ and DLQ Concept.

## What is DLQ
The dead-letter queue (or undelivered-message queue) is the queue to which messages are sent if they cannot be routed to their correct destination.

Messages are put on this queue when they cannot be put on the destination queue. For example, because the queue does not exist, or because it is full. Dead-letter queues are also used at the sending end of a channel, for data-conversion errors.

## Use cases
In microservices event driven architecture, we use dead letter queues for publishing messages for the error and exception scenarios. We can use any of the messaging queue application such as Apache Kafka, RabbitMQ, AWS SNS/SQS, AMQ or any other.

## Example - This springboot microservice is containing the problem statement that whenever user passed an employee salary in -ve integer value then application will throw an Invalid

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



