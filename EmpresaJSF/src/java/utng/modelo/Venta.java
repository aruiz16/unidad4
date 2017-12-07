/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_venta")
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)    
    @Column(name="id_venta")
    private Long idVenta;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_cliente")    
    private Cliente cliente;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_trabajador")    
    private Trabajador trabajador;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_producto")    
    private Producto producto;
    
    @Column(name="monto")
    private double monto;
    
    @Column(name="descripcion", length=100)
    private String descripcion;

    public Venta(Long idVenta, Cliente cliente, Trabajador trabajador, Producto producto, double monto, String descripcion) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.trabajador = trabajador;
        this.producto = producto;
        this.monto = monto;
        this.descripcion = descripcion;
    }

    

    public Venta() {
        this.idVenta=0L;
    }

    public Long getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Long idVenta) {
        this.idVenta = idVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
