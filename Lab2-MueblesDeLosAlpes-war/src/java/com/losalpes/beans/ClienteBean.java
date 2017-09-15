/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ CatalogoBean.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.beans;

import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.bos.TipoMueble;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.ServicioCatalogoMock;
import com.losalpes.servicios.ServicioClienteMock;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;


/**
 * Managed bean encargado del catálogo de muebles en el sistema
 * 
 */
@ManagedBean
@SessionScoped
public class ClienteBean
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Representa un nuevo mueble a ingresar
     */
    private Cliente cliente;

    /**
     * Relación con la interfaz que provee los servicios necesarios del catálogo.
     */
    private IServicioCliente servicioCliente;

    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase principal
     */
    public ClienteBean()
    {
        cliente=new Cliente();
        servicioCliente=new ServicioClienteMock();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    /**
     * Devuelve el objeto mueble
     * @return mueble Objeto mueble
     */
    public Cliente getCliente()
    {
        return cliente;
    }


    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    /**
     * Devuelve una lista con todos los muebles del sistema
     * @return muebles Muebles del sistema
     */
    public List<Cliente> getClientes()
    {
        return servicioCliente.darClientes();
    }

    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------

    /**
     * Agrega un nuevo mueble al sistema
     */
    public void agregarCliente()
    {
        servicioCliente.agregarCliente(cliente);
        cliente = new Cliente();
    }
    
    public void eliminarCliente(Cliente cliente) {
        servicioCliente.eliminarCliente(cliente);
    }

    /**
     * Elimina la información del mueble
     */
    public void limpiar()
    {
        cliente =new Cliente();
    }

    /**
     * Devuelve los tipos de muebles
     * @return sitems Tipos de muebles en el sistema
     */
    public SelectItem[] getTiposDocumento()
    {
        TipoDocumento[] tipos=  TipoDocumento.values();
        SelectItem[] sitems = new SelectItem[tipos.length];
        
        
        for (int i = 0; i < sitems.length; i++)
        {
             sitems[i] = new SelectItem(tipos[i]);
        }
        return sitems;
    }

}
