
FROM maven:3.6.1-jdk-8 as maven_builder
ADD ./ /app
WORKDIR /app
RUN mvn clean install

FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=maven_builder target/Crud-instituto-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/Crud-instituto-0.0.1-SNAPSHOT.war
ENTRYPOINT [ "sh", "-c", "java -Dspring.profiles.active=docker -Djava.security.egd=file:/dev/./urandom -jar /usr/local/tomcat/webapps/Crud-instituto-0.0.1-SNAPSHOT.war" ]