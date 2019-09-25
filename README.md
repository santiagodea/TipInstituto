# TIP - Tecnicatura En Programacion Informatica - UNQ - CIU(General Belgrano) 👨‍💻

_El proyecto consite en el desarrollo de un sistema para la administracion de un instituto, en el cual se deben poder visualizar/agregar y modificar cursos, inscribir alumnos a los cursos y poder registrar en un alumnos tanto las calificaciones como los pagos mensuales._

### Pre-requisitos 📋

_Java, npm, Eclipse_, MySQL


### Instalación 🔧

```
git clone https://github.com/santiagodea/TipInstituto
cd TipInstituto
npm install

```

## Deployment 📦

```
... ??

```

## Construido con 🛠️

## SERVER 💾
_Como esta en desarrollo podremos correrlo desde Eclipse_
_Instalar Spring Tool en Eclipse desde: Help – Eclipse Marketplace… - buscar: Spring Tools 4_
_luego importar el proyecto en Eclipse desde File - import..._

Se utilizara [MySql](https://dev.mysql.com/downloads/installer/) para persistir los datos.

para crear la base de datos correr los siguientes comandos:

Creo un usuario para la base de datos.

Luego en el archivo : \server\src\main\resources\application.properties corregir el **username** y la **password** que correspondan.

```
-- creo el schema
CREATE DATABASE `Tip-instituto` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;

-- selecciono schema
use 'Tip-instituto`;

```

hay un test para probar el creado y la consulta en la base.

para acceder a la base desde un JSON hay que correr el InstitutoApplication.java


* [MySql](https://dev.mysql.com/downloads/installer/)
* [Java](https://www.java.com/es/) con [Eclipse](https://www.eclipse.org)
* [Hibernate](https://hibernate.org/)
* [Spring Boot](https://spring.io/projects/spring-boot)
* [Maven](https://maven.apache.org/)

## CLIENTE 💻

```
npm start

```
_http://localhost:3000_

#### Tecnologias 📲
* [JavaScript](https://www.javascript.com/)
* [React](https://es.reactjs.org/)
* [Bootstrap](https://getbootstrap.com/)
* [HTML](https://developer.mozilla.org/es/docs/HTML/HTML5/HTML5_lista_elementos)
* [CSS](https://www.w3schools.com/css/)
* [NodeJS](https://nodejs.org/es/)

#### Librerias 📚
* [Light Bootstrap Dashboard React](https://www.creative-tim.com/product/light-bootstrap-dashboard-react)
_(FREE BOOTSTRAP REACT ADMIN TEMPLATE)_
* [Axios](https://www.npmjs.com/package/axios)
* [Express](https://www.npmjs.com/package/express)
* [Alert](https://www.npmjs.com/package/react-alert)
* [Router](https://www.npmjs.com/package/router)
* [Nodemon](https://www.npmjs.com/package/nodemon)
* etc...

## Issues 📝

* [Trello](https://trello.com/b/OBJgheWj/tip)
* [Tareas a realizar y/o pendientes](https://github.com/santiagodea/TipInstituto/blob/master/Documentacion-Apuntes/Tareas%20a%20Realizar%20API.md)

## Autor ✒️

* **Santiago De Andrea** - [santiagodea](https://github.com/santiagodea) 😎


## Licencia 📄

Este proyecto es realizado para la presentacion del trabajo final correspondiente a la carrera Tecnicatura en Programacion Informatica.
* [**CIU**](https://www.facebook.com/centrointer.universitario) 🏫
* [**UNQ**](http://www.unq.edu.ar/) 🎓



