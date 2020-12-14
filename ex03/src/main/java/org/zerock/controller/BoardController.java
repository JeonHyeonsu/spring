package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
//@AllArgsConstructor
public class BoardController {

	@Autowired
	private BoardService service;

	@GetMapping("/register")
	public void register() {

	}
	
	// Model 객체 생성
//	@GetMapping("/list")
//	public void list(Model model) {
//	
//		log.info("list");
//		// Model 객체에 service.getList()에서 return 받은 값을 "list"라는 변수에 담아서 model 객체에 넣는다.
//		// model는 Spring에서 알아서 view쪽에 던져준다. 
//		model.addAttribute("list", service.getList());
//	}

//	 @GetMapping("/list")
//	 public void list(Criteria cri, Model model) {
//	
//	 log.info("list: " + cri);
//	 model.addAttribute("list", service.getListWithPaging(cri));
//	
//	 }

	@GetMapping("/list")
	public void list(Criteria cri, Model model) {

		log.info("list: " + cri);
//		model.addAttribute("pageMaker", new PageDTO(cri, 123));
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("list", service.getListWithPaging(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}

	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {

		log.info("register: " + board);

		service.register(board);

		rttr.addFlashAttribute("result", board.getBno());

		return "redirect:/board/list";
	}

//	 @GetMapping({ "/get", "/modify" })
//	 public void get(@RequestParam("bno") Long bno, Model model) {
//	
//		 log.info("/get or modify ");
//		 model.addAttribute("board", service.get(bno));
//	 }

	// @ModelAttribute 는 model.addAttribute("cri", cri) 해주는거와 동일하다.
	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("board", service.get(bno));
	}

//	 @PostMapping("/modify")
//	 public String modify(BoardVO board, RedirectAttributes rttr) {
//		 log.info("modify:" + board);
//		 
//		 // 정상적으로 update된 행이 있다면 service.modify(board)값은 true 다.
//		 // 없다는 false라 result 변수는 null값이 될것임.
//		 if (service.modify(board)) {
//			 rttr.addFlashAttribute("result", "success");
//		 }
//		 return "redirect:/board/list";
//	 }

	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify:" + board);

		if (service.modify(board)) {
			rttr.addFlashAttribute("result", "success");
		}

//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list" + cri.getListLink();
	}

//	 @PostMapping("/remove")
//	 public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr) {
//	
//		 log.info("remove..." + bno);
//		 if (service.remove(bno)) {
//			 rttr.addFlashAttribute("result", "success");
//		 }
//		 return "redirect:/board/list";
//	 }

	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, Criteria cri, RedirectAttributes rttr) {

		log.info("remove..." + bno);
		if (service.remove(bno)) {
			rttr.addFlashAttribute("result", "success");
		}
		
//		rttr.addAttribute("pageNum", cri.getPageNum());
//		rttr.addAttribute("amount", cri.getAmount());
//		rttr.addAttribute("type", cri.getType());
//		rttr.addAttribute("keyword", cri.getKeyword());

		return "redirect:/board/list" + cri.getListLink();
	}

}
