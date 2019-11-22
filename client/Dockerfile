# build environment
FROM node:12.2.0-alpine as build
RUN mkdir -p /usr/src/client
COPY . /usr/src/client
WORKDIR /usr/src/client
ENV PATH /usr/src/client/node_modules/.bin:$PATH
RUN npm install --silent
#RUN npm install react-scripts@3.0.1 -g --silent
COPY . /usr/src/client
RUN npm run-script build

# production environment
FROM nginx:1.16.0-alpine
COPY --from=build /usr/src/client/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx/nginx.conf /etc/nginx/conf.d
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
