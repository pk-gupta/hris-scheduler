package org.marlabs.connection;

import org.springframework.jdbc.core.JdbcTemplate;

public interface Connection {

	
	public JdbcTemplate getHrisTemplate();
	public JdbcTemplate getIisTemplate();
	
}
