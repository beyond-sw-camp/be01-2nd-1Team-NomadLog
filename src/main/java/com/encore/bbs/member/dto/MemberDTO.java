package com.encore.bbs.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MemberDTO { // DTO는 값을 받아서 '전달'하는 역할을 한다.
	
	private int memberCode;
	
	@NotBlank
	private String memberId;
	
//	@Size(min = 3, max = 20, message = "비밀번호는 3자 이상 20자 이하로 입력해주세요")
	private String memberPassword;
	
	
	private String memberName;
	
	@Email(message = "이메일 형식에 맞게 입력해주세요.")
	private String memberEmail;

	private Integer memberAge;

}