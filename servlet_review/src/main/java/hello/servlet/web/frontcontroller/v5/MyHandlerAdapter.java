package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    // handler=controller, 현재 어댑터가 처리할 수 있는 컨트롤러인지 확인
    boolean supports(Object handler);

    // 컨트롤러를 호출하고, 결과를 ModelView로 반환
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;
}
