package com.project.observations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Observations {
	Connection conn=null;
	PreparedStatement stmt = null;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	private String ObservationId;
	private String ProjectId;
	private String name;
	private String observation;
	private String defectType; 
	private String process; 
	private String department; 
	private String function; 
	private String impact; 
	private String systemMac;
	private String systemIp; 
	private String systemName; 
	private String createdBy;
	
	public String getObservationId() {
		return ObservationId;
	}
	public void setObservationId(String observationId) {
		ObservationId = observationId;
	}
	public String getProjectId() {
		return ProjectId;
	}
	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getDefectType() {
		return defectType;
	}
	public void setDefectType(String defectType) {
		this.defectType = defectType;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getImpact() {
		return impact;
	}
	public void setImpact(String impact) {
		this.impact = impact;
	}
	public String getSystemMac() {
		return systemMac;
	}
	public void setSystemMac(String systemMac) {
		this.systemMac = systemMac;
	}
	public String getSystemIp() {
		return systemIp;
	}
	public void setSystemIp(String systemIp) {
		this.systemIp = systemIp;
	}
	public String getSystemName() {
		return systemName;
	}
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	} 
	
	public boolean save_observations(String type) {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection();  
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO propel_project.d_observations "
	        			+ "(rowId, projectId, observation, defectType, "
	        			+ "process, department, function, impact, systemMac, systemIp, systemName, "
	        			+ "createdBy, updatedBy, createdOn, updatedOn, name) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; System.out.println(sql);
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, ObservationId);
	            stmt.setString(2, ProjectId);
	            stmt.setString(3, observation);
	            stmt.setString(4, defectType);
	            stmt.setString(5, process);
	            stmt.setString(6, department);
	            stmt.setString(7, function);
	            stmt.setString(8, impact);
	            stmt.setString(9, systemMac);
	            stmt.setString(10, systemIp);
	            stmt.setString(11, systemName);
	            stmt.setString(12, createdBy);
	            stmt.setString(13, createdBy);
	            stmt.setTimestamp(14, timestamp);
	            stmt.setTimestamp(15, timestamp);
	            stmt.setString(16, name);
        	}else if(type.indexOf("updat")>=0){
        		String sql = "UPDATE propel_project.d_observations SET "
        				   + "updatedOn=?, projectId=?, observation=?, defectType=?, process=?, "
        				   + "department=?, function=?, impact=?, systemMac=?, systemIp=?, systemName=?, "
        				   + "updatedBy=? , name=? where rowId=?" ;
    			stmt = conn.prepareStatement(sql);
    			stmt.setTimestamp(1, timestamp);
	            stmt.setString(2, ProjectId);
	            stmt.setString(3, observation);
	            stmt.setString(4, defectType);
	            stmt.setString(5, process);
	            stmt.setString(6, department);
	            stmt.setString(7, function);
	            stmt.setString(8, impact);
	            stmt.setString(9, systemMac);
	            stmt.setString(10, systemIp);
	            stmt.setString(11, systemName);
	            stmt.setString(12, createdBy);
	            stmt.setString(13, name);
	            stmt.setString(14, ObservationId);
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
}
