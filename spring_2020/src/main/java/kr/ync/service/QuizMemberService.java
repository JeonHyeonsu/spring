package kr.ync.service;

import java.util.List;

import kr.ync.domain.BoardVO;
import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.QuizMemberVO;
import kr.ync.domain.QuizVO;
import kr.ync.domain.RankVO;

public interface QuizMemberService {
	
	public void member_insert(QuizMemberVO member);
	
	public QuizMemberVO view(QuizMemberVO member);
	
	public List<QuizMemberVO> getList();
	
	public List<RankVO> getRank();
	
    public List<RankVO> getListWithPaging(CriteriaAdmin cri);
	
	public int getTotal(CriteriaAdmin cri);

	public QuizMemberVO get(String id);
	
	public boolean modify(QuizMemberVO member);


}
