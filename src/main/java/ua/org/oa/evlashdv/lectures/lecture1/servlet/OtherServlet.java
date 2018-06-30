package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/other")
public class OtherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().write(req.getServletContext().getAttribute("one").toString());
        ServletContext servletContext=getServletContext();
        Enumeration<String>attrEnum=servletContext.getAttributeNames();
        while (attrEnum.hasMoreElements()){
            String s=attrEnum.nextElement();
            System.out.println(s+" = "+servletContext.getAttribute(s));
        }
    }
}
