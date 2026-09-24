package factory;

import model.EstadoPlan;
import model.PlanEntrenamiento;

/**
 * Define la fábrica abstracta para crear planes de entrenamiento.
 */
public abstract class FactoryPlan {

    /**
     * Crea un plan de entrenamiento.
     */
    public abstract PlanEntrenamiento crearPlan(
            String codigo,
            String nombre,
            String descripcion,
            int duracionMeses,
            double valorMensual,
            EstadoPlan estado
    );
}