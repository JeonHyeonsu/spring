package kr.ync.mapper;

import java.util.List;

import kr.ync.domain.BoardVO;
import kr.ync.domain.MemberVO;
import kr.ync.domain.QuizMemberVO;
import kr.ync.domain.QuizVO;
import kr.ync.domain.TypeVO;

public interface QuizMemberMapper {
	
	public void insert(QuizMemberVO member);
	public QuizMemberVO read(String id);
	public List<QuizMemberVO> getList();
	
}
