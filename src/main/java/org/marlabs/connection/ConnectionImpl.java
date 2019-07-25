package org.marlabs.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class ConnectionImpl implements Connection{

	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Override
	public JdbcTemplate getHrisTemplate() {
		// TODO Auto-generated method stub
		jdbcTemplate.setDataSource(DataSourceBuilder
		        .create()
		        .username("ers_appuser")
		        .password("Er$@1uH6c")
		        .url("jdbc:sqlserver://192.168.35.115;databaseName=HRIS;integratedSecurity=false")
		        .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
		        .build());
		
		return jdbcTemplate;
	}

	@Override
	public JdbcTemplate getIisTemplate() {
		
		jdbcTemplate.setDataSource(DataSourceBuilder
		        .create()
		        .username("dev_kochi")
		        .password("D*vK@ch1n")
		        .url("jdbc:sqlserver://10.150.13.111;databaseName=iiswebappdb_kochin;integratedSecurity=false")
		        .driverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
		        .build());
		
		return jdbcTemplate;
	}

	
	
	
	
}
