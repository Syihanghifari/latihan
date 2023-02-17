package id.co.ogya.jms.nasabah;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import id.co.ogya.jms.nasabah.util.DbUtil;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "jms.TrainingCF"),
		@ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = "jms.UpdateNasabah") }, mappedName = "jms.UpdateNasabah")
public class UpdateQueueListener1 implements MessageListener {
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection connection = null;
	public void onMessage(Message message) {

		try {
			if(connection == null||connection.isClosed()) {
				connection = DbUtil.getConnection();
				System.out.println("connection succes!!");
			}
			ps = connection.prepareStatement("UPDATE NASABAH SET NIK=?, NAMA_LENGKAP=?, CABANG=? WHERE NO_NASABAH=?");
			String messageInString = "";
			if (message instanceof TextMessage) {
				messageInString = ((TextMessage) message).getText();
			}
			String[] datas = messageInString.split(",", 5);
			int i = 1;
			for (String data : datas) {
				String[] names = data.split(":", 2);
				System.out.println(names[0] + ":" + " <" + names[1] + ">");
				if(names[0].toLowerCase().equals("no")) {
					ps.setString(4, names[1]);
				}else {
					ps.setString(i, names[1]);
					i++;
				}
			}
			rs = ps.executeQuery();
			DbUtil.dbCleanUp(connection, ps, rs);
			System.out.println("connection terminated!!");
		} catch (Exception e) {
			System.err.println("Error " + e.getMessage());
		}
	}
}
