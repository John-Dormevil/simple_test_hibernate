package com.test.hibernate.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.Table;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
@Table(appliesTo="commande")

public class Commande implements Serializable{
	
	
	@Generated(strategy=GenerationType.SEQUENCE, generator="SEQ_STORE")
	private Long Id;
	
	@Columns(name = "numerocommande", type="string")
	private Long numeroDeCommande;
	
	@Columns(name = "datecommande", type="string")
	private Date dateDeLacommande;
	
	@OneToOne(targetEntity="client" , mappedBy="commande")
	private Client client;
	
	@Id 
	public Long getId() {
		return Id;
	}
	
	public void setId(Long id) {
		Id = id;
	}

	public Long getNumeroDeCommande() {
		return numeroDeCommande;
	}

	public void setNumeroDeCommande(Long numeroDeCommande) {
		this.numeroDeCommande = numeroDeCommande;
	}

	public Date getDateDeLacommande() {
		return dateDeLacommande;
	}

	public void setDateDeLacommande(Date dateDeLacommande) {
		this.dateDeLacommande = dateDeLacommande;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
}
