package hello.servlet.web.frontcontroller.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ControllerV1 {
    // Controller는 I/F 상속을 부모 객체 변수로 자식 객체를 할당할 수 있음
    void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
