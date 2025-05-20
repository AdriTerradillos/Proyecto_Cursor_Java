package com.todoapp.modelo.negocio;

// IMPORTO LAS CLASES NECESARIAS
import com.todoapp.modelo.entidad.Prioridad;
import com.todoapp.modelo.entidad.Tarea;
import com.todoapp.modelo.persistencia.DaoTareas;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import jakarta.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//Clase que gestiona las tareas
@Service
public class GestorTareas {

    //Atributos de la clase
    private List<Tarea> listaTareas;
    private int contadorId;

    //Inyeccion de dependencias
    @Autowired
    private DaoTareas dao;

    //Constructor de la clase
    public GestorTareas() {
        listaTareas = new ArrayList<>();
    }

    //Metodo que se ejecuta despues de la inyeccion de dependencias
    @PostConstruct
    public void init() {
        listaTareas = dao.cargar();
        contadorId = obtenerProximoId();
    }

    //Metodo que agrega una tarea
    public Tarea agregarTarea(String titulo, String descripcion, LocalDate fechaLimite, Prioridad prioridad) {
        Tarea tarea = new Tarea();
        tarea.setId(contadorId++);
        tarea.setTitulo(titulo);
        tarea.setDescripcion(descripcion);
        tarea.setCompletada(false);
        tarea.setFechaLimite(fechaLimite);
        tarea.setFechaCreacion(LocalDate.now());
        tarea.setPrioridad(prioridad);
        tarea.setCategoria("general");
        tarea.setEtiquetas(new ArrayList<>());
        tarea.setSubtareas(new ArrayList<>());

        listaTareas.add(tarea);
        guardar();
        return tarea;
    }

    //Metodo que completa una tarea
    public boolean completarTarea(int id) {
        Tarea tarea = buscarPorId(id);
        if (tarea != null && !tarea.isCompletada()) {
            tarea.setCompletada(true);
            guardar();
            return true;
        }
        return false;
    }

    //Metodo que elimina una tarea
    public boolean eliminarTarea(int id) {
        boolean eliminada = listaTareas.removeIf(t -> t.getId() == id);
        if (eliminada) {
            guardar();
        }
        return eliminada;
    }

    //Metodo que lista las tareas pendientes
    public List<Tarea> listarTareasPendientes() {
        List<Tarea> pendientes = new ArrayList<>();
        for (Tarea t : listaTareas) {
            if (!t.isCompletada()) {
                pendientes.add(t);
            }
        }
        return pendientes;
    }

    //Metodo que ordena las tareas por prioridad
    public List<Tarea> ordenarPorPrioridad() {
        List<Tarea> copia = new ArrayList<>(listaTareas);
        copia.sort(Comparator.comparing(Tarea::getPrioridad));
        return copia;
    }

    //Metodo que busca una tarea por su id
    public Tarea buscarPorId(int id) {
        for (Tarea t : listaTareas) {
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    //Metodo que guarda las tareas
    private void guardar() {
        dao.guardar(listaTareas);
    }

    //Metodo que obtiene el siguiente id
    private int obtenerProximoId() {
        int maxId = 0;
        for (Tarea t : listaTareas) {
            if (t.getId() > maxId) {
                maxId = t.getId();
            }
        }
        return maxId + 1;
    }

    //Metodo que lista todas las tareas
    public List<Tarea> listarTodas() {
        return new ArrayList<>(listaTareas);
    }
}