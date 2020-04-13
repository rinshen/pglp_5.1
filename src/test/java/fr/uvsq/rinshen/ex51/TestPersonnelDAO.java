package fr.uvsq.rinshen.ex51;

import static org.junit.Assert.*;

import java.time.Month;

import org.junit.Test;

public class TestPersonnelDAO {
	@Test
	public void test() {
		Personnel p2 = null;
		Personnel p1 = new Personnel.Builder("Sofia","Beleyan")
				.date_naissance(26, Month.JANUARY, 1997)
				.fonction("Indéfinie")
				.num_telephone("0655892225")
				.build();
		PersonnelDao dao = FabriqueDao.creerPersonnelDao();
		
		dao.ecrire(p1, "test_personnel");
		p2 = dao.lire("test_personnel");
		
		assertEquals(p1, p2);
	}
}
