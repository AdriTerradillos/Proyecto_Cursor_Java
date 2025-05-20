package com.todoapp.modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import com.todoapp.modelo.entidad.Tarea;


//Clase que maneja la persistencia de las tareas
public class DaoTareas {

    //Atributo que almacena el archivo donde se guardan las tareas
	private String archivo;

    //Constructor que recibe el archivo donde se guardan las tareas
	public DaoTareas(String archivo) {
		this.archivo = archivo;
	}

    //Metodo que guarda las tareas en el archivo
	public void guardar(List<Tarea> tareas) {
        //try catch para guardar las tareas en el archivo
		try (java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(new java.io.FileOutputStream(archivo))) {
			oos.writeObject(tareas);
            //Si hay un error, se muestra un mensaje de error
		} catch (java.io.IOException e) {
			System.err.println("Error al guardar tareas: " + e.getMessage());
		}
	}

    //Metodo que carga las tareas desde el archivo
	@SuppressWarnings("unchecked")
	public List<Tarea> cargar() {
		java.io.File file = new java.io.File(archivo);
		if (!file.exists()) {
			return new ArrayList<>();
		}

        //try catch para cargar las tareas desde el archivo
		try (java.io.ObjectInputStream ois = new java.io.ObjectInputStream(new java.io.FileInputStream(file))) {
			return (List<Tarea>) ois.readObject();

            //Si hay un error, se muestra un mensaje de error y se devuelve una lista vacia
		} catch (java.io.IOException | ClassNotFoundException e) {
			System.err.println("Error al cargar tareas: " + e.getMessage());
			return new ArrayList<>();
		}
	}
}