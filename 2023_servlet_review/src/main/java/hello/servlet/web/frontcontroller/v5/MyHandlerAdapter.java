package hello.servlet.web.frontcontroller.v5;

import hello.servlet.web.frontcontroller.ModelView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {

    /**
     *
     * @param handler
     *          handler는 컨트롤러를 말함
     *          어대텁가 해당 컨트롤러를 처리할 수 있는지 확인
     * @return
     */
    boolean supports(Object handler);

    /**
     * 어댑터는 컨트롤러를 호출하고, ModelView 반환
     * 이전에는 프론트 컨트롤러가 컨트롤러를 호출했지만 이제는 어댑터를 통해 컨트롤러가 호출됨
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws ServletException
     * @throws IOException
     */
    ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException, IOException;

}
