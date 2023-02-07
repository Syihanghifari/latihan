package id.co.ogya.soap.service;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Nasabah {
	private Long noNasabah;
	private Long nik;
	private String namaLengkap;
	private String tempatLahir;
	private Date tanggalLahir;
	private String cabang;
	
	public Nasabah() {
		
	}
	public Nasabah(Long noNasabah, Long nik, String namaLengkap,String tempatLahir,Date tanggalLahir, String cabang) {
		super();
		this.noNasabah = noNasabah;
		this.nik = nik;
		this.namaLengkap = namaLengkap;
		this.tempatLahir = tempatLahir;
		this.tanggalLahir = tanggalLahir;
		this.cabang = cabang;
	}
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
