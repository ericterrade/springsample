package fr.treeptik.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import fr.treeptik.dao.PersonneDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Personne;
import fr.treeptik.service.PersonneService;

@Repository
public class PersonneJPADAO implements PersonneDAO {

	@PersistenceContext
	private EntityManager entityManager;
	private Logger logger = Logger.getLogger(PersonneService.class);

	@Override
	public Personne save(Personne personne) throws DAOException {
		
		try {
			entityManager.persist(personne);
		} catch (PersistenceException e) {
			logger.error("Erruer création de Personne dans Personne" + personne.getNom());
			throw new DAOException("Erreur creation de personne", e);
		}
		return personne;
	}

	@Override
	public Personne update(Personne personne) throws DAOException {
		try {
			entityManager.persist(personne);
		} catch (PersistenceException e) {
			throw new DAOException("Erreur creation de personne", e);
		}
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		TypedQuery<Personne> query = entityManager.createQuery(
				"select p from Personne p", Personne.class);
		return query.getResultList();
	}

}
