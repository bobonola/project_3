package com.site.controller;

import java.util.HashMap;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.site.service.UserService;
import com.site.vo.NoticeVo;
import com.site.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/main")
	public String main() {
		return "/main";
	}
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "/login";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "/user/joinForm";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/main";
	}
	
	
	@RequestMapping(value="/login_ajax")
	@ResponseBody
	public Map<String,Object> login_ajax(UserVo userVo,
								HttpServletRequest request,
								Model model) {
		
		Map<String,Object> map=new HashMap<String, Object>();
		UserVo uVo = userService.login(userVo); //전체리스트 가져오기
		map.put("uVo",uVo);
		if(uVo==null) {
			map.put("flag", "fail");
			map.put("msg", "이메일과 패스워드가 일치하지 않습니다.");
		}else {
			map.put("flag", "success");
			map.put("msg", "로그인 성공!");
			HttpSession session = request.getSession();
			session.setAttribute("session_flag","success");
			session.setAttribute("session_email", uVo.getEmail());
			session.setAttribute("session_admin_code", uVo.getAdmin_code());
			session.setAttribute("name", uVo.getName());
		}
		return map;
	}
	
	@RequestMapping("/joinDo")
	public String joinDo(UserVo userVo) {
		userService.insertUser(userVo);
		return "/login";
	}
	
	//이메일 중복체크
	
	@RequestMapping(value="/emailChk", method = RequestMethod.POST)
	@ResponseBody
	public String emailChkPOST(String email) throws Exception{
		int result = userService.emailCheck(email);
		if(result !=0) {
			return "fail";
		}else {
			return "success";
		}
	}
	
	//회원정보수정 페이지호출
	
	@RequestMapping("/userModify")
	public String modify(@RequestParam("email") String email,Model model) {
		UserVo userVo = userService.userModify(email);
		model.addAttribute(userVo);
		return "/user/userModify";
	}
	
	@RequestMapping("/userModifyDo")
	public String modifyDo(UserVo userVo) {
		userService.modifyUser(userVo);
		return "redirect:/main";
	}

	
	

}
