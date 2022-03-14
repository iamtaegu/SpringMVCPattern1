package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody // viewResolver 를 찾는게 아니라 HTTP 바디에 넣어 반환하겠다
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String memberName, @RequestParam("age") int memberAge)
            throws IOException {
        log.info("username={}, age={}", memberName, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, @RequestParam int age)
            throws IOException {
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    // HTTP 파라미터 이름이 변수명과 같으면 @RequestParam(name="xx") 생략 가능
    // 단, @RequestParam이 있어야 "요청 파라미터를 읽는다" 명시가 가능
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age)
            throws IOException {
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    // 필수 파라미터 설정
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username, @RequestParam(required = false) Integer age)
            throws IOException {
        if (age != null)
            log.info("username={}, age={}", username, age);

        return "ok";
    }

    // default값 설정으로 required는 불필요하게 됨
    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(required = true, defaultValue = "guest") String username
            , @RequestParam(required = false, defaultValue = "-1") int age)
            throws IOException {
        log.info("username={}, age={}", username, age);

        return "ok";
    }

    //파라미터를 map으로 조회
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) throws IOException {

        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

    // 스프링MVC는 @ModelAttribute가 있으면
    // 객체 파라미터의 이름으로 HelloData 객체의 프로퍼티를 찾고, 해당 프로퍼티의 setter를 호출해
    // 파라미터 값을 바인딩 함
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    //public String modelAttributeV1(@RequestParam String username, @RequestParam int age) {
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {
//        HelloData helloData = new HelloData();
//        helloData.setAge(age);
//        helloData.setUsername(username);
        log.info("helloData={}", helloData.toString());

        return "ok";
    }

    // String, int, Integer 같은 단순 타입은 @RequestParam
    // 나머지 @ModelAttribute로 처리 
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        log.info("helloData={}", helloData.toString());

        return "ok";
    }
}
