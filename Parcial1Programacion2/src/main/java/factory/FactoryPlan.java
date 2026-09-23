package factory;

import model.PlanEntrenamiento;

/**
 * Define la fábrica abstracta para crear planes de entrenamiento.
 */
public abstract class FactoryPlan {

    /**
     * Crea un plan de entrenamiento.
     */
    public abstract PlanEntrenamiento crearPlan();
}