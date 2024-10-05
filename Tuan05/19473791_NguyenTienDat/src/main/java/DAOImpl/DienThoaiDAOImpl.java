package DAOImpl;

import java.util.List;

import DAO.DienThoaiDAO;
import entities.DienThoai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DienThoaiDAOImpl implements DienThoaiDAO {

	private EntityManager entityManager;

	public DienThoaiDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<DienThoai> getAllDienThoai() {
		try {
			return entityManager.createQuery("from DienThoai", DienThoai.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public DienThoai getDienThoaiByID(int maDT) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DienThoai saveDienThoai(DienThoai dt) {
		EntityTransaction transaction = entityManager.getTransaction();
		try {
			transaction.begin();
            entityManager.persist(dt);
            transaction.commit();
            return dt;
		} catch (Exception e) {
			if(transaction.isActive()) {
	            transaction.rollback();
	        }
	        e.printStackTrace();
		}
		return null;
	}

	@Override
	public DienThoai updateDienThoai(DienThoai dt) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteDienThoai(int maDT) {
		// TODO Auto-generated method stub
		return false;
	}

}
