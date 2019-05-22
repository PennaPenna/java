package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.Dao;

/**
 * Servlet implementation class TutkiKirjaudu
 */
@WebServlet("/TutkiKirjaudu")
public class TutkiKirjaudu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutkiKirjaudu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	System.out.println("TutkiKirjaudu.doGet()");	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TutkiKirjaudu.doPost()");
		String pwd = request.getParameter("pwd");
		String user_id = request.getParameter("user_id");
		Dao dao = new Dao();
		String nimi = dao.login(user_id, pwd);
		if(nimi!=null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("kayttaja", nimi);
			response.sendRedirect("listaaveneet.jsp");
		}else {
			response.sendRedirect("index.jsp?login=0");
		}
		
	}

}
