package com.toDoApp.configuracion;

// importo las clases NECESARIAS
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;


// genero la clase configuracionToDoApp con @Configuration y @ComponentScan
@Configuration
@ComponentScan("com.toDoApp")

public class configuracionToDoApp {
    
}
