package controller;

import model.Gimnasio;
import model.Inscripcion;
import model.ServicioAdicional;

import java.util.List;

/**
 * Controlador encargado de gestionar los servicios adicionales ofrecidos por el gimnasio.
 */
public class ServicioAdicionalController {

    /**
     * Referencia al gimnasio que administra los servicios adicionales.
     */
    private Gimnasio gimnasio;

    /**
     * Crea un controlador de servicios adicionales asociado a un gimnasio.
     */
    public ServicioAdicionalController(Gimnasio gimnasio) {
        this.gimnasio = gimnasio;
    }

    /**
     * Registra un servicio adicional en el gimnasio.
     */
    public void registrarServicio(ServicioAdicional servicio) {
        gimnasio.registrarServicioAdicional(servicio);
    }

    /**
     * Obtiene la lista de servicios adicionales registrados
     * en el gimnasio.
     */
    public List<ServicioAdicional> getListServiciosAdicionales() {
        return gimnasio.getListServiciosAdicionales();
    }

    /**
     * Busca un servicio adicional mediante su código.
     */
    public ServicioAdicional buscarPorCodigo(String codigo) {

        for (ServicioAdicional servicio :
                gimnasio.getListServiciosAdicionales()) {

            if (servicio.getCodigo().equals(codigo)) {
                return servicio;
            }
        }

        return null;
    }

    /**
     * Agrega un servicio adicional a una inscripción.
     */
    public void agregarServicioAInscripcion(
            Inscripcion inscripcion,
            ServicioAdicional servicio) {

        inscripcion.agregarServicio(servicio);
    }

    /**
     * Obtiene los servicios adicionales asociados a una inscripción.
     */
    public List<ServicioAdicional> getServiciosDeInscripcion(
            Inscripcion inscripcion) {

        return inscripcion.getServiciosAdicionales();
    }
}