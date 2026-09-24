package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un entrenador registrado en el gimnasio.
 */
public class Entrenador {
    /**
     * Atributos de la clase
     */
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

    /**
     * Obtiene la identificación del entrenador.
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * Obtiene el nombre del entrenador.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la especialidad del entrenador.
     */
    public String getEspecialidad() {
        return especialidad;
    }

    /**
     * Obtiene el teléfono del entrenador.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Obtiene la tarifa por sesión.
     */
    public double getTarifaPorSesion() {
        return tarifaPorSesion;
    }

    /**
     * Obtiene el gimnasio al que pertenece el entrenador.
     */
    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    /**
     * Obtiene las inscripciones asignadas al entrenador.
     */
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "identificacion='" + identificacion + '\'' +
                ", nombre='" + nombre + '\'' +
                ", especialidad='" + especialidad + '\'' +
                ", telefono=" + telefono +
                ", tarifaPorSesion=" + tarifaPorSesion +
                '}';
    }
}
