package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        HelloData data = new HelloData();
        data.setUsername("오태건");
        data.setAge(31);
        //SpringMVC Jackson 라이브러리 객체 <> json 변환 지원
        // json > 객체
        //HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        // 객체 > json(string)
        String result = objectMapper.writeValueAsString(data);
        System.out.println("[ResponseJsonServlet] result= " + result);

        resp.getWriter().write(result);
    }
}
