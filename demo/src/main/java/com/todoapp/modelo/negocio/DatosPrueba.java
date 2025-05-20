package com.todoapp.modelo.negocio;

import com.todoapp.modelo.entidad.Prioridad;
import com.todoapp.modelo.entidad.Tarea;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


//Clase que genera tareas de ejemplo
public class DatosPrueba {

    //Metodo que genera tareas de ejemplo
    public static List<Tarea> generarTareasEjemplo() {
        List<Tarea> tareas = new ArrayList<>();

        Tarea tarea1 = new Tarea();
        tarea1.setId(1);
        tarea1.setTitulo("Entregar informe mensual");
        tarea1.setDescripcion("Enviar informe al gerente.");
        tarea1.setFechaLimite(LocalDate.now().plusDays(2));
        tarea1.setPrioridad(Prioridad.ALTA);
        tarea1.setCategoria("Trabajo");

        Tarea tarea2 = new Tarea();
        tarea2.setId(2);
        tarea2.setTitulo("Comprar regalos");
        tarea2.setDescripcion("Regalos para el cumpleaños de Ana.");
        tarea2.setFechaLimite(LocalDate.now().plusDays(5));
        tarea2.setPrioridad(Prioridad.MEDIA);
        tarea2.setCategoria("Personal");

        Tarea tarea3 = new Tarea();
        tarea3.setId(3);
        tarea3.setTitulo("Organizar escritorio");
        tarea3.setDescripcion("Limpiar documentos acumulados.");
        tarea3.setFechaLimite(LocalDate.now().plusWeeks(1));
        tarea3.setPrioridad(Prioridad.BAJA);
        tarea3.setCategoria("Hogar");

        tareas.add(tarea1);
        tareas.add(tarea2);
        tareas.add(tarea3);

        return tareas;
    }
}

