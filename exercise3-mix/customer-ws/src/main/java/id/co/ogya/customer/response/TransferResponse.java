package id.co.ogya.customer.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransferResponse {
	private String errorCode;
	private String errorMessage;
	private String referenceNumber;
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getReferenceNumber() {
		return referenceNumber;
	}
	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	
}
