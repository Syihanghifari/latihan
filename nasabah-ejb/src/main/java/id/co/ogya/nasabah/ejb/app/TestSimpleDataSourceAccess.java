package id.co.ogya.nasabah.ejb.app;

import id.co.ogya.nasabah.ejb.SimpleDataSourceAccess;
import id.co.ogya.nasabah.ejb.entity.InsertNasabahRequest;
import id.co.ogya.nasabah.ejb.entity.UpdateNasabahRequest;
import id.co.ogya.nasabah.ejb.util.ServiceFactory;

public class TestSimpleDataSourceAccess {

	public static void main(String[] args) {
		String simpleDataSourceAccessJNDIName =
				"SimpleDataSourceAccessImpl#id.co.ogya.nasabah.ejb.SimpleDataSourceAccess";
		
		ServiceFactory serviceFactory = new ServiceFactory();
		try{
			SimpleDataSourceAccess simpleDataSourceAccess = 
					(SimpleDataSourceAccess) serviceFactory.getService(simpleDataSourceAccessJNDIName);
			boolean isAbleToConnect = simpleDataSourceAccess.isConnected();
			System.out.println("is Able to connect " + isAbleToConnect);
//			InsertNasabah insertNasabah = new InsertNasabah();
//			//test database
//			insertNasabah.setNoNasabah(20L);
//			insertNasabah.setNik(100000L);
//			insertNasabah.setNamaLengkap("jajaja");
//			insertNasabah.setTempatLahir("malang");
//			insertNasabah.setTanggalLahir(null);
//			insertNasabah.setCabang("surabaya");
//			
//			simpleDataSourceAccess.insertPesertaTraining(insertNasabah);
//			InsertNasabah getNasabah = simpleDataSourceAccess.getNasabah(5L);
//			System.out.println(getNasabah.getNoNasabah());
//			System.out.println(getNasabah.getNik());
//			System.out.println(getNasabah.getNamaLengkap());
//			System.out.println(getNasabah.getTempatLahir());
//			System.out.println(getNasabah.getTanggalLahir());
//			System.out.println(getNasabah.getCabang());
			
			UpdateNasabahRequest updateNasabah = new UpdateNasabahRequest();
			updateNasabah.setNoNasabah(20L);
			updateNasabah.setNamaLengkap("sfsdf");
			updateNasabah.setNik(1900L);
			updateNasabah.setCabang("jogasdja");
			simpleDataSourceAccess.updateNasabah(updateNasabah);
		}catch(Exception e){
			System.err.println(e.getMessage());
		}
	}
}
