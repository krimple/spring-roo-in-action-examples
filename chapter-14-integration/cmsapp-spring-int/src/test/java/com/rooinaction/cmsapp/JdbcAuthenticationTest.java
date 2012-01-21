package com.rooinaction.cmsapp;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Copyright.
 */

/**
 * @author Srini
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public class JdbcAuthenticationTest {
	
	private static final Logger logger = Logger.getLogger(JdbcAuthenticationTest.class);
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void verifyJdbcDataSourceSetup() throws SQLException {
		
		logger.debug("Test 1");
		
		dataSource.getConnection();

		logger.debug("Test 2");
	}

}
