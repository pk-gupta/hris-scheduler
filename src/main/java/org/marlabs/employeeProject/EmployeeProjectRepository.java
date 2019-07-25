package org.marlabs.employeeProject;

import java.util.List;



public interface EmployeeProjectRepository {
	
	public List<EmployeeProjectVo> listEmployeeProjects() throws Exception;
	
}
