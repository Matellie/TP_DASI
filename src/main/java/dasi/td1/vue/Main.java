/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.vue;

import dasi.td1.dao.JpaUtil;
import dasi.td1.metier.modele.Client;
import dasi.td1.metier.modele.Employe;
import dasi.td1.metier.service.Service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author etarassov
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Long test = new Long(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        
        Client sam = null;
        Client bob = null;
        Client robin = null;
        
        try {
            sam = new Client("FAVRO", "Samuel", sdf.parse("2000/12/20"), "20 avenue AE", "sfavro@gmail.com", "toto");
            bob = new Client("GRIP", "Bob", sdf.parse("2010/04/20"), "20 avenue AE", "bobby@gmail.com", "toto");
            robin = new Client("CRINGE", "Robin", sdf.parse("2006/08/20"), "20 avenue AE", "robina@gmail.com", "toto");
        } catch (ParseException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JpaUtil.creerFabriquePersistance();
        
        testerInscriptionclient(sam);
        testerInscriptionclient(bob);
        testerInscriptionclient(robin);
        
        JpaUtil.fermerFabriquePersistance();
    }
    
    public static void testerInitialiserEmployes() {
        Service service = new Service();
        service.initialiserEmployes();
    }
    
    public static void testerTrouverEmployeParId(Long id) {
        Service service = new Service();
        System.out.println(service.trouverEmployeParId(id).toString());
    }
    
    public static void testerListerTousEmployes() {
        Service service = new Service();
        List<Employe> listEmp = service.listerTousEmployes();
        for (Employe employe : listEmp) {
            System.out.println(employe);
        }
    }
    
    public static void testerAuthentifierEmploye(String login, String password) {
        Service service = new Service();
        if(service.authentifierEmploye(login, password)) {
            System.out.println("success");
        } else {
            System.out.println("rip");
        }
    }
    
    public static void testerInscriptionclient(Client client) {
        Service service = new Service();
        service.inscriptionClient(client);
    }
}
