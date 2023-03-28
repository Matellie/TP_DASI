/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.metier.service;

import dasi.td1.metier.modele.Employe;
import dasi.td1.dao.EmployeDao;
import dasi.td1.dao.JpaUtil;

/**
 *
 * @author etarassov
 */
public class Service {

    public Service() {
        System.out.println("rgghfd");
    }
    
    public void initialiserEmployes() {
        Employe e1 = new Employe("FAVRO", "Samuel", "0642049305", "sfavro");
        Employe e2 = new Employe("DONODIO GALVIS", "Florine", "0671150503", "fdonodio");
        Employe e3 = new Employe("DEKEW", "Simon", "0713200950", "sdekew");
        Employe e4 = new Employe("LOU", "Flavien", "0437340532", "flou");
        Employe e5 = new Employe("GUOGUEN", "Gabriela", "0719843316", "ggouguen");
        
        e1.setMotDePasse("toto");
        e2.setMotDePasse("toto");
        e3.setMotDePasse("toto");
        e4.setMotDePasse("toto");
        e5.setMotDePasse("toto");
        
        EmployeDao employeDao = new EmployeDao();
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            
            employeDao.create(e1);
            employeDao.create(e2);
            employeDao.create(e3);
            employeDao.create(e4);
            employeDao.create(e5);
            
            JpaUtil.validerTransaction();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            JpaUtil.annulerTransaction();
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
    }    
}
