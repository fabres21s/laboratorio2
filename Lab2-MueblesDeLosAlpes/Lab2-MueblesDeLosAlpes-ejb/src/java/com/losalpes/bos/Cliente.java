package com.losalpes.bos;

/**
 *
 * @author Fabio Sierra, Mario Vélez
 */

/**
 * Clase que representa la información de un cliente en el sistema
 */
public class Cliente
{
    /**
     * -------------------------------------------------------------------------
     * Atributos
     * -------------------------------------------------------------------------
     */
    
    //Tipo de documento
    private TipoDocumento tipo;
    
    //Número de documento
    private String numero;
    
    //Nombre completo del cliente
    private String nombre;
    
    //Telefono de residencia del cliente
    private String telefonoR;
    
    //Telefono móvil del cliente
    private String telefonoM;
        
    //Dirección del cliente
    private String direccion;
    
    //Ciudad del cliente
    private String ciudad;
    
    //Departamento del cliente
    private String departamento;
    
    //Pais del cliente
    private String pais;
    
    //Profesión del cliente
    private String profesion;
    
    //Email del cliente
    private String email;
    
    /**
     * Constructor sin argumentos de la clase
     */
    public Cliente() 
    {

    }
    
    /**
     * Constructor de la clase. Inicializa los atributos con los valores que ingresan por parametro.
     * @param tipo Tipo de documento
     * @param numero número de documento
     * @param nombre nombre del clientes
     * @param telefonoR telefono de residencia del cliente
     * @param telefonoM telefono movil del cliente
     * @param direccion direccion del cliente
     * @param ciudad ciudad del cliente
     * @param departamento departamento del cliente
     * @param pais pais del cliente
     * @param profesion profesion del cliente
     * @param email email del cliente
     */
    
    public Cliente(TipoDocumento tipo, String numero, String nombre, String telefonoR, String telefonoM, String direccion, String ciudad, String departamento, String pais, String profesion, String email)
    {
        this.tipo = tipo;
        this.numero = numero;
        this.nombre = nombre;
        this.telefonoR = telefonoR;
        this.telefonoM = telefonoM;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.pais = pais;
        this.profesion = profesion;
        this.email = email;
    }

    /**
     * -------------------------------------------------------------------------
     * Getters y Setters
     * -------------------------------------------------------------------------
     */
    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDocumento tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefonoR() {
        return telefonoR;
    }

    public void setTelefonoR(String telefonoR) {
        this.telefonoR = telefonoR;
    }

    public String getTelefonoM() {
        return telefonoM;
    }

    public void setTelefonoM(String telefonoM) {
        this.telefonoM = telefonoM;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
