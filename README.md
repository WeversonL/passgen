# PassGen

Password generator made in Java and Spring Boot

Project created to practice the programming language using Spring Boot and its tools

## Requirements

1. [Java](https://www.java.com/)
2. [Docker](https://docs.docker.com/engine/install/) and [Docker-Compose](https://docs.docker.com/compose/)

## Get Started

To save passwords in the database, I chose to use Docker for knowledge purposes, so docker ends up being a dependency
A compiled Jar file has been included in the repository. Make sure you have Java installed on your machine

1. Clone the repository or download the source code

        git clone https://github.com/WeversonL/passgen.git
        cd passgen

2. Start the MySQL container with the following command

        docker-compose up -d

3. Run the jar file

        java -jar passgen.jar

4. If you want to change the code, and compile the Jar file. Follow the following steps

        mvn package
        mvn install
        java -jar target/passgen-*.jar