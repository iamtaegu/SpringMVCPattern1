package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println();
        System.out.println("----- HEADER-UTILS - start -----");
        System.out.println("req.getServerName() = " + req.getServerName());
        System.out.println("req.getServerPort() = " + req.getServerPort());

        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " + locale));
        System.out.println("req.getLocale() = " + req.getLocale());

        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }

        System.out.println("req.getContentType() = " + req.getContentType());
        System.out.println("req.getContentLength() = " + req.getContentLength());
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());

    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("----- REQUEST-HEADER - start -----");

        /*Enumeration<String> headerNames = req.getHeaderNames();
        while(headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + req.getHeader(headerName));
        }*/

        req.getHeaderNames().asIterator()
                        .forEachRemaining(headerName -> System.out.println(headerName + ": " + req.getHeader(headerName)));

        System.out.println("----- REQUEST-HEADER - end -----");
    }

    private void printStartLine(HttpServletRequest req) {
        System.out.println("----- REQUEST-LINE - start -----");

        System.out.println("req.getMethod() = " + req.getMethod());
        System.out.println("req.getProtocol() = " + req.getProtocol());
        System.out.println("req.getScheme() = " + req.getScheme());

        System.out.println("req.getRequestURL() = " + req.getRequestURL());
        System.out.println("req.getRequestURI() = " + req.getRequestURI());
        System.out.println("req.getQueryString() = " + req.getQueryString());

        System.out.println("req.getParameter() =" + req.getParameter("test"));

        System.out.println("req.isSecure() = " + req.isSecure());

        System.out.println("----- REQUEST-LINE - end -----");
    }
}
