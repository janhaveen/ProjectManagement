package com.support.issue;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;

public class Issue {
    
   Connection conn = null;
   PreparedStatement stmt = null;
   Timestamp timestamp = new Timestamp(System.currentTimeMillis());
   
   private String rowId;
   private String projectId;
   private String title;
   private String category;
   private Date expectedStartDate;
   private String duration;
   private String remarks;
   private String assignedTo;
   private String customer;
   private String mode;
   private String priority;
   private String description;
   private int isAccepted;
   private Date startDate;
   private Date endDate;
   private String createdby;
   private String updatedby;
   
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getExpectedStartDate() {
		return expectedStartDate;
	}
	public void setExpectedStartDate(Date expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIsAccepted() {
		return isAccepted;
	}
	public void setIsAccepted(int isAccepted) {
		this.isAccepted = isAccepted;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public boolean newIssue() {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
            String sql = "INSERT INTO propel_support.d_issue "
					+ "(rowId, projectId, title, category, assignedTo,"
					+ " customer, mode, priority, description,"
					+ " createdOn, updatedOn, createdBy, updatedBy) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
            stmt = conn.prepareStatement(sql);
        	
            stmt.setString(1, rowId);
            stmt.setString(2, projectId);
            stmt.setString(3, title);
            stmt.setString(4, category);
//            stmt.setDate(5, expectedDeilveryDate);
            stmt.setString(5, assignedTo);
            stmt.setString(6, customer);
            stmt.setString(7, mode);
            stmt.setString(8, priority);
            stmt.setString(9, description);
            stmt.setTimestamp(10, timestamp);
            stmt.setTimestamp(11, timestamp);
            stmt.setString(12, createdby);
            stmt.setString(13, updatedby);
            
            stmt.executeUpdate();
            conn.close();
            returnVal = true;
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

	public boolean updateIssueSupport() {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
			String sql = "update propel_support.d_issue set"
					+ " title = ?, category = ?, assignedTo = ?, customer = ?,"
					+ "	mode= ?, priority = ?, description = ?,"
					+ " updatedBy = ?, updatedOn = ?"
					+ " where rowId = ?";
			
			stmt = conn.prepareStatement(sql);

            stmt.setString(1, title);
            stmt.setString(2, category);
            stmt.setString(3, assignedTo);
            stmt.setString(4, customer);
            stmt.setString(5, mode);
            stmt.setString(6, priority);
            stmt.setString(7, description);
            stmt.setString(8, updatedby);
            stmt.setTimestamp(9, timestamp);
            stmt.setString(10, rowId);
            
            stmt.executeUpdate();
            returnVal = true;
			
		}catch (SQLException e) {
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

	public boolean updateIssue() {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
			String sql = "update propel_support.d_issue set"
					+ " title = ?, category = ?, expectedStartDate = ?, duration = ?, assignedTo = ?, customer = ?,"
					+ "	mode= ?, priority = ?, description = ?, remarks = ?, isAccepted = ?,"
					+ " updatedBy = ?, updatedOn = ?"
					+ " where rowId = ?";
			
			stmt = conn.prepareStatement(sql);

            stmt.setString(1, title);
            stmt.setString(2, category);
            stmt.setDate(3, expectedStartDate);
            stmt.setString(4, duration);
            stmt.setString(5, assignedTo);
            stmt.setString(6, customer);
            stmt.setString(7, mode);
            stmt.setString(8, priority);
            stmt.setString(9, description);
            stmt.setString(10, remarks);
            stmt.setInt(11, isAccepted);
            stmt.setString(12, updatedby);
            stmt.setTimestamp(13, timestamp);
            stmt.setString(14, rowId);
            
            stmt.executeUpdate();
            returnVal = true;
			
		}catch (SQLException e) {
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
	
	public boolean updateStartDate() {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
			String sql = "update propel_support.d_issue set"
					+ " startDate = ?, updatedBy = ?, updatedOn = ?"
					+ " where rowId = ?";
			
			stmt = conn.prepareStatement(sql);

            stmt.setDate(1, startDate);
            stmt.setString(2, updatedby);
            stmt.setTimestamp(3, timestamp);
            stmt.setString(4, rowId);
            
            stmt.executeUpdate();
            returnVal = true;
			
		}catch (SQLException e) {
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
	
	public boolean updateEndDate() {
		boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
			String sql = "update propel_support.d_issue set"
					+ " endDate = ?, updatedBy = ?, updatedOn = ?"
					+ " where rowId = ?";
			
			stmt = conn.prepareStatement(sql);

            stmt.setDate(1, endDate);
            stmt.setString(2, updatedby);
            stmt.setTimestamp(3, timestamp);
            stmt.setString(4, rowId);
            
            stmt.executeUpdate();
            returnVal = true;
			
		}catch (SQLException e) {
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
