package hello.servlet.basic.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) {

        printStartLine(request);
        printHeaders(request);
        printHeaderUtils(request);
        //기타 정보
        //기타 정보는 HTTP 메시지의 정보는 아님
        printEtc(request);
    }

    private static void printEtc(HttpServletRequest request) {
        System.out.println("---- 기타 조회 start ----");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request.getRemotePort() = " + request.getRemotePort());
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());
        System.out.println();
        System.out.println("----기타 조회 end ----");
        System.out.println();
    }

    private static void printHeaderUtils(HttpServletRequest request) {
        System.out.println("---- Header 편의 조회 start ----");
        System.out.println("request.getServerName() = " + request.getServerName());
        System.out.println("request.getServerPort() = " + request.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator().forEachRemaining(
                locale -> System.out.println("locale = " + locale)
        );
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null)
            for (Cookie cookie : request.getCookies())
                System.out.println(cookie.getName() + " : " + cookie.getValue());

        System.out.println();

        System.out.println("request.getContentType() = " + request.getContentType());
        System.out.println("request.getContentLength() = " + request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("---- Header 편의 조회 end ----");
        System.out.println();
    }

    private static void printHeaders(HttpServletRequest request) {
        System.out.println("---- Headers - start ----");

        /* Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + request.getHeader(headerName));
        } */

        request.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + ": " + request.getHeader(headerName)));
        System.out.println("---- Headers - end ----");
        System.out.println();
    }

    private static void printStartLine(HttpServletRequest request) {
        System.out.println("---- REQUEST-LINE - start ----");

        System.out.println("request.getMethod() = " + request.getMethod());
        System.out.println("request.getProtocol() = " + request.getProtocol());
        System.out.println("request.getScheme() = " + request.getScheme());
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        System.out.println("request.getQueryString() = " + request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure());
        System.out.println("---- REQUEST-LINE - end ----");
        System.out.println();
    }

}
