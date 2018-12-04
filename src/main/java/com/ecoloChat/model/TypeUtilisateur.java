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
@Table(name = "typeUtilisateur", catalog = "ecoloChat", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "TypeUtilisateur.findAll", query = "SELECT t FROM TypeUtilisateur t"),
		@NamedQuery(name = "TypeUtilisateur.findByIdType", query = "SELECT t FROM TypeUtilisateur t WHERE t.idType = :idType"),
		@NamedQuery(name = "TypeUtilisateur.findByLibelle", query = "SELECT t FROM TypeUtilisateur t WHERE t.libelle = :libelle") })
public class TypeUtilisateur implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idType")
	private Integer idType;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 200)
	@Column(name = "libelle")
	private String libelle;

	public TypeUtilisateur() {
	}

	public TypeUtilisateur(Integer idType) {
		this.idType = idType;
	}

	public TypeUtilisateur(Integer idType, String libelle) {
		this.idType = idType;
		this.libelle = libelle;
	}

	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idType != null ? idType.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof TypeUtilisateur)) {
			return false;
		}
		TypeUtilisateur other = (TypeUtilisateur) object;
		if ((this.idType == null && other.idType != null)
				|| (this.idType != null && !this.idType.equals(other.idType))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ecoloChat.model.TypeUtilisateur[ idType=" + idType + " ]";
	}

}
