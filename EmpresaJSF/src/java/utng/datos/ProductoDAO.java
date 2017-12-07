/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Producto;

/**
 *
 * @author Alejandro RG
 */
public class ProductoDAO extends DAO<Producto>{
    
    public ProductoDAO() {
        super(new Producto());
    }
    
    public Producto getOneById(Producto producto)
            throws HibernateException {
        return super.getOneById(producto.getIdProducto());
    }
}
