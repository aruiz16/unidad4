/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.modelo;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_certificacion")
public class Certificacion implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)  
    
    @Column(name="id_certificacion")
    private Long idCertificacion;
        
    @Column(name="nom_certificacion",length=100)
    private String nomCertificacion;

    public Certificacion(Long idCertificacion, String nomCertificacion) {
        this.idCertificacion = idCertificacion;
        this.nomCertificacion = nomCertificacion;
    }

    
    
    public Certificacion() {
        this.idCertificacion = 0L;
    }

    public Long getIdCertificacion() {
        return idCertificacion;
    }

    public void setIdCertificacion(Long idCertificacion) {
        this.idCertificacion = idCertificacion;
    }

    public String getNomCertificacion() {
        return nomCertificacion;
    }

    public void setNomCertificacion(String nomCertificacion) {
        this.nomCertificacion = nomCertificacion;
    }

    
}
