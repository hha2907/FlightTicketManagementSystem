package dataAccessObject;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import entities.Employee;
import entities.Flight;

public class FlightDAO implements DAOInterface<Flight>{

	public static FlightDAO getInstance() {
		return new FlightDAO();
	}
	
	@Override
	public int add(Flight t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(t);
            session.getTransaction().commit();
            session.close();
            return 1;
        } catch (Exception e) {
			e.printStackTrace();
        }
		return 0;
	}

	@Override
	public void update(Flight t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
			e.printStackTrace();
        }
	}

	@Override
	public void delele(Flight t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
			e.printStackTrace();
        }
	}

	@Override
	public int saveOrUpdate(Flight t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Flight> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Flight> resultSelect = (ArrayList<Flight>) session.createQuery("FROM Flight",Flight.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Flight selectById(String id) {
		Flight result;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.find(Flight.class, id);
            session.close();
            return result;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Flight> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Flight> selectIsActive() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Flight> resultSelect = (ArrayList<Flight>) session.createQuery("FROM Flight E WHERE E.isActive = 1")
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Flight> selectFromToday() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String condition = "isActive = 1 And MONTH(flightdate) >= MONTH(NOW()) AND DAY(flightdate)>=DAY(NOW()) AND YEAR(flightdate) >=YEAR(NOW())";
            ArrayList<Flight> resultSelect = (ArrayList<Flight>) session.createQuery("FROM Flight E WHERE " +condition).list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
