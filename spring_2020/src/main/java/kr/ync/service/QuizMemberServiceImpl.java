package kr.ync.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.QuizMemberVO;
import kr.ync.domain.QuizVO;
import kr.ync.domain.RankVO;
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
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	    String pwd = encoder.encode(member.getPwd());
	    member.setPwd(pwd);
		log.info("register......" + member);
		mapper.insert(member);
	}

	@Override
	public List<QuizMemberVO> getList() {
		log.info("getList..........");
		
		 return mapper.getList();
	}

	@Override
	public List<RankVO> getRank() {
		// TODO Auto-generated method stub
		return mapper.getRank();
	}

	@Override
	public List<RankVO> getListWithPaging(CriteriaAdmin cri) {
		// TODO Auto-generated method stub
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(CriteriaAdmin cri) {
		// TODO Auto-generated method stub
		return mapper.getTotalCount(cri);
	}

	@Override
	public QuizMemberVO get(String id) {
		// TODO Auto-generated method stub
		return mapper.read(id);
	}

	@Override
	public QuizMemberVO view(QuizMemberVO member) {
		// TODO Auto-generated method stub
		return mapper.view(member);
		
	}

	@Override
	public boolean modify(QuizMemberVO member) {
		// TODO Auto-generated method stub
		return mapper.update(member) == 1;
	}

	

}
