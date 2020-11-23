package kr.ync.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ync.domain.BoardVO;
import kr.ync.domain.QuizMemberVO;
import kr.ync.service.QuizMemberService;
import kr.ync.util.UploadUtils;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/front/*")
public class MemberController {
	@Autowired
	QuizMemberService service;
	
	@GetMapping("/index")
	public String index() {
		return "front/index";
	}
	
	@GetMapping("/login")
	public void login() {

	}
	
	@GetMapping("/membermake")
	public void membermake() {

	}
	
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {

		log.info("access Denied : " + auth);

		model.addAttribute("msg", "Access Denied");
	}
	
	@PostMapping("/membermake")
	public String register(QuizMemberVO member, RedirectAttributes rttr) {
		
		log.info("login: " + member);

		service.member_insert(member);
		//rttr.addFlashAttribute("result", member.getId());
		return "redirect:/front/login";
	}
	
	@PostMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {

		log.info("error: " + error);
		log.info("logout: " + logout);

		if (error != null) {
			model.addAttribute("error", "Login Error Check Your Account");
		}

		if (logout != null) {
			model.addAttribute("logout", "Logout!!");
		}
		
		
	}
	
	@GetMapping("/customLogout")
	public void logoutGET() {

		log.info("custom logout");
	}

	@PostMapping("/customLogout")
	public void logoutPost() {

		log.info("post custom logout");
	}

}
