package id.co.ogya.nasabah.ejb.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.NamingException;

import id.co.ogya.nasabah.ejb.SimpleDataSourceAccess;
import id.co.ogya.nasabah.ejb.entity.InsertNasabah;
import id.co.ogya.nasabah.ejb.entity.UpdateNasabah;
import id.co.ogya.nasabah.ejb.util.DataSourceServiceFactory;
import id.co.ogya.nasabah.ejb.util.ServiceFactory;

@Stateless(mappedName = "SimpleDataSourceAccessImpl", name = "SimpleDataSourceAccessImpl")
public class SimpleDataSourceAccessImpl implements SimpleDataSourceAccess {
	public boolean isConnected() {
		boolean isAbleToConnect = false;

		DataSourceServiceFactory dataSourceServiceFactory = new DataSourceServiceFactory();
		try {
			Connection connection = dataSourceServiceFactory.getConnection();
			if (!connection.isClosed()) {
				isAbleToConnect = true;
			}
			connection.close();
		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}

		return isAbleToConnect;
	}

	public InsertNasabah getNasabah(Long noNasabah) {
		InsertNasabah daftarNasabah = new InsertNasabah();
		DataSourceServiceFactory dataSourceServiceFactory = new DataSourceServiceFactory();
		try {
			Connection conn = dataSourceServiceFactory.getConnection();
			String sqlSelectQuery = "select * from nasabah where no_nasabah=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sqlSelectQuery);
			preparedStatement.setLong(1, noNasabah);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				daftarNasabah.setNoNasabah(resultSet.getLong("NO_NASABAH"));
				daftarNasabah.setNik(resultSet.getLong("NIK"));
				daftarNasabah.setNamaLengkap(resultSet.getString("NAMA_LENGKAP"));
				daftarNasabah.setTempatLahir(resultSet.getString("TEMPAT_LAHIR"));
				daftarNasabah.setTanggalLahir(resultSet.getDate("TANGGAL_LAHIR"));
				daftarNasabah.setCabang(resultSet.getString("CABANG"));
			}
			preparedStatement.close();
			dataSourceServiceFactory.closeConnection();
		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
		System.out.println(daftarNasabah.getNoNasabah());
		System.out.println(daftarNasabah.getNik());
		System.out.println(daftarNasabah.getNamaLengkap());
		System.out.println(daftarNasabah.getTempatLahir());
		System.out.println(daftarNasabah.getTanggalLahir());
		System.out.println(daftarNasabah.getCabang());
		return daftarNasabah;

	}

	public void insertNasabah(InsertNasabah insertNasabah) {
		DataSourceServiceFactory dataSourceServiceFactory = new DataSourceServiceFactory();
		try {
			Connection conn = dataSourceServiceFactory.getConnection();
			String sqlInsertQuery = "INSERT INTO NASABAH VALUES(?,?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(sqlInsertQuery);
			preparedStatement.setLong(1, insertNasabah.getNoNasabah());
			preparedStatement.setLong(2, insertNasabah.getNik());
			preparedStatement.setString(3, insertNasabah.getNamaLengkap());
			preparedStatement.setString(4, insertNasabah.getTempatLahir());
			preparedStatement.setDate(5, (Date) insertNasabah.getTanggalLahir());
			preparedStatement.setString(6, insertNasabah.getCabang());
			preparedStatement.executeUpdate();
			preparedStatement.close();
			dataSourceServiceFactory.closeConnection();
		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
		System.out.println("data berhasil ditambahkan");
	}

	public void updateNasabah(UpdateNasabah updateNasabah) {
		DataSourceServiceFactory dataSourceServiceFactory = new DataSourceServiceFactory();
		try {
			Connection conn = dataSourceServiceFactory.getConnection();
			String sqlInsertQuery = "UPDATE NASABAH SET NIK=?, NAMA_LENGKAP=?, CABANG=? WHERE NO_NASABAH=?";
			PreparedStatement preparedStatement = conn.prepareStatement(sqlInsertQuery);
			preparedStatement.setLong(1, updateNasabah.getNik());
			preparedStatement.setString(2, updateNasabah.getNamaLengkap());
			preparedStatement.setString(3, updateNasabah.getCabang());
			preparedStatement.setLong(4, updateNasabah.getNoNasabah());
			sendMessage(updateNasabah);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			dataSourceServiceFactory.closeConnection();
		} catch (SQLException e) {
			System.err.println("SQLException : " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
		System.out.println("data berhasil diupdate");

	}

	private void sendMessage(UpdateNasabah updateNasabah) throws SQLException {
		javax.jms.Connection connection = null;
		Session session = null;
		MessageProducer sender = null;

		String connectionFactoryName = "jms.TrainingCF";
		String queueName = "jms.UpdateNasabah";
		ServiceFactory serviceFactory = new ServiceFactory();
		try {
			ConnectionFactory cf = (ConnectionFactory) serviceFactory.getService(connectionFactoryName);
			connection = (javax.jms.Connection) cf.createConnection();
			session = ((javax.jms.Connection) connection).createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = (Destination) serviceFactory.getService(queueName);
			sender = session.createProducer(destination);

			((javax.jms.Connection) connection).start();

			TextMessage textMessage = session.createTextMessage();
			String data = updateNasabah.toString();
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
	}
}
