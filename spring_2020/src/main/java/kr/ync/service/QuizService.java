package kr.ync.service;

import java.util.List;

import kr.ync.domain.BoardVO;
import kr.ync.domain.Criteria;
import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.QuizVO;

public interface QuizService {
	public List<QuizVO> getList();
	
	public List<QuizVO> getList_jp();
	
	public List<QuizVO> getList_ns();
	
	public List<QuizVO> getList_cm();
	
	public List<QuizVO> getuserList();

	public List<QuizVO> getListWithPagingjp(Criteria cri);
	
	public List<QuizVO> getListWithPagingcm(Criteria cri);
	
	public List<QuizVO> getListWithPagingns(Criteria cri);
	
	public List<QuizVO> getListWithPaging(CriteriaAdmin cri);
	
	public List<QuizVO> getuserListWithPaging(CriteriaAdmin cri);
	
	public int getTotal(CriteriaAdmin cri);
	
	public int getTotal(Criteria cri);
	
	public QuizVO get(int quiz_idx);
	
	public void register(QuizVO quiz);
	
	public void userRegister(QuizVO quiz);
	
	public boolean modify(QuizVO quiz);
	
	public boolean remove(int quiz_idx);

}
