package com.ecoloChat.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecoloChat.model.LesMessages;
import com.ecoloChat.model.Utilisateur;

@Service
public interface IutilisateurService {
	public Utilisateur getUserByLoginAndPass(String login, String pwd);

	String getMsg();

	public List<Utilisateur> getListeAllUsers();

	public boolean savemessage(LesMessages msg);

	public Utilisateur getUserByEmail(String smail);

	public List<LesMessages> getAllMsgByIdEmeteurAndRecepteur(String idEmeteur, String idRecepteur);
}
