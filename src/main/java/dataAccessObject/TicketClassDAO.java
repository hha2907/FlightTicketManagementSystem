package dataAccessObject;

import java.util.ArrayList;

import org.hibernate.Session;

import entities.Ticketclass;

public class TicketClassDAO implements DAOInterface<Ticketclass>{

	public static TicketClassDAO getInstance() {
		return new TicketClassDAO();
	}
	
	@Override
	public int add(Ticketclass t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(Ticketclass t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delele(Ticketclass t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveOrUpdate(Ticketclass t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Ticketclass> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Ticketclass> resultSelect = (ArrayList<Ticketclass>) session.createQuery("FROM Ticketclass",Ticketclass.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Ticketclass selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Ticketclass> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}

}
