package factory;

import model.EstadoPlan;
import model.PlanBasico;
import model.PlanEntrenamiento;

/**
 * Factory concreta encargada de crear planes básicos.
 */
public class FactoryPlanBasico extends FactoryPlan {

    /**
     * Crea un plan básico con valores iniciales.
     */
    @Override
    public PlanEntrenamiento crearPlan() {
        return new PlanBasico(
                "001",
                "Plan Básico",
                "Plan de entrenamiento básico",
                1,
                80000,
                EstadoPlan.ACTIVO
        );
    }
}