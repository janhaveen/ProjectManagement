package com.project.interview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;

public class Audit {
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());    
    
	private String auditId; 
	private String InterviewId;
	private String influencingFactor; 
	private String currentMetric; 
	private String metricType; 
	private String comments; 
	private String createdBy;
	
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getInterviewId() {
		return InterviewId;
	}
	public void setInterviewId(String interviewId) {
		InterviewId = interviewId;
	}
	public String getInfluencingFactor() {
		return influencingFactor;
	}
	public void setInfluencingFactor(String influencingFactor) {
		this.influencingFactor = influencingFactor;
	}
	public String getCurrentMetric() {
		return currentMetric;
	}
	public void setCurrentMetric(String currentMetric) {
		this.currentMetric = currentMetric;
	}
	public String getMetricType() {
		return metricType;
	}
	public void setMetricType(String metricType) {
		this.metricType = metricType;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	} 
	
	public boolean saveAudit(String type) {
		boolean returnVal=false;
		conn = MySqlConnect.DBConnection();
		try {
			if(type.equals("insert")) {
				String sql = "INSERT INTO propel_project.d_audit " 
		    			+ " (rowId, influencingFactor, currentMetric, "
		    			+ " metricType, comments, systemMac, systemIp, "
		    			+ " systemName, createdBy, updatedBy, createdOn, updatedOn,InterviewId) "
						+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?)";
		        stmt = conn.prepareStatement(sql); 
		        stmt.setString(1, auditId);
		        stmt.setString(2, influencingFactor);
		        stmt.setString(3, currentMetric); 
		        stmt.setString(4, metricType);
		        stmt.setString(5, comments);
		        stmt.setString(6, GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));	        
		        stmt.setString(7, GetSystemDetails.getIp());  
		        stmt.setString(8, GetSystemDetails.getSystemName());
		        stmt.setString(9, createdBy);
		        stmt.setString(10, createdBy);
		        stmt.setTimestamp(11, timestamp); 
		        stmt.setTimestamp(12, timestamp); 
		        stmt.setString(13, InterviewId); System.out.println(stmt);
			}else if(type.equals("updat")) {
				String sql = "UPDATE propel_project.d_audit  SET " 
		    			+ " influencingFactor=?,  currentMetric=?, "
		    			+ "metricType=?,  comments=?,  systemMac=?,  "
		    			+ "systemIp=?,  systemName=?, updatedBy=?, updatedOn=? "
						+ " where rowid =? ";
		        stmt = conn.prepareStatement(sql); 
		        stmt.setString(1, influencingFactor);
		        stmt.setString(2, currentMetric); 
		        stmt.setString(3, metricType);
		        stmt.setString(4, comments);
		        stmt.setString(5, GetSystemDetails.getMACAddress(GetSystemDetails.getIp()));	        
		        stmt.setString(6, GetSystemDetails.getIp());  
		        stmt.setString(7, GetSystemDetails.getSystemName());
		        stmt.setString(8, createdBy);
		        stmt.setTimestamp(9, timestamp); 	       
		        stmt.setString(10, auditId);System.out.println(stmt);
			}
	        stmt.executeUpdate();
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
	/*public boolean updateAudit() {
		boolean returnVal=false;	
		conn = MySqlConnect.DBConnection();
		try {
			
	        stmt.executeUpdate();
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
		return returnVal;}*/
	
}
