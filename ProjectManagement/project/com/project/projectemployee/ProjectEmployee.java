package com.project.projectemployee;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
 
public class ProjectEmployee  { 
    Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
   
    private String employeeId;
    private String projectId;
    private String firstName;
    private String lastName;
    private String department;
    private String designation;
    private Long mobileNo;
    private Long altContactNo;
    private String emailId;
    private String userIdEmp;
    private String password;
    private Date birthday;
    private Date joinDate;
    private String status;
    private String location;
    private String reportTo;
    private String userId;
    private String branchId;
    private String Experience;
    private String Compensation;
	private String permissions;
	private String empOf;
	private String assignedRole;
   	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Long getAltContactNo() {
		return altContactNo;
	}

	public void setAltContactNo(Long altContactNo) {
		this.altContactNo = altContactNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserIdEmp() {
		return userIdEmp;
	}

	public void setUserIdEmp(String userIdEmp) {
		this.userIdEmp = userIdEmp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getReportTo() {
		return reportTo;
	}

	public void setReportTo(String reportTo) {
		this.reportTo = reportTo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBranchId() {
		return branchId;
	}

	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	
	public String getExperience() {
		return Experience;
	}

	public void setExperience(String experience) {
		Experience = experience;
	}

	public String getCompensation() {
		return Compensation;
	}

	public void setCompensation(String compensation) {
		Compensation = compensation;
	}
	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	public String getEmpOf() {
		return empOf;
	}

	public void setEmpOf(String empOf) {
		this.empOf = empOf;
	}

	public String getAssignedRole() {
		return assignedRole;
	}

	public void setAssignedRole(String assignedRole) {
		this.assignedRole = assignedRole;
	}
	public boolean Employee_action(String type) {
        boolean returnVal = false;
        conn = MySqlConnect.DBConnection();
         
        try {
        	if(type.indexOf("insert")>=0) {
	        	String sql = "INSERT INTO propel_project.d_project_employee "
						+ "(rowId, ProjectId, firstName, lastName, department, "
						+ "designation, contactNo, altcontactNo, emailId, isDeleted, Branch,"
						+ "location, DOB, joiningDate, reportTo, userId, status, password, experience, "
						+ "compensation, permissions, empOf, assignedRole, "
						+ "createdOn, updatedOn, createdBy, updatedBy) VALUES "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
	            stmt = conn.prepareStatement(sql);
	            stmt.setString(1, employeeId);
	            stmt.setString(2, projectId);
	            stmt.setString(3, firstName);
	            stmt.setString(4, lastName);
	            stmt.setString(5, department);
	            stmt.setString(6, designation);
	            stmt.setLong(7, mobileNo);
	            stmt.setLong(8, altContactNo);
	            stmt.setString(9, emailId);
	            stmt.setInt(10, 0);
	            stmt.setString(11, branchId);
	            stmt.setString(12, location);
	            stmt.setDate(13, birthday);
	            stmt.setDate(14, joinDate);
	            stmt.setString(15, reportTo);
	            stmt.setString(16, userIdEmp);
	            stmt.setString(17, status); 
	            stmt.setString(18, password);
	            stmt.setString(19, Experience);
	            stmt.setString(20, Compensation);
	            stmt.setString(21, permissions);
	            stmt.setString(22, empOf);
	            stmt.setString(23, assignedRole);
	            stmt.setTimestamp(24, timestamp);
	            stmt.setTimestamp(25, timestamp);
	            stmt.setString(26, userId);
	            stmt.setString(27, userId);
        	}else if(type.indexOf("updat")>=0){
        		String sql = "update propel_project.d_project_employee  set"
    					+ " firstName = ?, lastName = ?, department = ?, designation = ?, contactNo = ?,"
    					+ " emailId = ?,location = ?, reportTo = ?, experience = ?, compensation = ?, "
    					+ " updatedOn = ?, updatedBy = ? "
    					+ "where rowId = ?";
    			stmt = conn.prepareStatement(sql);
    			stmt.setString(1, firstName);
                stmt.setString(2, lastName);
                stmt.setString(3, department);
                stmt.setString(4, designation);
                stmt.setLong(5, mobileNo);
                stmt.setString(6, emailId);
                stmt.setString(7, location);
                stmt.setString(8, reportTo);
	            stmt.setString(9, Experience);
	            stmt.setString(10, Compensation);
	            stmt.setTimestamp(11, timestamp);
	            stmt.setString(12, userId);
    	        stmt.setString(13, employeeId);
        	}else if(type.indexOf("upIntCmp")>=0){
        		String sql = "update propel_project.d_project_employee  set"
    					+ "  experience = ?, compensation = ?, "
    					+ " updatedOn = ?, updatedBy = ? "
    					+ "where rowId = ?";
    			stmt = conn.prepareStatement(sql);
	            stmt.setString(1, Experience);
	            stmt.setString(2, Compensation);
	            stmt.setTimestamp(3, timestamp);
	            stmt.setString(4, userId);
    	        stmt.setString(5, employeeId);
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