package com.goodee.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.goodee.service.Service1;
import com.goodee.vo.BbsVO;
import com.goodee.vo.UserCommentVO;
import com.goodee.vo.UserVO;

@Controller
public class PageController {
	
	private Service1 service;

	public PageController(Service1 service) {
		super();
		this.service = service;
	}
	//세션에 들어있는 값 확인하기
	//UserVO list = (UserVO) session.getAttribute("session");
	//System.out.println(list.getId());
	
	//------1번--------------------------------------------------------
	@GetMapping("/Controller1")
	public String move1() {
		return "login/login1";
	}
	@PostMapping("/result1")
	public String login1_1(UserVO vo, Model model, HttpSession session) {
		if (service.login(vo)>0) {
			//리스트 가져오기
			service.getList(model);
			//getInfo에서 받아온 정보 넣어주기
			//vo.setId(service.getInfo(vo).getId());
			UserVO vo1 = service.getInfo(vo);
			//정보 세션에 저장
			session.setAttribute("session", vo1);
			return "result/result1";
		} 
		return "login/login1";
	}
	@GetMapping("/back1")//content1에서 뒤로가기 했을 때, 세션 다시 저장 안해도 됨
	public String login1_2(UserVO vo, Model model) {
		service.getList(model);
		return "result/result1";
	}
	@GetMapping("/content1")	//제목 누르면 제목, 내용 띄우기
	public String content1(@SessionAttribute("session") UserVO uservo,
							BbsVO vo, Model model) {
		service.getContent(model, vo);
		return "content/content1";
	}
	//------2번--------------------------------------------------------
	@GetMapping("/Controller2")
	public String move2() {
		return "login/login2";
	}
	@PostMapping("/result2")
	public String login2_1(UserVO vo, Model model, HttpSession session) {
		if (service.login(vo)>0) {
			//리스트 가져오기
			service.getList(model);
			//getInfo에서 받아온 정보 넣어주기
			//vo.setId(service.getInfo(vo).getId());
			UserVO vo1 = service.getInfo(vo);
			//정보 세션에 저장
			session.setAttribute("session", vo1);
			return "result/result2";
		} 
		return "login/login2";
	}
	@GetMapping("/back2")//content1에서 뒤로가기 했을 때, 세션 다시 저장 안해도 됨
	public String login2_2(UserVO vo, Model model) {
		service.getList(model);
		return "result/result2";
	}
	@GetMapping("/content2")	//제목 누르면 제목, 내용 띄우기
	public String content2(@SessionAttribute("session") UserVO uservo,
			BbsVO bbsvo, Model model) {
		bbsvo = service.getContent1(model, bbsvo);
		service.getComment(model, bbsvo);
		return "content/content2";
	}
	
	//------3번--------------------------------------------------------
		@GetMapping("/Controller3")
		public String move3() {
			return "login/login3";
		}
		@PostMapping("/result3")
		public String login3_1(UserVO vo, Model model, HttpSession session) {
			if (service.login(vo)>0) {
				//리스트 가져오기
				service.getList(model);
				//getInfo에서 받아온 정보 넣어주기
				//vo.setId(service.getInfo(vo).getId());
				UserVO vo1 = service.getInfo(vo);
				//정보 세션에 저장
				session.setAttribute("session", vo1);
				return "result/result3";
			} 
			return "login/login3";
		}
		@GetMapping("/back3")//content1에서 뒤로가기 했을 때, 세션 다시 저장 안해도 됨
		public String login3_2(UserVO vo, Model model) {
			service.getList(model);
			return "result/result3";
		}
		@GetMapping("/content3")	//제목 누르면 제목, 내용 띄우기
		public String content3(@SessionAttribute("session") UserVO uservo,
				BbsVO bbsvo,  UserCommentVO list, Model model) {
			bbsvo = service.getContent1(model, bbsvo);
			service.getComment(model, bbsvo);	//댓글 가져오기

			//대댓글 가져오기
			service.getRecomm(model);
			return "content/content3";
		}
		//게시글의 id 받아와서 commentvo의 bbs_id와 매칭
		//order_id는 1번에 div에 대댓글 달린거면 id가 1
		
		//bbsvo의 id를 유저커맨트vo의 bbs_id로 매핑하기



}
