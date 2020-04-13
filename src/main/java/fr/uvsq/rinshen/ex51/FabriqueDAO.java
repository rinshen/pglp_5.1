package fr.uvsq.rinshen.ex51;

public class FabriqueDAO {
	public static GroupeCompositeDAO creerCompositeDAO() {
		return new GroupeCompositeDAO();
	}
	
	public static GroupeFeuilleDAO creerFeuilleDAO() {
		return new GroupeFeuilleDAO();
	}
	
	public static PersonnelDAO creerPersonnelDAO() {
		return new PersonnelDAO();
	}
}
