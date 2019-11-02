FROM openjdk:11.0.5-jdk-slim-buster
COPY target/quick-facts-thorntail.jar .
# Es importante el flag -Djava.net.preferIPv4Stack=true para indicarle a la JVM
# que se estara ejecutando sobre un contenedor
ENTRYPOINT java  -Djava.net.preferIPv4Stack=true -jar ./quick-facts-thorntail.jar
