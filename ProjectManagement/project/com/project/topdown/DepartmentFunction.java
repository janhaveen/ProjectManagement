package com.project.topdown;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;

public class DepartmentFunction {
	Connection conn=null;
	PreparedStatement stmt = null;
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	private String FunctionId; 
	private String departmentId; 
	private String name; 
	private String roleDesc; 
	private String createdBy;
	private String IFId;
	private String InfluencingFactor;
	
	public String getFunctionId() {
		return FunctionId;
	}
	public void setFunctionId(String functionId) {
		FunctionId = functionId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	} 
	public String getIFId() {
		return IFId;
	}
	public void setIFId(String iFId) {
		IFId = iFId;
	}
	public String getInfluencingFactor() {
		return InfluencingFactor;
	}
	public void setInfluencingFactor(String influencingFactor) {
		InfluencingFactor = influencingFactor;
	}
	
	public boolean save_function(String type) {
		boolean returnVal=false;
		String ip=GetSystemDetails.getIp();
		conn=MySqlConnect.DBConnection();  
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO propel_project.d_function "
						+ "(rowId, departmentId, name, roleDesc, "
						+ "systemMac, systemIp, systemName, createdBy, "
						+ "updatedBy, createdOn, updatedOn, InfluencingFactor) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; System.out.println(sql);
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, FunctionId);
	            stmt.setString(2, departmentId);
	            stmt.setString(3, name);
	            stmt.setString(4, roleDesc);
	            stmt.setString(5, GetSystemDetails.getMACAddress(ip));
	            stmt.setString(6, ip);
	            stmt.setString(7, GetSystemDetails.getSystemName());
	            stmt.setString(8, createdBy);
	            stmt.setString(9, createdBy);
	            stmt.setTimestamp(10, timestamp);
	            stmt.setTimestamp(11, timestamp);
	            stmt.setString(12, InfluencingFactor);
        	}else if(type.indexOf("updat")>=0){
        		String sql = "UPDATE propel_project.d_function SET "
        				   + " name=?,  roleDesc=? , "
        				   + " systemMac=?, systemIp=?, systemName=?, "
        				   + "updatedBy=?, updatedOn=?, InfluencingFactor=?, departmentId=? where rowId=?" ;
    			stmt = conn.prepareStatement(sql);
 	            stmt.setString(1, name);
 	            stmt.setString(2, roleDesc);
 	            stmt.setString(3, GetSystemDetails.getMACAddress(ip));
 	            stmt.setString(4, ip);
 	            stmt.setString(5, GetSystemDetails.getSystemName());
 	            stmt.setString(6, createdBy);
 	            stmt.setTimestamp(7, timestamp);
 	            stmt.setString(8, InfluencingFactor);
 	            stmt.setString(9, departmentId);
 	            stmt.setString(10, FunctionId);
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
	
	/*private boolean save_influencingFactor(String type) {
		boolean returnVal=false;
		String ip=GetSystemDetails.getIp();
		conn=MySqlConnect.DBConnection();  
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO propel_project.d_function "
						+ "(rowId, functionId, InfluencingFactor) VALUES "
						+ "( ?, ?, ?)"; 
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, IFId);
	            stmt.setString(2, FunctionId);
	            stmt.setString(3, InfluencingFactor);
        	}else if(type.indexOf("updat")>=0){
        		String sql = "UPDATE propel_project.d_function SET "
        				   + " name=?,  roleDesc=?"
        				   + " systemMac=?, systemIp=?, systemName=?, "
        				   + "updatedBy=?, updatedOn=? where rowId=?" ;
    			stmt = conn.prepareStatement(sql);
 	            stmt.setString(1, name);
 	            stmt.setString(2, roleDesc);
 	            stmt.setString(3, GetSystemDetails.getMACAddress(ip));
 	            stmt.setString(4, ip);
 	            stmt.setString(5, GetSystemDetails.getSystemName());
 	            stmt.setString(6, createdBy);
 	            stmt.setTimestamp(7, timestamp);
 	            stmt.setString(8, FunctionId);
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
	}*/
	
	public boolean change_dept() {
		boolean returnVal=false;
		String ip=GetSystemDetails.getIp();
		conn=MySqlConnect.DBConnection();  
        try {        	
    		String sql = "UPDATE propel_project.d_function SET "
    				   + " departmentId =?, "
    				   + " systemMac=?, systemIp=?, systemName=?, "
    				   + "updatedBy=?, updatedOn=? where rowId=?" ;
			stmt = conn.prepareStatement(sql);
            stmt.setString(1, departmentId);
            stmt.setString(2, GetSystemDetails.getMACAddress(ip));
            stmt.setString(3, ip);
            stmt.setString(4, GetSystemDetails.getSystemName());
            stmt.setString(5, createdBy);
            stmt.setTimestamp(6, timestamp);
            stmt.setString(7, FunctionId);
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
