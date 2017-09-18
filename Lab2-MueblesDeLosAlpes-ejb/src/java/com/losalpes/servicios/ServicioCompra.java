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

import com.losalpes.bos.Compra;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.TipoMueble;
import java.util.ArrayList;
import java.util.List;


/**
 * Implementacion de los servicios del catalogo de muebles que se le prestan al sistema. [Mock Object]
 * 
 */

public class ServicioCompra implements IServicioCompra
{

    private List<Compra> compras;
    
    public ServicioCompra() {
        compras = new ArrayList<Compra>();
    }
    
    @Override
    public void agregarCompra(Compra compra) {
        compras.add(compra);
    }

    @Override
    public boolean validarCompra(String numero) {
        for (Compra compra : compras) {
            if (compra.getCliente().getNumero().equals(numero)) {
                return false;
            }
        }
        
        return true;
    }

   
}
