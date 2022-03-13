package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 반환하는 str를 http body에 바로 넣어줌
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass()); @Slf4j로 대체

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name); // 로그 설정 레벨에 상관없이 출력됨

        //로그 설정에 상관없이 첫번째 로그는 + 연산을 수행하면서 메모리를 사용하게 됨
        //두번째 로그는 파라미터만 넘기기 때문에 메모리 사용이 없음
        log.trace("trace log=" + name);
        log.trace("trace log={}", name);

        log.debug("debug log={}", name);
        log.info("info log={} ", name);
        log.warn("warn log={}", name);
        log.error("error log={} ", name);

        return "ok";
    }
}
