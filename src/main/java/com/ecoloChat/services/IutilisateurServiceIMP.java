package com.ecoloChat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ecoloChat.dao.IutilisateurDao;
import com.ecoloChat.model.LesMessages;
import com.ecoloChat.model.Utilisateur;

@Service
public class IutilisateurServiceIMP implements IutilisateurService {

	@Autowired
	public IutilisateurDao userDao;

	@Override
	public Utilisateur getUserByLoginAndPass(String login, String pwd) {
		// TODO Auto-generated method stub
		return userDao.getUserByLoginAndPass(login, pwd);
	}

	@Override
	public String getMsg() {
		return String.format("Hi there!! it's ");
	}

	@Override
	public List<Utilisateur> getListeAllUsers() {
		// TODO Auto-generated method stub
		return userDao.getListeAllUsers();
	}

	@Override
	public boolean savemessage(LesMessages msg) {
		// TODO Auto-generated method stub
		return userDao.savemessage(msg);
	}

	@Override
	public Utilisateur getUserByEmail(String smail) {
		// TODO Auto-generated method stub
		return userDao.getUserByEmail(smail);
	}

	@Override
	public List<LesMessages> getAllMsgByIdEmeteurAndRecepteur(String idEmeteur, String idRecepteur) {
		// TODO Auto-generated method stub
		return userDao.getAllMsgByIdEmeteurAndRecepteur(idEmeteur, idRecepteur);
	}

}
