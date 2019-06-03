# Inventory 
[![npm version](https://badge.fury.io/js/npm.svg)](https://badge.fury.io/js/npm)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

The following is a job qualification exercise which requires knowledge in the following technologies:

- Java
- Spring boot
- Swagger
- REST API/JSON
- Docker
- Angular 

## :rocket: Features

- [X] Need to write a spring-boot application with a REST controller, which expose a Swagger API catalog.
- [X] The application needs to expose the following APIs:
- List of inventory items list (item no, name, amount, inventory code)
- Read item details (by item no)
- Withdrawal quantity of a specific item from stock
- Deposit quantity of a specific item to stock
- Add item to stock
- Delete an item from stock  
- [X] Data should be persisted on H2 DB using JPA.
- [ ] Need to pack and run the application from docker.
- [ ] Need to send a link to GitHub for source and docker hub for docker image
- [X] Need to return the exercise in a week.
- [X] Bonus points for creating Angular pages which enable to create/read/update qty/delete item. 

## :gear: Setup

With [npm](https://npmjs.org/) installed, run

```
$ npm install
$ npm run webpack:build
```

## :computer: Usage

```
$ ./gradlew bootRun
```
Open [http://localhost:8080/](http://localhost:8080/)

## :bookmark_tabs: API
Open [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

## :page_facing_up: License
This software is licensed under the [MIT](https://github.com/nhn/tui.editor/blob/master/LICENSE)
