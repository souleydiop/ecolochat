/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecoloChat.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Baye
 */
@Entity
@Table(name = "utilisateur", catalog = "ecoloChat", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Utilisateur.findAll", query = "SELECT u FROM Utilisateur u"),
		@NamedQuery(name = "Utilisateur.findByIdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idUtilisateur = :idUtilisateur"),
		@NamedQuery(name = "Utilisateur.findByNomUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.nomUtilisateur = :nomUtilisateur"),
		@NamedQuery(name = "Utilisateur.findByPrenomUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.prenomUtilisateur = :prenomUtilisateur"),
		@NamedQuery(name = "Utilisateur.findByEmailUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.emailUtilisateur = :emailUtilisateur"),
		@NamedQuery(name = "Utilisateur.findByPwdUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.pwdUtilisateur = :pwdUtilisateur"),
		@NamedQuery(name = "Utilisateur.findByPseudo", query = "SELECT u FROM Utilisateur u WHERE u.pseudo = :pseudo"),
		@NamedQuery(name = "Utilisateur.findByActif", query = "SELECT u FROM Utilisateur u WHERE u.actif = :actif"),
		@NamedQuery(name = "Utilisateur.findByIdTypeUtilisateur", query = "SELECT u FROM Utilisateur u WHERE u.idTypeUtilisateur = :idTypeUtilisateur") })
public class Utilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idUtilisateur")
	private Integer idUtilisateur;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "nomUtilisateur")
	private String nomUtilisateur;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "prenomUtilisateur")
	private String prenomUtilisateur;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "emailUtilisateur")
	private String emailUtilisateur;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "pwdUtilisateur")
	private String pwdUtilisateur;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "pseudo")
	private String pseudo;
	@Basic(optional = false)
	@NotNull
	@Column(name = "actif")
	private int actif;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idTypeUtilisateur")
	private int idTypeUtilisateur;

	public Utilisateur() {
	}

	public Utilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public Utilisateur(Integer idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String emailUtilisateur,
			String pwdUtilisateur, String pseudo, int actif, int idTypeUtilisateur) {
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.emailUtilisateur = emailUtilisateur;
		this.pwdUtilisateur = pwdUtilisateur;
		this.pseudo = pseudo;
		this.actif = actif;
		this.idTypeUtilisateur = idTypeUtilisateur;
	}

	public Integer getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Integer idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}

	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}

	public String getPwdUtilisateur() {
		return pwdUtilisateur;
	}

	public void setPwdUtilisateur(String pwdUtilisateur) {
		this.pwdUtilisateur = pwdUtilisateur;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getActif() {
		return actif;
	}

	public void setActif(int actif) {
		this.actif = actif;
	}

	public int getIdTypeUtilisateur() {
		return idTypeUtilisateur;
	}

	public void setIdTypeUtilisateur(int idTypeUtilisateur) {
		this.idTypeUtilisateur = idTypeUtilisateur;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idUtilisateur != null ? idUtilisateur.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Utilisateur)) {
			return false;
		}
		Utilisateur other = (Utilisateur) object;
		if ((this.idUtilisateur == null && other.idUtilisateur != null)
				|| (this.idUtilisateur != null && !this.idUtilisateur.equals(other.idUtilisateur))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ecoloChat.model.Utilisateur[ idUtilisateur=" + idUtilisateur + " ]";
	}

}
