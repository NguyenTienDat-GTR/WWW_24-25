package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

@Entity
@Table(name = "NhaCungCap")
public class NhaCungCap {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MaNCC")
	protected int maNCC;

	@Column(name = "TenNCC")
	private String tenNCC;

	@Column(name = "DiaChi")
	private String diaChi;

	@Column(name = "SDT")
	private String sdt;

	@OneToMany(mappedBy = "nhaCungCap", fetch = FetchType.EAGER)
	private List<DienThoai> dienThoais;

	public int getMaNCC() {
		return maNCC;
	}

	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}

	public String getTenNCC() {
		return tenNCC;
	}

	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public List<DienThoai> getDienThoais() {
		return dienThoais;
	}

	public void setDienThoais(List<DienThoai> dienThoais) {
		this.dienThoais = dienThoais;
	}

	public NhaCungCap(int maNCC, String tenNCC, String diaChi, String sdt) {
		super();
		this.maNCC = maNCC;
		this.tenNCC = tenNCC;
		this.diaChi = diaChi;
		this.sdt = sdt;
	}

	public NhaCungCap() {
		super();
	}
}
