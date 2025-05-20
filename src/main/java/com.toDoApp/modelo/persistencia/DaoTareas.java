package com.toDoApp.modelo.persistencia;


// importo las clases NECESARIAS
import org.springframework.stereotype.Repository;
import com.toDoApp.modelo.entidad.Tarea;

import java.util.ArrayList;
import java.util.List;


@Repository


public class DaoTareas {

// genero el atributo (con su parametro)
    private final String archivo;

    // genero el constructor (con su parametro)
    public DaoTareas(String archivo) {
        this.archivo = archivo;  
}


// genero el metodo guardarTarea (con su parametro)
public void guardar(List <Tarea> listaTareas) {

    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
        oos.writeObject(listaTareas);

    } catch (IOException e) {
        System.out.println("Error al guardar la tarea en el archivo: " + e.getMessage());
    }
}


// genero el metodo cargarTareas (con su parametro)
@SuppressWarnings("unchecked")
public List <Tarea> cargarTareas() {

    File file = new File(archivo);
    if (!file.exists()) {
        return new ArrayList<>();
    }


// genero try catch para guardar la tarea en el archivo
try(ObjectOutputStream ois = new ObjectOutputStream(new FileOutputStream(archivo))) {
    ois.writeObject(listaTareas);

} catch (IOException e) {
    System.out.println("Error al guardar la tarea en el archivo: " + e.getMessage());
    return new ArrayList<>();
}


}
}




