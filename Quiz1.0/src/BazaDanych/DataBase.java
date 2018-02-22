package BazaDanych;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.EntityTransaction;

import javax.persistence.TypedQuery;

import Klasy.Pytania;
import Klasy.Uzytkownik;

public class DataBase {

	public void addUser(String name, String haslo1) {

		DBConfig dbConfig = new DBConfig();
		EntityManager entityManager = dbConfig.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();

		TypedQuery<Uzytkownik> query = entityManager.createQuery("SELECT n FROM Uzytkownik n", Uzytkownik.class);
		List<Uzytkownik> resultList = query.getResultList();
		for (Uzytkownik uzytkownik : resultList) {

			dbConfig.zwrocListeLogin().add(uzytkownik.getName());
			dbConfig.zwrocListeLogin().add(uzytkownik.getHaslo1());

		}

		try {
			transaction.begin();
			Uzytkownik uzytkownik = new Uzytkownik();
			uzytkownik.setName(name);
			uzytkownik.setHaslo1(haslo1);
			entityManager.persist(uzytkownik);
			transaction.commit();

		} catch (Exception e) {
			if (transaction.isActive())
				transaction.rollback();
		}
	}

	public void addQuestion(String question, String answer1, String answer2, String answer3, String answer4,
			String trueAnswer) {

		DBConfig dbConfig = new DBConfig();
		EntityManager entityManager = dbConfig.createEntityManagers();
		EntityTransaction transaction = entityManager.getTransaction();
		
		try{
			transaction.begin();
			Pytania pytania = new Pytania();
			pytania.setQuestion(question);
			pytania.setAnswer1(answer1);
			pytania.setAnswer2(answer2);
			pytania.setAnswer3(answer3);
			pytania.setAnswer4(answer4);
			pytania.setTrueAnswer(trueAnswer);
			entityManager.persist(pytania);
			transaction.commit();
		}catch(Exception e){
			if(transaction.isActive());
			transaction.rollback();
		}
	}

	public EntityManager check() {
		DBConfig dbConfig = new DBConfig();
		EntityManager em = dbConfig.createEntityManager();
		return em;
	}

}
