package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import entities.Customer;

public class CustomerDAO implements DAOInterface<Customer>{

	public static CustomerDAO getInstance() {
		return new CustomerDAO();
	}
	
	@Override
	public int add(Customer t) {
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
	
	public void presist(Customer t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(t);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
			e.printStackTrace();
        }
	}

	@Override
	public void update(Customer t) {
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
	public void delele(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveOrUpdate(Customer t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Customer> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Customer> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
