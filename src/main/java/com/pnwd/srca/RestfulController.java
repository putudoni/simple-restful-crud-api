/**
 * 
 */
package com.pnwd.srca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Putu Ngurah Wigadoni
 * @version 1.0
 */
@RestController
@RequestMapping("/api/v1")
public class RestfulController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/members")
	public ResponseEntity<ResponseApi> findAllMember(){
		ResponseApi response = new ResponseApi();
		response.setStatus(HttpStatus.OK.toString());
		response.setData(memberService.findAll());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@GetMapping("/member/save")
	public ResponseEntity<ResponseApi> saveMember(Member member){
		Member newMember =  memberService.create(member);
		ResponseApi response = new ResponseApi();
		response.setStatus(HttpStatus.OK.toString());
		response.setData(newMember);
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
