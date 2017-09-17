/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.ServicioCatalogoClientesMock;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Fabio Sierra, Mario Vélez
 */
@Named(value = "ClientesBean")
@SessionScoped
public class ClientesBean implements Serializable
{
    
    /**
     * -------------------------------------------------------------------------
     * Atributos
     * -------------------------------------------------------------------------
     */
    
    //Representa un nuevo cliente a ingresar
    private Cliente cliente;
    
    
    //Relación con la interfaz que provee los servicios necesarios del cliente.
    
    private IServicioCliente catalogoClientes;

    /**
     * -------------------------------------------------------------------------
     * Constructor
     * -------------------------------------------------------------------------
     */
    public ClientesBean()
    {
        cliente = new Cliente();
        catalogoClientes = new ServicioCatalogoClientesMock();
    }
    
    /**
     * -------------------------------------------------------------------------
     * Getters y Setters
     * -------------------------------------------------------------------------
     */
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes()
    {
        return catalogoClientes.darClientes();
    }
    
    /**
     * -------------------------------------------------------------------------
     * Métodos
     * -------------------------------------------------------------------------
     */
    
    /**
     * Agrega un nuevo cliente al sistema
     */
    public void agregarCliente()
    {
        catalogoClientes.agregarCliente(cliente);
        cliente=new Cliente();
    }

    /**
     * Elimina la información del cliente
     */
    public void limpiar()
    {
        cliente=new Cliente();
    }
    
    /**
     * Elimina un nuevo cliente del sistema
     */
    public void eliminarCliente()
    {
        
    }
    
    /**
     * Devuelve los tipos de muebles
     * @return sitems Tipos de muebles en el sistema
     */
    public SelectItem[] getTiposClientes()
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
