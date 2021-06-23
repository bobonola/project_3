package com.site.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.site.vo.NoticeVo;


@Service
public interface NoticeService {



	Map<String, Object> noticeList(int page);

	Map<String, Object> noticeListSearch(int page, String category, String search);

	Map<String, Object> noticeView(int notice_no);

	void noticeWriteDo(NoticeVo noticeVo, MultipartFile file);

	void noticeDelete(int notice_no);

	NoticeVo noticeModify(int notice_no);

	void noticeModifyDo(NoticeVo noticeVo, MultipartFile file);
	

}
