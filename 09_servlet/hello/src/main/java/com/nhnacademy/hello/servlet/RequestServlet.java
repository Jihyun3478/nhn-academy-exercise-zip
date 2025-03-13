package com.nhnacademy.hello.servlet;

import java.io.PrintWriter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "requestServlet", value = "/request-servlet")
public class RequestServlet extends HttpServlet {
    private static Logger log = Logger.getLogger(RequestServlet.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        /* 1. buffer size 설정 */
        log.info("default buffer size : " + resp.getBufferSize());
        resp.setBufferSize(1024);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        try (PrintWriter writer = resp.getWriter()) {
            writer.println("locale= " + req.getLocale());
            writer.println("parameter name= " + req.getParameter("name"));
            /* 2. flush 버퍼링 된 출력 바이트를 즉시 사용하도록(소켓을 통해서 내보냄) 강제함 */
            /* -> client 와 연결이 종료됨 -> 즉, 아래 로직은 실행되더라도 브라우저에 표시 X */
            // writer.flush();
            // writer.close();

            String userId = req.getParameter("userId");
            log.info("userId : " + userId);

            if (userId == null || userId.isEmpty()) {
                /* 3. response 초기화 */
                resp.reset();

                /* 4. error 코드르르 500으로 설정함 */
                resp.setStatus(500);

                /* 5. error 코드를 500으로 설정하고, error message 'name is empty' 설정함 */
                resp.sendError(500, "name is empty");
                return;
            }

            /* 6. redirect */
            String redirect = req.getParameter("redirect");
            if (Objects.nonNull(redirect)) {
                resp.sendRedirect(redirect);
                return;
            }

            writer.println("method= " + req.getMethod());
            writer.println("request uri= " + req.getRequestURI());

            /* 7. reset buffer - response 객체에 담겨있던 모든 buffer 초기화 ❔ buffer.flush() 느낌인건가 */
            resp.resetBuffer();

            writer.println("User-Agent header= " + req.getHeader("User-Agent"));
        } catch (Exception e) {
            log.log(Level.WARNING, e.getMessage());
        }
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        log.info("before init!");
        super.init(config);
    }
}
