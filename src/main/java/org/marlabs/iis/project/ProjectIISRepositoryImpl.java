package org.marlabs.iis.project;

import java.util.List;

import org.marlabs.connection.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ProjectIISRepositoryImpl implements ProjectIISRepository{
	
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	@Autowired
	private Connection conn;
	
	@Transactional(readOnly=true)
	public List<ProjectIISVo> listProjects() throws Exception {
		try {
			jdbcTemplate=conn.getIisTemplate();
			String sql = "SELECT * from Projects";
			List<ProjectIISVo> projectDetails = jdbcTemplate.query(sql, new ProjectMapper());
			return projectDetails;
		} catch (Exception e) {
			throw new Exception("--Error message--", e);
		}

	}	
	

}
