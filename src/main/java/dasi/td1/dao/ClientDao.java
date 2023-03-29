/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.dao;

import dasi.td1.metier.modele.Client;
import dasi.td1.metier.modele.Employe;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author etarassov
 */
public class ClientDao {

    public ClientDao() {
        
    }
    
    public void create(Client client) {
        JpaUtil.obtenirContextePersistance().persist(client);
    }
    
    public Client findById(Long id) {
        return JpaUtil.obtenirContextePersistance().find(Client.class, id);
    }
    
    public boolean authenticateMail(String mail, String password) {
        String s = "select c from Client c where c.login = :leLogin";
        
        TypedQuery query = JpaUtil.obtenirContextePersistance().createQuery(s, Client.class);
        query.setParameter("leLogin", mail);
        Client cli = (Client)query.getSingleResult();
        
        return cli.getMotDePasse().equals(password);
    }
    
    public boolean authenticateId(Long id, String password) {
        Client cli = JpaUtil.obtenirContextePersistance().find(Client.class, id);
        
        return cli.getMotDePasse().equals(password);
    }
    
}
