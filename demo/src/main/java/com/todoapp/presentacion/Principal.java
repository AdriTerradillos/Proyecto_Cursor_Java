package com.todoapp.presentacion;

import com.todoapp.modelo.negocio.GestorTareas;
import com.todoapp.modelo.entidad.Tarea;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.todoapp.configuracion.ConfiguracionApp;
import java.util.List;


//Clase principal
public class Principal {

    public static void main(String[] args) {
        //Contexto de la aplicacion
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfiguracionApp.class);
        //Gestor de tareas
        GestorTareas gestor = context.getBean("gestorTareas", GestorTareas.class);

        List<Tarea> tareas = gestor.listarTodas();
        System.out.println("📋 Lista de tareas cargadas:\n");

        for (Tarea t : tareas) {
            System.out.println(t);
        }
    }
}

