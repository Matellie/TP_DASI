/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dasi.td1.metier.modele;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author etarassov
 */
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String nom;
    private String prenom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNaissance;
    private String adressePostale;
    @Column(unique=true)
    private String mail;
    private String motDePasse;

    public Client() {
    }

    public Client(String nom, String prenom, Date dateNaissance, String adressePostale, String mail, String motDePasse) {
        this.id = id;
        this.dateNaissance = dateNaissance;
        this.nom = nom;
        this.prenom = prenom;
        this.adressePostale = adressePostale;
        this.mail = mail;
        this.motDePasse = motDePasse;
    }

    public long getId() {
        return id;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdressePostale() {
        return adressePostale;
    }

    public String getMail() {
        return mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdressePostale(String adressePostale) {
        this.adressePostale = adressePostale;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", dateNaissance=" + dateNaissance + ", nom=" + nom + ", prenom=" + prenom + ", adressePostale=" + adressePostale + ", mail=" + mail + ", motDePasse=" + motDePasse + '}';
    }
    
    
}
