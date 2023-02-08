package id.co.ogya.soap.service;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InsertNasabahRequest {
	private Long noNasabah;
	private Long nik;
	private String namaLengkap;
	private String tempatLahir;
	private String tanggalLahir;
	private String cabang;

	public InsertNasabahRequest() {

	}
	public InsertNasabahRequest(Long noNasabah, Long nik, String namaLengkap,String tempatLahir,String tanggalLahir, String cabang) {
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
	public String getTanggalLahir() {
		return tanggalLahir;
	}
	public void setTanggalLahir(String tanggalLahir) {
		this.tanggalLahir = tanggalLahir;
	}
	public String getCabang() {
		return cabang;
	}
	public void setCabang(String cabang) {
		this.cabang = cabang;
	}



}
