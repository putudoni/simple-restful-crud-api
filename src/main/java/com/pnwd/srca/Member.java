/**
 * 
 */
package com.pnwd.srca;

import java.util.Date;

import lombok.Data;

/**
 * @author Putu Ngurah Wigadoni
 * @version 1.0
 */
@Data
public class Member {

	private Long id;
	
	private String name;
	
	private String gender;
	
	private String email;
	
	private String address;
	
	private Date createdDate;
	
	private Date modifiedDate;

}
