package org.marlabs.iis.employee;

public class EmployeeIISVo {
	private int id;
	
	private String employeeId;
	private String employeeName;
	private String phoneNumber;
	private String email;
	private String location;
	private String state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private boolean isManager;
	private int role;
	public boolean isManager() {
		return isManager;
	}
	public void setManager(boolean isManager) {
		this.isManager = isManager;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	private String EmpRecruiter;
	private String EmpRecruiterId;
	private String EmpRecruiterEmail;

		
	public String getEmpRecruiterEmail() {
		return EmpRecruiterEmail;
	}
	public void setEmpRecruiterEmail(String empRecruiterEmail) {
		EmpRecruiterEmail = empRecruiterEmail;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmpRecruiter() {
		return EmpRecruiter;
	}
	public void setEmpRecruiter(String empRecruiter) {
		EmpRecruiter = empRecruiter;
	}
	public String getEmpRecruiterId() {
		return EmpRecruiterId;
	}
	public void setEmpRecruiterId(String empRecruiterId) {
		EmpRecruiterId = empRecruiterId;
	}
	
}
