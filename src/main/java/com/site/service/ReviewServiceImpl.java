package com.site.service;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void rewriteInsert(ReviewVo reviewVo, MultipartFile file) {
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
	
	//리뷰 리스트
		@Override
		public Map<String, Object> reviewList(int page, int product_no) {
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			int limit = 10;
			
			int startRow = (page - 1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			List<ReviewVo> list = reviewMapper.selectReviewList(startRow, endRow,product_no);
			int listCount = 0;	// 총 게시글 수
			listCount = reviewMapper.selectReviewCount();
			
			//하단 최대 넘버링페이지 
			int maxPage = (int)((double)listCount / limit + 0.99); 
			//하단 시작 넘버링페이지
			int startPage = (((int) ((double)page / 10 + 0.99)) - 1) * 10 + 1;
			//하단 끝 넘버링페이지
			int endPage = maxPage;
			// 1,2,3,4,5,6,7,8,9,10 -> 10개가 모두 있을 경우는 10을 endPage에 넣어줌.
			if (endPage > startPage + 10 - 1) {
				endPage = startPage + 10 - 1;
			}
			
			System.out.println(list);
			
			map.put("list", list);
			map.put("page", page);
			map.put("listCount", listCount);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("maxPage", maxPage);
			
			return map;
		}

		//리뷰 수정페이지 호출
		@Override
		public ReviewVo reviewModify(int review_no) {
			ReviewVo reviewVo = reviewMapper.selectReviewModify(review_no);
			return reviewVo;
		}

		//리뷰 수정 저장
		@Override
		public void reviewModifyDo(ReviewVo reviewVo) {
			reviewMapper.updateReviewModifyDo(reviewVo);
			
		}
		
		//리뷰 삭제
		@Override
		public void reviewDelete(int review_no) {
			reviewMapper.deleteReviewDelete(review_no);
			
		}

}
