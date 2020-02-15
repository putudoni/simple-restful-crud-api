/**
 * 
 */
package com.pnwd.srca;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
	
	@Transactional
	public Member create(Member member) {
		final String sql = "INSERT INTO member(name.gender,email,address,created_date,modified_date) VALUES(?,?,?,?,?)";
		KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
				ps.setString(1,member.getName());
				ps.setString(2,member.getGender());
				ps.setString(3,member.getEmail());
				ps.setString(4,member.getAddress());
				ps.setDate(5,new Date(member.getCreatedDate().getTime()));
				ps.setDate(6,new Date(member.getModifiedDate().getTime()));
				return ps;
			}
		},holder);
		Long memberId = holder.getKey().longValue();
		member.setId(memberId);
		return member;
	}
	
}
