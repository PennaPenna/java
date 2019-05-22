package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vene;
import dao.Dao;

@WebServlet("/HaeVeneet")
public class HaeVeneet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public HaeVeneet() {
        super();
        System.out.println("HaeVeneet.HaeVeneet()");
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeVeneet.doGet()");
		Dao dao = new Dao();
		ArrayList<Vene> Veneet = dao.listaaKaikki();
		request.setAttribute("Veneet", Veneet);		
		String jsp = "/haeveneet.jsp"; 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HaeVeneet.doPost()");
		String hakusana = request.getParameter("hakusana");
		if(hakusana.isEmpty()){
			response.sendRedirect("HaeVeneet");
			return;
		}
		Dao dao = new Dao();
		ArrayList<Vene> Veneet = dao.listaaKaikki(hakusana);
		request.setAttribute("Veneet", Veneet);		
		String jsp = "/haeveneet.jsp"; 
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(jsp);
		dispatcher.forward(request, response);
	}

}









