package factory;

import model.EstadoPlan;
import model.PlanEntrenamiento;
import model.PlanPersonalizado;

/**
 * Factory concreta encargada de crear planes personalizados.
 */
public class FactoryPlanPersonalizado extends FactoryPlan {

    /**
     * Crea un plan personalizado con los datos recibidos.
     */
    public PlanPersonalizado crearPlan(
            String codigo,
            String nombre,
            String descripcion,
            int duracionMeses,
            double valorMensual,
            EstadoPlan estado,
            int cantidadSesionesEntrenador,
            String especialidadRequerida,
            String objetivosCliente
    ) {

        return new PlanPersonalizado(
                codigo,
                nombre,
                descripcion,
                duracionMeses,
                valorMensual,
                estado,
                cantidadSesionesEntrenador,
                especialidadRequerida,
                objetivosCliente
        );
    }

    /**
     * Implementa el método de la fábrica abstracta.
     *
     * @param codigo código del plan
     * @param nombre nombre del plan
     * @param descripcion descripción del plan
     * @param duracionMeses duración del plan en meses
     * @param valorMensual valor mensual del plan
     * @param estado estado del plan
     * @return plan personalizado creado
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

        return new PlanPersonalizado(
                codigo,
                nombre,
                descripcion,
                duracionMeses,
                valorMensual,
                estado,
                0,
                "",
                ""
        );
    }
}