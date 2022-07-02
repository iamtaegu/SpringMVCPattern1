package hello.servlet.web.frontcontroller.v2;

import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV2 {
    /**
     * V1은 Controller가 view forward까지 처리
     * V2은 view forward을 frontController에서 처리
     * Return Type, void > MyView로 변경
     */
    MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
