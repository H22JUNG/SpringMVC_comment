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
		//모든 댓글 정보 가져오기
	//	UserCommentVO vo = new UserCommentVO();
	/*	for(int i=0; i<dao.allcomm().size(); i++) {
			list.setBbsId(dao.allcomm().get(i).getBbsId());
			list.setOrderId(dao.allcomm().get(i).getOrderId());
			
			//상세페이지 들어갔을 때 글번호, 댓글의 id 넣어주기
			vo.setBbsId(list.getBbsId());
			vo.setOrderId(list.getOrderId());
		}	*/
	//	model.addAttribute("recomment", dao.recomm(vo));
		model.addAttribute("recomment", dao.recomm());
		return dao.recomm();
	//	System.out.println(vo.getBbsId());
	//	System.out.println(vo.getOrderId());
		
		
		
	}

	
	
	
}
