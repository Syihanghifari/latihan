package id.co.ogya.soap.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.LongAccumulator;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.naming.NamingException;

import id.co.ogya.soap.util.ServiceFactory;

@WebService
public class Exercise {

	@WebMethod
	public Response insertNasabah(InsertNasabahRequest insertNasabahRequest)
			throws ParseException, InvalidInputException {
		if (insertNasabahRequest.getNoNasabah() == null) {
			throw new InvalidInputException("field nomor harus diisi", " ERR-002");
		} else if (insertNasabahRequest.getNik() == null) {
			throw new InvalidInputException("field nik harus diisi", " ERR-002");
		} else if (insertNasabahRequest.getNamaLengkap() == null || insertNasabahRequest.getNamaLengkap() == "") {
			throw new InvalidInputException("field nama harus diisi", " ERR-002");
		} else if (insertNasabahRequest.getTempatLahir() == null || insertNasabahRequest.getTempatLahir() == "") {
			throw new InvalidInputException("field tempat lahir harus diisi", " ERR-002");
		} else if (insertNasabahRequest.getTanggalLahir() == null) {
			throw new InvalidInputException("field tanggal lahir harus diisi", " ERR-002");
		} else if (insertNasabahRequest.getCabang() == null || insertNasabahRequest.getCabang() == "") {
			throw new InvalidInputException("field cabang harus diisi", " ERR-002");
		} else {
			if (insertNasabahRequest.getNoNasabah() instanceof Long && insertNasabahRequest.getNik() instanceof Long) {
				if (String.valueOf(insertNasabahRequest.getNoNasabah()).length() < 10) {
					throw new InvalidInputException("no nasabah harus 10 digit", " ERR-002");
				} else if (String.valueOf(insertNasabahRequest.getNik()).length() < 16) {
					throw new InvalidInputException("nik harus 16 digit", " ERR-002");
				} else {
					try {
						Date tanggal = new SimpleDateFormat("dd/MM/yyyy").parse(insertNasabahRequest.getTanggalLahir());

					} catch (Exception e) {
						throw new InvalidInputException("format tanggal salah", " ERR-002");
					}
					String tahun = insertNasabahRequest.getTanggalLahir().substring(6, 10);
					Long thn = Long.valueOf(tahun);
					Long umur = 2022 - thn;
					if (umur < 17L) {
						throw new InvalidInputException("usia kurang dari 17 tahun", " ERR-002");
					} else {
						InsertNasabahRequest newNasabah = new InsertNasabahRequest(insertNasabahRequest.getNoNasabah(),
								insertNasabahRequest.getNik(), insertNasabahRequest.getNamaLengkap(),
								insertNasabahRequest.getTempatLahir(), insertNasabahRequest.getTanggalLahir(),
								insertNasabahRequest.getCabang());

						Connection connection = null;
						Session session = null;
						MessageProducer sender = null;

						String connectionFactoryName = "jms.TrainingCF";
						String queueName = "jms.InsertNasabah";
						ServiceFactory serviceFactory = new ServiceFactory();
						try {
							ConnectionFactory cf = (ConnectionFactory) serviceFactory.getService(connectionFactoryName);
							connection = cf.createConnection();
							session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

							Destination destination = (Destination) serviceFactory.getService(queueName);
							sender = session.createProducer(destination);

							connection.start();

							TextMessage textMessage = session.createTextMessage();
							String data = newNasabah.toString();
							textMessage.setText(data);

							sender.send(textMessage);

							System.out.println("Message sent");

							connection.close();

						} catch (NamingException n) {
							n.printStackTrace();
						} catch (JMSException e) {
							e.printStackTrace();
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							try {
								if (sender != null) {
									sender.close();
								}
								if (session != null) {
									session.close();
								}
								if (connection != null) {
									connection.close();
								}
							} catch (JMSException e) {
								e.printStackTrace();
							}
						}
						Response message = new Response("ERR-000", "Data berhasil disimpan");
						return message;
					}
				}
			} else {
				throw new InvalidInputException("nomor and nik harus number", " ERR-001");
			}
		}
	}

	@WebMethod
	public Response updateNasabah(UpdateNasabahRequest updateNasabahRequest) throws InvalidInputException {
		InsertNasabahRequest nasabah = new InsertNasabahRequest(12L, 12121221L, "syihan", "jakarta", "27/04/2000",
				"cabang");
		if (updateNasabahRequest.getNoNasabah() == null) {
			throw new InvalidInputException("field nomor harus diisi", " ERR-002");
		} else if (updateNasabahRequest.getNik() == null) {
			throw new InvalidInputException("field nik harus diisi", " ERR-002");
		} else if (updateNasabahRequest.getNamaLengkap() == null || updateNasabahRequest.getNamaLengkap() == "") {
			throw new InvalidInputException("field nama harus diisi", " ERR-002");
		} else if (updateNasabahRequest.getCabang() == null || updateNasabahRequest.getCabang() == "") {
			throw new InvalidInputException("field cabang harus diisi", " ERR-002");
		} else {
			if (updateNasabahRequest.getNoNasabah() instanceof Long && updateNasabahRequest.getNik() instanceof Long) {
				if (String.valueOf(updateNasabahRequest.getNoNasabah()).length() < 10) {
					throw new InvalidInputException("no nasabah harus 10 digit", " ERR-002");
				} else if (String.valueOf(updateNasabahRequest.getNik()).length() < 16) {
					throw new InvalidInputException("nik harus 16 digit", " ERR-002");
				} else {
					nasabah.setNamaLengkap(updateNasabahRequest.getNamaLengkap());
					nasabah.setNik(updateNasabahRequest.getNik());
					nasabah.setNoNasabah(updateNasabahRequest.getNoNasabah());
					nasabah.setCabang(updateNasabahRequest.getCabang());

					Connection connection = null;
					Session session = null;
					MessageProducer sender = null;

					String connectionFactoryName = "jms.TrainingCF";
					String queueName = "jms.UpdateNasabah";
					ServiceFactory serviceFactory = new ServiceFactory();
					try {
						ConnectionFactory cf = (ConnectionFactory) serviceFactory.getService(connectionFactoryName);
						connection = cf.createConnection();
						session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

						Destination destination = (Destination) serviceFactory.getService(queueName);
						sender = session.createProducer(destination);

						connection.start();

						TextMessage textMessage = session.createTextMessage();
						String data = updateNasabahRequest.toString();
						textMessage.setText(data);

						sender.send(textMessage);

						System.out.println("Message sent");

						connection.close();

					} catch (NamingException n) {
						n.printStackTrace();
					} catch (JMSException e) {
						e.printStackTrace();
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						try {
							if (sender != null) {
								sender.close();
							}
							if (session != null) {
								session.close();
							}
							if (connection != null) {
								connection.close();
							}
						} catch (JMSException e) {
							e.printStackTrace();
						}
					}

					Response Imessage = new Response("ERR-000", "Data berhasil disimpan");
					return Imessage;
				}
			} else {
				throw new InvalidInputException("nomor and nik harus number", " ERR-001");
			}
		}
	}

	@WebMethod
	public InquiryNasabahResponse nasabahInquiry(@WebParam(name = "no") Long no)
			throws InvalidInputException, ParseException {
		Date tanggal = new SimpleDateFormat("dd/MM/yyyy").parse("27/04/2000");
		InsertNasabahRequest nasabah = new InsertNasabahRequest(12L, 12121221L, "syihan", "jakarta", "27/04/2000",
				"cabang");
		if (nasabah.getNoNasabah().equals(no)) {
			if (no % 2 != 0) {
				throw new InvalidInputException("data tidak ditemukan", " ERR-003");
			} else {
				InquiryNasabahResponse Jmessage = new InquiryNasabahResponse("ERR-000", "Data berhasil ditambahkan",
						nasabah);
				return Jmessage;
			}
		} else if (no == null) {
			throw new InvalidInputException("data harus diisi", " ERR-002");
		} else {
			throw new InvalidInputException("data tidak ditemukan", " ERR-003");
		}

	}
}
