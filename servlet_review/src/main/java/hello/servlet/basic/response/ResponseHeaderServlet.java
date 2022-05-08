package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(HttpServletResponse.SC_OK);
        resp.setHeader("Content-Type", "text/plain:charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        //[Header 편의 메서드]
        content(resp); // ContentType: application/json
        cookie(resp);
        redirect(resp); // HTML > ContentType: text/html

        //[message body]
        PrintWriter writer = resp.getWriter();
        writer.println("ok"); // 단순 텍스트
    }

    private void redirect(HttpServletResponse resp) throws IOException {
        resp.sendRedirect("/basic/hello-form.html");
    }

    private void cookie(HttpServletResponse resp) {
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);
        resp.addCookie(cookie);
    }

    private void content(HttpServletResponse resp) {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("euc-kr");
    }
}
