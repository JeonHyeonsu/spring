package kr.ync.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ync.domain.QuizMemberVO;
import kr.ync.mapper.QuizMemberMapper;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class QuizMemberServiceImpl implements QuizMemberService {
	
	@Autowired
	private QuizMemberMapper mapper;

	@Override
	public void member_insert(QuizMemberVO member) {
		// TODO Auto-generated method stub
		log.info("register......" + member);
		mapper.insert(member);
	}

	@Override
	public List<QuizMemberVO> getList() {
		log.info("getList..........");
		
		 return mapper.getList();
	}

	

}
