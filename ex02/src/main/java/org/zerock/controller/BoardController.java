package org.zerock.controller;

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

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
   
   
   //@Autowired
   private BoardService service;
   
   
   //게시물 전체 목록
   //Model 객체 생성 
//   @GetMapping("/list")
//   public void list(Model model) {
//      log.info("list");
//      model.addAttribute("list", service.getList());
//   }
   
   @PostMapping("/register")
   public String register(BoardVO board, RedirectAttributes rttr) {
      
      log.info("register : " + board);
      service.register(board);
      rttr.addFlashAttribute("result", board.getBno());
      return "redirect:/board/list";
      
   }
   
//      //글 읽기
//      @GetMapping("/get")
//      public void get(@RequestParam("bno") Long bno, Model model) {
//         log.info("/get");
//         model.addAttribute("board", service.get(bno));
//      }
      
      @GetMapping({"/get", "/modify"})
      public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri ,Model model) {
         log.info("/get or modify");
         model.addAttribute("board", service.get(bno));
      }
   
   
      //글 수정
      @PostMapping("/modify")
      public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri ,RedirectAttributes rttr) {
         log.info("modify: " + board);
         
         if(service.modify(board))  {
            rttr.addFlashAttribute("result", "success");
         }
         
         rttr.addAttribute("pageNum", cri.getPageNum());
         rttr.addAttribute("amount", cri.getAmount());
         
         
         return "redirect:/board/list";
      }
      
      //글 삭제
      @PostMapping("/remove")
      public String remove(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri , RedirectAttributes rttr) {
         log.info("remove....." + bno);
         if(service.remove(bno))  {
            rttr.addFlashAttribute("result", "success");
         }
         rttr.addAttribute("pageNum", cri.getPageNum());
         rttr.addAttribute("amount", cri.getAmount());
         
         return "redirect:/board/list";
      }

      @GetMapping("/register")
      public void register() {
         
      }
      
      
      @GetMapping("/list")
      public void list(Criteria cri, Model model) {
         log.info("list : " + cri);
         model.addAttribute("list", service.getListWithPaging(cri));
         //model.addAttribute("pageMaker", new PageDTO(cri, 123));
         int total = service.getTotal(cri);
         
         log.info("total : " + total);
         model.addAttribute("pageMaker" , new PageDTO(cri, total));
      }
      
   
   
}