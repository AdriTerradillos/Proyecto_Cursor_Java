package com.todoapp.configuracion;

//Importacion de las clases necesarias
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//Clase que configura la aplicacion de ToDoApp
@Configuration
@ComponentScan(basePackages = "com.todoapp")
public class ConfiguracionApp {
}