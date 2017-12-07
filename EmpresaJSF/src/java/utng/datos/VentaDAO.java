/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Venta;

/**
 *
 * @author Alejandro RG
 */
public class VentaDAO extends DAO<Venta>{
    
    public VentaDAO() {
        super(new Venta());
    }
    
    public Venta getOneById(Venta venta)
            throws HibernateException {
        return super.getOneById(venta.getIdVenta());
    }
}
