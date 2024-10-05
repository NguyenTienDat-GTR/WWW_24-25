package DAOImpl;

import java.util.List;

import DAO.NhaCungCapDAO;
import entities.NhaCungCap;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class NhaCungCapDAOImpl implements NhaCungCapDAO {
	
	private EntityManager entityManager;

	public NhaCungCapDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
		

	@Override
	public List<NhaCungCap> getAllNhaCungCap() {
		try {
			List<NhaCungCap> resultList = entityManager.createQuery("from NhaCungCap", NhaCungCap.class).getResultList();
			return resultList;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NhaCungCap getNhaCungCapByID(int maNCC) {
		try {
			EntityTransaction transaction = entityManager.getTransaction();
			transaction.begin();
			NhaCungCap ncc = entityManager.find(NhaCungCap.class, maNCC);
			transaction.commit();
			return ncc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NhaCungCap saveNhaCungCap(NhaCungCap ncc) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
			entityManager.persist(ncc);
			transaction.commit();
			return ncc;
		} catch (Exception e) {
			if (transaction.isActive() && transaction != null) {
				transaction.rollback();
			}
		}
		return null;
	}

	@Override
	public NhaCungCap updateNhaCungCap(NhaCungCap ncc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteNhaCungCap(int maNCC) {
		// TODO Auto-generated method stub
		return false;
	}

}
