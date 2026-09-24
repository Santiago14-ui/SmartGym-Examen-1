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

    /**
     * Registra un cliente en el gimnasio.
     */
    public void registrarCliente(Cliente cliente) {
        gimnasio.registrarCliente(cliente);
    }

    /**
     * Busca un cliente por su número de teléfono.
     */
    public Cliente buscarClientePorTelefono(String telefono) {
        return gimnasio.buscarClientePorTelefono(telefono);
    }

    /**
     * Elimina un cliente del gimnasio.
     */
    public void eliminarCliente(Cliente cliente) {
        gimnasio.eliminarCliente(cliente);
    }

    /**
     * Registra un entrenador en el gimnasio.
     */
    public void registrarEntrenador(Entrenador entrenador) {
        gimnasio.registrarEntrenador(entrenador);
    }

    /**
     * Registra un plan de entrenamiento.
     */
    public void registrarPlan(PlanEntrenamiento plan) {
        gimnasio.registrarPlan(plan);
    }

    /**
     * Registra un servicio adicional.
     */
    public void registrarServicioAdicional(ServicioAdicional servicio) {
        gimnasio.registrarServicioAdicional(servicio);
    }

    /**
     * Registra una inscripción.
     */
    public void registrarInscripcion(Inscripcion inscripcion) {
        gimnasio.registrarInscripcion(inscripcion);
    }

    /**
     * Obtiene la lista de clientes.
     */
    public List<Cliente> getListClientes() {
        return gimnasio.getListClientes();
    }

    /**
     * Obtiene la lista de entrenadores.
     */
    public List<Entrenador> getListEntrenadores() {
        return gimnasio.getListEntrenadores();
    }

    /**
     * Obtiene la lista de planes de entrenamiento.
     */
    public List<PlanEntrenamiento> getListPlanEntrenamientos() {
        return gimnasio.getListPlanes();
    }

    /**
     * Obtiene la lista de servicios adicionales.
     */
    public List<ServicioAdicional> getListServiciosAdicionales() {
        return gimnasio.getListServiciosAdicionales();
    }

    /**
     * Obtiene la lista de inscripciones.
     */
    public List<Inscripcion> getListInscripciones() {
        return gimnasio.getListInscripciones();
    }

    /**
     * Busca si un número es perfecto.
     */
    public boolean esNumeroPerfecto(String numero) {
        return gimnasio.esNumeroPerfecto(numero);
    }

    /**
     * Calcula los ingresos del gimnasio entre dos fechas.
     */
    public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
        return gimnasio.calcularIngresos(fechaInicio, fechaFin);
    }

    /**
     * Obtiene el gimnasio administrado por el controlador.
     */
    public Gimnasio getGimnasio() {
        return gimnasio;
    }
}