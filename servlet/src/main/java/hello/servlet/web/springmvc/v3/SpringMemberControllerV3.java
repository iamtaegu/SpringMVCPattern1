package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    //@RequestMapping(value = "/new-form", method = RequestMethod.GET) // URL 매핑 & GET인 경우에만 호출
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
        //return new ModelAndView("new-form");
    }

    //@RequestMapping(value="/save", method = RequestMethod.POST) // URL 매핑
    @PostMapping("/save")
    //public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
    public String save(@RequestParam("username") String username,
                             @RequestParam("age") int age,
                              Model model){

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    //@RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        // ctrl + alt + v
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}