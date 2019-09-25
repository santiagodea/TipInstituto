_Como yo no conozco la arquitectura que propone Swing (que parece incluir controllers, DTO, servicios y repositorios), te pido que hagas una lista de tareas necesarias para tener andando la persistencia de cursos hasta la API. O sea, qué clases tenés que tocar o agregar, y de qué se encarga cada una. Así puedo tener una idea del avance, y de qué mirar._

## Spring utiliza un modelo de capas, las cuales serian las siguiente:
* 1 - Repository -  _Encargado de persistir en la BD, contiene el CRUD_
* 2 - Model -  _contiene la asignación de tablas reales a clases con sus anotations_
* 3 - Service -  _donde debe colocar su lógica de negocios compleja_
* 4 - Controller -  _llama a la capa de servicio y devuelve lo que ésta nos retorne_
* 5 - DTO -  _Convierte JSON en Objetos_

# Tareas a realizar:
* refinado del modelo.              ✔
* creado del repository             ✔
* * Creado de DTOs                  ✔
    * creadode funciones e implementacion...  ✔

**PARA UN CURSO:**
* creado del service                ✔
    * agregado de funciones         ✔
        * implementar funciones     ✔

* CREADO DE TEST, pegandole directamente a los service ✔

* creado del controller            ✔
    * agregado de funciones        ✔
        * implementar funciones    ✔

* Agregado en el frontend de las clases necesarias para poder pegarle a la API ❌

**PARA EL RESTOD DE LAS CLASES (student, mark, payment, SC):**
* creado e implementados DTOs ✔
* creado e implementado Services ✔
* creado e implentado Controllers ✔

* CREADO DE TEST, pegandole directamente a los service para student ❌
* CREADO DE TEST, pegandole directamente a los service para mark ❌
* CREADO DE TEST, pegandole directamente a los service para payment ❌
* CREADO DE TEST, pegandole directamente a los service para studentCourse ❌

* Agregado en el frontend de las clases necesarias para poder pegarle a la API para STUDENT❌
* Agregado en el frontend de las clases necesarias para poder pegarle a la API para MARK❌
* Agregado en el frontend de las clases necesarias para poder pegarle a la API para PAYMENT❌
* Agregado en el frontend de las clases necesarias para poder pegarle a la API para SC❌