package org.marlabs.project;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository{
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Transactional(readOnly=true)
	public List<ProjectVo> listProjects() throws Exception {
		try {
			
			jdbcTemplate.setDataSource(DataSourceBuilder
			        .create()
			        .username("ers_appuser")
			        .password("Er$@1uH6c")
			        .url("jdbc:sqlserver://192.168.35.115;databaseName=HRIS;integratedSecurity=false")
			        .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
			        .build());
			
			String sql = "SELECT * from Projects_V";
			List<ProjectVo> projectDetails = jdbcTemplate.query(sql, new ProjectMapper());
			return projectDetails;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}

	}

	@Override
	@Transactional(readOnly=true)
	public List<ProjectVo> findProjectByName(String projectName) throws Exception {
try {
			
			String sql = "SELECT * from Projects_V where ProjectName = ?";
			List<ProjectVo> project = jdbcTemplate.query(sql, new ProjectMapper(),new Object[]{projectName});
			return project;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProjectVo> findProjectByCode(String projectCode) throws Exception {
      try {
			
			String sql = "SELECT * from Projects_V where [Project Code] = ?";
			List<ProjectVo> project = jdbcTemplate.query(sql,new Object[]{projectCode}, new ProjectMapper());
			return project;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProjectVo> findProjectById(String projectId) throws Exception {
		  try {				
				String sql = "SELECT * from Projects_V where ProjectId = ?";
				List<ProjectVo> project = jdbcTemplate.query(sql,new Object[]{projectId}, new ProjectMapper());
				return project;
			} catch (Exception e) {
				throw new Exception("--Error message--", e);
			}
	}
	
	
	

}
