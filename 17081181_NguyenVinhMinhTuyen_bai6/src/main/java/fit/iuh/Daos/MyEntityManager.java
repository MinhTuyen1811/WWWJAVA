package fit.iuh.Daos;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	private static MyEntityManager instance=null;
	private EntityManager em;
	public MyEntityManager() {
		// TODO Auto-generated constructor stub
		em = Persistence.createEntityManagerFactory("PersonID").createEntityManager();
	}
	public synchronized static MyEntityManager getInstance() {
		if(instance == null)
			instance = new MyEntityManager();
		return instance;
	}
	public EntityManager getEntityManager() {
		return em;
	}
}
