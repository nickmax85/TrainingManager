package com.training.db.service;

import java.util.List;

import com.training.db.dao.MitarbeiterDAO;
import com.training.db.dao.MitarbeiterJDBCDAO;
import com.training.db.util.DAOException;
import com.training.model.Mitarbeiter;

public class MitarbeiterService {

	private static MitarbeiterJDBCDAO mitarbeiterDAO;

	public MitarbeiterService() {

		mitarbeiterDAO = new MitarbeiterJDBCDAO();

	}

	public void insert(Mitarbeiter entity) {
		mitarbeiterDAO.openCurrentSession();
		try {
			mitarbeiterDAO.insert(entity);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mitarbeiterDAO.closeCurrentSession();
		}
	}

	public void update(Mitarbeiter entity) {
		mitarbeiterDAO.openCurrentSession();
		try {
			mitarbeiterDAO.update(entity);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mitarbeiterDAO.closeCurrentSession();
		}
	}

	public Mitarbeiter findById(int id) {
		mitarbeiterDAO.openCurrentSession();
		Mitarbeiter data = null;
		try {
			data = mitarbeiterDAO.get(id);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mitarbeiterDAO.closeCurrentSession();
		}
		return data;
	}

	public void delete(Mitarbeiter data) {
		mitarbeiterDAO.openCurrentSession();
		try {
			mitarbeiterDAO.delete(data);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mitarbeiterDAO.closeCurrentSession();
		}
	}

	public List<Mitarbeiter> findAll() {
		mitarbeiterDAO.openCurrentSession();
		List<Mitarbeiter> data = null;
		try {
			data = mitarbeiterDAO.getAll();
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			mitarbeiterDAO.closeCurrentSession();
		}
		return data;
	}

	public MitarbeiterDAO mitarbeiterDAO() {
		return mitarbeiterDAO;
	}

}
