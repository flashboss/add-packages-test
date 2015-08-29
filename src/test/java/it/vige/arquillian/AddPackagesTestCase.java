package it.vige.arquillian;

import static org.junit.Assert.assertTrue;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AddPackagesTestCase {

	@Deployment
	public static JavaArchive createDeployment() {
		JavaArchive javaArchive = ShrinkWrap.create(JavaArchive.class).addPackages(true, "org/h2").addPackages(true,
				"org/drools");
		assertTrue(javaArchive.toString(true).contains("drools"));
		assertTrue(javaArchive.toString(true).contains("h2"));
		return javaArchive;
	}

	@Test
	public void emptyTest() {
	}
}
