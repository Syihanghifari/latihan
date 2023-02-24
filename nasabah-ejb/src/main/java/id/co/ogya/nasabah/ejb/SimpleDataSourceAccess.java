package id.co.ogya.nasabah.ejb;



import javax.ejb.Remote;

import id.co.ogya.nasabah.ejb.entity.InsertNasabahRequest;
import id.co.ogya.nasabah.ejb.entity.UpdateNasabahRequest;

@Remote
public interface SimpleDataSourceAccess {
	public boolean isConnected();
	
	public void insertNasabah(InsertNasabahRequest insertNasabah);
	public InsertNasabahRequest getNasabah(Long noNasabah);
	public void updateNasabah(UpdateNasabahRequest updateNasabah);
}
