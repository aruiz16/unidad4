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
@Table(name="tbl_empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_empresa")
    private Long idEmpresa;
    
    @ManyToOne(cascade =CascadeType.REMOVE)
    @JoinColumn(name="id_certificacion")    
    private Certificacion certificacion;
    
    @Column(name="nom_empresa")
    private String nomEmpresa;
    
    @Column(name="num_empleados")
    private int numEmpleados;
    
    @Column(name="estado")
    private String estado;
    
    @Column(name="domicilio")
    private String domicilio;

    public Empresa(Long idEmpresa, String nomEmpresa, int numEmpleados, String estado, String domicilio) {
        super();
        this.idEmpresa = idEmpresa;
        this.nomEmpresa = nomEmpresa;
        this.numEmpleados = numEmpleados;
        this.estado = estado;
        this.domicilio = domicilio;
    }

    public Empresa() {
        this.idEmpresa = 0L;
    }

    
    
    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNomEmpresa() {
        return nomEmpresa;
    }

    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(Certificacion certificacion) {
        this.certificacion = certificacion;
    }

    
}
