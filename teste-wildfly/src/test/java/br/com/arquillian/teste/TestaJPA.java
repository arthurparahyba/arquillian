package br.com.arquillian.teste;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.arquillian.teste.model.Usuario;

@RunWith(Arquillian.class)
public class TestaJPA {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
				.addClasses(Usuario.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
				.addAsManifestResource("wildfly-ds.xml")
				.addAsManifestResource("persistence.xml");
		
		System.out.println(jar.toString(true));
		return jar;
	}
	
	@PersistenceContext(unitName="teste-arquillian")
	private EntityManager em;
	
	@Test
	public void testeInicial() {
		System.out.println("Inicio");
	}
	
	@Test
	public void teste2() {
		System.out.println("teste 2");
	}
}
