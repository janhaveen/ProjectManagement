package com.data.MySql;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MySqlConnect {

	public static String connector = "com.mysql.jdbc.Driver";
	//public static String dataBase = "jdbc:mysql://localhost:3306/";
	public static String dataBase = "jdbc:mysql://132.148.156.108:3306/";
	public static String dbUser = "root";
	public static String dbPassword = "Aditya@6511";
	
	public static Connection DBConnection() {
		try{
			Class.forName(connector);
			Connection conn = DriverManager.getConnection(dataBase,dbUser,dbPassword);
			return conn;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void main(String args[]) {
		System.out.println(DBConnection());
	}


public static java.sql.Timestamp convertToTimestamp(String date){
	Timestamp ts = Timestamp.valueOf(date);
    return ts;
}

public static Date convertToSqlDate(String strDate) {
	java.util.Date date;
	Date sqlDate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy");
	
	try {
		date = sdf.parse(strDate);
		sqlDate = new Date(date.getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		sqlDate =null;
	}
	
	return sqlDate;
}

public static Time convertToSqlTime(String myTime ) {
    
	 SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
	 Time t;
	 long ms;
	 try {
	  ms = sdf.parse(myTime).getTime();
	  t = new Time(ms);
	 } catch (ParseException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	  t=null;
	 }
	 return t;
	}

public static Time convertTime(String strTime) {
	java.util.Date date;
	Time sqlTime;
	SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
	try {
		date = sdf.parse(strTime);
		sqlTime = new Time(date.getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		sqlTime =null;
	}
	return sqlTime;
}
public static Date convertFromattedDate(String strDate) {
	java.util.Date date;
	Date sqlDate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	try {
		date = sdf.parse(strDate);
		sqlDate = new Date(date.getTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		sqlDate =null;
	}
	return sqlDate;
}

public static String convertToSqlTimeStamp(String myTime1) { 
	String ts = null;
	 SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM, yyyy hh:mm a");
	 java.util.Date date; Date sqlDate; Time t; long ms;
	 try {
		 date = sdf.parse(myTime1);
		 sqlDate = new Date(date.getTime());
		 ms = sdf.parse(myTime1).getTime();
		 t = new Time(ms);// System.out.println(sqlDate+"sddsdscdcds"+t);
		 String s=sqlDate.toString()+" " +t.toString();
		 ts=sqlDate.toString()+" " +t.toString();
	 } catch (ParseException e) {
	  // TODO Auto-generated catch block
		  e.printStackTrace();
	 }
	 return ts;
}
}


