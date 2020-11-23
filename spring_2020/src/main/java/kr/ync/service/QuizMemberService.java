package kr.ync.service;

import java.util.List;

import kr.ync.domain.BoardVO;
import kr.ync.domain.QuizMemberVO;

public interface QuizMemberService {
	
	public void member_insert(QuizMemberVO member);
	
	public List<QuizMemberVO> getList();


}
