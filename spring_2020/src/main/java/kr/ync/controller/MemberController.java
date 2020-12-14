package kr.ync.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.ync.domain.CriteriaAdmin;
import kr.ync.domain.PageAdminDTO;
import kr.ync.domain.QuizMemberVO;
import kr.ync.service.QuizMemberService;
import kr.ync.util.UploadUtils;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/front/*")
public class MemberController {
	
	@Value("${globalConfig.uploadPath}")
	private String uploadPath;
	
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
	
	@PostMapping("/login")
	public void loginInput(String error, String logout, Model model) {

		log.info("error: " + error);
		log.info("logout: " + logout);

		if (error != null) {
			model.addAttribute("error", "에러에러에러에러");
		}

		if (logout != null) {
			model.addAttribute("logout", "로그아웃로그아웃!!");
		}
		
		
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
	
	@GetMapping({ "/userprofile", "/usermodify" })
	public void get(@RequestParam("id") String id, Model model) {

		log.info("/get or modify");
		model.addAttribute("user", service.get(id));
	}
	
	@PostMapping("/usermodify")
	public String modify(MultipartFile[] uploadFile, QuizMemberVO member,  RedirectAttributes rttr) {
		log.info("modify:" + member);
		
		for (MultipartFile multipartFile : uploadFile) {
			// 실제로 upload된 file이 있을때만 upload 시킨다.
			if (multipartFile.getSize() > 0) {

				member.setProfile_img(UploadUtils.uploadFormPost(multipartFile, uploadPath));

			}
		}

		if (service.modify(member)) {
			rttr.addFlashAttribute("result", "success");
		}

		return "redirect:/front/index";
	}
	@RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        ModelAndView mv = new ModelAndView("redirect:/");
        return mv;
    }
	

}
