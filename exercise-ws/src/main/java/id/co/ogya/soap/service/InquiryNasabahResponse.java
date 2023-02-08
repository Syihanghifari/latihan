package id.co.ogya.soap.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(namespace = "http://service.soap.ogya.co.id/")
public class InquiryNasabahResponse {
	private String iCode;
	private String iMessage;
	private InsertNasabahRequest dataNasabah;
	public InquiryNasabahResponse() {
	}
	public InquiryNasabahResponse(String iCode, String iMessage, InsertNasabahRequest dataNasabah) {
		super();
		this.iCode = iCode;
		this.iMessage = iMessage;
		this.dataNasabah = dataNasabah;
	}

	public String getCode() {
		return iCode;
	}
	public void setCode(String iCode) {
		this.iCode = iCode;
	}
	public String getMessage() {
		return iMessage;
	}
	public void setMessage(String iMessage) {
		this.iMessage = iMessage;
	}
	public InsertNasabahRequest getDataNasabah() {
		return dataNasabah;
	}
	public void setDataNasabah(InsertNasabahRequest dataNasabah) {
		this.dataNasabah = dataNasabah;
	}
	
}
