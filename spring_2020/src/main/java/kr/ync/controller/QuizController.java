package kr.ync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ync.domain.Criteria;
import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.PageAdminDTO;
import kr.ync.domain.PageDTO;
import kr.ync.service.BoardService;
import kr.ync.service.QuizService;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/front/*")
public class QuizController {
	
	@Autowired
	private QuizService service;
	
	
	@GetMapping("/quiz_jp")
	public void list(Criteria cri, Model model) {
		log.info("list: " + cri);
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("quiz", service.getListWithPaging(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}
	
	@GetMapping("/list2")
	public void list2(CriteriaAdmin cri, Model model) {
		log.info("list: " + cri);
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("quiz", service.getListWithPaging(cri));
		model.addAttribute("pageMaker", new PageAdminDTO(cri, total));

	}
	
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("quiz_idx") int quiz_idx, @ModelAttribute("cri") CriteriaAdmin cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("quiz", service.get(quiz_idx));
	}
	
	@GetMapping("/rank")
	public void rank(CriteriaAdmin cri, Model model) {
		log.info("list: " + cri);
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("rank", service.getListWithPaging(cri));
		model.addAttribute("pageMaker", new PageAdminDTO(cri, total));

	}

}
