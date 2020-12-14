package kr.ync.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.ync.domain.BoardVO;
import kr.ync.domain.Criteria;
import kr.ync.domain.QuizMemberVO;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class QuizMemberMapperTests {

//	@Setter(onMethod_ = @Autowired)
//	private QuizMapper mapper;
	
	
	//@Setter(onMethod_ = @Autowired)
	@Autowired
	private QuizMemberMapper mapper;
	

//	@Test
//	public void testGetList() {
//
//		mapper.getList().forEach(quiz -> log.info("board 객체 내용 : " + quiz));
//
//	}

//	@Test
//	public void testinsert() {
//
//		QuizVO quiz = new QuizVO();
//		quiz.setQuiz_idx(1L);
//		quiz.setQuestion("새로 작성하는 문제");
//		quiz.setAnswer("새로 작성하는 정답");
//		quiz.setExample1("새로 작성하는 보기1");
//		quiz.setExample2("새로 작성하는 보기2");
//		quiz.setExample3("새로 작성하는 보기3");
//		quiz.setId("newbie");
//		quiz.setType_idx(1L);
//
//		mapper.insert(quiz);
//
//		log.info(quiz);
//	}
	
//	@Test
//	public void testTypeInsert() {
//		TypeVO type = new TypeVO();
//		
//		type.setType_idx(3L);
//		type.setType("cm");
//		
//		mapper.type_insert(type);
//		
//		
//	}
	
//	@Test
//	public void testinsert() {
//		QuizMemberVO member = new QuizMemberVO();
//		
//		member.setId("test53");
//		member.setPwd("q1w2e31");
//		member.setUsername("동완킹3");
//		member.setEmail("tlsehddhks@naver.com");
//		
//		mapper.insert(member);
//	      
//	}
	
	
//
//	@Test
//	public void testInsertSelectKey() {
//
//		BoardVO board = new BoardVO();
//		board.setTitle("새로 작성하는 글 select key");
//		board.setContent("새로 작성하는 내용 select key");
//		board.setWriter("newbie");
//
//		mapper.insertSelectKey(board);
//
//		log.info(board);
//	}
//
//	@Test
//	public void testRead() {
//
//		
//		// 존재하는 게시물 번호로 테스트
//		QuizMemberVO member = mapper.read("admin70");
//
//		log.info(member);
//		//member.getAuth().forEach(authVO -> log.info(authVO));
//	}
//
//	@Test
//	public void testDelete() {
//
//		log.info("DELETE COUNT: " + mapper.delete(3L));
//	}
//
	@Test
	public void testUpdate() {

		QuizMemberVO member = new QuizMemberVO();
		// 실행전 존재하는 번호인지 확인할 것
		member.setId("admin70");
		member.setUsername("앙잉옹");
		member.setProfile("프로필프로필");
		member.setProfile_img("");

		int count = mapper.update(member);
		log.info("UPDATE COUNT: " + count);

	}
//
//	@Test
//	public void testPaging() {
//
//		Criteria cri = new Criteria();
//		
//	    //10개씩 3페이지 
//	    cri.setPageNum(3);
//	    cri.setAmount(10);
//
//
//		List<BoardVO> list = mapper.getListWithPaging(cri);
//
//		list.forEach(board -> log.info(board));
//
//	}
	
//	@Test
//	public void testGetTotalCount() {
//		
//		Criteria cri = new Criteria();
//		
//		int totalCnt = mapper.getTotalCount(cri);
//
//		log.info("totalCnt = " + totalCnt);
//
//	}
	
//	  @Test
//	  public void testSearch() {
//
//	    Criteria cri = new Criteria();
//	    cri.setKeyword("키워드");
//	    cri.setType("TCW");
//
//	    List<BoardVO> list = mapper.getListWithPaging(cri);
//
//	    list.forEach(board -> log.info(board));
//	  }


}
