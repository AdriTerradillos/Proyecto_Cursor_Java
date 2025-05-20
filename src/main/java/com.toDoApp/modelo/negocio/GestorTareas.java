package com.toDoApp.modelo.negocio;

// importo las clases NECESARIAS
import com.toDoApp.modelo.entidad.Prioridad;
import com.toDoApp.modelo.entidad.Tarea;
import com.toDoApp.modelo.persistencia.DaoTareas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


// genero la clase GestorTareas con @Service
@Service
public class GestorTareas {

    // genero los atributos (con su parametro)
    private List<Tarea> listaTareas;
    private int contadorId;
    

// inyecto las dependencias con @Autowired
    @Autowired
    private DaoTareas daoTareas;
    
    
// genero el constructor (con su parametro)
    public GestorTareas() {
        daoTareas = new DaoTareas("tareas.dat");
        listaTareas = daoTareas.cargar();
        contadorId = getProximoId();
    }

    

public Tarea agregar(String titulo, String descripcion, LocalDate fechaLimite, Prioridad prioridad) {

// genero el metodo nuevaTarea (con sus parametros)
    Tarea t = new Tarea(contadorId++, titulo, descripcion, false, fechaLimite, 
    LocalDate.now(), prioridad, "general",new ArrayList<>(), new ArrayList<>());

    // (agrego la nueva tarea a la lista de tareas)
    listaTareas.add(t);
    guardar();
    return t;
}


    // genero el metodo completarTarea (con su parametro)
    public boolean completarTarea(int id) {
        Tarea t = buscarPorId(id);
        if (t != null && !t.isCompletada()) {
            t.marcarComoCompletada();
            guardar();
            return true;
        }
        return false;
    }


    // genero el metodo eliminarTarea (con su parametro)
    public boolean eliminarTarea(int id) {
        boolean eliminada = listaTareas.removeIf(t -> t.getId() == id);
        if (eliminada) {
            guardar();
        }
        return eliminada;
    }


    // genero el List<Tarea> listarTareasPendientes (con su parametro)
    public List<Tarea> listarTareasPendientes() {
        List<Tarea> pendientes = new ArrayList<>();
        for (Tarea t : listaTareas) {
            if (!t.isCompletada()) {
                pendientes.add(t);
            }
        }
        return pendientes;
    }


    // genero el metodo ordenarPorPrioridad (con su parametro)
    public List<Tarea> ordenarPorPrioridad() {
        List<Tarea> copia = new ArrayList<>(listaTareas);
        copia.sort(Comparator.comparing(Tarea::getPrioridad));
        return copia;
    }


// genero el metodo buscarPorId (con su parametro)
public Tarea buscarPorId(int id) {
    return listaTareas.stream()
    .filter(t -> t.getId() == id)
    .findFirst().orElse(null);
}

// genero el metodo guardar(con su parametro)
    private void guardar() {
        daoTareas.guardar(listaTareas);
    }


    // genero el metodo getProximoId (con su parametro)
    public int getProximoId() {
        int maximoId = 0;
        for (Tarea t : listaTareas) {
            if (t.getId() > maximoId) {
                maximoId = t.getId();
            }
        }
        return maximoId + 1;
    }
}

