package DAO;

import java.util.List;

import entities.NhaCungCap;

public interface NhaCungCapDAO {
	public List<NhaCungCap> getAllNhaCungCap();

	public NhaCungCap getNhaCungCapByID(int maNCC);

	public NhaCungCap saveNhaCungCap(NhaCungCap ncc);

	public NhaCungCap updateNhaCungCap(NhaCungCap ncc);

	public boolean deleteNhaCungCap(int maNCC);

}
