package factory;

import model.EstadoPlan;
import model.PlanBasico;
import model.PlanEntrenamiento;

/**
 * Factory concreta encargada de crear planes básicos.
 */
public class FactoryPlanBasico extends FactoryPlan {

    /**
     * Crea un plan básico con los datos recibidos.
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
        return new PlanBasico(
                codigo,
                nombre,
                descripcion,
                duracionMeses,
                valorMensual,
                estado
        );
    }
}