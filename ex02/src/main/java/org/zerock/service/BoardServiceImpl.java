package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class BoardServiceImpl implements BoardService {
	//@Autowired
	private BoardMapper mapper;

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("register....."+board);
		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		log.info("get......"+bno);
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		log.info("modify......"+board);
		//SQL 성공시 update tag에서 update 된 갯수를 리턴, 따라서 mapper,update(board)의 값은 1이됨
		//return true 가 됨
		return mapper.update(board) == 1;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		log.info("remove....."+bno);
		return mapper.delete(bno) == 1;
	}

	@Override
	public List<BoardVO> getList() {
		// TODO Auto-generated method stub
		log.info("getList.......");
		return mapper.getList();
	}
	
	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("get List with criteria : " + cri);
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		// TODO Auto-generated method stub
		log.info("get total count.......");
		return mapper.getTotalCount(cri);
	}
	

}
