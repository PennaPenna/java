package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import model.Vene;


@WebServlet("/MuokkaaVene")
public class MuokkaaVene extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MuokkaaVene() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("MuokkaaVene.doGet()");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		System.out.println("MuokkaaVene.doPost()");
		String nimi = request.getParameter("nimi");
		String nimiUusi = request.getParameter("nimiUusi");
		String merkkimalli = request.getParameter("merkkimalli");
		Double pituus = Double.parseDouble(request.getParameter("pituus"));
		Double leveys = Double.parseDouble(request.getParameter("leveys"));
		Double hinta = Double.parseDouble(request.getParameter("hinta"));
		Vene vene = new Vene(nimiUusi, merkkimalli, pituus, leveys, hinta);
		Dao dao = new Dao();
		dao.muokkaaVene(vene, nimi);
		response.sendRedirect("HaeVeneet");
	}
}
