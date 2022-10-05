package com.goodee.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.goodee.dao.DAO;
import com.goodee.vo.BbsVO;
import com.goodee.vo.UserCommentVO;
import com.goodee.vo.UserVO;

@Service
public class Service1 {
	
	private DAO dao;
	public Service1(DAO dao) {
		super();
		this.dao = dao;
	}
	
	public int login(UserVO vo) {
		return dao.count(vo);
	}
	
	public List<UserVO> getList(Model model) {
		model.addAttribute("list", dao.getList());
		return dao.getList();
	}
	
	public UserVO getInfo(UserVO vo) {
		return dao.getInfo(vo);
	}
	
	public void getContent(Model model, BbsVO vo) {
		model.addAttribute("vo", dao.getContent(vo));
	}
	
	public List<UserCommentVO> getComment(Model model, UserCommentVO comment) {
		model.addAttribute("comment", dao.comment(comment));
		return dao.comment(comment);
	}
}
