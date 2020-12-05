package fit.iuh.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fit.iuh.entities.Person;

public class PersonDAO {
	private EntityManager em;
	public PersonDAO() {
		// TODO Auto-generated constructor stub
		em= MyEntityManager.getInstance().getEntityManager();
	}
	
	public boolean insert(Person p) {
		EntityTransaction trans= em.getTransaction();
		try {
			if(!trans.isActive())
				trans.begin();
			em.persist(p);
			trans.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
	@SuppressWarnings("unchecked")
	public List<Person> getAll(){
		return em.createNamedQuery("getAll").getResultList();
	}
}
