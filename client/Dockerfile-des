FROM node:12.2.0-alpine
RUN mkdir -p /usr/src/client
COPY . /usr/src/client
WORKDIR /usr/src/client
ENV PATH /usr/src/client/node_modules/.bin:$PATH
RUN npm install
EXPOSE 3000
CMD ["npm", "start"]

