package pekidz;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;







public class TestAgencijaProdajeStanova {

	private Stan stan1;
    private Stan stan2;
    
    @Rule
	public final TestRule timeout = Timeout.seconds(5);
    
    @Rule
	public final ErrorCollector ec = new ErrorCollector();
    
    @BeforeClass
	public static void ProveriOperativniSistem() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Windows"));
	}
    
    @Before
    public void setUp() {
        stan1 = new Stan("Adresa 1", 50, 100);
        stan2 = new Stan("Adresa 2", 60, 150);
        AgencijaProdajeStanova.stan.clear(); // Očisti listu pre svakog testa
    }

    @Test
    public void testDodajStan() {
        AgencijaProdajeStanova.dodajStan(stan1);
        assertTrue(AgencijaProdajeStanova.stan.contains(stan1));
    }

    @Test(expected = NullPointerException.class)
    public void testDodajStanNull() {
        AgencijaProdajeStanova.dodajStan(null);
    }

    @Test(expected = RuntimeException.class)
    public void testDodajStanVecPostoji() {
        AgencijaProdajeStanova.dodajStan(stan1);
        AgencijaProdajeStanova.dodajStan(stan1); // Pokušaj ponovnog dodavanja
    }

    @Test
    public void testPronadjiStan() {
        AgencijaProdajeStanova.dodajStan(stan1);
        AgencijaProdajeStanova.dodajStan(stan2);
        
        LinkedList<Stan> pronadjeni = AgencijaProdajeStanova.pronadjiStan("Adresa 1");
        assertEquals(1, pronadjeni.size());
        assertEquals(stan1, pronadjeni.get(0));
    }

    @Test
    public void testPronadjiStanNepostojecaAdresa() {
        AgencijaProdajeStanova.dodajStan(stan1);
        LinkedList<Stan> pronadjeni = AgencijaProdajeStanova.pronadjiStan("Nepostojeca Adresa");
        assertTrue(pronadjeni.isEmpty());
    }

    @Test
    public void testPronadjiStanNullAdresa() {
        LinkedList<Stan> pronadjeni = AgencijaProdajeStanova.pronadjiStan(null);
        assertNull(pronadjeni);
    }
    
    
}
