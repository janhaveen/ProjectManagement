package com.project.poa;

import java.sql.SQLException;

import com.data.MySql.MySqlConnect;

public class PlanOfActionLog extends PlanOfAction{
	private String rowId;
	private String action;
	private String fromValue;
	private String  toValue;
	public String getRowId() {
		return rowId;
	}
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getFromValue() {
		return fromValue;
	}
	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}
	public String getToValue() {
		return toValue;
	}
	public void setToValue(String toValue) {
		this.toValue = toValue;
	}
	
	public boolean save_PlanOfActionLog() {
		boolean returnVal=false;
		conn=MySqlConnect.DBConnection();  
        try {
        	String sql = "INSERT INTO propel_project.f_planofaction_logs "
        			+ "(rowId, poaId, action, fromValue, toValue, remarks, "
        			+ "systemMac, systemIp, systemName, createdBy, createdOn) VALUES "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; System.out.println(sql);
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, rowId);
            stmt.setString(2, super.getPlanOfActionId());
            stmt.setString(3, action);
            stmt.setString(4, fromValue);
            stmt.setString(5, toValue);
            stmt.setString(6, super.getComment());
            stmt.setString(7, super.getSystemMac());
            stmt.setString(8, super.getSystemIp());
            stmt.setString(9, super.getSystemName());
            stmt.setString(10,  super.getCreatedBy());
            stmt.setTimestamp(11, timestamp);
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
