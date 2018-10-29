package ua.org.oa.evlashdv.lectures.lecture1.testPractice.testPractice9;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Servlet Filter implementation class VotingFilter
 */
@WebFilter(filterName = "votingfilter", servletNames = { "voting" })
public class VotingFilter implements Filter {
	private Map<String,HashSet<String>> storage;
    /**
     * Default constructor. 
     */
    public VotingFilter() {
        super();
        storage=new HashMap<>();
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=  (HttpServletResponse) resp;
		HttpSession session=request.getSession(true);
		String votedSport=request.getParameter("sport");
		String votedName=request.getParameter("name");
		if(votedSport!=null&&votedName!=null&&!votedName.trim().equals("")) {
			String sessionId=session.getId();
			HashSet<String> sessionSet=storage.get(votedName);
			if(sessionSet!=null&&sessionSet.contains(sessionId)) {
				response.sendRedirect(request.getContextPath() + "/errvote.html");
			}else{
				if(sessionSet==null) {
					sessionSet=new HashSet<String>();
					storage.put(votedName, sessionSet);
				}
				sessionSet.add(sessionId);
				chain.doFilter(req,resp);
			}
			
		}else {
			chain.doFilter(req,resp);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
