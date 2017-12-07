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
@Table(name="tbl_provedor")
public class Provedor implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_provedor")
    private Long idProvedor;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_empresa")    
    private Empresa empresa;
    
    @Column(name="nom_provedor", length=100)
    private String nomProvedor;
    
    @Column(name="ciudad")
    private String ciudad;

    public Provedor(Long idProvedor, Empresa empresa, String nomProvedor, String ciudad) {
        super();
        this.idProvedor = idProvedor;
        this.empresa = empresa;
        this.nomProvedor = nomProvedor;
        this.ciudad = ciudad;
    }

    public Provedor() {
        this.idProvedor = 0L;
    }


    public Long getIdProvedor() {
        return idProvedor;
    }

    public void setIdProvedor(Long idProvedor) {
        this.idProvedor = idProvedor;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public void setNomProvedor(String nomProvedor) {
        this.nomProvedor = nomProvedor;
    }

    
    public String getNomProvedor() {
        return nomProvedor;
    }

    public void setNumProducto(String nomProvedor) {
        this.nomProvedor = nomProvedor;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    
    
}
