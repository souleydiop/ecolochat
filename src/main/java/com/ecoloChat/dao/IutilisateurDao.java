package com.ecoloChat.dao;

import java.util.List;

import com.ecoloChat.model.LesMessages;
import com.ecoloChat.model.Utilisateur;

public interface IutilisateurDao {
	public Utilisateur getUserByLoginAndPass(String login, String pwd);

	public List<Utilisateur> getListeAllUsers();

	public boolean savemessage(LesMessages msg);

	public Utilisateur getUserByEmail(String smail);

	public List<LesMessages> getAllMsgByIdEmeteurAndRecepteur(String idEmeteur, String idRecepteur);
}
