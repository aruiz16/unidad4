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
import utng.datos.TrabajadorDAO;
import utng.modelo.Empresa;
import utng.modelo.Trabajador;

@ManagedBean(name = "trabajadorBean")
@SessionScoped
public class TrabajadorBean implements Serializable {
    private List<Trabajador> trabajadores;
    private Trabajador trabajador;
    private List<Empresa> empresas;
    
    public TrabajadorBean() {
        trabajador = new Trabajador();
        trabajador.setEmpresa(new Empresa());
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }

    public String listar() {
        TrabajadorDAO dao = new TrabajadorDAO();
        try {
            trabajadores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Trabajadores";
    }
    
    public String eliminar() {
        TrabajadorDAO dao = new TrabajadorDAO();
        try {
            dao.delete(trabajador);
            trabajadores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        trabajador = new Trabajador();
        trabajador.setEmpresa(new Empresa());
        try {
            empresas = new EmpresaDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }

    public String guardar() {
        TrabajadorDAO dao = new TrabajadorDAO();
        try {
            if (trabajador.getIdTrabajador() != 0) {
                dao.update(trabajador);
            } else {
                dao.insert(trabajador);
            }
            trabajadores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Trabajador trabajador) {
        this.trabajador = trabajador;
        try {
            empresas = new EmpresaDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
}
