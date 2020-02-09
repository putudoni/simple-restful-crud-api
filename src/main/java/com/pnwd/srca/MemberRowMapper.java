/**
 * 
 */
package com.pnwd.srca;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Putu Ngurah Wigadoni
 * @version 1.0
 */
public class MemberRowMapper implements RowMapper<Member>{

	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		member.setId(rs.getLong("id"));
		member.setName(rs.getString("name"));
		member.setEmail(rs.getString("email"));
		member.setGender(rs.getString("gender"));
		member.setAddress(rs.getString("address"));
		member.setCreatedDate(rs.getDate("created_date"));
		member.setModifiedDate(rs.getDate("modified_date"));
		return member;
	}

}
