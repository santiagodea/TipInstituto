FROM node:12-alpine
RUN mkdir -p /usr/src/client
COPY . /usr/src/client
WORKDIR /usr/src/client
RUN npm install
EXPOSE 3000
CMD ["npm", "start"]

