package fr.uvsq.rinshen.ex51;

public class FabriqueDao {
	public static GroupeCompositeDao creerCompositeDao() {
		return new GroupeCompositeDao();
	}
	
	public static GroupeFeuilleDao creerFeuilleDao() {
		return new GroupeFeuilleDao();
	}
	
	public static PersonnelDao creerPersonnelDao() {
		return new PersonnelDao();
	}
}
