package ua.org.oa.evlashdv.lectures.lecture1.servlet;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/thinkingServlet",asyncSupported = true)
public class ThinkingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext=req.getAsyncContext();
        asyncContext.start(new Runnable() {

            public void run() {
                //wait for event
            }
        });
        asyncContext.complete();
    }
}
