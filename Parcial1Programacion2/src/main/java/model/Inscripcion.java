package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa la inscripción de un cliente a un plan de entrenamiento.
 */
public class Inscripcion {

    private LocalDate fechaInscripcion;
    private double valorTotal;

    private Cliente cliente;
    private PlanEntrenamiento plan;
    private Entrenador entrenador;
    private List<ServicioAdicional> serviciosAdicionales;

    /**
     * Crea una inscripción asociada a un cliente y un plan.
     */
    public Inscripcion(LocalDate fechaInscripcion, Cliente cliente,
                       PlanEntrenamiento plan, Entrenador entrenador) {
        this.fechaInscripcion = fechaInscripcion;
        this.cliente = cliente;
        this.plan = plan;
        this.entrenador = entrenador;
        this.serviciosAdicionales = new ArrayList<>();
        this.valorTotal = calcularValorTotal();
    }

    /**
     * Agrega un servicio adicional a la inscripción.
     */
    public void agregarServicio(ServicioAdicional servicio) {
        serviciosAdicionales.add(servicio);
        valorTotal = calcularValorTotal();
    }

    /**
     * Calcula el valor total de la inscripción.
     */
    public double calcularValorTotal() {

        double total = plan.calcularValorBase();

        for (ServicioAdicional servicio : serviciosAdicionales) {
            total += servicio.getPrecio();
        }

        return total;
    }

    /**
     * Obtiene la fecha de la inscripción.
     */
    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    /**
     * Obtiene el valor total de la inscripción.
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Obtiene el cliente de la inscripción.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Obtiene el plan seleccionado.
     */
    public PlanEntrenamiento getPlan() {
        return plan;
    }

    /**
     * Obtiene el entrenador asignado.
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }

    /**
     * Obtiene los servicios adicionales de la inscripción.
     */
    public List<ServicioAdicional> getServiciosAdicionales() {
        return serviciosAdicionales;
    }

    /**
     * Retorna una representación textual de la inscripción.
     */
    @Override
    public String toString() {
        return "Inscripcion{" +
                "fechaInscripcion=" + fechaInscripcion +
                ", valorTotal=" + valorTotal +
                ", cliente=" + cliente +
                ", plan=" + plan +
                ", entrenador=" + entrenador +
                ", serviciosAdicionales=" + serviciosAdicionales +
                '}';
    }
}