package studio.thinkground.aroundhub.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import studio.thinkground.aroundhub.dto.MemberDTO;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
	
	@PostMapping(value="/member")
	public String postMember(@RequestBody Map<String, String> postData) {
		StringBuilder sb = new StringBuilder();
		
		postData.entrySet().forEach(map->{
			sb.append(map.getKey() + " : " + map.getValue() + "\n");
		});
		
		return sb.toString();
	}
	
	@PostMapping(value="/member2")
	public String postMemberDto(@RequestBody MemberDTO memberDTO) {
		return memberDTO.toString();
	}

	
}
