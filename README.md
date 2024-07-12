# Hospital Veterinario

Este proyecto es una API REST para gestionar un hospital veterinario, que incluye funcionalidades para la gestión de mascotas e ingresos.

## Requisitos

- Java 11 o superior
- Spring Boot
- Maven
- Base de datos H2 (incluida en el proyecto para facilidad de uso)

## Instalación

1. Clona el repositorio:

   ```bash
   git clone https://github.com/tuusuario/hospital-veterinario.git
   cd hospital-veterinario

   
´´´
2. mvn clean install
3. mvn spring-boot:run


## Uso

Endpoints
La API expone los siguientes endpoints para la gestión de mascotas e ingresos:

* Mascota
  1. POST /mascota

    - Guarda una nueva mascota.
    - Se debe añadir un JSON con este formato:
      ```
      {
        "especie": "Gato",
        "raza": "Persa",
        "edad": 3,
        "codigoIdentificacion": "12345",
        "dniResponsable": "11133333A",
      }
    ´´´


      
  2. GET /mascota/{idMascota}

    - Busca una mascota por su ID.
    - Parámetros: idMascota - ID de la mascota a buscar.

  3. DELETE /mascota/{idMascota}

    - Elimina una mascota por su ID.
    - Parámetros: idMascota - ID de la mascota a eliminar.

  4. GET /mascota/{idMascota}/ingreso

    - Obtiene los ingresos de una mascota por su ID.
    - Parámetros: idMascota - ID de la mascota cuyos ingresos se desean obtener.

* Ingreso

  1. GET /ingreso
    - Devuelve una lista de todos los ingresos registrados
      
