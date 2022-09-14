package dataAccessObject;

import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

import antlr.collections.List;
import entities.Account;
import entities.Employee;

public class EmployeeDAO implements DAOInterface<Employee>{
	
	public static EmployeeDAO getInstance() {
		return new EmployeeDAO();
	}

	@Override
	public int add(Employee t) {
		int result =0;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = (Integer) session.save(t);
            session.getTransaction().commit();
            session.close();
            return result;
        } catch (Exception e) {
			e.printStackTrace();
        }
		return result;
	}

	@Override
	public void update(Employee t) {
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
	public void delele(Employee t) {
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
	public ArrayList<Employee> selectAll() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Employee> resultSelect = (ArrayList<Employee>) session.createQuery("FROM Employee",Employee.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Employee selectById(int id) {
		Employee result;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            result = session.find(Employee.class, id);
            session.close();
            return result;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Employee> selectByCondition(String condition) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Employee> resultSelect = (ArrayList<Employee>) session.createQuery("FROM Employee WHERE Employee.isActive = 1",Employee.class)
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Employee> selectIsActive() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            ArrayList<Employee> resultSelect = (ArrayList<Employee>) session.createQuery("FROM Employee E WHERE E.isActive = 1")
            		.list();
            session.close();
            return resultSelect;
        } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public int saveOrUpdate(Employee t) {
		return 0;
	}
//
//	public static void main(String[] args) {
//		Employee employee1 = new Employee();
//		employee1.setEmployeeName("Thien");
//		Account account = new Account();
//		account.setUsername("aaaasa");
//		account.setEmployee(employee1);
//		account.setPassword("1231");
//		HashSet<Account> a= new HashSet<>();
//		a.add(account);
//		employee1.setAccounts(a);
//		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
//            session.beginTransaction();
//            session.persist(employee1);
//            session.getTransaction().commit();
//            session.close();
//        } catch (Exception e) {
//			e.printStackTrace();
//        }
//	}
}
