package hello.servlet.basic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("request= " + request);
        System.out.println("response= " + response);

        String name = request.getParameter("username");
        System.out.println("username= " + name);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + name);
    }
}
