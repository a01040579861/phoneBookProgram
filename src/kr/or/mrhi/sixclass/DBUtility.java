package kr.or.mrhi.sixclass;

import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBUtility {
	public static Connection getConnection() {
		Connection con = null;
		
		try {
			//Properties
			Properties properties = new Properties();
			String filePath = DataBaseTest.class.getResource("db.properties").getPath();
			filePath = URLDecoder.decode(filePath, "utf-8");
			properties.load(new FileReader(filePath));
			
			//Properties ¹ÙÀÎµù
			String driver = properties.getProperty("DRIVER");
			String url = properties.getProperty("URL");
			String userID = properties.getProperty("userID");
			String userPassword = properties.getProperty("userPassword");
			
			//Driver loader
			Class.forName(driver);
			
			//Database connection
			con = DriverManager.getConnection(url, userID, userPassword);
			
		} catch (Exception e) {
			System.out.println("Mysql Database connection fail");
			e.printStackTrace();
		} 
		
		return con;
	}
	
}



