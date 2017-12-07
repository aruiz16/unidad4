/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Cliente;

/**
 *
 * @author Alejandro RG
 */
public class ClienteDAO extends DAO<Cliente>{
    
    public ClienteDAO() {
        super(new Cliente());
    }
    
    public Cliente getOneById(Cliente cliente)
            throws HibernateException {
        return super.getOneById(cliente.getIdCliente());
    }
}
