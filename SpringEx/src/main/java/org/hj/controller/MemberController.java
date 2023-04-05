
package org.hj.controller;

import javax.servlet.http.HttpSession;
// 코드 숨겨져있음
import org.hj.model.LoginVO;
import org.hj.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {

	@Autowired
	LoginService ls;// LoginService ls = new LoginService(); <<주소를 만들어 클래스를 객체화(인스턴스화)
					// ls는 참조변수
	// 회원가입
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String member () {
		return "member/memberin";	// member폴더 안 memberin.jsp(회원가입 페이지)를 실행해라!
									// void로 주면 안된다? view안에 memberin이 없다?
	}
	
	// 회원가입서버
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	//public String memberPost (String id. String password, String name); -> 가능하나 비효율적이라 Model(LoginVo)을 쓰는 것
	public String memberPost (LoginVO member) {	// 메소드 선언부-클래스타입 참조(매개)변수
		System.out.println(member.toString());	// 여기서 toString() 메서드 호출(생략가능)
		ls.memreg(member);		// ls에 있는 memreg()메서드에 member를 인수로 던짐
		return "board/list";	// 회원가입 후 게시판 리스트 페이지로 이동
	}
	
	
	
	
	// 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login () {
		System.out.println("aaaa");
		return "member/login";
	}
	
	// 로그인 서버
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost (HttpSession session, LoginVO member) {
		
		//HttpSession  session = new HttpSession(); <- 이걸 쓸거면 매개변수는(LoginVO member)
/*		System.out.println("contorller="+member);
		System.out.println(ls.login(member));*/
		
		
		if (ls.login(member)==null) {
			return "member/login";
			} else {	
				session.setAttribute("login", ls.login(member)); // null이 아닐 때 세션에 저장
				return "redirect:/list";	
			}
		
		
		}
	
	// 회원관리페이지(관리자용)
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String memberlist(Model model) {	//Model은 MVC의 모델이 아닌 단순 객체임
		model.addAttribute("memlist", ls.memlist());	// memlist()에 있는 데이터를 memlist에 저장해서 넘김
		ls.memlist();
		return "member/list";
	};	
	
	
	// 회원정보 상세
	@RequestMapping(value = "/memberDetail", method = RequestMethod.GET)	// a태그를 통해 url로 접근했으므로 GET방식
	public String memberDetail(LoginVO memberId, Model model) {	// 선택한 id를 .xml까지 끌고가기 위해 매개변수가 필요
		model.addAttribute("memDetail", ls.memDetail(memberId));// select된 결과를 "memDetail"변수에 저장, .jsp에 전송 		
		ls.memDetail(memberId);	// 메서드 호출
		return "member/memberDetail";	// /WEB-INF/views/member/memberDetail.jsp <<servlet-context.xml에서 설정
	};
	
	// 회원정보 수정
	// 경우 1) update 후 상세페이지로 이동
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String memberModify(LoginVO login, RedirectAttributes rttr) {
		rttr.addAttribute("id", login.getId());
		ls.memModify(login);
		return "redirect:/memberDetail";//
	};
/*	// 경우 2) update 후 리스트로 이동
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String memberModify(LoginVO login) {
		ls.memModify(login);
		return "redirect:list";// select 한걸 같이 이동시켜야함
	};
*/	
	
	// 회원정보 삭제
		@RequestMapping(value = "/remove", method = RequestMethod.POST)
		public String memberRemove(LoginVO login) {
			ls.memRemove(login);
			return "redirect:list";// select 한걸 같이 이동시켜야함
	};
}
