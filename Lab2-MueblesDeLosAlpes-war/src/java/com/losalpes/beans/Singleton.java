/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Cliente;
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.IServicioCompra;
import com.losalpes.servicios.IServicioSeguridad;
import com.losalpes.servicios.ServicioCatalogoClientesMock;
import com.losalpes.servicios.ServicioCompra;
import com.losalpes.servicios.ServicioSeguridadMock;

/**
 *
 * @author fabio
 */
public class Singleton {
 
    private static Singleton instance = new Singleton();
    private Cliente cliente;
    private ServicioCompra servicioCompra;
    private ServicioCatalogoClientesMock catalogoClientes;
    private ServicioSeguridadMock servicioSeguridad;
    
    private Singleton(){
        servicioCompra = new ServicioCompra();
        catalogoClientes = new ServicioCatalogoClientesMock();
        servicioSeguridad = new ServicioSeguridadMock();
    }
    
    public static Singleton getInstance() {
        return instance;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the servicioCompra
     */
    public ServicioCompra getServicioCompra() {
        return servicioCompra;
    }

    /**
     * @param servicioCompra the servicioCompra to set
     */
    public void setServicioCompra(ServicioCompra servicioCompra) {
        this.servicioCompra = servicioCompra;
    }

    /**
     * @return the catalogoClientes
     */
    public ServicioCatalogoClientesMock getCatalogoClientes() {
        return catalogoClientes;
    }

    /**
     * @param catalogoClientes the catalogoClientes to set
     */
    public void setCatalogoClientes(ServicioCatalogoClientesMock catalogoClientes) {
        this.catalogoClientes = catalogoClientes;
    }

    /**
     * @return the servicioSeguridad
     */
    public ServicioSeguridadMock getServicioSeguridad() {
        return servicioSeguridad;
    }

    /**
     * @param servicioSeguridad the servicioSeguridad to set
     */
    public void setServicioSeguridad(ServicioSeguridadMock servicioSeguridad) {
        this.servicioSeguridad = servicioSeguridad;
    }
    
    
    
}
