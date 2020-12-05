package fit.iuh.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class MyEntityManager {
	private static MyEntityManager instance= null;
	private EntityManager em;
	public MyEntityManager() {
		// TODO Auto-generated constructor stub
		em=Persistence.createEntityManagerFactory("TUAN04_Bai2_MinhTuyen_17081181").createEntityManager();
	}
	public static MyEntityManager getInstance() {
		if(instance==null)
			instance= new MyEntityManager();
		return instance;
	}
	public EntityManager getEntityManager() {
		return em;
	}
}
