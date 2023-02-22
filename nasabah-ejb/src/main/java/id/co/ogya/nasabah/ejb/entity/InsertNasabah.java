package id.co.ogya.nasabah.ejb.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;


public class InsertNasabah implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Long noNasabah;
	public Long nik;
	public String namaLengkap;
	public String tempatLahir;
	public Date tanggalLahir;
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
	public String getTempatLahir() {
		return tempatLahir;
	}
	public void setTempatLahir(String tempatLahir) {
		this.tempatLahir = tempatLahir;
	}
	public Date getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(Date tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getCabang() {
		return cabang;
	}
	public void setCabang(String cabang) {
		this.cabang = cabang;
	}
}
