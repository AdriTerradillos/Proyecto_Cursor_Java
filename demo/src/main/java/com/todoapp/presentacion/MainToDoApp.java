package com.todoapp.presentacion;

//Importacion de las clases necesarias
import com.todoapp.modelo.entidad.Tarea;
import com.todoapp.configuracion.ConfiguracionApp;
import com.todoapp.modelo.negocio.GestorTareas;
import com.todoapp.modelo.entidad.Prioridad;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


//Clase principal de la aplicacion
public class MainToDoApp {

    //Metodo principal de la aplicacion
    public static void main(String[] args) {
        //Crea el contexto de la aplicacion
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfiguracionApp.class);
        //Obtiene el gestor de tareas
        GestorTareas gestor = context.getBean(GestorTareas.class);

        //Scanner para leer la entrada del usuario
        Scanner sc = new Scanner(System.in);
        int opcion;

        //Bucle para mostrar el menu y realizar las acciones
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Listar tareas pendientes");
            System.out.println("3. Completar tarea");
            System.out.println("4. Eliminar tarea");
            System.out.println("5. Listar por prioridad");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            //try catch para leer la opcion del usuario
            try {
                //Lee la opcion del usuario
                opcion = Integer.parseInt(sc.nextLine());

                //Switch para realizar las acciones
                switch (opcion) {
                    case 1 -> {
                        // try catch para agregar una tarea
                        try {
                            System.out.print("Título: ");
                            String titulo = sc.nextLine();
                            System.out.print("Descripción: ");
                            String descripcion = sc.nextLine();
                            System.out.print("Fecha límite (YYYY-MM-DD): ");
                            LocalDate fecha = LocalDate.parse(sc.nextLine());
                            System.out.print("Prioridad (ALTA/MEDIA/BAJA): ");
                            Prioridad prioridad = Prioridad.valueOf(sc.nextLine().toUpperCase());
                            // No es necesario verificar si es null ya que valueOf() lanzará IllegalArgumentException
                            // si el valor no es válido

                            
                            // try catch para agregar una tarea
                            Tarea nueva = gestor.agregarTarea(titulo, descripcion, fecha, prioridad);
                            System.out.println("Tarea creada: " + nueva);

                        } catch (Exception e) {
                            System.out.println("Error al crear la tarea: " + e.getMessage());
                        }
                    }
                    case 2 -> { 
                        //Lista las tareas pendientes
                        List<Tarea> pendientes = gestor.listarTareasPendientes();
                        if (pendientes.isEmpty()) {
                            System.out.println("No hay tareas pendientes");
                        } else {
                            pendientes.forEach(System.out::println);
                        }
                    }
                    case 3 -> {
                        try {
                            // try catch para completar una tarea
                            System.out.print("ID de la tarea a completar: ");
                            int id = Integer.parseInt(sc.nextLine());
                            boolean ok = gestor.completarTarea(id);
                            System.out.println(ok ? "Tarea completada." : "No encontrada o ya completada.");

                        } catch (NumberFormatException e) {
                            System.out.println("ID inválido");
                        }
                    }
                    case 4 -> {
                        try {
                            // try catch para eliminar una tarea
                            System.out.print("ID de la tarea a eliminar: ");
                            int id = Integer.parseInt(sc.nextLine());
                            boolean ok = gestor.eliminarTarea(id);
                            System.out.println(ok ? "Tarea eliminada." : "No encontrada.");
                            
                        } catch (NumberFormatException e) {
                            //Si el id no es un numero valido, se muestra un mensaje de error
                            System.out.println("ID inválido");
                        }
                    }
                    case 5 -> {
                        try {
                            // Caso 5: Ordenar tareas por prioridad
                            // Obtiene la lista de tareas ordenadas por prioridad usando el gestor
                            List<Tarea> ordenadas = gestor.ordenarPorPrioridad();
                            
                            // Verifica si hay tareas para mostrar
                            if (ordenadas.isEmpty()) {
                                // Si la lista está vacía, muestra mensaje
                                System.out.println("No hay tareas");
                            } else {
                                // Si hay tareas, las imprime una por una usando método forEach
                                System.out.println("--- Tareas ordenadas por prioridad ---");
                                //Imprime las tareas ordenadas
                                ordenadas.forEach(System.out::println);
                            }
                        } catch (Exception e) {
                            System.out.println("Error al ordenar las tareas: " + e.getMessage());
                        }
                    }
                    case 0 -> {
                        // Caso 0: Salir del programa
                        System.out.println("¡Hasta luego!");
                    }
                    default -> {
                        // Caso por defecto: Opción inválida
                        System.out.println("Opción no válida");
                    }
                }
            } catch (NumberFormatException e) {
                // Manejo de excepción si el usuario ingresa algo que no es un número
                System.out.println("Por favor, ingrese un número válido");
                // Se asigna -1 para continuar con el bucle
                opcion = -1;
            }
            // El bucle continúa mientras la opción no sea 0 (salir)
        } while (opcion != 0);
        
        // Cerrar recursos
        sc.close();
        context.close();
    }
}