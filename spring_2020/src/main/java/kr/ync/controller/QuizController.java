package kr.ync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ync.domain.BoardVO;
import kr.ync.domain.Criteria;
import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.PageAdminDTO;
import kr.ync.domain.PageDTO;
import kr.ync.domain.QuizVO;
import kr.ync.service.BoardService;
import kr.ync.service.QuizService;
import kr.ync.util.UploadUtils;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/front/*")
public class QuizController {
	
	@Autowired
	private QuizService service;
	
	@GetMapping("/register")
	@PreAuthorize("isAuthenticated()")
	public void register() {

	}
	
	@GetMapping("/userRegister")
	@PreAuthorize("isAuthenticated()")
	public void userRegister() {

	}
	
	@GetMapping("/quiz_jp")
	public void quiz_jp(Criteria cri, Model model) {
		log.info("list: " + cri);
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("quiz", service.getListWithPagingjp(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}
	@GetMapping("/quiz_ns")
	public void quiz_ns(Criteria cri, Model model) {
		log.info("list: " + cri);
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("quiz", service.getListWithPagingns(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}
	@GetMapping("/quiz_cm")
	public void quiz_cm(Criteria cri, Model model) {
		log.info("list: " + cri);
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("quiz", service.getListWithPagingcm(cri));
		model.addAttribute("pageMaker", new PageDTO(cri, total));

	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/list2")
	public void list2(CriteriaAdmin cri, Model model) {
		log.info("list: " + cri);
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("quiz", service.getListWithPaging(cri));
		model.addAttribute("pageMaker", new PageAdminDTO(cri, total));

	}
	
	@GetMapping("/userMadequiz")
	@PreAuthorize("isAuthenticated()")
	public void userMadequiz(CriteriaAdmin cri, Model model) {
		log.info("list: " + cri);
		
		// 게시판의 글은 지속적으로 등록, 삭제 되기에 매번 list를 호출 할때 total을 구해와야 한다. 
		int total = service.getTotal(cri);
		log.info("total: " + total);
		model.addAttribute("quiz", service.getuserListWithPaging(cri));
		model.addAttribute("pageMaker", new PageAdminDTO(cri, total));

	}
	
	@GetMapping({ "/get","/quizmodify","/quizCheck" })
	public void get(@RequestParam("quiz_idx") int quiz_idx, @ModelAttribute("cri") CriteriaAdmin cri, Model model) {

		log.info("/get or modify");
		model.addAttribute("quiz", service.get(quiz_idx));
	}
	
	@PostMapping("/quizmodify")
	public String modify(QuizVO quiz, @ModelAttribute("cri") CriteriaAdmin cri, RedirectAttributes rttr) {
		log.info("modify:" + quiz);

		if (service.modify(quiz)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/front/list2" + cri.getListLink();
	}
	
	@PostMapping("/register")
	public String register(QuizVO quiz, RedirectAttributes rttr) {
		
		log.info("register: " + quiz);

		service.register(quiz);

		rttr.addFlashAttribute("result", quiz.getQuiz_idx());

		return "redirect:/front/list2";
	}
	
	@PostMapping("/userRegister")
	public String userRegister(QuizVO quiz, RedirectAttributes rttr) {
		
		log.info("register: " + quiz);

		service.register(quiz);

		rttr.addFlashAttribute("result", quiz.getQuiz_idx());

		return "redirect:/front/index";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("quiz_idx") int quiz_idx, CriteriaAdmin cri, RedirectAttributes rttr) {

		log.info("remove..." + quiz_idx);
		if (service.remove(quiz_idx)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/front/list2" + cri.getListLink();
	}
	

}
