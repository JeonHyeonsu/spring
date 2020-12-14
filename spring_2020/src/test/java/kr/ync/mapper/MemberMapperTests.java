package kr.ync.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.ync.domain.MemberVO;
import kr.ync.domain.QuizMemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
"file:src/main/webapp/WEB-INF/spring/security-context.xml" })
@Log4j
public class MemberMapperTests {

	@Setter(onMethod_ = @Autowired)
	private QuizUserMemberMapper q_mapper;
	//private MemberMapper mapper;
	
	
	@Test
	public void testRead() {

		QuizMemberVO vo = q_mapper.read("admin70");

		log.info(vo);
		
		//vo.getAuth().forEach(authVO -> log.info(authVO));

	}

}
