package id.co.ogya.customer.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TransferRequest {
	private Long accountFrom;
	private Long accountTo;
	private Long amount;
	private String notes;
	public Long getAccountFrom() {
		return accountFrom;
	}
	public void setAccountFrom(Long accountFrom) {
		this.accountFrom = accountFrom;
	}
	public Long getAccountTo() {
		return accountTo;
	}
	public void setAccountTo(Long accountTo) {
		this.accountTo = accountTo;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
