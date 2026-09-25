package controller;

import model.Cliente;
import model.Gimnasio;
import model.Inscripcion;
import model.ServicioAdicional;

import java.time.LocalDate;
import java.util.List;

/**
 * Controlador encargado de gestionar las operaciones relacionadas con los clientes del gimnasio.
 */
public class ClienteController {

    private Cliente cliente;

    /**
     * Constructor del controlador.
     */
    public ClienteController(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return cliente.getNombreCompleto();
    }

    /**
     * Obtiene el documento de identidad del cliente.
     */
    public String getDocumentoIdentidad() {
        return cliente.getDocumentoIdentidad();
    }

    /**
     * Obtiene el teléfono del cliente.
     */
    public String getTelefono() {
        return cliente.getTelefono();
    }

    /**
     * Obtiene el correo electrónico del cliente.
     */
    public String getCorreoElectronico() {
        return cliente.getCorreoElectronico();
    }

    /**
     * Obtiene la edad del cliente.
     */
    public int getEdad() {
        return cliente.getEdad();
    }

    /**
     * Obtiene la fecha de registro del cliente.
     */
    public LocalDate getFechaRegistro() {
        return cliente.getFechaRegistro();
    }

    /**
     * Obtiene el gimnasio asociado al cliente.
     */
    public Gimnasio getGimnasio() {
        return cliente.getGimnasio();
    }

    /**
     * Obtiene las inscripciones del cliente.
     */
    public List<Inscripcion> getListInscripciones() {
        return cliente.getListInscripciones();
    }

    /**
     * Agrega una inscripción al cliente.
     */
    public void agregarInscripcion(Inscripcion inscripcion) {
        cliente.agregarInscripcion(inscripcion);
    }

    /**
     * Elimina una inscripción del cliente.
     */
    public void eliminarInscripcion(Inscripcion inscripcion) {
        cliente.eliminarInscripcion(inscripcion);
    }

    /**
     * Asigna un gimnasio al cliente.
     */
    public void asignarGimnasio(Gimnasio gimnasio) {
        cliente.setGimnasio(gimnasio);
    }

    /**
     * Actualiza los datos básicos del cliente.
     */
    public void actualizarDatos(
            String nombreCompleto,
            String documentoIdentidad,
            String telefono,
            String correoElectronico,
            int edad,
            LocalDate fechaRegistro) {

        cliente.setNombreCompleto(nombreCompleto);
        cliente.setDocumentoIdentidad(documentoIdentidad);
        cliente.setTelefono(telefono);
        cliente.setCorreoElectronico(correoElectronico);
        cliente.setEdad(edad);
        cliente.setFechaRegistro(fechaRegistro);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}