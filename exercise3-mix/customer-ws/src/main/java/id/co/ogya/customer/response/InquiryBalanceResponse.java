package id.co.ogya.customer.response;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InquiryBalanceResponse {
	private String errorCode;
	private String errorMessage;
	private Long accountBalance;
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
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
}
