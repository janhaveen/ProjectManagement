package com.project.process;

import java.sql.SQLException;

import com.data.MySql.MySqlConnect;
import com.general.system.GetSystemDetails;
import com.project.interview.Interview;


public class Process extends Interview{
	private String ProcessId;
	private String processName;
	private String department;
	private String ProcessDocType;
	private String ProcedureComments;
	private String supplier; 
	private String input; 
	private String process;
	private String output; 
	private String customer;
	public String getProcessId() {
		return ProcessId;
	}
	public void setProcessId(String processId) {
		ProcessId = processId;
	}
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProcessDocType() {
		return ProcessDocType;
	}
	public void setProcessDocType(String processDocType) {
		ProcessDocType = processDocType;
	}
	public String getProcedureComments() {
		return ProcedureComments;
	}
	public void setProcedureComments(String procedureComments) {
		ProcedureComments = procedureComments;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public boolean save_process(String type) {
		boolean returnVal=false;
		String ip=GetSystemDetails.getIp();
		conn=MySqlConnect.DBConnection();  
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO propel_project.d_process "
						+ "(rowId, interviewId, procedureName, department, type, comments,"
						+ " systemMac, systemIp, systemName, "
						+ " createdBy, updatedBy, createdOn, updatedOn, "
						+ " projectid, supplier, input, output, customer, process ) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; System.out.println(sql);
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, ProcessId);
	            stmt.setString(2, super.getInterviewId());
	            stmt.setString(3, processName);
	            stmt.setString(4, department);
	            stmt.setString(5, ProcessDocType);
	            stmt.setString(6, ProcedureComments);
	            stmt.setString(7, GetSystemDetails.getMACAddress(ip));
	            stmt.setString(8, ip);
	            stmt.setString(9, GetSystemDetails.getSystemName());
	            stmt.setString(10, super.getCreatedBy());
	            stmt.setString(11, super.getCreatedBy());
	            stmt.setTimestamp(12, timestamp);
	            stmt.setTimestamp(13, timestamp);
	            stmt.setString(14, super.getProjectId());
	            stmt.setString(15, supplier);
 	            stmt.setString(16, input);
 	            stmt.setString(17, output);
 	            stmt.setString(18, customer);
 	            stmt.setString(19, process);
        	}else if(type.indexOf("updat")>=0){
        		String sql = "UPDATE propel_project.d_process SET "
        				   + " supplier=?,  input=?,  output=?,  customer=?,"
        				   + " systemMac=?, systemIp=?, systemName=?, "
        				   + "updatedBy=?, procedureName=?, type=?, comments=?, "
        				   + "process=?, projectid=?, department=? where rowId=?" ;
    			stmt = conn.prepareStatement(sql);
 	            stmt.setString(1, supplier);
 	            stmt.setString(2, input);
 	            stmt.setString(3, output);
 	            stmt.setString(4, customer);
 	            stmt.setString(5, GetSystemDetails.getMACAddress(ip));
 	            stmt.setString(6, ip);
 	            stmt.setString(7, GetSystemDetails.getSystemName());
 	            stmt.setString(8, super.getCreatedBy());
 	            stmt.setString(9, processName);
	            stmt.setString(10, ProcessDocType);
	            stmt.setString(11, ProcedureComments);
	            stmt.setString(12, process);
	            stmt.setString(13, super.getProjectId());
	            stmt.setString(14, department);
 	            stmt.setString(15, ProcessId);
        	}System.out.println(stmt);
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
