# Service send Simple E-mail 

## Table of Contents

- [About](#about)
- [Getting Started](#getting_started)
- [Usage](#usage)

## About <a name = "about"></a>

This project is a Spring Boot service REST of sending e-mail and implemented using Apache Artemis MQ for to queue the message and posteriorly send to server (in case gmail) by through the endpoint -> http://localhost:8080/ and verb POST with follow object:
{
  "recipient": "[Target]",
  "subject": "[subject]"
  "msgBody": "[Body]",
}

The follow image explain better the architecture of service:

![alt text](https://github.com/felipeschirmann/simple-email-artemismq/blob/323be07fc6d12a2675014add7b5537422e218a2a/img/architecture.png?raw=true)

## Getting Started <a name = "getting_started"></a>

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

Configure env vars in file application.properties and compile and run as a spring application.

### Prerequisites

- Server with Apache ActiveMQ 
- Account of E-mail for send e-mail(SMTP)

