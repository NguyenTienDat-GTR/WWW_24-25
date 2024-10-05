package DAO;

import java.util.List;

import entities.DienThoai;

public interface DienThoaiDAO {
	
	public List<DienThoai> getAllDienThoai();
	public DienThoai getDienThoaiByID(int maDT);
	public DienThoai saveDienThoai(DienThoai dt);
	public DienThoai updateDienThoai(DienThoai dt);
	public boolean deleteDienThoai(int maDT);

}
