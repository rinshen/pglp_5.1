package fr.uvsq.rinshen.ex51;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GroupeFeuilleDAO implements DataAccessObject<GroupeFeuille> {

	public GroupeFeuilleDAO() {
		;
	}

	public void ecrire(GroupeFeuille obj, String fichier) {
		try {
			ObjectOutputStream sortie;
			sortie = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(fichier))));
			sortie.writeObject(obj);
			sortie.close();
		} catch (FileNotFoundException e) {
			System.out.println("Fichier introuvable");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Erreur d'écriture");
			e.printStackTrace();
		}
	}

	public GroupeFeuille lire(String fichier) {
		GroupeFeuille g = null;
		try {
			ObjectInputStream entree;
			entree = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(fichier))));
			g=(GroupeFeuille)entree.readObject();
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
		return g;
	}
}
