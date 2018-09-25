package ua.org.oa.evlashdv.lectures.lecture1.lecture8b;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServletToBase extends HttpServlet {
    public void doGet(HttpServletRequest req,HttpServletResponse resp){
        performTask(req, resp);
    }
    public void doPost(HttpServletRequest req,HttpServletResponse resp){
        performTask(req,resp);
    }
    public void showInfo(PrintWriter out, ResultSet rs) throws SQLException {
        out.print("From DB:");
        while (rs.next()){
            out.print("<br>Name:-> "+rs.getString(1)+" Phone:-> "+rs.getInt(2));
        }
    }
    public void performTask(HttpServletRequest req, HttpServletResponse resp){
        resp.setContentType("text/html; charset=Cp1251");
        PrintWriter out=null;
        try {
            out=resp.getWriter();
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
