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

import com.losalpes.bos.Detalle;
import com.losalpes.bos.Compra;
import com.losalpes.bos.Mueble;
import com.losalpes.servicios.IServicioCompra;
import com.losalpes.servicios.ServicioCompra;
import java.util.ArrayList;
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
public class CompraBean
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Representa un nuevo mueble a ingresar
     */
    private List<Detalle> detalles;
    private Mueble mueble;
    private Compra compra;
    
    private Integer cantidad;
    private Integer totalPagar;
    private String metodo;
    
    /**
     * Relación con la interfaz que provee los servicios necesarios del catálogo.
     */
    

 
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------

    /**
     * Constructor de la clase principal
     */
    public CompraBean()
    {
        metodo = "";
        detalles = new ArrayList<Detalle>();
        
        totalPagar = 0;
    }



    //-----------------------------------------------------------
    // Métodos
    //-----------------------------------------------------------
    public String verMueble(Mueble mueble) {        
        this.setMueble(mueble);
        return "mostrar.xhtml";
    }
    
    public String agregarMueble() {
        Detalle detalle = new Detalle();
        detalle.setCantidad(cantidad);
        
        setTotalPagar((Integer) (getTotalPagar() + cantidad * mueble.getPrecioUnitario()));
        detalle.setTotal(cantidad * mueble.getPrecioUnitario());
        detalle.setMueble(mueble);
        getDetalles().add(detalle);
        return verCarrito();
    }
    
    public void eliminarMueble(Detalle detalle) {
        setTotalPagar((Integer) (getTotalPagar() - detalle.getTotal()));
        detalles.remove(detalle);
        System.out.println(detalles.size());
    }
    
    public String cancelar() {
        return "compra.xhtml";
    }
    
    public String verCarrito() {
        return "carrito.xhtml";
    }
    
    public String pagar() {
        setCompra(new Compra());
        getCompra().setReferencia(String.valueOf(System.currentTimeMillis()));
        getCompra().setTotal(totalPagar);
        StringBuffer descripcion = new StringBuffer();
        for (Detalle detalle : detalles) {
            descripcion.append(detalle.getCantidad() + " "+ detalle.getMueble().getDescripcion() + " - ");
        }
        getCompra().setDescripcion(descripcion.toString());
        
        return "pagar.xhtml";
        
    }
    
    public String realizarPago() {
        compra.setDetalles(detalles);
        compra.setCliente(Singleton.getInstance().getCliente());
        Singleton.getInstance().getServicioCompra().agregarCompra(compra);
        compra = new Compra();
        detalles.clear();
        totalPagar = 0;
        return "exito.xhtml";
    }

    
    public SelectItem[] getMeses()
    {
       
        SelectItem[] sitems = new SelectItem[12];
        
        for (int i = 1; i <= 12; i++)
        {
             sitems[i - 1] = new SelectItem(String.format("%02d", i));
        }
        return sitems;
    }
    
    public SelectItem[] getAnhos()
    {
       
        SelectItem[] sitems = new SelectItem[9];
        
        for (int i = 2017; i <= 2025; i++)
        {
             sitems[i - 2017] = new SelectItem(i);
        }
        return sitems;
    }
        
        
    public SelectItem[] getCuotas()
    {
       
        SelectItem[] sitems = new SelectItem[12];
        
        for (int i = 1; i <= 12; i++)
        {
             sitems[i - 1] = new SelectItem(i);
        }
        return sitems;
    }
    
    /**
     * @return the mueble
     */
    public Mueble getMueble() {
        return mueble;
    }

    /**
     * @param mueble the mueble to set
     */
    public void setMueble(Mueble mueble) {
        this.mueble = mueble;
    }

    /**
     * @return the detalles
     */
    public List<Detalle> getDetalles() {
        return detalles;
    }

    /**
     * @param detalles the detalles to set
     */
    public void setDetalles(List<Detalle> detalles) {
        this.detalles = detalles;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the totalPagar
     */
    public Integer getTotalPagar() {
        return totalPagar;
    }

    /**
     * @param totalPagar the totalPagar to set
     */
    public void setTotalPagar(Integer totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * @return the compra
     */
    public Compra getCompra() {
        return compra;
    }

    /**
     * @param compra the compra to set
     */
    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    /**
     * @return the metodo
     */
    public String getMetodo() {
        return metodo;
    }

    /**
     * @param metodo the metodo to set
     */
    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

}
