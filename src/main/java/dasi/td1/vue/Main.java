/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.vue;

import dasi.td1.dao.JpaUtil;
import dasi.td1.metier.modele.Employe;
import dasi.td1.metier.service.Service;

/**
 *
 * @author etarassov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JpaUtil.creerFabriquePersistance();
        
        testerInitialiserEmployes();
        
        JpaUtil.fermerFabriquePersistance();
    }
    
    public static void testerInitialiserEmployes() {
        Service service = new Service();
        service.initialiserEmployes();
    }
    
}
