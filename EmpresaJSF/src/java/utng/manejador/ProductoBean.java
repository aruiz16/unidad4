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
import utng.datos.ProductoDAO;
import utng.datos.ProvedorDAO;
import utng.modelo.Producto;
import utng.modelo.Provedor;

@ManagedBean(name = "productoBean")
@SessionScoped
public class ProductoBean implements Serializable {
    private List<Producto> productos;
    private Producto producto;
    private List<Provedor> provedores;
    
    public ProductoBean() {
        producto = new Producto();
        producto.setProvedor(new Provedor());
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Provedor> getProvedores() {
        return provedores;
    }

    public void setProvedores(List<Provedor> provedores) {
        this.provedores = provedores;
    }

    public String listar() {
        ProductoDAO dao = new ProductoDAO();
        try {
            productos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Productos";
    }
    
    public String eliminar() {
        ProductoDAO dao = new ProductoDAO();
        try {
            dao.delete(producto);
            productos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        producto = new Producto();
        producto.setProvedor(new Provedor());
        try {
            provedores = new ProvedorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }

    public String guardar() {
        ProductoDAO dao = new ProductoDAO();
        try {
            if (producto.getIdProducto() != 0) {
                dao.update(producto);
            } else {
                dao.insert(producto);
            }
            productos = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Producto producto) {
        this.producto = producto;
        try {
            provedores = new ProvedorDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
}
