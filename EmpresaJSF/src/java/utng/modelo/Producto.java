/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;

import javax.persistence.CascadeType;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_producto")
public class Producto implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_producto")
    private Long idProducto;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_provedor")    
    private Provedor provedor;
    
    @Column(name="nom_producto")
    private String nomProducto;
    
    @Column(name="num_producto")
    private int numProducto;

    public Producto(Long idProducto, Provedor provedor, String nomProducto, int numProducto) {
        this.idProducto = idProducto;
        this.provedor = provedor;
        this.nomProducto = nomProducto;
        this.numProducto = numProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    

    public Producto() {
        this.idProducto = 0L;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    
    
}
