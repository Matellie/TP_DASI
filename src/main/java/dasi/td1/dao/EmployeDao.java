/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.dao;

import dasi.td1.metier.modele.Employe;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author etarassov
 */
public class EmployeDao {

    public EmployeDao() {
        
    }
    
    public void create(Employe employe) {
        JpaUtil.obtenirContextePersistance().persist(employe);
    }
    
    public Employe findById(Long id) {
        return JpaUtil.obtenirContextePersistance().find(Employe.class, id);
    }
    
    public List<Employe> findAll() {
        String s = "select e from Employe e order by e.nom asc";
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s, Employe.class);
        return query.getResultList();
    }
    
    public boolean authenticate(String login, String password) {
        String s = "select e from Employe e where e.login = :leLogin";
        
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s, Employe.class);
        query.setParameter("leLogin", login);
        Employe emp = (Employe)query.getSingleResult();
        
        return emp.getMotDePasse().equals(password);
    }
    
}
