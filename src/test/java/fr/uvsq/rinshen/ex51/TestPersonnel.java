package fr.uvsq.rinshen.ex51;

import java.time.LocalDate;
import java.time.Month;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestPersonnel {
	@Test
	public void testNom() {
		Personnel p1 = new Personnel.Builder("Beleyan","Sofia")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		assertEquals(p1.getNom(), "Beleyan");
	}
	
	@Test
	public void testPrenom() {
		Personnel p1 = new Personnel.Builder("Beleyan","Sofia")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		assertEquals(p1.getPrenom(), "Sofia");
	}
	
	@Test
	public void testDateNaissance() {
		Personnel p1 = new Personnel.Builder("Beleyan","Sofia")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		assertEquals(p1.getDateNaissance(), LocalDate.of(1997, Month.JANUARY, 26));
	}
	
	@Test
	public void testNumTelephone() {
		Personnel p1 = new Personnel.Builder("Beleyan","Sofia")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		assertEquals(p1.getNumTelephone().get(0), "0655892225");
	}
	
	@Test
	public void testFonction() {
		Personnel p1 = new Personnel.Builder("Beleyan","Sofia")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		assertEquals(p1.getFonction(), "Indéfinie");
	}
	
	@Test
	public void testEquals() {
		Personnel p1 = new Personnel.Builder("Sofia","Beleyan")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		Personnel p2 = new Personnel.Builder("Sofia","Beleyan")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		assertEquals(p1, p2);
	}
	
	@Test
	public void testSerialisationPersonnel(){
		//initialisation
		ObjectOutputStream sortie;
		ObjectInputStream entree;
		Personnel p2 = null;
		Personnel p1 = new Personnel.Builder("Sofia","Beleyan")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();

		//écriture
		try {
			sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("test_personnel"))));
			sortie.writeObject(p1);
			sortie.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur d'écriture");
			e.printStackTrace();
		}
		
		//lecture
		try {
			entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("test_personnel"))));
			p2=(Personnel)entree.readObject();
			entree.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur d'écriture");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Fichier incorrect");
			e.printStackTrace();
		}
		assertEquals(p1, p2);
 	}
}
