package sfr.treeptik.service;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Personne;
import fr.treeptik.service.PersonneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:testApplicationContext.xml")
public class PersonneServiceTest {

	@Autowired
	private PersonneService personneService;

	@Test
	public void shouldCreatePersonne() {
		Personne expectedPersonne = new Personne(1,"DUPONT", "Paul");
		try {
			Personne personne = personneService.save(new Personne(null,"DUPONT", "Paul"));
			Assert.assertEquals(expectedPersonne, personne);
		} catch (ServiceException e) {
			Assert.fail();
			e.printStackTrace();
		}
	}
}
