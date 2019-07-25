package org.marlabs.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{
	
	
	
	
	
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Transactional(readOnly=true)
	public List<EmployeeVo> listEmployees()throws Exception  {
		try {
			jdbcTemplate.setDataSource(DataSourceBuilder
			        .create()
			        .username("ers_appuser")
			        .password("Er$@1uH6c")
			        .url("jdbc:sqlserver://192.168.35.115;databaseName=HRIS;integratedSecurity=false")
			        .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
			        .build());
		
			String Sql = "select * from Employee_V";


			List<EmployeeVo> employeeDetails = jdbcTemplate.query(Sql, new EmployeeMapper());
			return employeeDetails;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}

	}

	@Override
	@Transactional(readOnly=true)
	public List<EmployeeVo> findEmployeeById(String employeeId) throws Exception {
		try {
			String sql = "SELECT * from Employee_V where [Employee Id] = ? ";
			List<EmployeeVo> employee = jdbcTemplate.query(sql,new Object[]{employeeId},new EmployeeMapper());
			return employee;
		}	
		  catch (Exception e) {
			throw new Exception("--Error message--Employee Id--", e);
		}
	}
	@Override
	@Transactional(readOnly=true)
	public List<EmployeeVo> findEmployeeByMail(String email) throws Exception {
		try {
			String sql = "SELECT * from Employee_V where Mail = ?";
			List<EmployeeVo> employee = jdbcTemplate.query(sql,new Object[]{email},new EmployeeMapper());
			return employee;
		}	
		  catch (Exception e) {
			throw new Exception("--Error message--Mail--", e);
		}
	}
	@Override
	@Transactional(readOnly=true)
	public List<EmployeeVo> findEmployeeByName(String employeeName) throws Exception {
		try {
			jdbcTemplate.setDataSource(DataSourceBuilder
			        .create()
			        .username("sa")
			        .password("Marlabs123")
			        .url("jdbc:sqlserver://192.168.28.77;databaseName=HRIS;integratedSecurity=false")
			        .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
			        .build());
			String sql = "SELECT * from Employee_V where [Employee Name] like ?";
			List<EmployeeVo> employee = jdbcTemplate.query(sql,new Object[]{"%"+employeeName+"%"},new EmployeeMapper());
			return employee;
		}	
		  catch (Exception e) {
			throw new Exception("--Error message--EmployeeName--", e);
		}
	}
}
