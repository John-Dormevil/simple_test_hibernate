package com.test.hibernate.entity;


import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "client")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "datedenaissance")
	private Date dateDeNaissance;
	
	
	@OneToMany(mappedBy="client")
	@Cascade(value = { CascadeType.SAVE_UPDATE })
	private Set<Commande> commmandes;
	
	
	public Long getId() {
		return id;
	}
	
	public Client(){
		
	}

	public Client(String nom, String prenom, Date dateDeNaissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
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

	public Set<Commande> getCommmandes() {
		return commmandes;
	}

	public void setCommmandes(Set<Commande> commmandes) {
		this.commmandes = commmandes;
	}

	
}
