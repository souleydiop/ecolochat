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
import javax.persistence.Lob;
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
@Table(name = "lesMessages", catalog = "ecoloChat", schema = "")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LesMessages.findAll", query = "SELECT l FROM LesMessages l"),
		@NamedQuery(name = "LesMessages.findById", query = "SELECT l FROM LesMessages l WHERE l.id = :id"),
		@NamedQuery(name = "LesMessages.findByIdEmeteur", query = "SELECT l FROM LesMessages l WHERE l.idEmeteur = :idEmeteur"),
		@NamedQuery(name = "LesMessages.findByIdRecepteur", query = "SELECT l FROM LesMessages l WHERE l.idRecepteur = :idRecepteur") })
public class LesMessages implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Lob
	@Size(min = 1, max = 65535)
	@Column(name = "textMsg")
	private String textMsg;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idEmeteur")
	private String idEmeteur;
	@Basic(optional = false)
	@NotNull
	@Column(name = "idRecepteur")
	private String idRecepteur;

	public LesMessages() {
	}

	public LesMessages(Integer id) {
		this.id = id;
	}

	public LesMessages(Integer id, String textMsg, String idEmeteur, String idRecepteur) {
		this.id = id;
		this.textMsg = textMsg;
		this.idEmeteur = idEmeteur;
		this.idRecepteur = idRecepteur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTextMsg() {
		return textMsg;
	}

	public void setTextMsg(String textMsg) {
		this.textMsg = textMsg;
	}

	public String getIdEmeteur() {
		return idEmeteur;
	}

	public void setIdEmeteur(String idEmeteur) {
		this.idEmeteur = idEmeteur;
	}

	public String getIdRecepteur() {
		return idRecepteur;
	}

	public void setIdRecepteur(String idRecepteur) {
		this.idRecepteur = idRecepteur;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof LesMessages)) {
			return false;
		}
		LesMessages other = (LesMessages) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.ecoloChat.model.LesMessages[ id=" + id + " ]";
	}

}
