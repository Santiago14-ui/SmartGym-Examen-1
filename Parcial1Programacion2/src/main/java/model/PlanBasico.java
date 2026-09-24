package model;

/**
 * Representa un plan básico de entrenamiento.
 */
public class PlanBasico extends PlanEntrenamiento {

    /**
     * Crea un plan básico de entrenamiento.
     */
    public PlanBasico(String codigo, String nombre, String descripcion,
                      int duracionMeses, double valorMensual,
                      EstadoPlan estado) {

        super(codigo, nombre, descripcion, duracionMeses, valorMensual, estado);

        // El plan básico incluye únicamente acompañamiento de entrenador.
        agregarBeneficio(BeneficioPlan.ACOMPANAMIENTO_ENTRENADOR);
    }
}