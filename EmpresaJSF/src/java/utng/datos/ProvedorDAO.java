/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Provedor;

/**
 *
 * @author Alejandro RG
 */
public class ProvedorDAO extends DAO<Provedor>{
    
    public ProvedorDAO() {
        super(new Provedor());
    }
    
    public Provedor getOneById(Provedor provedor)
            throws HibernateException {
        return super.getOneById(provedor.getIdProvedor());
    }
}
