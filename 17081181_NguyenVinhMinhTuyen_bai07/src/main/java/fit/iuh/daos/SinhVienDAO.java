package fit.iuh.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fit.iuh.entities.SinhVien;

public class SinhVienDAO {
	private EntityManager em = MyEntityManager.getInstance().getEntityManager();

	// Lay tat ca SinhVien
	public List<SinhVien> getAll() {
		return em.createNamedQuery("getAll", SinhVien.class).getResultList();
	}

	// tim 1 SinhVien
	public SinhVien findSinhVien(long maSV) {
		return em.find(SinhVien.class, maSV);
	}

	// Them 1 SinhVien
	public boolean addSinhVien(SinhVien p) {
		EntityTransaction trans = em.getTransaction();
		try {
			if (!trans.isActive())
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

	// Cap nhat 1 SinhVien
	public boolean updateSinhVien(SinhVien p) {
		EntityTransaction trans = em.getTransaction();
		try {
			if (!trans.isActive())
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

	// Xoa 1 SinhVien
	public boolean deleteSinhVien(long maSV) {
		EntityTransaction trans = em.getTransaction();
		try {
			if (!trans.isActive())
				trans.begin();
			SinhVien p = findSinhVien(maSV);
			if (p == null)
				return false;
			else {
				em.remove(p);
				trans.commit();
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
