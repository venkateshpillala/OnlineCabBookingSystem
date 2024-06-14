package com.cab.utility;

import java.sql.*;
import java.util.*;
import java.io.*;

public class JdbcConnection {

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getJdbcConnection() throws IOException,SQLException {
		
		String file = "D:\\Java\\BookCab\\src\\main\\java\\com\\cab\\utility\\applications.properties";
		FileInputStream fis = new FileInputStream(file);
		Properties p = new Properties();
		p.load(fis);
		
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		
		Connection con = DriverManager.getConnection(url,username,password);
		return con;
	}
}
