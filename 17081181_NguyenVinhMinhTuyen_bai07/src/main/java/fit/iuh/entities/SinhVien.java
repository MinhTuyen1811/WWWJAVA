package fit.iuh.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity(name = "sinhviens")
@NamedQuery(name = "getAll", query = "select sv from sinhviens sv")
public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private long maSV;
	private String hoTen;
	private String gioiTinh;
	private String soDienThoai;
	private String diaChi;
	public long getMaSV() {
		return maSV;
	}
	public void setMaSV(long maSV) {
		this.maSV = maSV;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public SinhVien(long maSV, String hoTen, String gioiTinh, String soDienThoai, String diaChi) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.gioiTinh = gioiTinh;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
	}
	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (maSV ^ (maSV >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		if (maSV != other.maSV)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", soDienThoai=" + soDienThoai
				+ ", diaChi=" + diaChi + "]";
	}
	
}
