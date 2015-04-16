package fr.treeptik.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import fr.treeptik.dao.PersonneDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.model.Personne;

@Repository
public class PersonneMemoryDAO implements PersonneDAO{

	List<Personne> personnes = new ArrayList<Personne>();
	
	@Override
	public Personne save(Personne personne) {
		personnes.add(personne);
		return null;
	}

	@Override
	public List<Personne> findAll() {
		return personnes;
	}

	@Override
	public Personne update(Personne personne) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

}
