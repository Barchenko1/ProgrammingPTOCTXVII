package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/temp4")
public class TempServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Enumeration<String >headNames=req.getHeaderNames();
//        while (headNames.hasMoreElements()){
//            String s=headNames.nextElement();
//            System.out.println(s+" = "+req.getHeader(s));
//        }
        System.out.println(req.getProtocol());
        System.out.println(req.getRequestURI());
        System.out.println(req.getRequestURL());
    }
}
