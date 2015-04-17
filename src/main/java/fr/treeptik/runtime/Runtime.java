package fr.treeptik.runtime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Personne;
import fr.treeptik.service.PersonneService;

public class Runtime {

	public static void main(String[] args) throws ServiceException {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:applicationContext.xml");

		PersonneService personneService = (PersonneService) context
				.getBean("personneService");
		
		
		personneService.setValeur("valuer1");
		

		personneService = (PersonneService) context
				.getBean("personneService");
		
		
		System.out.println(personneService.getValeur());
		
//		Personne personne = new Personne(null, "dupont", "pierre");
//		personneService.save(personne);
//		Personne personne2 = new Personne(null, "TERRADE", "Eric");
//		personneService.save(personne2);
//		System.out.println(personneService.findAll());

	}

}
