# Prueba Técnica Java - Spring Boot

## Descripción
Aplicación de demostración desarrollada con Spring Boot para pruebas técnicas.

## Tecnologías Utilizadas
- Java 17
- Spring Boot 3.5.4
- Spring Data JPA
- MySQL
- Maven

## Configuración de la Base de Datos

### 1. Variables de Entorno
Configura las siguientes variables de entorno en tu sistema:

```bash
export DB_URI="jdbc:mysql://localhost:3306/prueba_tecnica?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true"
export DB_USER="tu_usuario"
export DB_PASSWORD="tu_password"
export DB_DRIVER="com.mysql.cj.jdbc.Driver"
```

### 2. Crear Base de Datos
```sql
CREATE DATABASE prueba_tecnica CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. Configuración de Desarrollo
Para desarrollo, puedes usar el archivo `application-dev.properties` que incluye:
- Configuración de base de datos local
- DDL automático (create-drop)
- Inicialización automática de datos
- Logging detallado de SQL

## Modelos de Datos

### Alumno
- Gestión de estudiantes del sistema
- Campos: id, nombre, apellido, email, fechaNacimiento
- Relación: One-to-Many con Nota

### Materia
- Asignaturas o cursos disponibles
- Campos: id, nombre, codigo, creditos
- Relación: One-to-Many con Nota

### Nota
- Calificaciones de los alumnos en las materias
- Campos: id, valor, fechaRegistro, alumno, materia
- Relaciones: Many-to-One con Alumno y Materia

## Estructura de Archivos

```
src/main/java/com/creangel/pruebaTecnica/
├── model/
│   ├── Alumno.java
│   ├── Materia.java
│   └── Nota.java
└── PruebaTecnicaApplication.java

src/main/resources/
├── application.properties
├── application-dev.properties
├── schema.sql
└── data.sql
```

## Esquema de Base de Datos

### Tabla Alumno
```sql
CREATE TABLE Alumno (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellido VARCHAR(100),
    email VARCHAR(150),
    fecha_nacimiento DATE
);
```

### Tabla Materia
```sql
CREATE TABLE Materia (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    codigo VARCHAR(20),
    creditos INT
);
```

### Tabla Nota
```sql
CREATE TABLE Nota (
    id INT AUTO_INCREMENT PRIMARY KEY,
    valor DECIMAL(3,1),
    fecha_registro DATE,
    id_alumno INT,
    id_materia INT,
    FOREIGN KEY (id_alumno) REFERENCES Alumno(id),
    FOREIGN KEY (id_materia) REFERENCES Materia(id)
);
```

## Ejecución

### 1. Compilar el proyecto
```bash
mvn clean compile
```

### 2. Ejecutar la aplicación
```bash
mvn spring-boot:run
```

### 3. Con perfil de desarrollo
```bash
mvn spring-boot:run -Dspring.profiles.active=dev
```

## Características

- **JPA/Hibernate**: Mapeo objeto-relacional automático
- **DDL Automático**: Las tablas se crean automáticamente al iniciar
- **Datos de Ejemplo**: Inicialización automática con datos de prueba
- **Relaciones**: Mapeo de relaciones entre entidades (One-to-Many, Many-to-One)
- **Auditoría**: Fechas de registro automáticas
- **Validaciones**: Restricciones de base de datos y claves foráneas

## Datos de Ejemplo

La aplicación incluye datos de ejemplo:
- 5 materias (Matemáticas, Física, Programación Java, Base de Datos, Inglés Técnico)
- 5 alumnos con información personal
- 15 notas distribuidas entre alumnos y materias

## Notas Importantes

- La aplicación está configurada para crear las tablas automáticamente (`ddl-auto=update`)
- Los datos de ejemplo se insertan automáticamente al iniciar
- El esquema incluye índices para optimizar consultas frecuentes
- Las relaciones están configuradas con fetch lazy para optimizar el rendimiento
