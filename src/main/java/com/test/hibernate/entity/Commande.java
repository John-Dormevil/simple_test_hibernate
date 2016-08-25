package com.test.hibernate.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="numeroDeCommande")
	private Long numeroDeCommande;
	
	@Column(name="dateDeLaCommande")
	private Date dateDeLaCommande;
	
	@ManyToOne
	@JoinColumn(name = "client_id", nullable=false)
	private Client client;
	
	public void setId(Long id){
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	

	public Long getNumeroDeCommande() {
		return numeroDeCommande;
	}

	public Commande setNumeroDeCommande(Long numeroDeCommande) {
		this.numeroDeCommande = numeroDeCommande;
		return this;
	}

	public Date getDateDeLaCommande() {
		return dateDeLaCommande;
	}

	public Commande setDateDeLaCommande(Date dateDeLacommande) {
		this.dateDeLaCommande = dateDeLacommande;
		
		return this;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
