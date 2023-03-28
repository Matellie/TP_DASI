/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.metier.modele;

import javax.persistence.*;

/**
 *
 * @author etarassov
 */
@Entity
public class Employe {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String telephonePro;
    private String login;
    private String motDePasse;

    public Employe() {
    }

    public Employe(String nom, String prenom, String telephonePro, String login) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephonePro = telephonePro;
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephonePro() {
        return telephonePro;
    }

    public String getLogin() {
        return login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephonePro(String telephonePro) {
        this.telephonePro = telephonePro;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", telephonePro=" + telephonePro + ", login=" + login + ", motDePasse=" + motDePasse + '}';
    }
    
    
}
