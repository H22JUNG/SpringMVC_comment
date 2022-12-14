package com.goodee.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.goodee.vo.BbsVO;
import com.goodee.vo.UserCommentVO;
import com.goodee.vo.UserVO;

@Mapper
public interface DAO {
	
	public int count(UserVO vo);
	public List<UserVO> getList();
	public BbsVO getContent(BbsVO vo);
	public UserVO getInfo(UserVO vo);
	
	public List<UserCommentVO> comment(BbsVO vo);
	
	//리댓글 정보 다가져오기
	public List<UserCommentVO> recomm();
	
	public int putcomm(UserCommentVO vo);
	
	public int delcomm(@Param("id") int id);

}
