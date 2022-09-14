package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import entities.Airport;
import entities.Flight;

public class AirportDAO implements DAOInterface<Airport>{

	public static AirportDAO getInstance() {
		return new AirportDAO();
	}
	
	@Override
	public int add(Airport t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Airport t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delele(Airport t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveOrUpdate(Airport t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Airport> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Airport> resultSelect = (ArrayList<Airport>) session.createQuery("FROM Airport",Airport.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Airport selectById(String id) {
		Airport result;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.find(Airport.class, id);
            session.close();
            return result;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Airport> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
