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
import utng.modelo.Cliente;

@ManagedBean(name = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable{
    private List<Cliente> clientes;
    private Cliente cliente;

    public ClienteBean () {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public String listar(){
        ClienteDAO dao = new ClienteDAO();
        try {
            clientes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Clientes";
    }
    
    public String eliminar(){
         ClienteDAO dao = new ClienteDAO();
        try {
            dao.delete(cliente);
            clientes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Eliminar";
    }
    
    public String iniciar(){
        cliente= new Cliente();
        return "Iniciar";
    }

    public String guardar(){
        ClienteDAO dao = new ClienteDAO();
        try {
            if(cliente.getIdCliente()!= 0){
                dao.update(cliente);
            }else {
                dao.insert(cliente);
            }
            clientes=dao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Guardar";
    }
    
    public String cancelar(){
        return "Cancelar";
    }
    
    public String editar(Cliente cliente){
        this.cliente=cliente;
        return "Editar";
    }   
}
