package hello.springmvc.basic.response;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.html.HTMLOptGroupElement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * HTMl이 아니라 데이터를 보내기 때문에
 * HTTP 응답 메시지 바디에 JSON같은 형식으로 데이터를 실어 보냄
 */

@Slf4j
@Controller
// @RestController
public class ResponseBodyController {

    // HttpServletResponse 객체를 통해 HTTP 메시지 바디에 직접 응답 메시지를 전달
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV1() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }

    // @ResponseBody를 사용해 view를 사용하지 않고 HTTP메시지 컨버터를 통해 HTTP 메시지 바디에 직접 응답 메시지를 전달 
    @ResponseBody
    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    // HTTP 메시지 컨버터를 통해 JSON 형식으로 변환되어 반환
    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("test");
        helloData.setAge(20);

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("test");
        helloData.setAge(20);

        return helloData;
    }

}
