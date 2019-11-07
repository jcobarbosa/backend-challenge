# Invillia recruitment challenge

[![Build Status](https://travis-ci.org/shelsonjava/invillia.svg?branch=master)](https://travis-ci.org/shelsonjava/invillia)

![Invillia Logo](https://invillia.com/public/assets/img/logo-invillia.svg)
[Invillia](https://https://www.invillia.com/) - A transformação começa aqui.

The ACME company is migrating their monolithic system to a microservice architecture and you’re responsible to build their MVP (minimum viable product)  .
https://en.wikipedia.org/wiki/Minimum_viable_product

Your challenge is:
Build an application with those features described below, if you think the requirements aren’t detailed enough please leave a comment (portuguese or english) and proceed as best as you can.

You can choose as many features you think it’s necessary for the MVP,  IT’S NOT necessary build all the features, we strongly recommend to focus on quality over quantity, you’ll be evaluated by the quality of your solution.

If you think something is really necessary but you don’t have enough time to implement please at least explain how you would implement it.

## Tasks

Your task is to develop one (or more, feel free) RESTful service(s) to:
* Create a **Store**
* Update a **Store** information
* Retrieve a **Store** by parameters
* Create an **Order** with items
* Create a **Payment** for an **Order**
* Retrieve an **Order** by parameters
* Refund **Order** or any **Order Item** [não detalhado se o item pode ser individualmente marcado com Status ou Flag de reembolso(estorno)]

Fork this repository and submit your code with partial commits.

## Business Rules

* A **Store** is composed by name and address
* An **Order** is composed by address, confirmation date and status
* An **Order Item** is composed by description, unit price and quantity.
* A **Payment** is composed by status, credit card number and payment date
* An **Order** just should be refunded until ten days after confirmation and the payment is concluded.

## Non functional requirements

Your service(s) must be resilient, fault tolerant, responsive. You should prepare it/them to be highly scalable as possible.

The process should be closest possible to "real-time", balancing your choices in order to achieve the expected
scalability.

## Nice to have features (describe or implement):
* Asynchronous processing - pela descrição dos requisitos, não há necessidade explicita de implementação de processos assíncronos, que são uma alternativa para possibilitar a utilização de forma otimizada de recursos do servidor (threads), que podem ficar presos mediante a necessidade do aguardo de processos ou eventos que demandam tempo ou alta carga de processamento. 
* Database - h2
* Docker - esta é com certeza uma das ferramentas mais práticas e poderosas nos dias atuais, onde a configuração de infra para aplicação pode ser facilmente compartilhada e "homogenizada" desde o desenvolvimento, ao ambiente de produção.
* AWS - não especificado como necessidade para deploy e integração. 
* Security - Spring Security com Basic Auth [Usuários/Senhas = user/userPass, admin/adminPass]
* Swagger - 2.0
* Clean Code
