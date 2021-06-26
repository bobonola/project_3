package com.site.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.site.service.ReviewService;
import com.site.vo.ProductVo;
import com.site.vo.ReviewVo;

@Controller
@RequestMapping("/review")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;
	
	//리뷰 글쓰기 페이지 호출
	@RequestMapping("/reviewWrite") 
	public String reviewWrite(@RequestParam(value="product_no") int product_no, Model m) {
			
		m.addAttribute("product_no", product_no); 
			
	return "/reviewWrite"; 
	}
	
	//리뷰 글쓰기 저장
		@RequestMapping("/rewriteInsert") 
		public String rewriteInsert(ReviewVo reviewVo, ProductVo productVo, @RequestPart MultipartFile file) {
			
			//작성자-session,제목,내용
			System.out.println("test : "+reviewVo.getEmail());
			
			//데이터,파일첨부에서 넘어온 파일명을 매개변수로 보냄
			reviewService.rewriteInsert(reviewVo, file);
			System.out.println("review : "+reviewVo.getReview_no() );
			
			//파일위치
			String fileUrl = "C:/Users/user/eclipse-workspace/shop1/src/main/resources/static/upload/";
				
			//파일이름 중복방지
			long time = System.currentTimeMillis(); // 숫자형태로 시간을 표현해줘요. return타입이 long임
			String uploadFileName =  time + "_" +file.getOriginalFilename(); //파일이름 -> 시간_파일이름으로 나옴
				
			//파일저장 - io를 import해서 자동으로 디렉토리 없으면 만들어서 저장시킴
			File f = new File(fileUrl+uploadFileName);
			
			//파일전송 - 예외처리 필요, 에러나서 다운될까봐, 예외처리는 마음대로 불가능, 피치못할 사정으로 생긴 에러만 예외처리할것.
			try {
				file.transferTo(f);
			}catch(Exception e) {
				e.printStackTrace();
			}
				
			//파일이름 삽입
			reviewVo.setReview_image(uploadFileName);
				
				
			// 1.파일첨부 내용 넘어오는거 체크
			System.out.println("파일업로드 유저아이디 : "      + reviewVo.getEmail());
			System.out.println("파일업로드 제목 : "          + reviewVo.getReview_title());
			System.out.println("파일업로드 내용 : "   	    + reviewVo.getReview_content());
			System.out.println("파일업로드 변경 전 파일이름 : " + file.getOriginalFilename());
			System.out.println("파일업로드 변경 후 파일이름 : " + uploadFileName);
			
			
			return "redirect:/view?product_no="+ productVo.getProduct_no();
		}
	
		@RequestMapping("/reviewModify")	// review 수정페이지 호출
		public String reviewModify(@RequestParam("review_no")int review_no, Model model) {
			ReviewVo reviewVo = reviewService.reviewModify(review_no);
			model.addAttribute(reviewVo);
			return "reviewModify";
		}
		
		@RequestMapping("/reviewModifyDo")	// review 수정 저장
		public String reviewModifyDo(ReviewVo reviewVo) {
			reviewService.reviewModifyDo(reviewVo);
			return "redirect:/view?product_no="+reviewVo.getProduct_no();
		}
		
		@RequestMapping("/reviewDelete")	// review 삭제
		public String reviewDelete(@RequestParam("review_no") int review_no, ReviewVo reviewVo) {
			reviewService.reviewDelete(review_no);
			System.out.println("삭제 : "+review_no);
			return "redirect:/view?product_no="+reviewVo.getProduct_no();
		}
}
