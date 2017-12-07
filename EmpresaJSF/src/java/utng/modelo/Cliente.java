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
@Table(name="tbl_cliente")
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    @Column(name="id_cliente")
    private Long idCliente;
    
    @Column(name="nom_cliente")
    private String nomCliente;
    
    @Column(name="apellidoP_cli")
    private String apePatCli;
    
    @Column(name="apellidoM_cli")
    private String  apeMatCli;
    
    @Column(name="edad")
    private int edad;

    public Cliente(Long idCliente, String nomCliente, String apePatCli, String apeMatCli, int edad) {
        super();
        this.idCliente = idCliente;
        this.nomCliente = nomCliente;
        this.apePatCli = apePatCli;
        this.apeMatCli = apeMatCli;
        this.edad = edad;
    }

    public Cliente() {
        this.idCliente = 0L;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApePatCli() {
        return apePatCli;
    }

    public void setApePatCli(String apePatCli) {
        this.apePatCli = apePatCli;
    }

    public String getApeMatCli() {
        return apeMatCli;
    }

    public void setApeMatCli(String apeMatCli) {
        this.apeMatCli = apeMatCli;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
