package db;

import com.training.db.service.Service;
import com.training.db.util.DAOException;
import com.training.db.util.HibernateUtil;
import com.training.model.Anlage;
import com.training.model.Hersteller;
import com.training.model.Kategorie;
import com.training.model.Mitarbeiter;
import com.training.model.Produkt;
import com.training.model.Standort;

public class TestHibernate {

	public static void main(String[] args) {
		try {
			new TestHibernate();

			HibernateUtil.getSessionFactory().close();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public TestHibernate() throws DAOException {
		// testKategorie();
		// testHersteller();
		testMitarbeiter();
		// testProdukt();

		// testAnlage();

		// testMitarbeiter();
		// testStandort();

	}

	private void testAnlage() {

		for (Anlage data : Service.getInstance().getAnlageService().findAll()) {
			System.out.println(data.getName());
			System.out.println(data.getStandort().getName());

			for (Mitarbeiter ma : data.getMitarbeiter())
				System.out.println(ma.getNachname());

		}

		System.out.println();

	}

	private void testStandort() {

		for (Standort data : Service.getInstance().getStandortService().findAll()) {
			System.out.println(data.getName());
			System.out.println(data.getAnlagen());

		}

	}

	private void testHersteller() {

		for (Hersteller data : Service.getInstance().getHerstellerService().findAll()) {
			System.out.println(data.getName());

		}

	}

	private void testProdukt() {

		for (Produkt data : Service.getInstance().getProduktService().findAll()) {
			System.out.println(data.getName());

			System.out.println(data.getSchulungen());

		}

	}

	private void testKategorie() {

		for (Kategorie kat : Service.getInstance().getKategorieService().findAll()) {
			System.out.println(kat.getName());

			for (Produkt produkte : kat.getProdukte()) {
				System.out.println(produkte.getName());
			}
			System.out.println();

		}

	}

	private void testMitarbeiter() {

		for (Mitarbeiter mit : Service.getInstance().getMitarbeiterService().findAll()) {
			System.out.println(mit.getNachname());

			for (Anlage anl : mit.getAnlagen()) {
				System.out.println(anl.getName());
			}
			System.out.println();

		}

	}

}
