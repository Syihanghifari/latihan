package id.co.ogya.soap.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InquiryNasabahResponse {
	private String code;
	private String message;
	private InsertNasabahRequest dataNasabah;
	public InquiryNasabahResponse() {
	}
	public InquiryNasabahResponse(String code, String message, InsertNasabahRequest dataNasabah) {
		super();
		this.code = code;
		this.message = message;
		this.dataNasabah = dataNasabah;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public InsertNasabahRequest getDataNasabah() {
		return dataNasabah;
	}
	public void setDataNasabah(InsertNasabahRequest dataNasabah) {
		this.dataNasabah = dataNasabah;
	}
	
}
