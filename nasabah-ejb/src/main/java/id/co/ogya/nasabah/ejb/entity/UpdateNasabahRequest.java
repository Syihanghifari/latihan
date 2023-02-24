package id.co.ogya.nasabah.ejb.entity;

import java.io.Serializable;
import java.util.Date;

public class UpdateNasabahRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long noNasabah;
	public Long nik;
	public String namaLengkap;
	public String cabang;
	public Long getNoNasabah() {
		return noNasabah;
	}
	public void setNoNasabah(Long noNasabah) {
		this.noNasabah = noNasabah;
	}
	public Long getNik() {
		return nik;
	}
	public void setNik(Long nik) {
		this.nik = nik;
	}
	public String getNamaLengkap() {
		return namaLengkap;
	}
	public void setNamaLengkap(String namaLengkap) {
		this.namaLengkap = namaLengkap;
	}
	public String getCabang() {
		return cabang;
	}
	public void setCabang(String cabang) {
		this.cabang = cabang;
	}
	@Override
	public String toString() {
		return "no:"+noNasabah + ",nik:" + nik
				+ ",nama lengkap:" + namaLengkap + ",cabang:" + cabang;
	}
	
}
