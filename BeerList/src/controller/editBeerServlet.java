package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BeerItem;

/**
 * Servlet implementation class editBeerServlet
 */
@WebServlet("/editBeerServlet")
public class editBeerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editBeerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeerListHelper dao = new BeerListHelper();
		
		String brewery = request.getParameter("brewery");
		String beerName = request.getParameter("beerName");
		String beerType = request.getParameter("beerType");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
				
		BeerItem beerToUpdate = dao.searchForBeerById(tempId);
		beerToUpdate.setBrewery(brewery);
		beerToUpdate.setBeerName(beerName);
		beerToUpdate.setBeerType(beerType);
				
		dao.updateBeer(beerToUpdate);

		getServletContext().getRequestDispatcher("/viewAllBeersServlet").forward(request, response);


	}

}
