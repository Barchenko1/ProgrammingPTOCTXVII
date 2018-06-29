package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/temp3")
public class TempServlet3 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String one=req.getParameter("one");
        one=one==null?"":one.replaceAll("<","&lt;").replaceAll(">","&gt;");
        resp.getWriter().write("<html>" +
                "<head></head>" +
                "<body>" +
                "    one="+one +
                "<form action=temp3 method=post>" +
                "        <textarea name= 'one'></textarea> "+
                "        <input type='submit' name='submit'/> " +
                "    </form>" +
                "</body> "+
                "</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
