package factory;

import model.EstadoPlan;
import model.PlanEntrenamiento;
import model.PlanPremium;

/**
 * Factory concreta encargada de crear planes premium.
 */
public class FactoryPlanPremium extends FactoryPlan {

    /**
     * Crea un plan premium con los datos recibidos.
     */
    @Override
    public PlanEntrenamiento crearPlan(
            String codigo,
            String nombre,
            String descripcion,
            int duracionMeses,
            double valorMensual,
            EstadoPlan estado
    ) {
        return new PlanPremium(
                codigo,
                nombre,
                descripcion,
                duracionMeses,
                valorMensual,
                estado
        );
    }
}