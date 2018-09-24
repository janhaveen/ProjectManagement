package com.project.format;

import java.sql.SQLException;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;
import com.general.system.SystemDetails;
import com.project.process.Process;

public class Format extends Process{
	private String formatId;
	private String name;
	private String ftype;
	private String filename;
	private String filepath;
	public String getFormatId() {
		return formatId;
	}
	public void setFormatId(String formatId) {
		this.formatId = formatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	public boolean save_format(String type) {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection();  
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO propel_project.d_format "
						+ "(rowId, processId, name, type, filename, "
						+ "systemMac, systemIp, systemName, "
						+ "createdBy, updatedBy, createdOn, updatedOn) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, formatId);
	            stmt.setString(2, super.getProcessId());
	            stmt.setString(3, name);
	            stmt.setString(4, ftype);
	            stmt.setString(5, filename);
	            stmt.setString(6, GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
	            stmt.setString(7, GetSystemDetails.getIp());
	            stmt.setString(8,GetSystemDetails.getSystemName());
	            stmt.setString(9, super.getCreatedBy());
	            stmt.setString(10, super.getCreatedBy());
	            stmt.setTimestamp(11, timestamp);
	            stmt.setTimestamp(12, timestamp);
        	}else if(type.indexOf("updat")>=0){
        		String sql = "UPDATE propel_project.d_format SET "
        				   + " updatedOn=?, processId=?, name=?, type=?, filename=?, "
        				   + "systemMac=?, systemIp=?, systemName=?, "
        				   + "updatedBy=? where rowId=?" ;
    			stmt = conn.prepareStatement(sql);
 	            stmt.setTimestamp(1, timestamp);
 	            stmt.setString(2, super.getProcessId());
 	            stmt.setString(3, name);
 	            stmt.setString(4, ftype);
 	            stmt.setString(5, filename);
 	            stmt.setString(6, GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
 	            stmt.setString(7, GetSystemDetails.getIp());
 	            stmt.setString(8, GetSystemDetails.getSystemName());
 	            stmt.setString(9, super.getCreatedBy());
 	            stmt.setString(10, formatId);
        	}
            stmt.executeUpdate(); System.out.println(stmt);
            returnVal = true;
            conn.close();
            }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = false;
        }
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return returnVal;
	}
	
	public boolean saveLocation() {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection();  
        try {
    		String sql = "UPDATE propel_project.d_format SET "
    				   + " updatedOn=?, filepath=?, filename=?, "
    				   + "systemMac=?, systemIp=?, systemName=?, "
    				   + "updatedBy=? where rowId=?" ;
			stmt = conn.prepareStatement(sql);
            stmt.setTimestamp(1, timestamp);
            stmt.setString(2, filepath);
            stmt.setString(3, filename);
            stmt.setString(4, GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
            stmt.setString(5, GetSystemDetails.getIp());
            stmt.setString(6, GetSystemDetails.getSystemName());
            stmt.setString(7, super.getCreatedBy());
            stmt.setString(8, formatId);
            stmt.executeUpdate(); System.out.println(stmt);
            returnVal = true;
            conn.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = false;
        }
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return returnVal;
	}
}
