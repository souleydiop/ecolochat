package com.ecoloChat.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ecoloChat.model.Utilisateur;
import com.ecoloChat.services.IutilisateurService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@Component
@SessionScoped
@ManagedBean
public class UtilisateurBean extends SpringBeanAutowiringSupport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IutilisateurService UtilisateurService;

	private String username;

	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login(ActionEvent event) {
		FacesMessage message = null;
		boolean loggedIn = false;
		Utilisateur u = UtilisateurService.getUserByLoginAndPass(username, password);
		if (u != null) {

			FacesContext.getCurrentInstance().getApplication().getNavigationHandler().handleNavigation(
					FacesContext.getCurrentInstance(), null,
					"menuChat?faces-redirect=true&id=" + u.getIdUtilisateur());
		} else {
			System.out.println("non connecter");
		}

	}

	public String getMsg() {
		return UtilisateurService.getMsg();
	}

}