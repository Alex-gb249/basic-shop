# Basic shop backend
## Alexis Guzmán Bermúdez - alexis.gb249@gmail.com

Este documento contiene toda la información necesaria para el proyecto.

## Arquitectura

Se empleó el patrón de diseño Controller, Service, Repository y Model. Patrón muy común en aplicaciones con Spring Boot, que podría ser visto como una variación del MVC, además de poder sufrir variaciones para enfocarlo aún más en el dominio.

Explicaré las responsabilidades de cada componente:

- **Controllers:** Estos se encargan de exponer nuestros 'Entry-points' a cualquier aplicación que pueda hacer uso de estos (Frontend otro backend, aplicaciones, etc.). En general, se encarga de contruir la respuesta, pero no del contenido como tal.
- **Services:** Estos se encargan de la comunicación con el repositorio, es ideal ubicar aquí toda la lógica del dominio, es decir, del negocio.
- **Repositories:** Estos se encargan de los métodos que interactuan directamente con la base de datos, es decir, todo lo que sea crear, leer, actualizar, eliminar, busquedas por filtro, etc.
- **Models:** Estos se encargan de la definición de la estructura de las entidades conceptuales y/o abstractas que hayan en el proyecto y que pueda requerir el dominio. 

Es **importante** destacar que en este proyecto se utiliza la librería **Spring Data JPA** y **Lombok**, las cuales fácilitan tareas tales como:

- En el caso de JPA:
    1. Creación de métodos en los repositorios.
    2. Creación de la base de datos, y tablas.
    3. Ejecución de los métodos.
- En el caso de Lombok:
    1. Creación de contructores.
    2. Creación de getters y setters
    3. Ejecución de logs.

## Notas importantes:
- El archivo **application.properties** en un proyecto real, no debería de estar en repositorio, puesto que contiene información sensible de acceso a base de datos, pero ya que este proyecto es una prueba, lo mantengo para efectos prácticos.