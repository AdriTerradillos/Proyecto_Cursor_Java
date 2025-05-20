package com.todoapp.modelo.negocio;

import com.todoapp.modelo.persistencia.DaoTareas;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DaoTareasConfig {
    @Bean
    public DaoTareas daoTareas() {
        return new DaoTareas("tareas.dat");
    }
} 