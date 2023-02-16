package com.training.mdb.simple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import com.training.mdb.util.DbUtil;


@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue="jms.TrainingCF"),
		@ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue="jms.InsertNasabah")
}, mappedName="jms.InsertNasabah")
public class InsertQueueListener1 implements MessageListener{
	PreparedStatement ps = null;
	ResultSet rs = null;
	Connection connection = null;
	public void onMessage(Message message){
		
		try{
			if(connection == null||connection.isClosed()) {
				connection = DbUtil.getConnection();
				System.out.println("connection succes!!");
			}
			ps = connection.prepareStatement("INSERT INTO NASABAH VALUES(?,?,?,?,?,?)");
			String messageInString = "";
			if (message instanceof TextMessage){
				messageInString = ((TextMessage) message).getText();
			} 
			String[] datas = messageInString.split(",", 8);
			int i = 1;
			for (String data : datas) {
				String[] names = data.split(":", 2);
					System.out.println(names[0] + ":" + " <" + names[1] + ">");
						ps.setString(i, names[1]);
					i++;
			}
			rs = ps.executeQuery();
			try{
				Thread.sleep(5000l);
				System.out.println("Process finished instance 1");
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}catch(Exception e){
			System.err.println("Error " + e.getMessage());
		}
	}
}
