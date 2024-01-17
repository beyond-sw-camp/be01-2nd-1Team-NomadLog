package com.encore.bbs.board.service;

import java.util.List;

import com.encore.bbs.board.dto.CountryDto;
import com.encore.bbs.board.dto.HashTag;

import com.encore.bbs.board.dto.BbsDTO;


public interface BbsService {

	List<BbsDTO> selectBbsList() throws Exception ;

	public void insertBbs(BbsDTO bbs, String content) throws Exception;

	BbsDTO selectBbsDetail(int bbsId) throws Exception;

	void updateBbs(BbsDTO bbs) throws Exception;

	void deleteBbs(int bbsId) throws Exception;

    BbsDTO updatedeleteBbs(int bbsId) throws Exception;

	void insertHashtag(HashTag hashTag)throws Exception;

	Long getLatestBbsId();

	List<CountryDto> getCountryList();

	List<HashTag> getHashtagList(int bbsId);

	Long selectCountryBbs(Long countryId);

	List<CountryDto> findCountryById(int bbsId);

	//void insertCountry(BbsDTO bbs) throws Exception;

    int selectId(int bbsId);
}