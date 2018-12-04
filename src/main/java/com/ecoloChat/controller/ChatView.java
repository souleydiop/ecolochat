package com.ecoloChat.controller;

import java.io.Serializable;
import java.util.List;

import org.primefaces.context.RequestContext;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.ecoloChat.model.LesMessages;
import com.ecoloChat.model.Utilisateur;
import com.ecoloChat.services.IutilisateurService;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class ChatView extends SpringBeanAutowiringSupport implements Serializable {

	// private final PushContext pushContext =
	// PushContextFactory.getDefault().getPushContext();

	private final EventBus eventBus = EventBusFactory.getDefault().eventBus();

	@Autowired
	private IutilisateurService UtilisateurService;

	@ManagedProperty("#{chatUsers}")
	private ChatUsers users;

	private String privateMessage;

	private String globalMessage;

	private String username;

	private String password;

	private boolean loggedIn;

	private String privateUser;

	private List<LesMessages> lMsg;

	Utilisateur connectedUser;

	public List<LesMessages> getlMsg() {
		return lMsg;
	}

	public void setlMsg(List<LesMessages> lMsg) {
		this.lMsg = lMsg;
	}

	public Utilisateur getConnectedUser() {
		return connectedUser;
	}

	public void setConnectedUser(Utilisateur connectedUser) {
		this.connectedUser = connectedUser;
	}

	private final static String CHANNEL = "/{room}/";

	public ChatUsers getUsers() {

		return users;
	}

	public void setUsers(ChatUsers users) {
		this.users = users;
	}

	public String getPrivateUser() {
		return privateUser;
	}

	public void setPrivateUser(String privateUser) {
		this.privateUser = privateUser;
	}

	public String getGlobalMessage() {
		return globalMessage;
	}

	public void setGlobalMessage(String globalMessage) {
		this.globalMessage = globalMessage;
	}

	public String getPrivateMessage() {
		return privateMessage;
	}

	public void setPrivateMessage(String privateMessage) {
		this.privateMessage = privateMessage;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isLoggedIn() {
		// loggedIn = true;
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public void sendGlobal() {
		eventBus.publish(CHANNEL + "*", username + ": " + globalMessage);
		globalMessage = null;
	}

	public void sendPrivate() {
		eventBus.publish(CHANNEL + privateUser, "[PM] " + username + ": " + privateMessage);
		eventBus.publish(CHANNEL + connectedUser.getEmailUtilisateur(), "[PM] " + "MOI" + ": " + privateMessage);
		LesMessages msg = new LesMessages();
		msg.setIdEmeteur(connectedUser.getPseudo());
		msg.setIdRecepteur(UtilisateurService.getUserByEmail(privateUser).getPseudo());
		msg.setTextMsg(privateMessage);
		UtilisateurService.savemessage(msg);
		privateMessage = null;
	}

	public void chargerLesDiscussion(String user1) {
		// System.out.println(connectedUser.getIdUtilisateur()+
		// "----"+UtilisateurService.getUserByEmail(user1).getIdUtilisateur());
		try {
			lMsg = UtilisateurService.getAllMsgByIdEmeteurAndRecepteur(connectedUser.getPseudo(),
					UtilisateurService.getUserByEmail(user1).getPseudo());
			for (LesMessages ut : lMsg) {
				System.out.println(ut.getTextMsg());
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void login() {
		RequestContext requestContext = RequestContext.getCurrentInstance();
		connectedUser = UtilisateurService.getUserByLoginAndPass(username, password);

		if (connectedUser != null) {
			users.add(connectedUser.getPseudo());
			requestContext.execute("PF('subscriber').connect('/" + connectedUser.getPseudo() + "')");
			loggedIn = true;

			/**
			 * List<Utilisateur> lu=UtilisateurService.getListeAllUsers(); for (Utilisateur
			 * ut : lu) { if(ut.getEmailUtilisateur()!=u.getEmailUtilisateur()){
			 * users.add(ut.getEmailUtilisateur());
			 * requestContext.execute("PF('subscriber').connect('/" +
			 * ut.getEmailUtilisateur() + "')"); } }
			 */

		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Login ou mot de passe Incorrect", "Veuillez saisir les bons parametre"));
			requestContext.update("growl");
		}

	}

	public void disconnect() {
		// remove user and update ui
		users.remove(username);
		RequestContext.getCurrentInstance().update("form:users");

		// push leave information
		eventBus.publish(CHANNEL + "*", username + " left the channel.");

		// reset state
		loggedIn = false;
		username = null;
	}
}
