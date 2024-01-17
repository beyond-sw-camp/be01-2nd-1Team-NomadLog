package com.encore.bbs.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.member.dto.CommentDTO;
import com.encore.bbs.member.dto.MemberDTO;

@Mapper // @Mapper 어노테이션을 사용한 인터페이스는 MyBatis에 의해 구현체가 자동으로 생성되어 사용된다.
public interface MemberMapper {
    int save(MemberDTO memberDTO);

    MemberDTO login(MemberDTO memberDTO);

	List<BbsDTO> findByIdBbs(int loginId);

	List<CommentDTO> findByIdComment(String loginId);

	MemberDTO findByInfo(int loginId);

	int update(MemberDTO memberDTO);

	void deleteMember(int loginId);

	int code(MemberDTO memberDTO);

	MemberDTO findId(String memberId);

	MemberDTO findAllCode(Integer loginId);
}