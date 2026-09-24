package controller;

import model.EstadoPlan;
import model.Gimnasio;
import model.PlanEntrenamiento;

import java.util.List;

/**
 * Controlador encargado de gestionar los planes de entrenamiento registrados en el gimnasio.
 */
public class PlanEntrenamientoController {

    /**
     * Referencia al gimnasio que administra los planes.
     */
    private Gimnasio gimnasio;

    /**
     * Crea un controlador de planes de entrenamiento asociado a un gimnasio.
     */
    public PlanEntrenamientoController(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    /**
     * Registra un plan de entrenamiento en el gimnasio.
     */
    public void registrarPlan(PlanEntrenamiento plan) {
        gimnasio.registrarPlan(plan);
    }

    /**
     * Obtiene la lista de planes registrados en el gimnasio.
     */
    public List<PlanEntrenamiento> getListPlanes() {
        return gimnasio.getListPlanes();
    }

    /**
     * Busca un plan de entrenamiento mediante su código.
     */
    public PlanEntrenamiento buscarPorCodigo(String codigo) {

        for (PlanEntrenamiento plan : gimnasio.getListPlanes()) {

            if (plan.getCodigo().equals(codigo)) {
                return plan;
            }
        }

        return null;
    }

    /**
     * Busca un plan de entrenamiento mediante su nombre.
     */
    public PlanEntrenamiento buscarPorNombre(String nombre) {

        for (PlanEntrenamiento plan : gimnasio.getListPlanes()) {

            if (plan.getNombre().equalsIgnoreCase(nombre)) {
                return plan;
            }
        }

        return null;
    }

    /**
     * Calcula el valor base de un plan de entrenamiento.
     */
    public double calcularValorBase(PlanEntrenamiento plan) {
        return plan.calcularValorBase();
    }

    /**
     * Obtiene los planes que tienen un estado determinado.
     */
    public List<PlanEntrenamiento> buscarPorEstado(EstadoPlan estado) {

        List<PlanEntrenamiento> planes = new java.util.ArrayList<>();

        for (PlanEntrenamiento plan : gimnasio.getListPlanes()) {

            if (plan.getEstado() == estado) {
                planes.add(plan);
            }
        }

        return planes;
    }
}