package fr.treeptik.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.PersonneDAO;
import fr.treeptik.exception.DAOException;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Personne;
import fr.treeptik.utils.DateUtils;

@Service
@Scope(value = "singleton")
public class PersonneService {
	
	private Logger logger = Logger.getLogger(PersonneService.class);

	@Autowired
	@Qualifier("personneJPADAO")
	// nom du bean
	private PersonneDAO personneDAO;

	@Autowired
	private DateUtils dateUtils;
	
	@Value("#{config.masuperproperty}")
	private String value;
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	private String valeur;

	@Transactional
	public Personne save(Personne personne) throws ServiceException {
		logger.debug("valeur de la property value :  " + value);
		logger.debug("appel de la methode save dans PersonneService " + personne.getNom());
		try {
			return personneDAO.save(personne);
		} catch (DAOException e) {
			logger.error("Erruer création de Personne dans Service" + e.getMessage());
			throw new ServiceException("erreur save service", e);
		}
	}

	@Transactional
	public Personne saveAndChangeName(Personne personne)
			throws ServiceException {

		try {
			personne = this.save(personne);
			personne.setNom(personne.getNom().toUpperCase());
			personne = personneDAO.update(personne);
		} catch (DAOException e) {
			throw new ServiceException("Erreur saveAndChangeName", e);
		}
		return personne;
	}

	public List<Personne> findAll() {
		return personneDAO.findAll();

	}

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

}
