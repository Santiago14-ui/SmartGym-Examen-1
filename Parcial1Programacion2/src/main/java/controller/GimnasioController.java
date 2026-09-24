package controller;

import model.Cliente;
import model.Entrenador;
import model.Gimnasio;
import model.Inscripcion;
import model.PlanEntrenamiento;
import model.ServicioAdicional;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones del gimnasio.
 */
public class GimnasioController {

    private Gimnasio gimnasio;

    /**
     * Constructor del controlador.
     */
    public GimnasioController(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    // =========================
    // CLIENTES
    // =========================

    public void registrarCliente(Cliente cliente) {
        gimnasio.registrarCliente(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        gimnasio.actualizarCliente(cliente);
    }

    public Cliente buscarClientePorTelefono(String telefono) {
        return gimnasio.buscarClientePorTelefono(telefono);
    }

    public void eliminarCliente(Cliente cliente) {
        gimnasio.eliminarCliente(cliente);
    }

    // =========================
    // ENTRENADORES
    // =========================

    public void registrarEntrenador(Entrenador entrenador) {
        gimnasio.registrarEntrenador(entrenador);
    }

    public void actualizarEntrenador(Entrenador entrenador) {
        gimnasio.actualizarEntrenador(entrenador);
    }

    public Entrenador buscarEntrenadorPorIdentificacion(String identificacion) {
        return gimnasio.buscarEntrenadorPorIdentificacion(identificacion);
    }

    public void eliminarEntrenador(Entrenador entrenador) {
        gimnasio.eliminarEntrenador(entrenador);
    }

    // =========================
    // PLANES
    // =========================

    public void registrarPlan(PlanEntrenamiento plan) {
        gimnasio.registrarPlan(plan);
    }

    // =========================
    // SERVICIOS
    // =========================

    public void registrarServicioAdicional(ServicioAdicional servicio) {
        gimnasio.registrarServicioAdicional(servicio);
    }

    // =========================
    // INSCRIPCIONES
    // =========================

    public void registrarInscripcion(Inscripcion inscripcion) {
        gimnasio.registrarInscripcion(inscripcion);
    }

    // =========================
    // LISTAS
    // =========================

    public List<Cliente> getListClientes() {
        return gimnasio.getListClientes();
    }

    public List<Entrenador> getListEntrenadores() {
        return gimnasio.getListEntrenadores();
    }

    public List<PlanEntrenamiento> getListPlanEntrenamientos() {
        return gimnasio.getListPlanes();
    }

    public List<ServicioAdicional> getListServiciosAdicionales() {
        return gimnasio.getListServiciosAdicionales();
    }

    public List<Inscripcion> getListInscripciones() {
        return gimnasio.getListInscripciones();
    }

    // =========================
    // OTROS
    // =========================

    public boolean esNumeroPerfecto(String numero) {
        return gimnasio.esNumeroPerfecto(numero);
    }

    public double calcularIngresos(
            LocalDate fechaInicio,
            LocalDate fechaFin) {

        return gimnasio.calcularIngresos(fechaInicio, fechaFin);
    }

    public Gimnasio getGimnasio() {
        return gimnasio;
    }
}