package id.co.ogya.soap.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UpdateNasabahRequest {
	private Long updateNoNasabah;
	private Long updateNik;
	private String updateNamaLengkap;
	private String updateCabang;
	public UpdateNasabahRequest() {
	}
	public UpdateNasabahRequest(Long updateNoNasabah, Long updateNik, String updateNamaLengkap, String updateCabang) {
		super();
		this.updateNoNasabah = updateNoNasabah;
		this.updateNik = updateNik;
		this.updateNamaLengkap = updateNamaLengkap;
		this.updateCabang = updateCabang;
	}
	public Long getNoNasabah() {
		return updateNoNasabah;
	}
	public void setNoNasabah(Long noNasabah) {
		this.updateNoNasabah = noNasabah;
	}
	public Long getNik() {
		return updateNik;
	}
	public void setNik(Long updateNik) {
		this.updateNik = updateNik;
	}
	public String getNamaLengkap() {
		return updateNamaLengkap;
	}
	public void setNamaLengkap(String updateNamaLengkap) {
		this.updateNamaLengkap = updateNamaLengkap;
	}
	public String getCabang() {
		return updateCabang;
	}
	public void setCabang(String updateCabang) {
		this.updateCabang = updateCabang;
	}
}
