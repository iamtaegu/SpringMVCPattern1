package hello.servlet.web.springmvc.v1;

import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // spring bean 등록 & 스프링MVC 애노테이션 컨트롤러 인식
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form") // URL 매핑
    public ModelAndView process() {
        return new ModelAndView("new-form");
    }

}
