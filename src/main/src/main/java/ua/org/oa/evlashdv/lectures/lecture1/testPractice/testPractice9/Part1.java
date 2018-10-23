package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice9;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Part1")
public class Part1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private int x;
    private int y;
    private String op;
    private int result;
    public Part1() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            x=Integer.parseInt(request.getParameter("x"));
            op=request.getParameter("op");
            y=Integer.parseInt(request.getParameter("y"));
            if ("plus".equals(op)) {
                result=x+y;
            }
            if ("minus".equals(op)) {
                result=x-y;
            }
            PrintWriter out=response.getWriter();
            out.println("<html><body></br><a href=\"part1.html\">Link</a></body></html>" + "<br>" + "Result:" + result);
            out.close();
        }catch(Exception e) {
            request.getServletContext().getRequestDispatcher("/error.html").forward(request, response);
        }

    }

}
