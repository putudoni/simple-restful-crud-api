/**
 * 
 */
package com.pnwd.srca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Putu Ngurah Wigadoni
 * @version 1.0
 */
@Service
public class MemberService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
}
