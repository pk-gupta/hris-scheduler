package org.marlabs.iis.employee;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.marlabs.connection.*;
@Repository
public class EmployeeIISRepositoryImpl implements EmployeeIISRepository{
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private Connection conn;
	
	@Transactional(readOnly=true)
	public List<EmployeeIISVo> listEmployees() throws Exception  {
		try {
			jdbcTemplate=conn.getIisTemplate();
			String sql = "SELECT * from Employees";
			List<EmployeeIISVo> employeeDetails = jdbcTemplate.query(sql, new EmployeeIISMapper());	
			List<EmployeeIISVo> mockEmployeeDetails =new ArrayList<EmployeeIISVo>();
		
				mockEmployeeDetails.addAll(employeeDetails);
				mockEmployeeDetails.get(0).setEmail("shibu.varghese@marlabsglobal.com");
				mockEmployeeDetails.get(0).setEmployeeName("shibu,varghese");
				mockEmployeeDetails.get(0).setEmpRecruiterEmail("siva.raman@marlabs.com");
				mockEmployeeDetails.get(1).setEmail("santharam.Ayyalasomayajula@marlabsglobal.com");
				mockEmployeeDetails.get(1).setEmpRecruiterEmail("Venugopal.palyam@marlabs.com");
				mockEmployeeDetails.get(2).setEmail("abdul.Kodungukkaran@marlabsglobal.com");
				mockEmployeeDetails.get(2).setEmpRecruiterEmail("Venugopal.palyam@marlabs.com");
				mockEmployeeDetails.get(3).setEmployeeName("palyam,Venugopal");
				mockEmployeeDetails.get(3).setEmpRecruiterEmail("shibu.varghese@marlabsglobal.com");
				mockEmployeeDetails.get(3).setEmail("Venugopal.palyam@marlabs.com");
	return employeeDetails;
			//return mockEmployeeDetails.subList(0, 4);
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}
	
	
	}
}
