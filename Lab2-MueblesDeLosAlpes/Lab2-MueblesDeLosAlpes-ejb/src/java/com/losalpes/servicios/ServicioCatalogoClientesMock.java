package com.losalpes.servicios;

/**
 *
 * @author Fabio Sierra, Mario Vélez
 */

import com.losalpes.bos.Cliente;
import com.losalpes.bos.TipoDocumento;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implementacion de los servicios del catalogo de clientes que se le prestan al sistema. [Mock Object]
 */

public class ServicioCatalogoClientesMock implements IServicioCliente
{   
    
    /**
     * -------------------------------------------------------------------------
     * Atributos
     * -------------------------------------------------------------------------
     */
    
    private ArrayList<Cliente> clientes;
    private Set<String> setDocumentos;
    
    /**
     * -------------------------------------------------------------------------
     * Atributos
     * -------------------------------------------------------------------------
     */
    
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioCatalogoClientesMock()
    {

        //Inicializa el arreglo de los muebles
        clientes=new ArrayList<Cliente>();
        setDocumentos = new HashSet<String>();

        //Agrega los muebles del sistema
        agregarCliente(new Cliente(TipoDocumento.CedulaDeCiudadania,"111111111","Mario Velez","2706746","31092391232","cra 123 #456 - 789","Cali","Valle","Colombia","Ingeniero Electronico","mf.velez@correo.com"));
        agregarCliente(new Cliente(TipoDocumento.CedulaDeCiudadania,"222222222","Fabio Sierra","12412312","3158498032","cra 987 #654 - 321","Bogota","Cundinamarca","Colombia","Ingeniero de Sistemas","f.sierra@correo.com"));
   
    }
    
    @Override
    public void agregarCliente(Cliente cliente)
    {
        if(setDocumentos.add(cliente.getNumero()))
        {
        clientes.add(cliente);
        System.out.println("Se agregó el cliente correctamente");
        }
        else
        {
            System.out.println("El número de documento ya existe");
        }
    }

    @Override
    public List<Cliente> darClientes()
    {
        return clientes;
    }
}
