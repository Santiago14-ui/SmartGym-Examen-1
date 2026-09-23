package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa un cliente registrado en el gimnasio.
 */
public class Cliente {

    private String nombreCompleto;
    private String documentoIdentidad;
    private int telefono;
    private String correoElectronico;
    private int edad;
    private LocalDate fechaRegistro;

    private Gimnasio gimnasio;
    private List<Inscripcion> inscripciones;

    /**
     * Construye un cliente con la información suministrada.
     */
    public Cliente(String nombreCompleto, String documentoIdentidad, int telefono,
                   String correoElectronico, int edad, LocalDate fechaRegistro) {

        this.nombreCompleto = nombreCompleto;
        this.documentoIdentidad = documentoIdentidad;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.edad = edad;
        this.fechaRegistro = fechaRegistro;
        this.inscripciones = new ArrayList<>();
    }

    /**
     * Agrega una inscripción al cliente.
     */
    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }

    /**
     * Elimina una inscripción del cliente.
     */
    public void eliminarInscripcion(Inscripcion inscripcion) {
        inscripciones.remove(inscripcion);
    }

    /**
     * Obtiene el nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Obtiene el documento de identidad del cliente.
     */
    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    /**
     * Obtiene el teléfono del cliente.
     */
    public int getTelefono() {
        return telefono;
    }

    /**
     * Obtiene el correo electrónico del cliente.
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Obtiene la edad del cliente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Obtiene la fecha de registro del cliente.
     */
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Obtiene el gimnasio al que pertenece el cliente.
     */
    public Gimnasio getGimnasio() {
        return gimnasio;
    }

    /**
     * Obtiene las inscripciones del cliente.
     */
    public List<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                ", telefono=" + telefono +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", edad=" + edad +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}