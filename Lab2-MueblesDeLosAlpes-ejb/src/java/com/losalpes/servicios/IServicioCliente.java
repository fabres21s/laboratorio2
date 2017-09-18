package com.losalpes.servicios;

/**
 *
 * @author admin
 */

import com.losalpes.bos.Cliente;
import java.util.List;

/**
 * Contrato funcional de los servicios que se le prestan al catálogo
 */
public interface IServicioCliente
{

    /**
     * Agrega un cliente al sistema
     * @param cliente Nuevo cliente
     */
    public boolean agregarCliente(Cliente cliente);

    /**
     * Devuelve todos los clientes del sistema
     * @return clientes Lista de clientes
     */
    public List<Cliente> darClientes();
    
    /**
     * Elimina un cliente del sistema
     * @param cliente cliente a eliminar
     */
    public void eliminarCliente(Cliente cliente);
    
}
