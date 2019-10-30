FROM node:12-alpine
ENV API_SERVER_URL="http://server:4400"
RUN mkdir -p /usr/src/client
COPY ./client /usr/src/client
WORKDIR /usr/src/client
RUN npm install
EXPOSE 3444
CMD ["npm", "start"]

