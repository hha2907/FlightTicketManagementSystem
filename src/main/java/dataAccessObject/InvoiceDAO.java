package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import entities.Invoice;

public class InvoiceDAO implements DAOInterface<Invoice>{
	
	public static InvoiceDAO getInstance() {
		return new InvoiceDAO();
	}

	@Override
	public int add(Invoice t) {
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
	
	public int pesist(Invoice t) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(t);
            session.getTransaction().commit();
            session.close();
            return 1;
        } catch (Exception e) {
			e.printStackTrace();
        }
		return 0;
	}

	@Override
	public void update(Invoice t) {
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
	public void delele(Invoice t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveOrUpdate(Invoice t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Invoice> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Invoice selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Invoice> selectByCondition(String condition) {
		return null;
	}

}
