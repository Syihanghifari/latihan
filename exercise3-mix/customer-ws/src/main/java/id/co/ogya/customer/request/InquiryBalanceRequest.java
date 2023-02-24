package id.co.ogya.customer.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class InquiryBalanceRequest {
	private Long accountNo;

	public Long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	
}
