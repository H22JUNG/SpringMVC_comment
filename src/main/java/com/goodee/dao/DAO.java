package com.goodee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.goodee.vo.BbsVO;
import com.goodee.vo.UserCommentVO;
import com.goodee.vo.UserVO;

@Mapper
public interface DAO {
	
	public int count(UserVO vo);
	public List<UserVO> getList();
	public BbsVO getContent(BbsVO vo);
	public UserVO getInfo(UserVO vo);
	
	public List<UserCommentVO> comment(UserCommentVO comment);

}
