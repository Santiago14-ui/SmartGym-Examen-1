package controller;

import model.Entrenador;
import model.Gimnasio;
import model.Inscripcion;

import java.util.List;

public class EntrenadorController {

    private Gimnasio gimnasio;

    public EntrenadorController(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    public void registrarEntrenador(Entrenador entrenador) {
        gimnasio.registrarEntrenador(entrenador);
    }

    public List<Entrenador> getListEntrenadores() {
        return gimnasio.getListEntrenadores();
    }

    public void agregarInscripcion(Entrenador entrenador, Inscripcion inscripcion) {
        entrenador.agregarInscripcion(inscripcion);
    }

    public List<Inscripcion> getInscripciones(Entrenador entrenador) {
        return entrenador.getInscripciones();
    }

    public Entrenador buscarEntrenadorPorIdentificacion(String identificacion) {

        for (Entrenador entrenador : gimnasio.getListEntrenadores()) {

            if (entrenador.getIdentificacion().equals(identificacion)) {
                return entrenador;
            }
        }

        return null;
    }
}