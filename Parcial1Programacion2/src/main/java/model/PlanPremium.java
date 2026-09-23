package model;

/**
 * Representa un plan premium de entrenamiento.
 */
public class PlanPremium extends PlanEntrenamiento {

    /**
     * Crea un plan premium de entrenamiento.
     */
    public PlanPremium(String codigo, String nombre, String descripcion,
                       int duracionMeses, double valorMensual,
                       EstadoPlan estado) {
        super(codigo, nombre, descripcion, duracionMeses, valorMensual, estado);
    }
}