package com.ecoloChat.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecoloChat.model.LesMessages;
import com.ecoloChat.model.Utilisateur;

@Component
@Repository
@Transactional
public class IutilisateurIMP extends Utils implements IutilisateurDao {

	@Override
	public Utilisateur getUserByLoginAndPass(String login, String pwd) {
		// TODO Auto-generated method stub
		Query query = getSession()
				.createQuery("From Utilisateur as u where u.emailUtilisateur=? and u.pwdUtilisateur=?");
		query.setString(0, login);
		query.setString(1, pwd);
		try {
			return (Utilisateur) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Utilisateur> getListeAllUsers() {
		// TODO Auto-generated method stub
		Query query = getSession().createQuery("From Utilisateur as u");
		try {
			List<Utilisateur> lu = query.list();
			return lu;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean savemessage(LesMessages msg) {
		try {
			getSession().persist(msg);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return false;
		}
	}

	@Override
	public Utilisateur getUserByEmail(String smail) {
		Query query = getSession().createQuery("From Utilisateur as u where u.pseudo=?");
		query.setString(0, smail);
		try {
			return (Utilisateur) query.uniqueResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<LesMessages> getAllMsgByIdEmeteurAndRecepteur(String idEmeteur, String idRecepteur) {
		Query query = getSession().createQuery(
				"From LesMessages as lmg where (lmg.idEmeteur=? and lmg.idRecepteur=?) or (lmg.idEmeteur=? and lmg.idRecepteur=?)");
		query.setString(0, idEmeteur);
		query.setString(1, idRecepteur);
		query.setString(2, idRecepteur);
		query.setString(3, idEmeteur);
		try {
			List<LesMessages> lmgs = query.list();
			return lmgs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
