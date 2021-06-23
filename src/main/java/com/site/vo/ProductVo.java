package com.site.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVo {
	private int product_no;					// 상품번호
	private String st_no;					// 스타일번호
	private String product_name;			// 상품명
	private Timestamp product_date;			// 상품등록일
	private String product_main_image;		// 상품메인이미지
	private String product_image1;			// 상품이미지1
	private String product_image2;			// 상품이미지2
	private String product_image3;			// 상품이미지3
	private String product_image4;			// 상품이미지4
	private String product_image5;			// 상품이미지5
	private int product_price;				// 상품가격
	private String product_description;		// 상품설명
	
	private int product_total_stock;
	private int product_size_230;
	private int product_size_240;
	private int product_size_250;
	private int product_size_260;
	private int product_size_270;
	private int product_size_280;
	private int product_size_290;
	private int product_size_300;

}
