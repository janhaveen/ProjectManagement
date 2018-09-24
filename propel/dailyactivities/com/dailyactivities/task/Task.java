package com.dailyactivities.task;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Task {
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    
    private String rowId;
    private String title;
    private String projectName;
    private String moduleName;
    private Date date;
    private Time startTime;
    private Time endTime;
    private String assignedBy;
    private String description;
    private String status;
    private String createdBy;
    private String updatedBy;
    
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public Time getEndTime() {
		return endTime;
	}
	public void setEndTime(Time endTime) {
		this.endTime = endTime;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public boolean updateTask() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
        	
        	String sql = "update propel_support.d_task set"
					+ " title = ?, projectName = ?, moduleName = ?, date = ?, startTime = ?,"
					+ " endTime = ?, assignedBy = ?, description = ?, status = ?,"
					+ " updatedOn = ?, updatedBy = ?"
					+ " where rowId = ?";
        	
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, title);
            stmt.setString(2, projectName);
            stmt.setString(3, moduleName);
            stmt.setDate(4, date);
            stmt.setTime(5, startTime);
            stmt.setTime(6, endTime);
            stmt.setString(7, assignedBy);
            stmt.setString(8, description);
            stmt.setString(9, status);
            stmt.setTimestamp(10, timestamp);
            stmt.setString(11, updatedBy);
            stmt.setString(12, rowId);
            System.out.println(stmt);
            
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

	public boolean newTask() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
        try {
        	String sql = "INSERT INTO propel_support.d_task "
					+ "(rowId, title, projectName, moduleName, date, startTime,"
					+ " endTime, assignedBy, description, status,"
					+ " createdOn, updatedOn, createdBy, updatedBy ) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        	
            stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, rowId);
            stmt.setString(2, title);
            stmt.setString(3, projectName);
            stmt.setString(4, moduleName);
            stmt.setDate(5, date);
            stmt.setTime(6, startTime);
            stmt.setTime(7, endTime);
            stmt.setString(8, assignedBy);
            stmt.setString(9, description);
            stmt.setString(10, status);
            stmt.setTimestamp(11, timestamp);
            stmt.setTimestamp(12, timestamp);
            stmt.setString(13, createdBy);
            stmt.setString(14, updatedBy);
            
            System.out.println(stmt);
            
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
}
