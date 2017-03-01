/**
 * 
 */
package com.android.server;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.android.server.entities.Categorie;
import com.android.server.entities.Produit;
import com.android.server.metier.IMetierRepository;

/**
 * @author SABER KHALIFA
 *
 */
public class TestJpa {
	ClassPathXmlApplicationContext app;
	IMetierRepository<Produit> metier;
	IMetierRepository<Categorie> metierCat;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		app = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
	}

	@Test
	public void test() {
		 metier=(IMetierRepository<Produit>) app.getBean("metier");
		 metierCat=(IMetierRepository<Categorie>) app.getBean("metier");
		 Produit prod=new Produit("PC", "PC DELL", 850, 10, "");
		 metier.insert(prod);
	}

}
