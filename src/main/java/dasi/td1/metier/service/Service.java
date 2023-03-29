/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.metier.service;

import dasi.td1.dao.ClientDao;
import dasi.td1.metier.modele.Employe;
import dasi.td1.dao.EmployeDao;
import dasi.td1.dao.JpaUtil;
import dasi.td1.metier.modele.Client;
import java.util.List;
import util.Message;

/**
 *
 * @author etarassov
 */
public class Service {

    public Service() {
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
    
    public Employe trouverEmployeParId(Long id) {
        EmployeDao employeDao = new EmployeDao();
        Employe emp = null;
        
        try {
            JpaUtil.creerContextePersistance();
            
            emp = employeDao.findById(id);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return emp;
    }
    
    public List<Employe> listerTousEmployes() {
        EmployeDao employeDao = new EmployeDao();
        List<Employe> listeEmp = null;
        
        try {
            JpaUtil.creerContextePersistance();
            
            listeEmp = employeDao.findAll();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return listeEmp;
    }
    
    public boolean authentifierEmploye(String login, String password) {
        EmployeDao employeDao = new EmployeDao();
        boolean auth = false;
        
        try {
            JpaUtil.creerContextePersistance();
            
            auth = employeDao.authenticate(login, password);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return auth;
    }
    
    public void inscriptionClient(Client client) {
        Message message = new Message();
        ClientDao clientDao = new ClientDao();
        
        String mailExpediteur = "Systeme";
        String mailDestinataire = client.getMail();
        
        try {
            JpaUtil.creerContextePersistance();
            JpaUtil.ouvrirTransaction();
            
            clientDao.create(client);
            
            JpaUtil.validerTransaction();
            
            message.envoyerMail(mailExpediteur, mailDestinataire, "Confirmation inscription", "Vous etes bien inscrit !");
        }
        catch (Exception ex) {
            ex.printStackTrace();
            JpaUtil.annulerTransaction();
            
            message.envoyerMail(mailExpediteur, mailDestinataire, "Infirmation inscription", "Oups, une erreur s est produite !");
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
    }
    
    public Client trouverClientParId(Long id) {
        ClientDao clientDao = new ClientDao();
        Client cli = null;
        
        try {
            JpaUtil.creerContextePersistance();
            
            cli = clientDao.findById(id);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return cli;
    }
    
    public boolean authentifierClientMail(String mail, String password) {
        ClientDao clientDao = new ClientDao();
        boolean auth = false;
        
        try {
            JpaUtil.creerContextePersistance();
            
            auth = clientDao.authenticateMail(mail, password);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return auth;
    }
    
    public boolean authentifierClientId(Long id, String password) {
        ClientDao clientDao = new ClientDao();
        boolean auth = false;
        
        try {
            JpaUtil.creerContextePersistance();
            
            auth = clientDao.authenticateId(id, password);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            JpaUtil.fermerContextePersistance();
        }
        
        return auth;
    }
}
