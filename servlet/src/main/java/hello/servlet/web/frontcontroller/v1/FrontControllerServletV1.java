package hello.servlet.web.frontcontroller.v1;

import hello.servlet.web.frontcontroller.v1.controller.MemberFormControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberListControllerV1;
import hello.servlet.web.frontcontroller.v1.controller.MemberSaveControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {
    
    // 다형성
    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    // 매핑 정보
    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("FrontControllerServlerV1.service");

        String requestURI = req.getRequestURI();
        System.out.println("requestURI= " + requestURI);
        // 1. 매핑정보
        // URI에 해당하는 Controller를 찾음
        // Controller I/F를 통해 실행 객체를 가져옴
        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null) {
            // 4**, Client Error
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        // version_1은 req,resp 서블릿을 그대로 주기 때문에
        // Controller 실행 후 F/C 역할은 끝남
        controller.process(req, resp);
    }

}

