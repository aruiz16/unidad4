/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utng.datos;

import org.hibernate.HibernateException;
import utng.modelo.Certificacion;

/**
 *
 * @author Alejandro RG
 */
public class CertificacionDAO extends DAO<Certificacion>{
    
    public CertificacionDAO() {
        super(new Certificacion());
    }
    
    public Certificacion getOneById(Certificacion certificacion)
            throws HibernateException {
        return super.getOneById(certificacion.getIdCertificacion());
    }
}
