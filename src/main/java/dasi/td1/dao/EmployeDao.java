/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.dao;

import dasi.td1.metier.modele.Employe;

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
       
}
