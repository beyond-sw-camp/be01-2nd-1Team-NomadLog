package com.encore.bbs.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.member.dto.CommentDTO;
import com.encore.bbs.member.dto.MemberDTO;
import com.encore.bbs.member.mapper.MemberMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper memberMapper;

	public int save(MemberDTO memberDTO) {
		return memberMapper.save(memberDTO);
	}

	public boolean login(MemberDTO memberDTO) {
		MemberDTO loginMember = memberMapper.login(memberDTO);
		if(loginMember != null) {
			return true;
		} else {
			return false;
		}

	}
	
	@Override
	public int code(MemberDTO memberDTO) {
		return memberMapper.code(memberDTO);
	}

	@Override
	public List<BbsDTO> findByIdBbs(int loginId) {
		return memberMapper.findByIdBbs(loginId);
	}

	@Override
	public List<CommentDTO> findByIdComment(String loginId) {
		return memberMapper.findByIdComment(loginId);
	}

	@Override
	public MemberDTO findByIdInfo(int loginId) {
		return memberMapper.findByInfo(loginId);
	}

	@Override
	public boolean update(MemberDTO memberDTO) {
		int updateResult = memberMapper.update(memberDTO);
		if (updateResult > 0) {
			return true;
		} else {
			return false;
		}
		
	}

	@Override
	public String idCheck(String memberId) {
		MemberDTO memberDTO = memberMapper.findId(memberId);
		if (memberDTO == null) {
			return "ok";
		} else {
			return "no";
		}
	}

	@Override
	public void delete(int loginId) {
		memberMapper.deleteMember(loginId);
	}

	@Override
	public MemberDTO findAllCode(Integer loginId) {
		return memberMapper.findAllCode(loginId);
	}



}