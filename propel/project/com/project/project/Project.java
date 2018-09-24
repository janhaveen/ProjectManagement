package com.project.project;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.data.MySql.MySqlConnect;
public class Project {
	Connection conn = null;
    PreparedStatement stmt = null;
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());    
	
	private String  projectId; 
	private String  companyName; 
	private String  branchName; 
	private String  referenceBy; 
	private String  location; 
	private String  industry; 
	private String  phoneNo; 
	private String  website; 
	private String  emailId; 
	private String  stakeholderFname; 
	private String  stakeholderLname; 
	private String  stakeholderDesignation; 
	private String  stakeholderContactno; 
	private String  stakeholderAltcontactno;
	private String  stakeholderEmailid; 
	private float  billAmount; 
	private String  paymentMode; 
	private String  paymentFrequency; 
	private String  gstNo; 
	private String  address1; 
	private String  address2; 
	private String  areaCity; 
	private String  state; 
	private String  pincode; 
	private Date  startdate; 
	private String  visitfrequency; 
	private String  cpc; 
	private String  epc; 
	private String  createdby;
	private String source;
	private String preferredDay;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getReferenceBy() {
		return referenceBy;
	}
	public void setReferenceBy(String referenceBy) {
		this.referenceBy = referenceBy;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getStakeholderFname() {
		return stakeholderFname;
	}
	public void setStakeholderFname(String stakeholderFname) {
		this.stakeholderFname = stakeholderFname;
	}
	public String getStakeholderLname() {
		return stakeholderLname;
	}
	public void setStakeholderLname(String stakeholderLname) {
		this.stakeholderLname = stakeholderLname;
	}
	public String getStakeholderDesignation() {
		return stakeholderDesignation;
	}
	public void setStakeholderDesignation(String stakeholderDesignation) {
		this.stakeholderDesignation = stakeholderDesignation;
	}
	public String getStakeholderContactno() {
		return stakeholderContactno;
	}
	public void setStakeholderContactno(String Contactno) {
		this.stakeholderContactno = Contactno;
	}
	public String getStakeholderAltcontactno() {
		return stakeholderAltcontactno;
	}
	public void setStakeholderAltcontactno(String string) {
		this.stakeholderAltcontactno = string;
	}
	public String getStakeholderEmailid() {
		return stakeholderEmailid;
	}
	public void setStakeholderEmailid(String stakeholderEmailid) {
		this.stakeholderEmailid = stakeholderEmailid;
	}
	public float getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(float billAmount) {
		this.billAmount = billAmount;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	public String getPaymentFrequency() {
		return paymentFrequency;
	}
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}
	public String getGstNo() {
		return gstNo;
	}
	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getAreaCity() {
		return areaCity;
	}
	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public String getVisitfrequency() {
		return visitfrequency;
	}
	public void setVisitfrequency(String visitfrequency) {
		this.visitfrequency = visitfrequency;
	}
	public String getCpc() {
		return cpc;
	}
	public void setCpc(String cpc) {
		this.cpc = cpc;
	}
	public String getEpc() {
		return epc;
	}
	public void setEpc(String epc) {
		this.epc = epc;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getPreferredDay() {
		return preferredDay;
	}
	public void setPreferredDay(String preferredDay) {
		this.preferredDay = preferredDay;
	}
	public boolean saveProject() {
		boolean returnVal=false;
		conn = MySqlConnect.DBConnection();
		try {
			String sql = "INSERT INTO propel_project.d_project " 
	    			+ " (rowid, companyName, branchName, referenceBy, location, "
	    			+ "industry, phoneNo, website, emailId, "
	    			+ "stakeholderFname, stakeholderLname, stakeholderDesignation, "
	    			+ "stakeholderContactno, stakeholderAltcontactno, stakeholderEmailid, "
	    			+ "billAmount, paymentMode, paymentFrequency, gstNo, "
	    			+ "address1, address2, areaCity, state, pincode, "
	    			+ "startdate, visitfrequency, cpc, epc, "
	    			+ "createdon, updatedon, createdby, updatedby,source, preferredDay) "
					+ " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, "
					+ " ?, ?,  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        stmt = conn.prepareStatement(sql); 
	        stmt.setString(1, projectId);
	        stmt.setString(2, companyName);
	        stmt.setString(3, branchName); 
	        stmt.setString(4, referenceBy);
	        stmt.setString(5, location);
	        stmt.setString(6, industry);	        
	        stmt.setString(7, phoneNo);  
	        stmt.setString(8, website);
	        stmt.setString(9, emailId);
	        stmt.setString(10, stakeholderFname);
	        stmt.setString(11, stakeholderLname);
	        stmt.setString(12, stakeholderDesignation);
	        stmt.setString(13, stakeholderContactno);
	        stmt.setString(14, stakeholderAltcontactno);
	        stmt.setString(15, stakeholderEmailid);
	        stmt.setFloat(16, billAmount);
	        stmt.setString(17, paymentMode);
	        stmt.setString(18, paymentFrequency);
	        stmt.setString(19, gstNo);
	        stmt.setString(20, address1);
	        stmt.setString(21, address2);
	        stmt.setString(22, areaCity);
	        stmt.setString(23, state);
	        stmt.setString(24, pincode);
	        stmt.setDate(25, startdate);
	        stmt.setString(26, visitfrequency);
	        stmt.setString(27, cpc);
	        stmt.setString(28, epc);
	        stmt.setTimestamp(29, timestamp); 
	        stmt.setTimestamp(30, timestamp); 
	        stmt.setString(31, createdby);
	        stmt.setString(32, createdby);
	        stmt.setString(33, source);
	        stmt.setString(34, preferredDay);System.out.println(stmt);
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
	public boolean updateProject() {
		boolean returnVal=false;	
		conn = MySqlConnect.DBConnection();
		try {
			String sql = "UPDATE propel_project.d_project SET " 
	    			+ " companyName=?, branchName=?, updatedby=?, referenceBy=?, location=?, "
	    			+ "industry=?, phoneNo=?, website=?, emailId=?, "
	    			+ "stakeholderFname=?, stakeholderLname=?, stakeholderDesignation=?, "
	    			+ "stakeholderContactno=?, stakeholderAltcontactno=?, stakeholderEmailid=?, "
	    			+ "billAmount=?, paymentMode=?, paymentFrequency=?, gstNo=?, "
	    			+ "address1=?, address2=?, areaCity=?, state=?, pincode=?, "
	    			+ "startdate=?, visitfrequency=?, cpc=?, epc=?, "
	    			+ "updatedon=? , source=?, preferredDay=? "
					+ " where rowid =? ";
	        stmt = conn.prepareStatement(sql); 
	        stmt.setString(1, companyName);
	        stmt.setString(2, branchName); 
	        stmt.setString(3, createdby);
	        stmt.setString(4, referenceBy);
	        stmt.setString(5, location);
	        stmt.setString(6, industry);	        
	        stmt.setString(7, phoneNo);  
	        stmt.setString(8, website);
	        stmt.setString(9, emailId);
	        stmt.setString(10, stakeholderFname);
	        stmt.setString(11, stakeholderLname);
	        stmt.setString(12, stakeholderDesignation);
	        stmt.setString(13, stakeholderContactno);
	        stmt.setString(14, stakeholderAltcontactno);
	        stmt.setString(15, stakeholderEmailid);
	        stmt.setFloat(16, billAmount);
	        stmt.setString(17, paymentMode);
	        stmt.setString(18, paymentFrequency);
	        stmt.setString(19, gstNo);
	        stmt.setString(20, address1);
	        stmt.setString(21, address2);
	        stmt.setString(22, areaCity);
	        stmt.setString(23, state);
	        stmt.setString(24, pincode);
	        stmt.setDate(25, startdate);
	        stmt.setString(26, visitfrequency);
	        stmt.setString(27, cpc);
	        stmt.setString(28, epc);
	        stmt.setTimestamp(29, timestamp); 	       
	        stmt.setString(30, source);
	        stmt.setString(31, preferredDay);
	        stmt.setString(32, projectId);System.out.println(stmt);
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
		return returnVal;}
}