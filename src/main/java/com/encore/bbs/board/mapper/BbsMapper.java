package com.encore.bbs.board.mapper;

import java.util.List;

import com.encore.bbs.board.dto.CountryDto;
import com.encore.bbs.board.dto.HashTag;
import org.apache.ibatis.annotations.Mapper;

import com.encore.bbs.board.dto.BbsDTO;

@Mapper
public interface BbsMapper {
	List<BbsDTO> selectBbsList() throws Exception;

	void insertBbs(BbsDTO bbs) throws Exception;

	void updateViewCount(int bbsId) throws Exception;

	BbsDTO selectBbsDetail(int bbsId) throws Exception;

	void updateBbs(BbsDTO bbs) throws Exception;

	void deleteBbs(int bbsId) throws Exception;

    BbsDTO updatedeleteBbs(int bbsId) throws Exception;

	void insertHashtag(HashTag hashTag)throws Exception;

	Long getLatestBbsId();

	List<CountryDto> getCountryList();

	Long selectCountryBbs(Long countryId);

	void insertCountry(BbsDTO bbs) throws Exception; //국가저장 메서드

	List<CountryDto> findCountryById(int bbsId);

    int selectId(int bbsId);

	List<HashTag> getHashtagList(int bbsId);
}