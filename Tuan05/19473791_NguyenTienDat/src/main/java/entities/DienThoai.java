package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "DienThoai")
public class DienThoai {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaDT")
    protected int maDT;

    @Column(name = "TenDT")
    private String tenDT;

    @Column(name = "NamSanXuat")
    private int namSX;

    @Column(name = "CauHinh")
    private String cauHinh;

    @ManyToOne
    @JoinColumn(name = "MaNCC") 
    private NhaCungCap nhaCungCap;

    
    public int getMaDT() {
        return maDT;
    }

    public void setMaDT(int maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public int getNamSX() {
        return namSX;
    }

    public void setNamSX(int namSX) {
        this.namSX = namSX;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public DienThoai(int maDT, String tenDT, int namSX, String cauHinh, NhaCungCap nhaCungCap) {
        super();
        this.maDT = maDT;
        this.tenDT = tenDT;
        this.namSX = namSX;
        this.cauHinh = cauHinh;
        this.nhaCungCap = nhaCungCap;
    }

    public DienThoai() {
        super();
    }
}
