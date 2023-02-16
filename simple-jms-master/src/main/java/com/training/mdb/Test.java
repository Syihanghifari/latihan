package com.training.mdb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.training.mdb.util.DbUtil;

public class Test {
	public static void main(String[] args) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection connection = null;
		
		try {
			if(connection == null||connection.isClosed()) {
				connection = DbUtil.getConnection();
			}
			ps = connection.prepareStatement("INSERT INTO NASABAH VALUES(?,?,?,?,?,?)");
			ps.setInt(1, 10);
			ps.setInt(2, 10);
			ps.setString(3, "hilman");
			ps.setString(4, "jakarta");
			ps.setDate(5, null);
			ps.setString(6, "jakarta");
			rs = ps.executeQuery();
		}catch(Exception e) {
			System.err.println("Error " + e.getMessage());
		}
		
		
	}
}
