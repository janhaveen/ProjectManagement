package com.project.interview;

import java.sql.SQLException;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;
import com.project.process.Process;

public class Tools extends Process{
	private String ToolId;
	private String name;
	private String storage;
	private String condition;
	private String caliberation;
	private String maintainance;
	public String getToolId() {
		return ToolId;
	}
	public void setToolId(String toolId) {
		ToolId = toolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getCaliberation() {
		return caliberation;
	}
	public void setCaliberation(String caliberation) {
		this.caliberation = caliberation;
	}
	public String getMaintainance() {
		return maintainance;
	}
	public void setMaintainance(String maintainance) {
		this.maintainance = maintainance;
	}
	
	public boolean save_tools() {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection();  
        try {
        	String sql = "INSERT INTO propel_project.d_tools "
					+ "(rowId, InterviewId, item, storage, "
					+ "`condition`, caliberation, maintainance, "
					+ "systemMac, systemIp, systemName, "
					+ "createdBy, updatedBy, createdOn, updatedOn) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, ToolId);
            stmt.setString(2, super.getInterviewId());
            stmt.setString(3, name);
            stmt.setString(4, storage);
            stmt.setString(5, condition);
            stmt.setString(6, caliberation); 
            stmt.setString(7, maintainance); 
            stmt.setString(8, GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));
            stmt.setString(9, GetSystemDetails.getIp());
            stmt.setString(10, GetSystemDetails.getSystemName());
            stmt.setString(11, super.getCreatedBy());
            stmt.setString(12, super.getCreatedBy());
            stmt.setTimestamp(13, timestamp);
            stmt.setTimestamp(14, timestamp);
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
