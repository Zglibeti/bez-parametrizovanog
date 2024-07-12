package pekidz;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestStan {

	private Stan stan;

    @Before
    public void setUp() {
        stan = new Stan("Test Adresa", 50, 100);
    }

    @Test
    public void testGetAdresa() {
        assertEquals("Test Adresa", stan.getAdresa());
    }

    @Test
    public void testGetKvadratura() {
        assertEquals(50, stan.getKvdratura());
    }

    @Test
    public void testGetCenaPoKvadratu() {
        assertEquals(100, stan.getCenaPoKvadratu());
    }

    @Test
    public void testIzracunajCenu() {
        assertEquals(5000, stan.izracunajCenu(), 0);
    }

    @Test
    public void testPovoljanStanTrue() {
        Stan povoljanStan = new Stan("Povoljna Adresa", 100, 400);
        assertFalse(povoljanStan.povoljanStan());
    }

    @Test
    public void testPovoljanStanFalse() {
        Stan skupStan = new Stan("Skupa Adresa", 100, 600);
        assertFalse(skupStan.povoljanStan());
    }

    @Test(expected = RuntimeException.class)
    public void testSetKvadraturaNegative() {
        stan.setKvadratura(-1);
    }

    @Test(expected = RuntimeException.class)
    public void testSetCenaPoKvadratuNegative() {
        stan.setCenaPoKvadratu(-1);
    }

    @Test(expected = RuntimeException.class)
    public void testSetCenaPoKvadratuTooHigh() {
        stan.setCenaPoKvadratu(6000);
    }

    @Test(expected = RuntimeException.class)
    public void testSetAdresaNull() {
        stan.setAdresa(null);
    }

    @Test
    public void testSetKvadratura() {
        stan.setKvadratura(75);
        assertEquals(75, stan.getKvdratura());
    }

    @Test
    public void testSetCenaPoKvadratu() {
        stan.setCenaPoKvadratu(200);
        assertEquals(200, stan.getCenaPoKvadratu());
    }

    @Test
    public void testSetAdresa() {
        stan.setAdresa("Nova Adresa");
        assertEquals("Nova Adresa", stan.getAdresa());
    }

    @Test
    public void testToString() {
        assertEquals("Stan [adresa=Test Adresa, kvadratura=50, cena po kvadratu=100]", stan.toString());
    }
}
