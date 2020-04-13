package fr.uvsq.rinshen.ex51;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
		g.ajouteMembre(p1);
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
		
		g1.ajouteMembre(p1);
		g1.ajouteMembre(p2);
		
		g2.ajouteMembre(p1);
		g2.ajouteMembre(p2);
		
		assertEquals(g1, g2);
	}
	
	@Test
	public void testSerialisationGroupeFeuille(){
		//initialisation
		ObjectOutputStream sortie;
		ObjectInputStream entree;
		Personnel p2 = new Personnel.Builder("Yaheza","Alexandra")
				.date_naissance(15, Month.JULY, 1996)
				.fonction("Indescriptible")
				.num_telephone("0625648257")
				.build();
		Personnel p1 = new Personnel.Builder("Sofia","Beleyan")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		GroupeFeuille g1 = new GroupeFeuille();
		GroupeFeuille g2 = null;
		
		g1.ajouteMembre(p1);
		g1.ajouteMembre(p2);

		//écriture
		try {
			sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("test_groupe_feuille"))));
			sortie.writeObject(g1);
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
			entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("test_groupe_feuille"))));
			g2=(GroupeFeuille)entree.readObject();
			entree.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur de lecture");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Fichier incorrect");
			e.printStackTrace();
		}
		assertEquals(g1, g2);
 	}

}
