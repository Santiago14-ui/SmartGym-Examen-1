package factory;

import model.EstadoPlan;
import model.PlanEntrenamiento;
import model.PlanPremium;

/**
 * Factory concreta encargada de crear planes premium.
 */
public class FactoryPlanPremium extends FactoryPlan {

    /**
     * Crea un plan premium con valores iniciales.
     */
    @Override
    public PlanEntrenamiento crearPlan() {
        return new PlanPremium(
                "002",
                "Plan Premium",
                "Plan de entrenamiento premium",
                1,
                150000,
                EstadoPlan.ACTIVO
        );
    }
}