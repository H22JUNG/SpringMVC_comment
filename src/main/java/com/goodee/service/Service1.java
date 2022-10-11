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
	
	public BbsVO getContent1(Model model, BbsVO vo) {
		model.addAttribute("vo", dao.getContent(vo));
		return dao.getContent(vo);
	}
	
	//댓글 가져오기
	public List<UserCommentVO> getComment(Model model, BbsVO vo) {
		model.addAttribute("comment", dao.comment(vo));
		return dao.comment(vo);
	}
	
	//대댓글 가져오기
	public List<UserCommentVO> getRecomm(Model model) {
		model.addAttribute("recomment", dao.recomm());
		//게시글의 id 받아와서 commentvo의 bbs_id와 매칭
		//order_id는 1번에 div에 대댓글 달린거면 id가 1
		return dao.recomm();

	}
	
	public UserCommentVO putcomm(int id, UserVO uservo, UserCommentVO commvo) {
		commvo.setBbsId(id);
		commvo.setOwner(uservo.getUsername());
		commvo.setOwnerId(uservo.getId());
		dao.putcomm(commvo);
		return commvo;
	}
	
	public int delcomm(int id) {
		return dao.delcomm(id);
	}

	
	
	
}
