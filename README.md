# Fake Store API Integration with Database

## Descripción

Este proyecto es una implementación de una API que consume datos de productos desde la API pública de Fake Store (https://fakestoreapi.com), almacena esos datos en una base de datos y los expone a través de una API RESTful propia. La aplicación permite gestionar productos de manera eficiente, incluyendo operaciones como obtener productos, eliminarlos y gestionar sus detalles.

### Características principales:
- **Consumo de API externa**: Consume productos de la API pública Fake Store.
- **Persistencia en base de datos**: Almacena los productos obtenidos en una base de datos.
- **Exposición de productos**: Los productos son expuestos a través de una API REST.
- **Manejo de excepciones**: Implementación de un manejo de errores con excepciones personalizadas.
- **DTO (Data Transfer Objects)**: Utilización de DTOs para la transferencia de datos entre la capa de persistencia y la capa de presentación.
- **Mapeo de entidades**: Implementación de un Mapper para convertir entre objetos `Product` (entidad de base de datos) y `ProductDTO` (Data Transfer Object).

## Tecnologías utilizadas

- **Spring Boot**: Framework de desarrollo para crear aplicaciones Java basadas en Spring.
- **Kotlin**: Lenguaje de programación usado para implementar la API.
- **JPA (Java Persistence API)**: API para gestionar las operaciones de base de datos.
- **MYSQL Database**: Base de datos en memoria para almacenar los productos.
- **WebClient**: Para consumir la API externa de Fake Store.
- **REST API**: Para exponer los productos almacenados a través de un servicio RESTful.
- **Manejo de excepciones personalizadas**: Implementación de una clase `CustomException` para manejar errores específicos.

## Estructura del Proyecto


```bash
src/
├── main/
│   ├── kotlin/
│   │   ├── com/
│   │   │   ├── arielZarate/
│   │   │   │   ├── apiFakeStore/
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   └── ProductController.kt
│   │   │   │   │   ├── dto/
│   │   │   │   │   │   └── ProductDTO.kt
                        └── RatingDTO.kt
│   │   │   │   │   ├── entity/
│   │   │   │   │   │   └── Product.kt
│   │   │   │   │   ├── exception/
│   │   │   │   │   │   └── CustomException.kt
│   │   │   │   │   ├── mapper/
│   │   │   │   │   │   └── RatingMapper.kt
                        └── RatingMapper.kt
│   │   │   │   │   ├── repository/
│   │   │   │   │   │   └── ProductRepository.kt
│   │   │   │   │   ├── service/
│   │   │   │   │   │   ├── ApiService.kt
│   │   │   │   │   │   └── ProductService.kt
└── resources/
    ├── application.properties


```


### Descripción de las carpetas y archivos:
1. **controller**: Contiene los controladores REST para manejar las solicitudes HTTP.
    - `ProductController.kt`: Controlador que maneja las solicitudes de productos, como obtener y eliminar productos.

2. **dto**: Contiene los objetos `Data Transfer Object` (DTO), que son usados para la transferencia de datos entre las capas de la aplicación.
    - `ProductDTO.kt`: DTO que representa un producto con campos como `id`, `title`, `price`, etc.

3. **entity**: Contiene las entidades que representan los objetos de la base de datos.
    - `Product.kt`: Entidad JPA que mapea la tabla de productos en la base de datos.

4. **exception**: Contiene las clases de manejo de excepciones personalizadas.
    - `CustomException.kt`: Clase personalizada para el manejo de excepciones con mensajes detallados.

5. **mapper**: Contiene los mapeadores que convierten entidades en DTOs y viceversa.
    - `RatingMapper.kt`: Mapea objetos `Rating` entre la entidad y el DTO.

6. **repository**: Contiene los repositorios para interactuar con la base de datos.
    - `ProductRepository.kt`: Repositorio que extiende `JpaRepository` para manejar operaciones CRUD de productos.

7. **service**: Contiene la lógica de negocio de la aplicación.
    - `ApiService.kt`: Servicio que consume la API externa de Fake Store y guarda los productos en la base de datos.
    - `ProductService.kt`: Servicio que gestiona la lógica de los productos dentro de la aplicación.

## Endpoints disponibles

1. **GET /api**:
    - **Descripción**: Devuelve un mensaje de bienvenida.
    - **Respuesta**: `200 OK`
      ```json
      {
        "message": "Welcome a la api de products de fake store api"
      }
      ```

2. **GET /api/products**:
    - **Descripción**: Devuelve todos los productos almacenados en la base de datos.
    - **Respuesta**: `200 OK`
      ```json
      [
        {
          "id": 1,
          "title": "Product 1",
          "price": 29.99,
          "description": "Product description",
          "category": "electronics",
          "image": "https://example.com/image1.jpg",
          "rating": {
            "rate": 4.5,
            "count": 150
          }
        },
        ...
      ]
      ```

3. **DELETE /api/products/{id}**:
    - **Descripción**: Elimina un producto de la base de datos según su ID.
    - **Respuesta**:
        - `204 No Content` si el producto fue eliminado correctamente.
        - `404 Not Found` si el producto no se encuentra en la base de datos.

## Configuración de la base de datos

Este proyecto utiliza H2 como base de datos en memoria para almacenar los productos. Para configurar la base de datos, no es necesario hacer ninguna configuración adicional, ya que se encuentra configurada de forma predeterminada en el archivo `application.properties`.

### `application.properties`
```properties
spring.application.name=apiFakeStore

server.port=8082
#mysl
spring.datasource.url=jdbc:mysql://localhost:3306/fakestoreapi?useSSL=false&serverTimerZone=UTC
spring.datasource.username=root
spring.datasource.password=su_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

## JPA
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

##logs
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.show_sql=true

```

### intrucciones para ejecutar el proyecto
`
git clone <URL_DEL_REPOSITORIO>
cd <nombre_del_proyecto>
`

### compilar y ejecutar 
`./gradlew bootRun
`



## Acceder a la API: 
Una vez que el servidor esté en funcionamiento, puedes acceder a los 
endpoints definidos utilizando herramientas como Postman o cURL:
- GET http://localhost:8082/api/products para obtener todos los productos.
- DELETE http://localhost:8082/api/products/{id} para eliminar un producto por 
- GET http://localhost:8082/api/products/{id} para obtener un solo producto