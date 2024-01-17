package com.encore.bbs.member.service;

import java.util.List;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.member.dto.CommentDTO;
import com.encore.bbs.member.dto.MemberDTO;

public interface MemberService {
	int save(MemberDTO memberDTO);
	boolean login(MemberDTO memberDTO);
//	List<MemberDTO> findById();
	List<BbsDTO> findByIdBbs(int loginId);
	List<CommentDTO> findByIdComment(String loginId);
	MemberDTO findByIdInfo(int loginId);
	boolean update(MemberDTO memberDTO);
	String idCheck(String memberId);
	void delete(int loginId);
	int code(MemberDTO memberDTO);

	// 수정사항
	MemberDTO findAllCode(Integer loginId);
}

