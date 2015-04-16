package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Personne;

public interface PersonneDAO {
	
	Personne save(Personne personne) throws DAOException;
	List<Personne> findAll();
	Personne update(Personne personne) throws DAOException;

}
