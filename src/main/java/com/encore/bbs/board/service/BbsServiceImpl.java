package com.encore.bbs.board.service;

import java.util.List;

import com.encore.bbs.board.dto.CountryDto;
import com.encore.bbs.board.dto.HashTag;
import com.encore.bbs.chat.model.ChatRoom;
import com.encore.bbs.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.board.mapper.BbsMapper;

@Service
public class BbsServiceImpl implements BbsService {


	@Autowired
	private BbsMapper bbsmapper;

	@Autowired
	private ChatService chatService;

	@Override
	public List<BbsDTO> selectBbsList() throws Exception {
		return bbsmapper.selectBbsList();
	}

	@Override
	public void insertBbs(BbsDTO bbs, String content) throws Exception {
		bbsmapper.insertBbs(bbs);

		//		//게시글 저장 아이디 반환(getLatestBbsId 추가 service)
		long savedBbsId = bbsmapper.getLatestBbsId();


		HashTag hashTag = new HashTag(); // 해시태그 저장을 위한 객체 생성
		hashTag.setBbsId(savedBbsId); // 해당 객체에 저장아이디 반환
		hashTag.setContent(content); // 해당 객체에 작성한 내용 반환

		//해시태그 인서트
		bbsmapper.insertHashtag(hashTag);

		//Long savedcountryBbsId = bbsmapper.getLatestBbsId();


		//CountryDto countryDto = new CountryDto();
//		countryDto.setCountryId(savedcountryBbsId);
		//bbsmapper.selectCountryBbs(savedcountryBbsId);

		chatService.createRoom(savedBbsId);

	}

	@Override
	public BbsDTO selectBbsDetail(int bbsId) throws Exception {
		BbsDTO bbs = bbsmapper.selectBbsDetail(bbsId);
		bbsmapper.updateViewCount(bbsId);
		return bbs;
	}

	@Override
	public void updateBbs(BbsDTO bbs) throws Exception {
		bbsmapper.updateBbs(bbs);
	}

	@Override
	public BbsDTO updatedeleteBbs(int bbsId) throws Exception {
		BbsDTO bbs = bbsmapper.updatedeleteBbs(bbsId);
		return bbs;
	}


	@Override
	public void deleteBbs(int bbsId) throws Exception {
		bbsmapper.deleteBbs(bbsId);

	}

	@Override
	public void insertHashtag(HashTag hashTag) throws Exception {
		bbsmapper.insertHashtag(hashTag);
	}

	@Override
	public Long getLatestBbsId() {
		return bbsmapper.getLatestBbsId();
	}

	@Override
	public List<CountryDto> getCountryList() {
		return bbsmapper.getCountryList();
	}

	@Override
	public List<HashTag> getHashtagList(int bbsId) {
		return bbsmapper.getHashtagList(bbsId);
	}

	@Override
	public Long selectCountryBbs(Long countryId) {
		return bbsmapper.selectCountryBbs(countryId);
	}

	@Override
	public List<CountryDto> findCountryById(int bbsId) {
		return bbsmapper.findCountryById(bbsId);
	}

    @Override
    public int selectId(int bbsId) {
        return bbsmapper.selectId(bbsId);
    }
}