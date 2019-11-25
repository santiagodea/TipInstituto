FROM tomcat:8.0.51-jre8-alpine
CMD ["mvn","clean","install"]
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/Crud-instituto-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war


# ENV MONGO_URL="mongodb://mongo:27017/inst"
# RUN mkdir -p /usr/src/server
# COPY ./server /usr/src/server
# WORKDIR /usr/src/server
# RUN npm install
# EXPOSE 4200
# CMD ["npm", "start"]

