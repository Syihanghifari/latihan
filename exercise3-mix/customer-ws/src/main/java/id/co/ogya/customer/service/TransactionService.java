package id.co.ogya.customer.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import id.co.ogya.customer.request.InquiryBalanceRequest;
import id.co.ogya.customer.request.TransferRequest;
import id.co.ogya.customer.response.InquiryBalanceResponse;
import id.co.ogya.customer.response.TransferResponse;
import id.co.ogya.ebanking.ejb.EbankingService;
import id.co.ogya.ebanking.ejb.util.ServiceFactory;

@WebService
public class TransactionService {
	
	
	
	@WebMethod
	public id.co.ogya.ebanking.ejb.response.InquiryBalanceResponse cekSaldo(id.co.ogya.ebanking.ejb.request.InquiryBalanceRequest inquiryBalanceRequest) throws InvalidInputException {
		id.co.ogya.ebanking.ejb.response.InquiryBalanceResponse response = new id.co.ogya.ebanking.ejb.response.InquiryBalanceResponse();
		if(inquiryBalanceRequest.getAccountNo().equals(null)) {
			throw new InvalidInputException("Field <account no> harus diisi", " OGYA-999");
		}else {
			String simpleDataSourceAccessJNDIName =
					"EbankingServiceImpl#id.co.ogya.ebanking.ejb.EbankingService";
			try {
				
				
				ServiceFactory serviceFactory = new ServiceFactory();
				EbankingService ebankingService = (EbankingService) serviceFactory.getService(simpleDataSourceAccessJNDIName);
				boolean isAbleToConnect = ebankingService.isConnected();
				System.out.println("is Able to connect " + isAbleToConnect);
				response = ebankingService.cekSaldo(inquiryBalanceRequest);
				response.setErrorCode("OGYA-000");
				response.setErrorMessage("Transaksi berhasil");
			}catch(Exception e) {
				throw new InvalidInputException("error dari backend", " OGYA-999");
			}
		}
		return response;
	}
	
	@WebMethod
	public TransferResponse kirim(TransferRequest transferRequest) throws InvalidInputException {
		TransferResponse response = new TransferResponse();
		if (transferRequest.getAccountFrom().equals(null)) {
			throw new InvalidInputException("Field <account from> harus diisi", " OGYA-999");
		} else if (transferRequest.getAccountTo().equals(null)) {
			throw new InvalidInputException("Field <account to> harus diisi", " OGYA-999");
		} else if (transferRequest.getAmount().equals(null) || transferRequest.getAmount().equals(0L)) {
			throw new InvalidInputException("Field <amount> harus diisi", " OGYA-999");
		} else {
			try {

				// callservice
				response.setErrorCode("OGYA-000");
				response.setErrorMessage("Transaksi berhasil");
				response.setReferenceNumber("ini");
			} catch (Exception e) {
				throw new InvalidInputException("error dari backend", " OGYA-999");
			}
		}
		return response;
	}
}
