package fr.uvsq.rinshen.ex51;

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

public class Tests {
	@Test
	public void SerialisationPersonnel(){
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

	@Test
	public void SerialisationGroupeFeuille(){
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
		
		g1.ajoute_membre(p1);
		g1.ajoute_membre(p2);

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

	@Test
	public void SerialisationGroupeComposite(){
		//initialisation
		ObjectOutputStream sortie;
		ObjectInputStream entree;
		Personnel p4 = new Personnel.Builder("Rogg","Waldric")
				.date_naissance(15, Month.JULY, 1996)
				.fonction("Docteur")
				.num_telephone("0658423215")
				.build();
		Personnel p3 = new Personnel.Builder("Drek","Goliath")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Infirmier")
				.num_telephone("0621658719")
				.build();
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
		GroupeFeuille g2 = new GroupeFeuille();
		
		GroupeComposite c1 = new GroupeComposite();
		GroupeComposite c2 = null;

		g1.ajoute_membre(p1);
		g1.ajoute_membre(p2);
		g2.ajoute_membre(p3);
		g2.ajoute_membre(p4);
		
		c1.ajoute_groupe(g1);
		c1.ajoute_groupe(g2);

		//écriture
		try {
			sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("test_groupe_composite"))));
			sortie.writeObject(c1);
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
			entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("test_groupe_composite"))));
			c2=(GroupeComposite)entree.readObject();
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
		assertEquals(c1, c2);
 	}
}
