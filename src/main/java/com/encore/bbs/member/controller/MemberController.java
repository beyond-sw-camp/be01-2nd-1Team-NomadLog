package com.encore.bbs.member.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.encore.bbs.board.dto.BbsDTO;
import com.encore.bbs.member.dto.MemberDTO;
import com.encore.bbs.member.service.MemberService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor // DI(의존성 주입)의 방법 중에 생성자 주입을 임의의 코드없이 자동으로 설정해주는 어노테이션. final 혹은 @NotNull이 붙은 필드의 생성자를 자동으로 만들어준다.
public class MemberController {

	private final MemberService memberService; // 왜 이렇게 쓰지? 이해 필요. 어쨌든 의존성 주입하여 MemberService에 값을 넣어주기 위해 사용한다.
	// @RequiredArgsConstructor에 의해 memberService의 생성자 함수가 만들어지고 거기에 값이 입력되면 Service 클래스로 의존성 주입한다.
	// 일단 @RequiredArgsConstructor은 final이 붙은 필드에만 생성자를 만들기 때문에 final을 붙인다
	// 의존성 주입의 3가지 방법
	// 1. 생성자 주입(Constructor Injection)
	// 2. 필드 주입(Field Injection)
	// 3. 수정자 주입(Setter Injection)
	// @RequiredArgsConstructor 어노테이션과 같이 쓴다.

	@GetMapping("/save")
	public String saveForm() {
		return "/member/save";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute MemberDTO memberDTO) { 
		// 클래스를 객체로 받기 위해 @modelAttribute를 썼다. 하나의 값을 받으려면 @RequestParam 쓰면 됨.
		// save.html에서 받은 값이 @ModelAttribute로 memberDTO에 전부 담긴다. 마치 setter 메서드
		// 결국 DTO에 담긴 값의 최종 목적지는 DB다. 이는 컨트롤러에서 서비스 클래스로 보내야 한다.
		int saveResult = memberService.save(memberDTO);
		if(saveResult > 0) {
			return "/member/login";
		} else {
			return "/member/save"; // 저장이 잘 돼서 리턴으로 받은 값이 0이기 때문에 else 구문 실행 후 /save url로 이동
		}
		// 결과값이 Bad Request, status=400라고 나왔다면 
	}

	@GetMapping("/login")
	public String loginForm(HttpSession session) {
		if(session.getAttribute("loginId") != null) {
			return "redirect:/bbs";
		}else {
			return "member/login";
		}
	}

	@PostMapping("/login")
	public String login(@ModelAttribute MemberDTO memberDTO, // 값을 다 쓰지 않더라도 객체로 받는게 편하다.
										HttpSession session) { // HttpSession을 쓰는 이유는, 나의 로그인 계정(정보)이 계속 나를 따라다니도록 만들기 위함이다. 
		boolean loginResult = memberService.login(memberDTO);
		memberDTO.setMemberCode(memberService.code(memberDTO));
		if(loginResult) {
			session.setAttribute("loginId", memberDTO.getMemberCode());
			System.out.println(session.getAttribute("loginId"));
			// 로그인이 성공한 경우, 세션에 현재 로그인한 사용자의 아이디를 저장하는 코드
			// setAttribute 메서드는 세션에 속성(attribute)을 설정하는 메서드다. 
			// 세션 객체에는 여러 속성을 저장할 수 있으며, 각 속성은 고유한 이름(키)을 가지게되는데 이때 "loginId"는 세션에 저장될 속성의 이름(키)이다. 
			return "main";
		} else {
			return "/member/login";
		}
	}
	
	@GetMapping("/mypage")
	public String myPage(Model model, HttpSession session) { // Model model2
	    // 세션에서 로그인 아이디 가져오기
	    int loginId = (int) session.getAttribute("loginId");
	    System.out.println(loginId);
	    // 로그인한 아이디를 기반으로 데이터베이스에서 정보 가져오기
	    List<BbsDTO> loggedInBbsDTOList = memberService.findByIdBbs(loginId);
//	    MemberDTO loggedInMember = memberService.findById(loginId);
	    
//	    List<CommentDTO> loggedInCommentDTOList = memberService.findByIdComment(loginId);
	    
	    // 모델에 데이터 추가
	    model.addAttribute("loggedInMember", loggedInBbsDTOList); // 리스트 결과를 loggedInMemberDTOList에 담아서 mypage로 보낸다.
//	    model2.addAttribute("loggedInComment", loggedInCommentDTOList); // 리스트 결과를 loggedInMemberDTOList에 담아서 mypage로 보낸다.
	    
	    return "/member/mypage"; // 해당 정보를 출력할 페이지 이름으로 수정
	}
	
	@GetMapping("/update")
	public String updateForm(HttpSession session, Model model) {
		
		int loginId = (int)session.getAttribute("loginId"); // session.getAttribute으로 얻는 값은 Object 타입이므로 스트링으로 변환 필요
		MemberDTO memberDTO = memberService.findByIdInfo(loginId);
		model.addAttribute("info",memberDTO);
		return "/member/update";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute MemberDTO memberDTO) {
		boolean updateResult = memberService.update(memberDTO);
		if (updateResult) {
			return "main"; //"redirect:/memebr?memberId=" + memberDTO.getMemberId()
		} else {
			return "index";
		}
		
	}
	
	
	// 아이디 중복확인 메서드
	@PostMapping("/id-check") // ajax 응답을 처리할때는 @ResponseBody 또는 @ResponseEntity 등이 붙어야 ajax로 제대로된 응답이 나갈 수 있다.
	public @ResponseBody String idCheck(@RequestParam("memberId") String memberId) {
		// @RequestParam("memberId") 어노테이션을 사용하여 Ajax 요청에서 전달된 memberId 파라미터를 받아온다
		System.out.println("memberId : " + memberId);
		String checkResult = memberService.idCheck(memberId);
		return checkResult; // 결과 값은 res로 넘어간다. Ajax 요청이 성공하면 서버에서 반환한 값이 success 콜백 함수의 res 파라미터로 전달되기 때문.
		// 왜? @ResponseBody 썼으니까
		
		
	}
	
	
	
	// 만약 페이지마다 session을 끌고 오고 싶다면
	// String loginId = (String) session.getAttribute("loginId");를 정의하고
	// loginId 값이 있는지 또는 작성자의 loginId와 같은지 비교하는 코드를 짜면 된다.
	// loginId 값이 없으면 전부 로그인 페이지로 넘겨준다.
	
	//로그아웃
	@GetMapping("/logout") // HttpServletRequest : 클라이언트로부터 서버로 요청이 들어오면 서버에서는 HttpServletRequest를 생성하며, 요청정보에 있는 패스로 매핑된 서블릿에게 전달
	public String logoutMainGET(HttpSession session) throws Exception{
        
        session.invalidate();
        
        return "redirect:/";
    }
	
	@GetMapping("delete")
	public String deleteForm() {
		return "/member/deleteForm";
	}
	
	@GetMapping("del") // delete로도 해뵈기
	public String delete(HttpSession session) {
		int loginId = (int) session.getAttribute("loginId");
		memberService.delete(loginId);
		return "redirect:/";
	}

}









