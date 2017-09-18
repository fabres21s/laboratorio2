/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import java.io.Serializable;
import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoDocumento;
import com.losalpes.bos.TipoUsuario;
import com.losalpes.bos.Usuario;
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.ServicioCatalogoClientesMock;
import com.losalpes.servicios.ServicioCompra;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Fabio Sierra, Mario Vélez
 */
@SessionScoped
@ManagedBean
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
    
    

    /**
     * -------------------------------------------------------------------------
     * Constructor
     * -------------------------------------------------------------------------
     */
    public ClientesBean()
    {
        cliente = new Cliente();
        
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
        return Singleton.getInstance().getCatalogoClientes().darClientes();
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
        
        if (Singleton.getInstance().getCatalogoClientes().agregarCliente(cliente) ) {
            Usuario usuario = new Usuario();
            usuario.setTipo(TipoUsuario.CLIENTE);
            usuario.setNombre(cliente.getNumero());
            usuario.setContraseña(cliente.getPassword());
            Singleton.getInstance().getServicioSeguridad().agregarUsuario(usuario);
        }
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
    public void eliminarCliente(Cliente cliente)
    {
        this.cliente = cliente;
        
        Singleton singleton = Singleton.getInstance();
        
        ServicioCompra servicioCompra = singleton.getServicioCompra();
        
        if (servicioCompra.validarCompra(cliente.getNumero())) {
            Singleton.getInstance().getCatalogoClientes().eliminarCliente(cliente);
        } else {
            System.out.println("no se pudo eliminar el cliente, ya tiene compras");
        }
        
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
