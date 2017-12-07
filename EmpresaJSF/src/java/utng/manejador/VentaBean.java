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
import utng.datos.ClienteDAO;
import utng.datos.ProductoDAO;
import utng.datos.TrabajadorDAO;
import utng.datos.VentaDAO;
import utng.modelo.Cliente;
import utng.modelo.Producto;
import utng.modelo.Trabajador;
import utng.modelo.Venta;

@ManagedBean(name = "ventaBean")
@SessionScoped
public class VentaBean implements Serializable {
    private List<Venta> ventas;
    private Venta venta;
    private List<Cliente> clientes;
    private List<Trabajador> trabajadores;
    private List<Producto> productos;
    
    public VentaBean() {
        venta = new Venta();
        venta.setCliente(new Cliente());
        venta.setTrabajador(new Trabajador());
        venta.setProducto(new Producto());
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(List<Trabajador> trabajadores) {
        this.trabajadores = trabajadores;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    
    public String listar() {
        VentaDAO dao = new VentaDAO();
        try {
            ventas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Ventas";
    }
    
    public String eliminar() {
        VentaDAO dao = new VentaDAO();
        try {
            dao.delete(venta);
            ventas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }

    public String iniciar() {
        venta = new Venta();
        venta.setCliente(new Cliente());
        venta.setTrabajador(new Trabajador());
        venta.setProducto(new Producto());
        try {
            clientes = new ClienteDAO().getAll();
            trabajadores = new TrabajadorDAO().getAll();
            productos = new ProductoDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Iniciar";
    }

    public String guardar() {
        VentaDAO dao = new VentaDAO();
        try {
            if (venta.getIdVenta() != 0) {
                dao.update(venta);
            } else {
                dao.insert(venta);
            }
            ventas = dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }

    public String cancelar() {
        return "Cancelar";
    }

    public String editar(Venta venta) {
        this.venta = venta;
        try {
            clientes = new ClienteDAO().getAll();
            trabajadores = new TrabajadorDAO().getAll();
            productos = new ProductoDAO().getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Editar";
    }
}
