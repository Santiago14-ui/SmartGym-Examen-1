package controller;

import model.Cliente;
import model.Entrenador;
import model.Gimnasio;
import model.Inscripcion;
import model.PlanEntrenamiento;
import model.ServicioAdicional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Controlador encargado de gestionar las inscripciones realizadas en el gimnasio.
 */
public class InscripcionController {

    private Gimnasio gimnasio;

    /**
     * Crea un controlador de inscripciones asociado a un gimnasio.
     */
    public InscripcionController(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    /**
     * Registra una inscripción en el gimnasio.
     */
    public void registrarInscripcion(Inscripcion inscripcion) {
        gimnasio.registrarInscripcion(inscripcion);
    }

    /**
     * Obtiene la lista de inscripciones registradas en el gimnasio.
     */
    public List<Inscripcion> getListInscripciones() {
        return gimnasio.getListInscripciones();
    }

    /**
     * Crea una nueva inscripción y establece las relaciones correspondientes
     * con el cliente, plan y entrenador.
     */
    public Inscripcion crearInscripcion(
            LocalDateTime fechaInscripcion,
            Cliente cliente,
            PlanEntrenamiento plan,
            Entrenador entrenador) {

        Inscripcion inscripcion = new Inscripcion(
                fechaInscripcion,
                cliente,
                plan,
                entrenador
        );

        gimnasio.registrarInscripcion(inscripcion);

        cliente.agregarInscripcion(inscripcion);
        plan.agregarInscripcion(inscripcion);

        if (entrenador != null) {
            entrenador.agregarInscripcion(inscripcion);
        }

        return inscripcion;
    }

    /**
     * Agrega un servicio adicional a una inscripción.
     */
    public void agregarServicio(
            Inscripcion inscripcion,
            ServicioAdicional servicio) {

        inscripcion.agregarServicio(servicio);
    }

    /**
     * Calcula el valor total de una inscripción.
     */
    public double calcularValorTotal(Inscripcion inscripcion) {
        return inscripcion.calcularValorTotal();
    }

    /**
     * Busca la primera inscripción asociada a un cliente.
     */
    public Inscripcion buscarPorCliente(Cliente cliente) {

        for (Inscripcion inscripcion : gimnasio.getListInscripciones()) {

            if (inscripcion.getCliente().equals(cliente)) {
                return inscripcion;
            }
        }

        return null;
    }

    /**
     * Obtiene los servicios adicionales asociados a una inscripción.
     */
    public List<ServicioAdicional> getServiciosAdicionales(
            Inscripcion inscripcion) {

        return inscripcion.getServiciosAdicionales();
    }
}