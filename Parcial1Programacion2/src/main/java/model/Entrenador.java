package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un entrenador registrado en el gimnasio.
 */
public class Entrenador {

    // Atributos de la clase
    private String identificacion;
    private String nombre;
    private String especialidad;
    private String telefono;
    private double tarifaPorSesion;

    private Gimnasio gimnasio;
    private List<Inscripcion> inscripciones;

    /**
     * Crea un entrenador con sus datos básicos.
     */
    public Entrenador(String identificacion, String nombre, String especialidad,
                      String telefono, double tarifaPorSesion) {

        this.identificacion = identificacion;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.telefono = telefono;
        this.tarifaPorSesion = tarifaPorSesion;
        this.inscripciones = new ArrayList<>();
    }

    /**
     * Asocia una inscripción con el entrenador.
     */
    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    // Getters

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTelefono() {
        return telefono;
    }

    public double getTarifaPorSesion() {
        return tarifaPorSesion;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    // Setters

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTarifaPorSesion(double tarifaPorSesion) {
        this.tarifaPorSesion = tarifaPorSesion;
    }

    public void setGimnasio(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    public void setInscripciones(List<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

    /**
     * Se muestra solamente el nombre en los ComboBox.
     */
    @Override
    public String toString() {
        return nombre;
    }
}