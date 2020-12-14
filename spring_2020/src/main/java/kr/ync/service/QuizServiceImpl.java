package kr.ync.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ync.domain.Criteria;
import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.QuizVO;
import kr.ync.mapper.BoardMapper;
import kr.ync.mapper.QuizMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class QuizServiceImpl implements QuizService {
	@Autowired
	private QuizMapper mapper;

	@Override
	public List<QuizVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<QuizVO> getList_jp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuizVO> getList_ns() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuizVO> getList_cm() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<QuizVO> getListWithPagingjp(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPagingjp(cri);
	}
	
	@Override
	public List<QuizVO> getListWithPagingcm(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPagingcm(cri);
	}

	@Override
	public List<QuizVO> getListWithPagingns(Criteria cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPagingns(cri);
	}

	@Override
	public QuizVO get(int quiz_idx) {
		// TODO Auto-generated method stub
		return mapper.read(quiz_idx);
	}

	@Override
	public int getTotal(CriteriaAdmin cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

	@Override
	public List<QuizVO> getListWithPaging(CriteriaAdmin cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri);
	}

	@Override
	public void register(QuizVO quiz) {
		// TODO Auto-generated method stub
		log.info("register......" + quiz);

		mapper.insertSelectKey(quiz);
	}

	@Override
	public boolean modify(QuizVO quiz) {
		// TODO Auto-generated method stub
		return mapper.update(quiz) == 1;
	}

	@Override
	public boolean remove(int quiz_idx) {
		// TODO Auto-generated method stub
		return mapper.delete(quiz_idx) == 1;
	}

	@Override
	public void userRegister(QuizVO quiz) {
		// TODO Auto-generated method stub
		mapper.insertSelectKey(quiz);
	}

	@Override
	public List<QuizVO> getuserList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QuizVO> getuserListWithPaging(CriteriaAdmin cri) {
		// TODO Auto-generated method stub
		return mapper.getuserListWithPaging(cri);
	}


}
