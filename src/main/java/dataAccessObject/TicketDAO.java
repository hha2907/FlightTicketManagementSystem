package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import entities.Ticket;

public class TicketDAO implements DAOInterface<Ticket>{
	
	public static TicketDAO getInstance() {
		return new TicketDAO();
	}

	@Override
	public int add(Ticket t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Ticket t) {
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
	public void delele(Ticket t) {
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
	public int saveOrUpdate(Ticket t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Ticket> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Ticket> resultSelect = (ArrayList<Ticket>) session.createQuery("FROM Ticket",Ticket.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Ticket selectById(int id) {
		Ticket result;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.find(Ticket.class, id);
            session.close();
            return result;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Ticket> selectByCondition(String condition) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Ticket WHERE " +condition;
            ArrayList<Ticket> resultSelect =  (ArrayList<Ticket>) session.createQuery(hql).list();
            session.getTransaction().commit();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
