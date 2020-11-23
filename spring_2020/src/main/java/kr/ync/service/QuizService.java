package kr.ync.service;

import java.util.List;

import kr.ync.domain.BoardVO;
import kr.ync.domain.Criteria;
import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.QuizVO;

public interface QuizService {
	public List<QuizVO> getList();

	public List<QuizVO> getListWithPaging(Criteria cri);
	
	public List<QuizVO> getListWithPaging(CriteriaAdmin cri);
	
	public int getTotal(Criteria cri);
	
	public int getTotal(CriteriaAdmin cri);
	
	public QuizVO get(int quiz_idx);

}
