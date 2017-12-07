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
@Table(name="tbl_trabajador")
public class Trabajador implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_trabajador")
    private Long idTrabajador;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_empresa")    
    private Empresa empresa;
    
    @Column(name="nom_trabajador")
    private String nomTrabajador;
    
    @Column(name="apellidoP_tra")
    private String apePatTra;
    
    @Column(name="apellidoM_tra")
    private String  apeMatTra;
    
    @Column(name="edad")
    private int edad;

    public Trabajador(Long idTrabajador, Empresa empresa, String nomTrabajador, String apePatTra, String apeMatTra, int edad) {
        this.idTrabajador = idTrabajador;
        this.empresa = empresa;
        this.nomTrabajador = nomTrabajador;
        this.apePatTra = apePatTra;
        this.apeMatTra = apeMatTra;
        this.edad = edad;
    }

    public Trabajador() {
        this.idTrabajador = 0L;
    }

    public Long getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNomTrabajador() {
        return nomTrabajador;
    }

    public void setNomTrabajador(String nomTrabajador) {
        this.nomTrabajador = nomTrabajador;
    }

    public String getApePatTra() {
        return apePatTra;
    }

    public void setApePatTra(String apePatTra) {
        this.apePatTra = apePatTra;
    }

    public String getApeMatTra() {
        return apeMatTra;
    }

    public void setApeMatTra(String apeMatTra) {
        this.apeMatTra = apeMatTra;
    }

    

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
