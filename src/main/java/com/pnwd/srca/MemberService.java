/**
 * 
 */
package com.pnwd.srca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Putu Ngurah Wigadoni
 * @version 1.0
 */
@Service
public class MemberService {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
	public List<Member> findAll(){
		return jdbcTemplate.query("SELECT * FROM member",new MemberRowMapper());
	}
	
}
