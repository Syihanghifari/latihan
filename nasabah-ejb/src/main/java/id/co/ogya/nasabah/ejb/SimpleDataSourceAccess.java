package id.co.ogya.nasabah.ejb;

import java.util.Hashtable;
import java.util.List;

import javax.ejb.Remote;

import id.co.ogya.nasabah.ejb.entity.InsertNasabah;
import id.co.ogya.nasabah.ejb.entity.UpdateNasabah;

@Remote
public interface SimpleDataSourceAccess {
	public boolean isConnected();
	
	public void insertNasabah(InsertNasabah insertNasabah);
	public InsertNasabah getNasabah(Long noNasabah);
	public void updateNasabah(UpdateNasabah updateNasabah);
}
