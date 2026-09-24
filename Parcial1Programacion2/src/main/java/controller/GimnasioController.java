package controller;

import model.*;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador para interactuar con la Entrenador
 */
public class GimnasioController {
    private Gimnasio gimnasio;

    public GimnasioController(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    public double calcularIngresos(LocalDate fechaInicio, LocalDate fechaFin) {
        return gimnasio.calcularIngresos(fechaInicio, fechaFin);
    }

    public boolean esNumeroPerfecto(String numero) {
        return gimnasio.esNumeroPerfecto(numero);
    }

    public Cliente buscarClientePorTelefono(String telefono) {
        return gimnasio.buscarClientePorTelefono(telefono);
    }

    public void registrarInscripcion(Inscripcion inscripcion) {
        gimnasio.registrarInscripcion(inscripcion);
    }

    public void registrarCliente(Cliente cliente) {
        gimnasio.registrarCliente(cliente);
    }

    public void registrarEntrenador(Entrenador entrenador) {
        gimnasio.registrarEntrenador(entrenador);
    }

    public List<Cliente> getListClientes() {
        return gimnasio.getListClientes();
    }

    public List<Entrenador> getListEntrenadores() {
        return gimnasio.getListEntrenadores();
    }

    public List<Inscripcion> getListInscripciones() {
        return gimnasio.getListInscripciones();
    }

    public List<PlanEntrenamiento> getListPlanEntrenamientos() {
        return gimnasio.getListPlanes();
    }

}
