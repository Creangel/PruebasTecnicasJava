# Configuración de Swagger/OpenAPI

## Descripción

Se ha configurado Swagger/OpenAPI para documentar automáticamente la API REST de la aplicación. Esto proporciona una interfaz web interactiva para probar y documentar todos los endpoints.

## Dependencias Agregadas

### Maven Dependency
```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>
```

## Configuración Implementada

### 1. Clase de Configuración OpenAPI
**Archivo**: `src/main/java/com/creangel/pruebaTecnica/config/OpenApiConfig.java`

- Configuración de información de la API
- Metadatos del proyecto
- Información de contacto
- Licencia
- Servidores disponibles

### 2. Anotaciones en DTOs
- **`@Schema`**: Documenta campos con descripciones y ejemplos
- **Campos requeridos**: Marcados como `required = true`
- **Ejemplos**: Valores de ejemplo para cada campo

### 3. Anotaciones en Controladores
- **`@Tag`**: Agrupa endpoints por categoría
- **`@Operation`**: Describe cada operación
- **`@ApiResponses`**: Documenta códigos de respuesta
- **`@Parameter`**: Describe parámetros de entrada

### 4. Configuración de Propiedades
**Archivo**: `src/main/resources/application.properties`

```properties
# Configuración de Swagger/OpenAPI
springdoc.api-docs.path=/api-docs
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.swagger-ui.operationsSorter=method
springdoc.swagger-ui.tagsSorter=alpha
springdoc.swagger-ui.doc-expansion=none
springdoc.swagger-ui.display-request-duration=true
springdoc.swagger-ui.filter=true
springdoc.swagger-ui.try-it-out-enabled=true
springdoc.swagger-ui.request-snippets-enabled=true
springdoc.swagger-ui.response-snippets-enabled=true
```

## URLs de Acceso

### Swagger UI
```
http://localhost:8080/swagger-ui.html
```

### OpenAPI JSON
```
http://localhost:8080/api-docs
```

### OpenAPI YAML
```
http://localhost:8080/api-docs.yaml
```

## Características de la Documentación

### 1. Información de la API
- **Título**: API de Prueba Técnica
- **Descripción**: API REST para gestión de alumnos y materias
- **Versión**: 1.0.0
- **Contacto**: Equipo de Desarrollo
- **Licencia**: MIT License

### 2. Servidores Configurados
- **Desarrollo**: `http://localhost:8080`
- **Producción**: `https://api.creangel.com`

### 3. Endpoints Documentados

#### Alumnos (`/api/alumnos`)
- **Tag**: Alumnos
- **Descripción**: API para gestión de alumnos
- **Operaciones**: CREATE, READ, UPDATE, DELETE
- **Búsquedas**: Por nombre, apellido, email
- **Utilidades**: Contar, verificar existencia

#### Materias (`/api/materias`)
- **Tag**: Materias
- **Descripción**: API para gestión de materias
- **Operaciones**: CREATE, READ, UPDATE, DELETE
- **Búsquedas**: Por nombre, código
- **Utilidades**: Contar, verificar existencia, contar por créditos

### 4. Esquemas de Datos

#### AlumnoDTO
- `id`: Identificador único (Integer)
- `nombre`: Nombre del alumno (String, requerido)
- `apellido`: Apellido del alumno (String, requerido)
- `email`: Dirección de email (String, requerido)
- `fechaNacimiento`: Fecha de nacimiento (LocalDate, requerido)

#### MateriaDTO
- `id`: Identificador único (Integer)
- `nombre`: Nombre de la materia (String, requerido)
- `codigo`: Código único (String, requerido)
- `creditos`: Número de créditos (Integer, requerido)

## Funcionalidades de Swagger UI

### 1. Interfaz Interactiva
- **Try it out**: Permite probar endpoints directamente
- **Request/Response**: Muestra ejemplos de peticiones y respuestas
- **Validación**: Valida esquemas de entrada
- **Autenticación**: Preparado para futuras implementaciones

### 2. Organización
- **Agrupación por Tags**: Alumnos y Materias
- **Ordenamiento**: Por método HTTP y alfabético
- **Filtros**: Búsqueda rápida de endpoints
- **Expansión**: Control de visualización de detalles

### 3. Información Detallada
- **Códigos de Respuesta**: Documentados con descripciones
- **Parámetros**: Descripción de cada parámetro
- **Ejemplos**: Valores de ejemplo para testing
- **Modelos**: Esquemas de datos completos

## Ventajas de la Implementación

### 1. Documentación Automática
- **Sincronización**: La documentación se actualiza automáticamente con el código
- **Consistencia**: No hay discrepancias entre código y documentación
- **Mantenimiento**: Cambios en el código se reflejan inmediatamente

### 2. Testing Interactivo
- **Pruebas en Tiempo Real**: Endpoints se pueden probar desde la interfaz
- **Validación**: Verificación automática de esquemas
- **Debugging**: Facilita la identificación de problemas

### 3. Colaboración
- **Desarrolladores**: Documentación clara para nuevos integrantes
- **QA**: Facilita las pruebas de la API
- **Frontend**: Referencia clara para consumir la API

## Configuración Avanzada

### 1. Personalización de Swagger UI
```properties
# Ordenar operaciones por método HTTP
springdoc.swagger-ui.operationsSorter=method

# Ordenar tags alfabéticamente
springdoc.swagger-ui.tagsSorter=alpha

# No expandir operaciones por defecto
springdoc.swagger-ui.doc-expansion=none

# Mostrar duración de las peticiones
springdoc.swagger-ui.display-request-duration=true
```

### 2. Filtros y Búsqueda
```properties
# Habilitar filtros
springdoc.swagger-ui.filter=true

# Habilitar "Try it out"
springdoc.swagger-ui.try-it-out-enabled=true

# Habilitar snippets de petición
springdoc.swagger-ui.request-snippets-enabled=true

# Habilitar snippets de respuesta
springdoc.swagger-ui.response-snippets-enabled=true
```

## Uso Recomendado

### 1. Desarrollo
- Usar Swagger UI para probar endpoints durante el desarrollo
- Verificar que la documentación refleje los cambios realizados
- Utilizar ejemplos para validar esquemas de datos

### 2. Testing
- Usar la interfaz para pruebas manuales
- Validar respuestas y códigos de estado
- Probar casos edge y validaciones

### 3. Documentación
- Referencia para consumidores de la API
- Guía para nuevos desarrolladores
- Especificación técnica de la API

## Notas Importantes

1. **Acceso**: Swagger UI está disponible en `/swagger-ui.html`
2. **Seguridad**: No incluye autenticación por simplicidad
3. **Producción**: Considerar deshabilitar en entornos de producción
4. **Mantenimiento**: Las anotaciones deben mantenerse actualizadas
5. **Versionado**: La documentación se actualiza automáticamente con el código
