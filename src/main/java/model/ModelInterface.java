package model;

public interface ModelInterface<T> {
	public void insert(T t);
	
	public void remove(T t);
	
	public void update(T t);
	
	public boolean checkExists(T t);
}
