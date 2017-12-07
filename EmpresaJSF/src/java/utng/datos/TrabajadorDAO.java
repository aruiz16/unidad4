/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Trabajador;

/**
 *
 * @author Alejandro RG
 */
public class TrabajadorDAO extends DAO<Trabajador>{
    
    public TrabajadorDAO() {
        super(new Trabajador());
    }
    
    public Trabajador getOneById(Trabajador trabajador)
            throws HibernateException {
        return super.getOneById(trabajador.getIdTrabajador());
    }
}
