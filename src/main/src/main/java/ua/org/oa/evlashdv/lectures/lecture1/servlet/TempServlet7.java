package ua.org.oa.evlashdv.lectures.lecture1.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/temp7")
public class TempServlet7 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();
        for (Cookie cookie:cookies){
            System.out.println(cookie.getName());
            System.out.println(cookie.getValue());
        }
        Cookie cookie=new Cookie("testCookie","abc");
        resp.addCookie(cookie);
    }
}
