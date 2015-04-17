package fr.treeptik.aop;

import org.apache.log4j.Logger;

import org.aspectj.lang.JoinPoint.StaticPart;

import fr.treeptik.model.Personne;

public class MonitorAspect {
	
	private Logger logger = Logger.getLogger(MonitorAspect.class);

	public void afterReturningSavePersonne(StaticPart staticPart, Object result){
		Personne personne = (Personne) result;
		logger.info("Déclenchement de : " + staticPart.getSignature().getName()+" Type de Retour : " +result);
	}
	
}
