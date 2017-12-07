/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.manejador;

import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import utng.datos.EmpresaDAO;
import utng.datos.CertificacionDAO;
import utng.modelo.Certificacion;
import utng.modelo.Empresa;

@ManagedBean(name = "certificacionBean")
@SessionScoped
public class CertificacionBean implements Serializable {
    private List<Certificacion> certificaciones;
    private Certificacion certificacion;
    
    
    public CertificacionBean() {
    }

    public List<Certificacion> getCertificaciones() {
        return certificaciones;
    }

    public void setCertificaciones(List<Certificacion> certificaciones) {
        this.certificaciones = certificaciones;
    }

    public Certificacion getCertificacion() {
        return certificacion;
    }

    public void setCertificacion(Certificacion certificacion) {
        this.certificacion = certificacion;
    }

    public String listar() {
        CertificacionDAO dao = new CertificacionDAO();
        try {
            certificaciones = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Certificaciones";
    }
    
    public String eliminar() {
        CertificacionDAO dao = new CertificacionDAO();
        try {
            dao.delete(certificacion);
            certificaciones = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        certificacion= new Certificacion();
        return "Iniciar";
    }

    public String guardar() {
        CertificacionDAO dao = new CertificacionDAO();
        try {
            if (certificacion.getIdCertificacion() != 0) {
                dao.update(certificacion);
            } else {
                dao.insert(certificacion);
            }
            certificaciones = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Certificacion certificacion) {
        this.certificacion=certificacion;
        return "Editar";
    }
}
