package fit.iuh.Daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.bson.types.ObjectId;

import fit.iuh.Entities.Person;

public class PersonDaos {
	private EntityManager em = MyEntityManager.getInstance().getEntityManager();

	// lay tat ca person
	public List<Person> getAll() {
		return em.createNamedQuery("getAll", Person.class).getResultList();
	}
	//tim 1 person
	public Person findPerson(ObjectId id) {
		return em.find(Person.class, id);
	}
	// them person
	public boolean addPerson(Person p) {
		EntityTransaction trans = em.getTransaction();
		try {
			if(!trans.isActive())
				trans.begin();
			em.persist(p);
			trans.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
			// TODO: handle exception
		}
	}
	// update person
		public boolean updatePerson(Person p) {
			EntityTransaction trans = em.getTransaction();
			try {
				if(!trans.isActive())
					trans.begin();
				em.merge(p);
				trans.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		}
	//xoa person
		public boolean deletePerson(Object id) {
			EntityTransaction trans = em.getTransaction();
			try {
				if(!trans.isActive())
					trans.begin();
				Person p = em.find(Person.class, id);
				em.remove(p);
				trans.commit();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				e.getStackTrace();
				return false;
			}
		}
}
