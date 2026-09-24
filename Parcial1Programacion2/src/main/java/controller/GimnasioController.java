package controller;

import model.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador para interactuar con el Gimnasio.
 */
public class GimnasioController {

    private Gimnasio gimnasio;

    /**
     * Constructor del controlador.
     */
    public GimnasioController(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    /**
     * Calcula los ingresos del gimnasio entre dos fechas.
     */
    public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
        return gimnasio.calcularIngresos(fechaInicio, fechaFin);
    }

    /**
     * Determina si un número es perfecto.
     */
    public boolean esNumeroPerfecto(String numero) {
        return gimnasio.esNumeroPerfecto(numero);
    }

    /**
     * Busca un cliente utilizando su teléfono.
     */
    public Cliente buscarClientePorTelefono(String telefono) {
        return gimnasio.buscarClientePorTelefono(telefono);
    }

    /**
     * Registra una inscripción en el gimnasio.
     */
    public void registrarInscripcion(Inscripcion inscripcion) {
        gimnasio.registrarInscripcion(inscripcion);
    }

    /**
     * Registra un cliente en el gimnasio.
     */
    public void registrarCliente(Cliente cliente) {
        gimnasio.registrarCliente(cliente);
    }

    /**
     * Registra un entrenador en el gimnasio.
     */
    public void registrarEntrenador(Entrenador entrenador) {
        gimnasio.registrarEntrenador(entrenador);
    }

    /**
     * Registra un plan de entrenamiento en el gimnasio.
     */
    public void registrarPlan(PlanEntrenamiento plan) {
        gimnasio.registrarPlan(plan);
    }

    /**
     * Obtiene la lista de clientes registrados.
     */
    public List<Cliente> getListClientes() {
        return gimnasio.getListClientes();
    }

    /**
     * Obtiene la lista de entrenadores registrados.
     */
    public List<Entrenador> getListEntrenadores() {
        return gimnasio.getListEntrenadores();
    }

    /**
     * Obtiene la lista de inscripciones registradas.
     */
    public List<Inscripcion> getListInscripciones() {
        return gimnasio.getListInscripciones();
    }

    /**
     * Obtiene la lista de planes de entrenamiento.
     */
    public List<PlanEntrenamiento> getListPlanEntrenamientos() {
        return gimnasio.getListPlanes();
    }
}