package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import entities.Aircraft;

public class AircraftDAO implements DAOInterface<Aircraft> {

	public static AircraftDAO getInstance() {
		return new AircraftDAO();
	}
	
	@Override
	public int add(Aircraft t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Aircraft t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delele(Aircraft t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveOrUpdate(Aircraft t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Aircraft> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Aircraft> resultSelect = (ArrayList<Aircraft>) session.createQuery("FROM Aircraft",Aircraft.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Aircraft selectById(String id) {
		Aircraft result;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.find(Aircraft.class, id);
            session.close();
            return result;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Aircraft> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
