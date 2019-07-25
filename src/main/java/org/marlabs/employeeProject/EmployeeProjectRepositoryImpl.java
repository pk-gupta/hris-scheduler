package org.marlabs.employeeProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EmployeeProjectRepositoryImpl implements EmployeeProjectRepository{
	
	
	
	
	
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Transactional(readOnly=true)
	public List<EmployeeProjectVo> listEmployeeProjects()throws Exception  {
		try {
			jdbcTemplate.setDataSource(DataSourceBuilder
			        .create()
			        .username("ers_appuser")
			        .password("Er$@1uH6c")
			        .url("jdbc:sqlserver://192.168.35.115;databaseName=HRIS;integratedSecurity=false")
			        .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
			        .build());
		
			String Sql = "select * from EmployeeProject_V";


			List<EmployeeProjectVo> employeeDetails = jdbcTemplate.query(Sql, new EmployeeProjectMapper());			
			return employeeDetails;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}

	}

	
}
