
FROM maven:3.6.1-jdk-8 as maven_builder
ADD ./ /app
WORKDIR /app
RUN mvn clean install -DskipTests=true

FROM openjdk:8-jre-alpine
COPY --from=maven_builder /app/target/Crud-instituto-0.0.1-SNAPSHOT.war /usr/local/webapps/Crud-instituto-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/webapps/Crud-instituto-0.0.1-SNAPSHOT.war" ]
