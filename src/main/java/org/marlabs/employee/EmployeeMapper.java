package org.marlabs.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<EmployeeVo>{

	
	public EmployeeVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeVo employeeDetails = new EmployeeVo();
		/*int count = rs.getMetaData().getColumnCount();
		for (int i = 1; i <= count; i++)
		{
		   System.out.println(rs.getMetaData().getColumnName(i));
		}*/
		employeeDetails.setEmployeeId(rs.getString("Employee Id"));
		employeeDetails.setEmployeeDepartment(rs.getString("Employee Department"));
		employeeDetails.setEmployeeProject(rs.getString("Employee Project"));
		employeeDetails.setEmployeeProjectId(rs.getString("Employee ProjectId"));
		employeeDetails.setEmployeeDepartmentId(rs.getInt("Employee Department Id"));
		employeeDetails.setEmployeeName(rs.getString("Employee Name"));
		employeeDetails.setLocation(rs.getString("Location"));
		employeeDetails.setEmail(rs.getString("Mail"));
		employeeDetails.setPhoneNumber(rs.getString("Phone Number"));
		employeeDetails.setEmployeeManager(rs.getString("Employee Manager"));
		employeeDetails.setEmployeeManagerId(rs.getString("Employee ManagerId"));
		employeeDetails.setDesignation(rs.getString("Designation"));
		employeeDetails.setDesignationId(rs.getInt("Designation Id"));
		employeeDetails.setDesignationLevel(rs.getInt("Designation Level"));
		employeeDetails.setIsManager(rs.getBoolean("Is Manager"));
		employeeDetails.setIsBillable(rs.getBoolean("Billable or not"));
		employeeDetails.setIsActive(rs.getBoolean("IsActive"));
	
		return employeeDetails;
	}

}
