package com.site.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
	
	
	
	private String email;
	private int user_no;
	private String password;
	private String name;
	private String phone_no;
	private String birth;
	private int admin_code;
	private String address1;
	private String address2;
	private String zipcode;

}
