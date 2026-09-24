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

        // El plan premium incluye los tres beneficios.
        agregarBeneficio(BeneficioPlan.ACCESO_ZONAS_DEPORTIVAS);
        agregarBeneficio(BeneficioPlan.CLASES_GRUPALES);
        agregarBeneficio(BeneficioPlan.ACOMPANAMIENTO_ENTRENADOR);
    }
}