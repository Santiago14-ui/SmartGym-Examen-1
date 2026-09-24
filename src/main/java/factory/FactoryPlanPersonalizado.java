package factory;

import model.EstadoPlan;
import model.PlanEntrenamiento;
import model.PlanPersonalizado;

/**
 * Factory concreta encargada de crear planes personalizados.
 */
public class FactoryPlanPersonalizado extends FactoryPlan {

    /**
     * Crea un plan personalizado con valores iniciales.
     */
    @Override
    public PlanEntrenamiento crearPlan() {
        return new PlanPersonalizado(
                "003",
                "Plan Personalizado",
                "Plan adaptado a los objetivos del cliente",
                1,
                200000,
                EstadoPlan.ACTIVO,
                8,
                "Entrenamiento funcional",
                "Mejorar condición física"
        );
    }
}