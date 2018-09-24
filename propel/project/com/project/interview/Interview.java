package com.project.interview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;

public class Interview{
	protected Connection conn=null;
	protected PreparedStatement stmt = null;
	protected Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	private String InterviewId;
	private String projectId;
	private String EmployeeId;
	private String designation;
	private String experience;
	private String compensation;
	private String meeting;
	private String coaching;
	private String training;
	private String role;
	private String challenges;
	private String createdBy;

	public String getInterviewId() {
		return InterviewId;
	}
	public void setInterviewId(String interviewId) {
		InterviewId = interviewId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String EmployeeId) {
		this.EmployeeId = EmployeeId;
	}
	public String getMeeting() {
		return meeting;
	}
	public void setMeeting(String meeting) {
		this.meeting = meeting;
	}
	public String getCoaching() {
		return coaching;
	}
	public void setCoaching(String coaching) {
		this.coaching = coaching;
	}
	public String getTraining() {
		return training;
	}
	public void setTraining(String training) {
		this.training = training;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getChallenges() {
		return challenges;
	}
	public void setChallenges(String challenges) {
		this.challenges = challenges;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	String ip=GetSystemDetails.getIp();
	public boolean save_interView(String type) {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection();  
        try {
        	if(type.indexOf("insert")>=0) {
        	String sql = "INSERT INTO propel_project.d_interview "
        			+ "(rowId, projectId, EmployeeId, "
        			+ "meeting, coaching, training, role1, challenges, "
        			+ "systemMac, systemIp, systemName, createdBy, updatedBy, createdOn, updatedOn) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, InterviewId);
            stmt.setString(2, projectId);
            stmt.setString(3, EmployeeId);
            stmt.setString(4, meeting);
            stmt.setString(5, coaching);
            stmt.setString(6, training);
            stmt.setString(7, role);
            stmt.setString(8, challenges);
            stmt.setString(9,GetSystemDetails.getMACAddress(ip));
            stmt.setString(10, ip);
            stmt.setString(11, GetSystemDetails.getSystemName());
            stmt.setString(12, createdBy);
            stmt.setString(13, createdBy);
            stmt.setTimestamp(14, timestamp);
            stmt.setTimestamp(15, timestamp);
        	}else if(type.indexOf("updat")>=0){
        		String sql = "UPDATE propel_project.d_interview SET "
        				   + "meeting=?, coaching=?, training=?, role1=?, challenges=?, "
        				   + "systemMac=?, systemIp=?, systemName=?, "
        				   + "updatedBy=?, updatedOn=?  where rowId=?" ;
    			stmt = conn.prepareStatement(sql);
	            stmt.setString(1, meeting);
	            stmt.setString(2, coaching);
	            stmt.setString(3, training);
	            stmt.setString(4, role);
	            stmt.setString(5, challenges);
	            stmt.setString(6,GetSystemDetails.getMACAddress(ip));
	            stmt.setString(7, ip);
	            stmt.setString(8, GetSystemDetails.getSystemName());
	            stmt.setString(9, createdBy);
	            stmt.setTimestamp(10, timestamp);
	            stmt.setString(11, InterviewId);
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
