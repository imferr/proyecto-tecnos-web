# INTERNSHIP BACKEND Proyecto de Tecnologías Web

<div align="center">
    <img src="https://www.ovhcloud.com/sites/default/files/styles/text_media_horizontal/public/2021-09/ECX-1909_Hero_PostgreSQL_600x400%402x.png" alt="Logo" width="auto" height="100">
    <img src="https://miro.medium.com/v2/resize:fit:700/0*R60lnmJl4hanOBaJ.png" alt="Logo" width="auto" height="100">
</div>

## Documentación

La documentación de este proyecto se encuentra en el siguiente enlace: [Documentación Internship] (https://docs.google.com/document/d/1New43yZgYZLagiPTidPiOHPEdc70P9URpXEa2AsUDTY/edit?usp=sharing)

## Requerimientos

Para poder hacer correr el proyecto se necesita tener instalado lo siguiente:

- Java 17
- Maven 3.8.2
- PostgreSQL 13.4

## Configuración de la base de datos

Para poder hacer correr el proyecto se necesita tener una base de datos en PostgreSQL con el nombre de `bddinternship` y con el usuario `postgres` y contraseña `123456`. Si se desea cambiar estos valores se debe modificar el archivo `application.yaml` en la carpeta `src/main/resources`.

Continue con la configuración de la base de datos siguiendo los siguientes pasos:

1. Descargar la imagen de Docker PostgreSQL

    Asegúrese de tener Docker instalado en su sistema. Luego, abra una terminal y ejecute el siguiente comando para descargar la imagen de PostgreSQL:

    ```bash
    docker pull postgres
    ```
2. Crear y ejecutar el contenedor de Docker PostgreSQL

    Ejecute el siguiente comando para crear y ejecutar el contenedor de Docker:

    ```bash
    docker run --name internship -e POSTGRES_PASSWORD=123456 -d -p 5432:5432 postgres
    ```

    El comando anterior creará un contenedor de Docker con el nombre `internship` y la contraseña `123456`. Además, el comando mapeará el puerto `5432` del contenedor al puerto `5432` de su máquina local.

3. Acceder a la base de datos

    Ejecute el siguiente comando para acceder a la base de datos:

    ```bash
    docker exec -it internship psql -U postgres
    ```

    El comando anterior lo llevará al shell de PostgreSQL.

4. Crear la base de datos

    Ejecute el siguiente comando para crear la base de datos:

    ```bash
    CREATE DATABASE bddinternship;
    ```
    
    Luego, ingrese a la base de datos con el siguiente comando:

    ```bash
    \c bddinternship
    ```

5. Crear las tablas en la base de datos

    Dentro del proyecto encontrará una carpeta llamada `bdd` con un archivo llamado `bdd.sql`. Copie el contenido de este archivo y ejecútelo en el shell de PostgreSQL.

## Ejecutar el proyecto en Spring

1. Para construir el proyecto ejecute el siguiente comando:

    ```bash
    mvn clean package
    ```

2. Para ejecutar el proyecto ejecute el siguiente comando:

    ```bash
    mvn spring-boot:run
    ```
