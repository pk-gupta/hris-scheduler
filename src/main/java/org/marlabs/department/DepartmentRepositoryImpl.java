package org.marlabs.department;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Transactional(readOnly=true)
	public List<DepartmentVo> listDepartments()throws Exception  {
		try {
			
			jdbcTemplate.setDataSource(DataSourceBuilder
			        .create()
			        .username("ers_appuser")
			        .password("Er$@1uH6c")
			        .url("jdbc:sqlserver://192.168.35.115;databaseName=HRIS;integratedSecurity=false")
			        .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
			        .build());
			String sql = "SELECT * from Department_V";
			List<DepartmentVo> deptDetails = jdbcTemplate.query(sql, new DepartmentMapper());			
			return deptDetails;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}
	}

	
	@Override
	public List<DepartmentVo> findDeptById(String deptId) throws Exception {
try {
			
			String sql = "SELECT * from Department_V where [Department Id] = ?";
			List<DepartmentVo> deptDetails = jdbcTemplate.query(sql,new Object[]{deptId}, new DepartmentMapper());			
			return deptDetails;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}
	}

	@Override
	public List<DepartmentVo> findDeptByName(String deptName) throws Exception {
try {
			
			String sql = "SELECT * from Department_V where [Department Name]=?";
			List<DepartmentVo> deptDetails = jdbcTemplate.query(sql,new Object[]{deptName}, new DepartmentMapper());			
			return deptDetails;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}
	}

	@Override
	public List<DepartmentVo> findDeptByDivision(String division) throws Exception {
try {
			
			String sql = "SELECT * from Department_V where Division = ?";
			List<DepartmentVo> deptDetails = jdbcTemplate.query(sql,new Object[]{division}, new DepartmentMapper());			
			return deptDetails;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}
	}


	@Override
	public List<DepartmentVo> findDeptByCode(String deptCode) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
