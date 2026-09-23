package model;

/**
 * Representa un plan personalizado de entrenamiento.
 */
public class PlanPersonalizado extends PlanEntrenamiento {

    private int cantidadSesionesEntrenador;
    private String especialidadRequerida;
    private String objetivosCliente;

    /**
     * Crea un plan personalizado de entrenamiento.
     */
    public PlanPersonalizado(String codigo, String nombre, String descripcion,
                             int duracionMeses, double valorMensual,
                             EstadoPlan estado, int cantidadSesionesEntrenador,
                             String especialidadRequerida, String objetivosCliente) {

        super(codigo, nombre, descripcion, duracionMeses, valorMensual, estado);
        this.cantidadSesionesEntrenador = cantidadSesionesEntrenador;
        this.especialidadRequerida = especialidadRequerida;
        this.objetivosCliente = objetivosCliente;
    }

    /**
     * Crea una copia del plan personalizado actual.
     */
    public PlanPersonalizado crearCopia() {

        return new PlanPersonalizado(
                getCodigo(),
                getNombre(),
                getDescripcion(),
                getDuracionMeses(),
                getValorMensual(),
                getEstado(),
                cantidadSesionesEntrenador,
                especialidadRequerida,
                objetivosCliente
        );
    }

    /**
     * Obtiene la cantidad de sesiones con entrenador.
     */
    public int getCantidadSesionesEntrenador() {
        return cantidadSesionesEntrenador;
    }

    /**
     * Obtiene la especialidad requerida.
     */
    public String getEspecialidadRequerida() {
        return especialidadRequerida;
    }

    /**
     * Obtiene los objetivos establecidos para el cliente.
     */
    public String getObjetivosCliente() {
        return objetivosCliente;
    }
}