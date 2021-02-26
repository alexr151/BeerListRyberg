package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BeerItem;

/**
 * Servlet implementation class addBeerServlet
 */
@WebServlet("/addBeerServlet")
public class addBeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addBeerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	String brewery = request.getParameter("brewery");
		String beerName = request.getParameter("beerName");
		String beerType = request.getParameter("beerType");
		if (brewery.isEmpty() || beerName.isEmpty() || beerType.isEmpty() || brewery == null || beerName == null || beerType == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			BeerItem bi = new BeerItem(brewery, beerName, beerType);
			BeerListHelper dao = new BeerListHelper();
			dao.insertBeer(bi);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
	}

}
