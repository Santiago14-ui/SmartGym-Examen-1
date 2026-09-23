package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Define la información común de los planes de entrenamiento.
 */
public abstract class PlanEntrenamiento {

    private String codigo;
    private String nombre;
    private String descripcion;
    private int duracionMeses;
    private double valorMensual;
    private EstadoPlan estado;

    private Gimnasio gimnasio;
    private List<Inscripcion> inscripciones;

    /**
     * Crea un plan de entrenamiento con sus datos básicos.
     */
    public PlanEntrenamiento(String codigo, String nombre, String descripcion,
                             int duracionMeses, double valorMensual,
                             EstadoPlan estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMeses = duracionMeses;
        this.valorMensual = valorMensual;
        this.estado = estado;
        this.inscripciones = new ArrayList<>();
    }

    /**
     * Calcula el valor base del plan según su duración.
     */
    public double calcularValorBase() {
        return valorMensual * duracionMeses;
    }

    /**
     * Agrega una inscripción asociada al plan.
     */
    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracionMeses() {
        return duracionMeses;
    }

    public double getValorMensual() {
        return valorMensual;
    }

    public EstadoPlan getEstado() {
        return estado;
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }
}