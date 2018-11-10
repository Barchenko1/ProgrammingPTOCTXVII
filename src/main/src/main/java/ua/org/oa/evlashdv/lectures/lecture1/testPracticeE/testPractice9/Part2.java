package ua.org.oa.evlashdv.lectures.lecture1.testPracticeE.testPractice9;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Servlet implementation class Part2
 */
@WebServlet(name = "voting", urlPatterns = { "/voting" })
public class Part2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LinkedHashMap<String, ArrayList<String>> votes;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Part2() {
        super();
        votes=new LinkedHashMap<>();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String votedSport=request.getParameter("sport");
		String votedName=request.getParameter("name");
		
		if(votedSport!=null&&votedName!=null&&!votedName.trim().equals("")) {
			List<String> namesList=votes.get(votedSport);
			if(namesList!=null) {
				namesList.add(votedName);
			}
		}
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Voting</title>");
        out.println("<style>");
        out.println("table, th, td {");
   		out.println("	border: 1px solid grey;}");
   		out.println("th, td {");
   		out.println("    padding: 10px;}");
   		out.println("th {");
   		out.println("    text-align: center;}");
   		out.println("td {");
   		out.println("    text-align: left;}");
   		out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<form action=\"voting\" method=POST>");
        out.println("<table style=\"width:80%\" align=\"center\">");
        out.println("<caption><strong>Vote for your favourite sport!</strong></caption>");
        out.println("<tr>");
        out.println("  <th>Sport</th>");
        out.println("  <th>Voted</th>");
        out.println("  <th>Users voted</th>");
        out.println("</tr>");
        
        doSome(out);
        
        out.println("<tr>");
        out.println("  <td colspan=\"3\">");
        out.println("Enter your name: <input type=\"text\" name=\"name\">");
        out.println(" and <input type=\"submit\" value=\"Vote!\">");
        out.println("  </td>");
        out.println("</tr>");
        
        out.println("</table>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
	}
	private void doSome(PrintWriter out){
		List<String> sportsList=new ArrayList<>(votes.keySet());
		for(int i=0; i<sportsList.size();i++) {
			String sport=sportsList.get(i);
			List<String> namesList=votes.get(sport);
			int voted=namesList.size();
			String names=namesList.toString().replaceAll("[\\[\\]]", "");
			String radio = 	"<input type=\"radio\" name=\"sport\" value=\"" 
					+ sport + "\" title=\"" + sport + "\" />"
					+ sport;
			out.println("<tr>");
			out.println("  <td>" + radio + "</td>");
			out.println("  <td>" + voted + "</td>");
			out.println("  <td>" + names + "</td>");
			out.println("</tr>");
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		String[] sports=getServletContext().getInitParameter("list").trim().split(" ");
		if(sports==null||sports.length==0) {
			throw new IllegalArgumentException("No <context-params> in web.xml to construct Voting properly!");
		}
		for(int i=0;i<sports.length; i++) {
			votes.put(sports[i], new ArrayList<String>());
		}
	}

	
	

}
