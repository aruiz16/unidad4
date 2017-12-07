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
import utng.datos.ProvedorDAO;
import utng.modelo.Empresa;
import utng.modelo.Provedor;

@ManagedBean(name = "provedorBean")
@SessionScoped
public class ProvedorBean implements Serializable {
    private List<Provedor> provedores;
    private Provedor provedor;
    private List<Empresa> empresas;
    
    public ProvedorBean() {
        provedor = new Provedor();
        provedor.setEmpresa(new Empresa());
    }

    public List<Provedor> getProvedores() {
        return provedores;
    }

    public void setProvedores(List<Provedor> provedores) {
        this.provedores = provedores;
    }

    public Provedor getProvedor() {
        return provedor;
    }

    public void setProvedor(Provedor provedor) {
        this.provedor = provedor;
    }

    public List<Empresa> getEmpresas() {
        return empresas;
    }

    public void setEmpresas(List<Empresa> empresas) {
        this.empresas = empresas;
    }
    
    public String listar() {
        ProvedorDAO dao = new ProvedorDAO();
        try {
            provedores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Provedores";
    }
    
    public String eliminar() {
        ProvedorDAO dao = new ProvedorDAO();
        try {
            dao.delete(provedor);
            provedores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        provedor= new Provedor();
        provedor.setEmpresa(new Empresa());
        try {
            empresas = new EmpresaDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }

    public String guardar() {
        ProvedorDAO dao = new ProvedorDAO();
        try {
            if (provedor.getIdProvedor() != 0) {
                dao.update(provedor);
            } else {
                dao.insert(provedor);
            }
            provedores = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Provedor provedor) {
        this.provedor = provedor;
        try {
            empresas = new EmpresaDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
}
