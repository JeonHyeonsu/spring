package kr.ync.mapper;

import java.util.List;

import kr.ync.domain.BoardVO;
import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.MemberVO;
import kr.ync.domain.QuizMemberVO;
import kr.ync.domain.QuizVO;
import kr.ync.domain.RankVO;
import kr.ync.domain.TypeVO;

public interface QuizMemberMapper {
	
	public void insert(QuizMemberVO member);
	
	public QuizMemberVO read(String id);
	
	public List<QuizMemberVO> getList();
	
	public List<RankVO> getRank();
	
	public int getTotalCount(CriteriaAdmin cri);
	
	public List<RankVO> getListWithPaging(CriteriaAdmin cri);

	public QuizMemberVO view(QuizMemberVO member);

	public int update(QuizMemberVO member);

	
	
	
}
