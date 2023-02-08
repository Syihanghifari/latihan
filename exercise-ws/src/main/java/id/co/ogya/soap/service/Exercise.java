package id.co.ogya.soap.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Exercise {

	@WebMethod
	public SuccesMessages inputPojo(Nasabah nasabah) throws ParseException, InvalidInputException {
		if (nasabah.getNoNasabah() == null) {
			throw new InvalidInputException("field nomor harus diisi", " ERR-002");
		} else if (nasabah.getNik() == null) {
			throw new InvalidInputException("field nik harus diisi", " ERR-002");
		} else if (nasabah.getNamaLengkap() == null || nasabah.getNamaLengkap() == "") {
			throw new InvalidInputException("field nama harus diisi", " ERR-002");
		} else if (nasabah.getTempatLahir() == null || nasabah.getTempatLahir() == "") {
			throw new InvalidInputException("field tempat lahir harus diisi", " ERR-002");
		} else if (nasabah.getTanggalLahir() == null) {
			throw new InvalidInputException("field tanggal lahir harus diisi", " ERR-002");
		} else if (nasabah.getCabang() == null || nasabah.getCabang() == "") {
			throw new InvalidInputException("field cabang harus diisi", " ERR-002");
		} else {
			if (nasabah.getNoNasabah() instanceof Long && nasabah.getNik() instanceof Long) {
				if (String.valueOf(nasabah.getNoNasabah()).length() < 10) {
					throw new InvalidInputException("no nasabah harus 10 digit", " ERR-002");
				} else if (String.valueOf(nasabah.getNik()).length() < 16) {
					throw new InvalidInputException("nik harus 16 digit", " ERR-002");
				} else {
					try {
						Date tanggal = new SimpleDateFormat("dd/MM/yyyy").parse(nasabah.getTanggalLahir());

					} catch (Exception e) {
						throw new InvalidInputException("format tanggal salah", " ERR-002");
					}
					String tahun = nasabah.getTanggalLahir().substring(6, 10);
					Long thn = Long.valueOf(tahun);
					Long umur = 2022 - thn;
					if (umur < 17L) {
						throw new InvalidInputException("usia kurang dari 17 tahun", " ERR-002");
					} else {
						Nasabah newNasabah = new Nasabah(nasabah.getNoNasabah(), nasabah.getNik(),
								nasabah.getNamaLengkap(), nasabah.getTempatLahir(), nasabah.getTanggalLahir(),
								nasabah.getCabang());
						SuccesMessages message = new SuccesMessages("ERR-000", "Data berhasil disimpan");
						return message;
					}
				}
			} else {
				throw new InvalidInputException("nomor and nik harus number", " ERR-001");
			}
		}
	}

//	@WebMethod
//	public SuccesMessages input(@WebParam(name = "no") Long no, @WebParam(name = "nik") Long nik,
//			@WebParam(name = "nama") String nama, @WebParam(name = "tempatLahir") String tempatLahir,
//			@WebParam(name = "tanggalLahir") String tanggalLahir, @WebParam(name = "cabang") String cabang)
//			throws ParseException, InvalidInputException {
//		if (no == null) {
//			throw new InvalidInputException("field nomor harus diisi", " ERR-002");
//		} else if (nik == null) {
//			throw new InvalidInputException("field nik harus diisi", " ERR-002");
//		} else if (nama == null || nama == "") {
//			throw new InvalidInputException("field nama harus diisi", " ERR-002");
//		} else if (tempatLahir == null || tempatLahir == "") {
//			throw new InvalidInputException("field tempat lahir harus diisi", " ERR-002");
//		} else if (tanggalLahir == null || tanggalLahir == "") {
//			throw new InvalidInputException("field tanggal lahir harus diisi", " ERR-002");
//		} else if (cabang == null || cabang == "") {
//			throw new InvalidInputException("field cabang harus diisi", " ERR-002");
//		} else {
//			if (no instanceof Long && nik instanceof Long) {
//				if (String.valueOf(no).length() < 10) {
//					throw new InvalidInputException("no nasabah harus 10 digit", " ERR-002");
//				} else if (String.valueOf(nik).length() < 16) {
//					throw new InvalidInputException("nik harus 16 digit", " ERR-002");
//				} else {
//					String tahun = tanggalLahir.substring(6, 10);
//					Long thn = Long.valueOf(tahun);
//					Long umur = 2022 - thn;
//					if (umur < 17L) {
//						throw new InvalidInputException("usia kurang dari 17 tahun", " ERR-002");
//					} else {
//						try {
//							Date tanggal = new SimpleDateFormat("dd/MM/yyyy").parse(tanggalLahir);
//							Nasabah nasabah = new Nasabah(no, nik, nama, tempatLahir, tanggalLahir, cabang);
//							SuccesMessages message = new SuccesMessages("ERR-000", "Data berhasil disimpan");
//							return message;
//						} catch (Exception e) {
//							throw new InvalidInputException("format tanggal salah", " ERR-002");
//						}
//					}
//				}
//			} else {
//				throw new InvalidInputException("nomor and nik harus number", " ERR-001");
//			}
//		}
//	}

	@WebMethod
	public SuccesMessages update(@WebParam(name = "no") Long no, @WebParam(name = "nik") Long nik,
								 @WebParam(name = "nama") String nama, @WebParam(name = "cabang") String cabang)
			throws InvalidInputException, ParseException {
		Date tanggal = new SimpleDateFormat("dd/MM/yyyy").parse("27/04/2000");
		Nasabah nasabah = new Nasabah(12L, 12121221L, "syihan", "jakarta", "27/04/2000", "cabang");
		if (nasabah.getNamaLengkap().equals(nama)) {
			if (no == null) {
				throw new InvalidInputException("field nomor harus diisi", " ERR-002");
			} else if (nik == null) {
				throw new InvalidInputException("field nik harus diisi", " ERR-002");
			} else if (nama == null || nama == "") {
				throw new InvalidInputException("field nama harus diisi", " ERR-002");
			} else if (cabang == null || cabang == "") {
				throw new InvalidInputException("field cabang harus diisi", " ERR-002");
			} else {
				if (no instanceof Long && nik instanceof Long) {
					if (String.valueOf(no).length() < 10) {
						throw new InvalidInputException("no nasabah harus 10 digit", " ERR-002");
					} else if (String.valueOf(nik).length() < 16) {
						throw new InvalidInputException("nik harus 16 digit", " ERR-002");
					} else {
						nasabah.setNoNasabah(no);
						nasabah.setNik(nik);
						nasabah.setNamaLengkap(nama);
						nasabah.setCabang(cabang);
						SuccesMessages message = new SuccesMessages("ERR-000", "Data berhasil diupdate");
						return message;
					}
				} else {
					throw new InvalidInputException("nomor and nik harus number", " ERR-001");
				}
			}

		} else {
			throw new InvalidInputException("data tidak ditemukan", " ERR-003");
		}
	}

	@WebMethod
	public SuccesMessages findNo(@WebParam(name = "no") Long no) throws InvalidInputException, ParseException {
		Date tanggal = new SimpleDateFormat("dd/MM/yyyy").parse("27/04/2000");
		Nasabah nasabah = new Nasabah(12L, 12121221L, "syihan", "jakarta", "27/04/2000", "cabang");
		if (nasabah.getNoNasabah().equals(no)) {
			if (no % 2 != 0) {
				throw new InvalidInputException("data tidak ditemukan", " ERR-003");
			} else {
				SuccesMessages message = new SuccesMessages("ERR-000", "Data berhasil ditambahkan");
				return message;
			}
		} else if (no == null) {
			throw new InvalidInputException("data harus diisi", " ERR-002");
		} else {
			throw new InvalidInputException("data tidak ditemukan", " ERR-003");
		}

	}
}
