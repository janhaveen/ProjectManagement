package com.project.poa;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class PlanOfAction {
	Connection conn=null;
	PreparedStatement stmt = null;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	private String PlanOfActionId; 
	private String projectid; 
	private Timestamp reviewDate; 
	private String challenges; 
	private String planofaction; 
	private String responsible; 
	private String accountable; 
	private String consulted; 
	private String informed; 
	private String status; 
	private String comment; 
	private Date expectedClosureDate; 
	private Date closureDate; 
	private String createdBy;
	private String systemMac;
	private String systemIp;
	private String systemName;
	private String reviewee;
	private String poaName;
	private String priority;
	
	public String getPlanOfActionId() {
		return PlanOfActionId;
	}
	public void setPlanOfActionId(String planOfActionId) {
		PlanOfActionId = planOfActionId;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public Timestamp getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getChallenges() {
		return challenges;
	}
	public void setChallenges(String challenges) {
		this.challenges = challenges;
	}
	public String getPlanofaction() {
		return planofaction;
	}
	public void setPlanofaction(String planofaction) {
		this.planofaction = planofaction;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getAccountable() {
		return accountable;
	}
	public void setAccountable(String accountable) {
		this.accountable = accountable;
	}
	public String getConsulted() {
		return consulted;
	}
	public void setConsulted(String consulted) {
		this.consulted = consulted;
	}
	public String getInformed() {
		return informed;
	}
	public void setInformed(String informed) {
		this.informed = informed;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Date getExpectedClosureDate() {
		return expectedClosureDate;
	}
	public void setExpectedClosureDate(Date expectedClosureDate) {
		this.expectedClosureDate = expectedClosureDate;
	}
	public Date getClosureDate() {
		return closureDate;
	}
	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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
	public String getReviewee() {
		return reviewee;
	}
	public void setReviewee(String reviewee) {
		this.reviewee = reviewee;
	}
	public String getPoaName() {
		return poaName;
	}
	public void setPoaName(String poaName) {
		this.poaName = poaName;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public boolean save_poa(String type) {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection();  
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO propel_project.d_poa "
	        			+ "(rowId, reviewDate, challenges, planofaction, "
	        			+ "responsible, accountable, consulted, informed, "
	        			+ "status, comment, expectedClosureDate, closureDate, "
	        			+ "systemMac, systemIp, systemName, createdBy, updatedBy,"
	        			+ " createdOn, updatedOn, reviewee,poaname, priority, projectid ) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?)"; System.out.println(sql);
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, PlanOfActionId);
	            stmt.setTimestamp(2, reviewDate);
	            stmt.setString(3, challenges);
	            stmt.setString(4, planofaction);
	            stmt.setString(5, responsible);
	            stmt.setString(6, accountable);
	            stmt.setString(7, consulted);
	            stmt.setString(8, informed);
	            stmt.setString(9, status);
	            stmt.setString(10, comment);
	            stmt.setDate(11, expectedClosureDate);
	            stmt.setDate(12, closureDate);
	            stmt.setString(13, systemMac);
	            stmt.setString(14, systemIp);
	            stmt.setString(15, systemName);
	            stmt.setString(16, createdBy);
	            stmt.setString(17, createdBy);
	            stmt.setTimestamp(18, timestamp);
	            stmt.setTimestamp(19, timestamp);
	            stmt.setString(20, reviewee);
	            stmt.setString(21, poaName);
	            stmt.setString(22, priority);
	            stmt.setString(23, projectid);
        	}else if(type.indexOf("updat")>=0){
        		String sql = "UPDATE propel_project.d_poa SET "
        				   + "updatedOn=?, reviewDate=?, challenges=?, planofaction=?, "
        				   + "responsible=?, accountable=?, consulted=?, informed=?, "
        				   + "status=?, comment=?, expectedClosureDate=?, closureDate=?, "
        				   + "systemMac=?, systemIp=?, systemName=?, updatedBy=? , "
        				   + "reviewee=?, poaname= ?, priority=? "
        				   + "where rowId=?" ;
    			stmt = conn.prepareStatement(sql);
    			stmt.setTimestamp(1, timestamp);
 	            stmt.setTimestamp(2, reviewDate);
 	            stmt.setString(3, challenges);
 	            stmt.setString(4, planofaction);
 	            stmt.setString(5, responsible);
 	            stmt.setString(6, accountable);
 	            stmt.setString(7, consulted);
 	            stmt.setString(8, informed);
 	            stmt.setString(9, status);
 	            stmt.setString(10, comment);
 	            stmt.setDate(11, expectedClosureDate);
 	            stmt.setDate(12, closureDate);
 	            stmt.setString(13, systemMac);
 	            stmt.setString(14, systemIp);
 	            stmt.setString(15, systemName);
 	            stmt.setString(16, createdBy);
 	            stmt.setString(17, reviewee);
 	            stmt.setString(18, poaName);
 	            stmt.setString(19, priority);
 	            stmt.setString(20, PlanOfActionId);
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
	
	public boolean update_status(){
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection(); 
		try {
			String sql = "UPDATE propel_project.d_poa SET "
 				   + "updatedOn=?, status=?,  "
 				   + "systemMac=?, systemIp=?, systemName=?, updatedBy=? "
 				   + "where rowId=?" ;
			  stmt = conn.prepareStatement(sql);
			  stmt.setTimestamp(1, timestamp);
	          stmt.setString(2, status);
	          stmt.setString(3, systemMac);
	          stmt.setString(4, systemIp);
	          stmt.setString(5, systemName);
	          stmt.setString(6, createdBy);
	          stmt.setString(7, PlanOfActionId);
	          stmt.executeUpdate(); System.out.println(stmt);
	          returnVal = true;
	          conn.close();
	    }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = false;
		}
		return returnVal;
	}
	
	public boolean update_closureDate(){
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection(); 
		try {
			String sql = "UPDATE propel_project.d_poa SET "
 				   + "updatedOn=?, closureDate=?,  "
 				   + "systemMac=?, systemIp=?, systemName=?, updatedBy=?  "
 				   + "where rowId=?" ;
			  stmt = conn.prepareStatement(sql);
			  stmt.setTimestamp(1, timestamp);
	          stmt.setDate(2, closureDate);
	          stmt.setString(3, systemMac);
	          stmt.setString(4, systemIp);
	          stmt.setString(5, systemName);
	          stmt.setString(6, createdBy);
	          stmt.setString(7, PlanOfActionId);
	          stmt.executeUpdate(); System.out.println(stmt);
	          returnVal = true;
	          conn.close();
	    }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = false;
		}
		return returnVal;
	}
	public boolean comments_poa() {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection(); 
		try {
			String sql = "UPDATE propel_project.d_poa SET "
 				   + "updatedOn=?, comment=?,  "
 				   + "systemMac=?, systemIp=?, systemName=?, updatedBy=? "
 				   + "where rowId=? " ;
			  stmt = conn.prepareStatement(sql);
			  stmt.setTimestamp(1, timestamp);
	          stmt.setString(2, comment);
	          stmt.setString(3, systemMac);
	          stmt.setString(4, systemIp);
	          stmt.setString(5, systemName);
	          stmt.setString(6, createdBy);
	          stmt.setString(7, PlanOfActionId);
	          stmt.executeUpdate(); System.out.println(stmt);
	          returnVal = true;
	          conn.close();
	    }
        catch (SQLException e) {
            e.printStackTrace();
        	returnVal = false;
		}
		return returnVal;
	}
}
