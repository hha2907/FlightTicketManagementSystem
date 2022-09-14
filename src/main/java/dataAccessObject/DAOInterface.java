package dataAccessObject;

import java.util.ArrayList;
import java.util.List;


public interface DAOInterface<T> {
	public int add(T t);
	
	public void update(T t);
	
	public void delele(T t);
	
	public int saveOrUpdate(T t);
	
	public ArrayList<T> selectAll();
	
	public ArrayList<T> selectByCondition(String condition);
}
