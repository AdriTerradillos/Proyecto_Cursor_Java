# Todo App - Gestor de Tareas

## Dudas

- Etiquetas: al momento de incorporar cada etiqueta con su respectivo archivo (@Componnent, @Service, @Repository, @Bean) a proyecto Java SpringBoot, he tenido un pequeño "quebradero de cabeza" ya que no estaban integradas en las dependencias y he preguntado a IA cursor para que retoque y las integre en el prom.xml

- Errores de compilación: He utilizado otros apuntes del curso cmo plantilla para hacer estos proyectos. Al momento de finalizar, he estado dos horas comparando un archivo de git hub con este. Finalmente, he preguntado a Cursor AI y ha sido una solución simple. Cambiar de minúscula a mayúscula el nombre del archivo "Prioridad"...

- Dudas iniciales: Al momento de encarar el proyecto, he logrado no dejar llevar por la IA, dejándola en segundo plano. A través de los apuntes, he podido completar gran parte del trabajo.

- Mejor manejo de Proyecto_Cursor_Java: Al tener más fresco este lenguaje, he tenido algo menos de dudas que el 
Proyecto_Cursor_JavaScript.


## Descripción
Todo App es una aplicación de gestión de tareas desarrollada en Java que permite a los usuarios crear, completar y eliminar tareas. La aplicación implementa un sistema de prioridades y ofrece una interfaz intuitiva para la gestión de tareas pendientes.


## Tecnologías Utilizadas
- **Lenguaje**: Java
- **Framework**: Spring Boot
- **Patrón de Diseño**: MVC (Modelo-Vista-Controlador)
- **Gestión de Dependencias**: Maven


## Estructura del Proyecto
```
src/
└── main/
    └── java/
        └── com.toDoApp/
            ├── configuracion/
            │   └── configuracionToDoApp.java
            ├── modelo/
            │   ├── entidad/
            │   │   ├── Prioridad.java
            │   │   └── Tarea.java
            │   ├── negocio/
            │   │   └── GestorTareas.java
            │   └── persistencia/
            │       └── DaoTareas.java
            └── vista/
                └── VistaTareas.java
```

## Uso de Cursor
Este proyecto fue desarrollado utilizando Cursor, un IDE moderno que ofrece:
- Autocompletado inteligente
- Integración con control de versiones
- Depuración integrada
- Soporte para múltiples lenguajes
- Interfaz intuitiva para desarrollo ágil

## Características Principales
- Creación de tareas con título y descripción
- Sistema de prioridades (baja, media, alta)
- Marcado de tareas como completadas
- Eliminación de tareas
- Listado de tareas pendientes
- Ordenamiento por prioridad

## Requisitos
- Java 17 o superior
- Maven
- Spring Boot 3.x

## Instalación
1. Clonar el repositorio
2. Ejecutar `mvn install` para instalar dependencias
3. Ejecutar `mvn spring-boot:run` para iniciar la aplicación
