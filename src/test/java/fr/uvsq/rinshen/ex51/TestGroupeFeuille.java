package fr.uvsq.rinshen.ex51;

import static org.junit.Assert.*;

import java.time.Month;

import org.junit.Test;

public class TestGroupeFeuille {
	@Test
	public void testAjouteMembre() {
		Personnel p1 = new Personnel.Builder("Beleyan","Sofia")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		GroupeFeuille g = new GroupeFeuille();
		g.ajoute_membre(p1);
		Personnel p2 = g.getMembres().get(0);
		
		assertEquals(p1, p2);
	}
	
	@Test
	public void testEquals() {
		Personnel p2 = new Personnel.Builder("Yaheza","Alexandra")
				.date_naissance(15, Month.JULY, 1996)
				.fonction("Indescriptible")
				.num_telephone("0625648257")
				.build();
		Personnel p1 = new Personnel.Builder("Beleyan","Sofia")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		GroupeFeuille g1 = new GroupeFeuille();
		GroupeFeuille g2 = new GroupeFeuille();
		
		g1.ajoute_membre(p1);
		g1.ajoute_membre(p2);
		
		g2.ajoute_membre(p1);
		g2.ajoute_membre(p2);
		
		assertEquals(g1, g2);
	}
}
