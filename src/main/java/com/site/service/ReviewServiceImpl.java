package com.site.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.site.mapper.ReviewMapper;
import com.site.vo.ReviewVo;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewMapper reviewMapper;
	
	@Override
	public void reviewWirteDo(ReviewVo reviewVo, MultipartFile file) {
		//파일저장위치
		String fileUrl = "D:/workspace3/shop/src/main/resources/static/upload/";
		
		// 파일이름 중복방지를 위한 파일명 변경
		long time = System.currentTimeMillis(); // 숫자형태로 시간을 표현해줘요. return타입이 long임
		String uploadFileName = time + "_" + file.getOriginalFilename(); // 파일이름 -> 시간_파일이름으로 나옴
		
		// 파일저장 - io를 import해서 자동으로 디렉토리 없으면 만들어서 저장시킴
		File f = new File(fileUrl + uploadFileName);
		System.out.println("DB저장 전 uploadFileName : " + uploadFileName);

		//파일전송 - 예외처리 필요, 에러나서 다운될까봐, 예외처리는 마음대로 불가능, 피치못할 사정으로 생긴 에러만 예외처리할것.
		 
		try {
			file.transferTo(f);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 파일이름을 VO에 저장
		reviewVo.setReview_image(uploadFileName);
 
		// DB저장
		reviewMapper.insertReviewWrite(reviewVo);

		System.out.println("DB저장 후 uploadFileName : " + reviewVo.getEmail());
	}

}
