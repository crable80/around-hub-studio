package studio.thinkground.aroundhub.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.aroundhub.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
	
	@PutMapping(value = "/default")
	public String putMethod() {
		return "Hello world!";
	}
	
	@PutMapping(value = "/member")
	public String postMember(@RequestBody Map<String, String> putData) {
		StringBuilder sb = new StringBuilder();
		
		putData.entrySet().forEach(map -> {
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	@PutMapping(value = "/member1")
	public String postMemberDto1(@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}
	
	@PutMapping(value = "/member2")
	public MemberDTO postMemberDto2(@RequestBody MemberDTO memberDTO) {
		return memberDTO;
	}
	
	@PutMapping(value = "/member3")
	public ResponseEntity<MemberDTO> postMember3(@RequestBody MemberDTO memberDTO){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(memberDTO);
	}

}
