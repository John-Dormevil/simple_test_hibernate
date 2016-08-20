package com.test.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Table;

@Entity
@Table(appliesTo = "client")
public class Client implements Serializable{

	private Long id;
	
	@Columns(name = "nom", type="string")
	private String nom;
	
	@Columns(name = "prenom", type="string")
	private String prenom;
	
	@Columns(name = "datedenaissance", type="Date")
	private Date dateDeNaissance;

	@OneToMany(targetEntity="commande", mappedBy="client")
	private Long commmandes;
	
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Long getCommmandes() {
		return commmandes;
	}

	public void setCommmandes(Long commmandes) {
		this.commmandes = commmandes;
	}

	
}
