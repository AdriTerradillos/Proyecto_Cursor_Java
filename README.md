# To-Do Application

## Descripción
Esta es una aplicación de gestión de tareas (To-Do) desarrollada en Java utilizando Spring Boot. La aplicación permite a los usuarios crear, leer, actualizar y eliminar tareas pendientes, organizándolas de manera eficiente.

## Tecnologías Utilizadas
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (para desarrollo)
- Maven
- Thymeleaf (para la interfaz web)

## Características Principales
- Crear nuevas tareas
- Marcar tareas como completadas
- Editar tareas existentes
- Eliminar tareas
- Filtrar tareas por estado
- Interfaz web intuitiva

## Cómo Ejecutar el Proyecto
1. Asegúrate de tener Java 17 instalado
2. Clona este repositorio
3. Navega al directorio del proyecto
4. Ejecuta `mvn spring-boot:run`
5. Abre tu navegador y visita `http://localhost:8080`

## Uso de Cursor como Asistente de IA
Cursor fue utilizado activamente en este proyecto para:
- Generar la estructura inicial del proyecto Spring Boot
- Implementar las funcionalidades CRUD
- Documentar el código automáticamente
- Detectar y corregir errores durante el desarrollo
- Optimizar el código existente
- Crear este archivo README.md

## Estructura del Proyecto
```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── todoapp/
│   │           ├── controllers/
│   │           ├── models/
│   │           ├── repositories/
│   │           ├── services/
│   │           └── TodoApplication.java
│   └── resources/
│       ├── static/
│       ├── templates/
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── todoapp/
```

## Contribución
Las contribuciones son bienvenidas. Por favor, abre un issue para discutir los cambios propuestos.

## Licencia
Este proyecto está bajo la Licencia MIT.
