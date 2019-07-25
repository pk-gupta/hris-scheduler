package org.marlabs.department;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DepartmentMapper implements RowMapper<DepartmentVo>{

	
	public DepartmentVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		DepartmentVo deptDetails = new DepartmentVo();
		/*int count = rs.getMetaData().getColumnCount();
		for (int i = 1; i <= count; i++)
		{
		   System.out.println(rs.getMetaData().getColumnName(i));
		}*/
		deptDetails.setDepartmentId(rs.getInt("Department Id"));
		deptDetails.setDepartmentName(rs.getString("Department Name"));
		deptDetails.setDivision(rs.getString("Division"));
		deptDetails.setDepartmentGroupName(rs.getString("Department GroupName"));
		deptDetails.setDepartmentManagerId(rs.getString("Dept Manager Id"));
		deptDetails.setDepartmentManager(rs.getString("Department Head"));
		
		return deptDetails;
	}

}
