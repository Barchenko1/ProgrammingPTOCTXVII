package ua.org.oa.evlashdv.lectures.lecture1.ee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/temp2")
public class TempServlet2 extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String one=req.getParameter("one");
//        String two=req.getParameter("two");
//        if (one!=null){
//            System.out.println(one);
//        }if (two!=null){
//            System.out.println(two);
//        }
//        String [] ones=req.getParameterValues("one");
//        for (String s:ones) {
//            System.out.println(s);
//        }
//        Enumeration<String> pEnum=req.getParameterNames();
//        while (pEnum.hasMoreElements()){
//            String elementName=pEnum.nextElement();
//            System.out.println(elementName+" = "+req.getParameter(elementName));
//        }
//        Map<String,String []> paramMap=req.getParameterMap();

//        System.out.println(req.getRequestURL());
//        System.out.println(req.getServletPath());
//        System.out.println(req.getRemoteHost());
//        System.out.println(req.getRequestURI());
//        System.out.println(req.getLocalPort());
//        System.out.println(req.getQueryString());
        String one=req.getParameter("one");
        String two=req.getParameter("two");
        String tree=req.getParameter("tree");
        resp.getWriter().write("<html>\n" +
                "<head></head>" +
                "<body>" +
                "    one="+one +
                "    two="+two +
                "    tree= "+tree +
                "<form action=temp2 method=post>" +
                "        <input type= 'text' name= 'one'/> "+
                "        <input type= 'text' name='two'/> "+
                "        <input type= 'text' name='tree'/> "+
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
