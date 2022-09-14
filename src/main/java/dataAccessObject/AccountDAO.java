package dataAccessObject;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entities.Account;

public class AccountDAO implements DAOInterface<Account>{

	public static AccountDAO getInstance() {
		return new AccountDAO();
	}
	
	@Override
	public int add(Account t) {
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
	public void update(Account t) {
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
	public void delele(Account t) {
	}

	@Override
	public ArrayList<Account> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Account selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Account> selectByCondition(String condition) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            String hql = "FROM Account WHERE " +condition;
            ArrayList<Account> resultSelect =  (ArrayList<Account>) session.createQuery(hql).list();
            session.getTransaction().commit();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int saveOrUpdate(Account t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
