package kr.ync.mapper;

import java.util.List;

import kr.ync.domain.AuthVO;
import kr.ync.domain.BoardVO;
import kr.ync.domain.Criteria;
import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.QuizMemberVO;
import kr.ync.domain.QuizVO;
import kr.ync.domain.TypeVO;

public interface QuizMapper {
	
	public List<QuizVO> getList();
	
	public void quiz_insert(QuizVO quiz);

	public void type_insert(TypeVO type);
	
	public int quiz_jp(QuizVO quizjp);
	
	public Integer insertSelectKey(QuizVO quiz);
	
	public QuizVO read(int quiz_idx);
	
	public int delete(int quiz_idx);

	public int update(QuizVO board);
	
	public int getTotalCount(Criteria cri);
	
	public int getTotalCount(CriteriaAdmin cri);
	
	public List<QuizVO> getListWithPaging(Criteria cri);
	
	public List<QuizVO> getListWithPaging(CriteriaAdmin cri);
	
	
}
