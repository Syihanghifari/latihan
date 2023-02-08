package id.co.ogya.soap.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UpdateNasabahRequest {
	private Long noNasabah;
	private Long nik;
	private String namaLengkap;
	private String cabang;
	public UpdateNasabahRequest() {
	}
	public UpdateNasabahRequest(Long noNasabah, Long nik, String namaLengkap, String cabang) {
		super();
		this.noNasabah = noNasabah;
		this.nik = nik;
		this.namaLengkap = namaLengkap;
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
	public String getCabang() {
		return cabang;
	}
	public void setCabang(String cabang) {
		this.cabang = cabang;
	}
}
