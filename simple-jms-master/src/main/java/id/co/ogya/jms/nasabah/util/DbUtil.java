package id.co.ogya.jms.nasabah.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtil {
	private static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/xe";
	private static final String DRIVER_NAME = "oracle.jdbc.replay.OracleDataSourceImpl";
	private static final String DB_USERNAME = "training";
	private static final String DB_PWD = "training";
	static Connection connection = null;
	static {
		try {
			Class.forName(DRIVER_NAME);
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PWD);
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
	public static void dbCleanUp(Connection conn,Statement st,ResultSet rs) {
		if (conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
