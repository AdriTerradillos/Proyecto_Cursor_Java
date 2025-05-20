package com.todoapp.modelo.entidad;

// Importacion de clases necesarias
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


//Clase que representa una tarea en la aplicación
public class Tarea implements Serializable {

	// Atributos de la clase
	private int id;
	private String titulo;
	private String descripcion;
	private boolean completada;
	private LocalDate fechaLimite;
	private LocalDate fechaCreacion;
	private Prioridad prioridad;
	private String categoria;
	private List<String> etiquetas;
	private List<String> subtareas;


	// Constructor por defecto
	public Tarea() {
		this.id = 0;
		this.etiquetas = new ArrayList<>();
		this.subtareas = new ArrayList<>();
	}


	// Constructor con todos los atributos
	public Tarea(int id, String titulo, String descripcion, boolean completada, LocalDate fechaLimite,
			LocalDate fechaCreacion, Prioridad prioridad, String categoria, List<String> etiquetas,
			List<String> subtareas) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.completada = completada;
		this.fechaLimite = fechaLimite;
		this.fechaCreacion = fechaCreacion;
		this.prioridad = prioridad;
		this.categoria = categoria;
		this.etiquetas = etiquetas;
		this.subtareas = subtareas;
	}


	// Getters y setters para los atributos
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isCompletada() {
		return completada;
	}

	public void setCompletada(boolean completada) {
		this.completada = completada;
	}

	public LocalDate getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(LocalDate fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Prioridad getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(Prioridad prioridad) {
		this.prioridad = prioridad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<String> getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(List<String> etiquetas) {
		this.etiquetas = etiquetas;
	}

	public List<String> getSubtareas() {
		return subtareas;
	}

	public void setSubtareas(List<String> subtareas) {
		this.subtareas = subtareas;
	}


	// Método toString para representar la tarea como una cadena de caracteres
	@Override
	public String toString() {
		return "Tarea [id= " + id + ", titulo= " + titulo + ", descripcion= " + descripcion +
			   ", completada= " + completada + ", fechaLimite= " + fechaLimite +
			   ", fechaCreacion= " + fechaCreacion + ", prioridad= " + prioridad +
			   ", categoria= " + categoria + ", etiquetas=" + etiquetas +
			   ", subtareas= " + subtareas + "]";
	}
}