/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioCatalogoMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * 
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package com.losalpes.servicios;


import com.losalpes.bos.Cliente;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.Stateless;


/**
 * Implementacion de los servicios del catalogo de muebles que se le prestan al sistema. [Mock Object]
 * 
 */
@Stateless
public class ServicioClienteMock implements IServicioCliente
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Arreglo con los muebles del sistema
     */
    private ArrayList<Cliente> clientes;
    private Set<String> setDocumentos;
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioClienteMock()
    {

        //Inicializa el arreglo de los muebles
        clientes=new ArrayList<Cliente>();
        setDocumentos = new HashSet<String>();
       

    }

    @Override
    public void agregarCliente(Cliente cliente) {
        
       
        if (setDocumentos.add(cliente.getNumeroDocumento())) {
            clientes.add(cliente);
            System.out.println("Se agregó el cliente correctamente");
        } else {
            System.out.println("El número de documento ya existe!!!");
        }
        
    }

    @Override
    public List<Cliente> darClientes() {
        return clientes;
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
        setDocumentos.remove(cliente.getNumeroDocumento());
    }
}
