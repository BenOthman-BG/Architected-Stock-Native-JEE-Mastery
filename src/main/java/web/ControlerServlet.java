package web;


import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.IProduitDAO;
import metier.entities.Produit;

@WebServlet (name = "cs" , urlPatterns = {"*.php"})

public class ControlerServlet  extends HttpServlet{
	
    // reserve space for taking a object 
	
    private IProduitDAO metierDao;

    @Override
    public void init() throws ServletException {
    	
         // asking for the object ( i have the key ) -> injected the object in the variable 
        this.metierDao = (IProduitDAO) getServletContext().getAttribute("daoService");
    }
    
    //-------------------------------------------------------
	
	@Override
	protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
           
		String path = request.getServletPath();
		
		if(path.equals("/index.php")) {
			request.getRequestDispatcher("produits.jsp").forward(request, response);
			
			
		}else if(path.equals("/search.php")) {
			String moCle = request.getParameter("moCle");
			ProduitModel model = new ProduitModel();
			model.setMc(moCle); 
			List<Produit> produits = metierDao.ProduitsParMC("%"+moCle+"%");
			model.setProduits(produits);
			request.setAttribute("model",model);
			request.getRequestDispatcher("produits.jsp").forward(request, response);
			
			
		}else if (path.equals("/saisie.php")) {
			request.getRequestDispatcher("AjouterProduit.jsp").forward(request, response);
			
			
		}else if (path.equals("/save.php") && (request.getMethod().equals("POST")) ){
			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qantite = Integer.parseInt(request.getParameter("qantite"));
			ProduitModel model = new ProduitModel();
			Produit p = metierDao.saveProduit( new Produit(designation,prix,qantite));
		
			model.setProduit(p);
			request.setAttribute("model", model);
			
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
			
			
		}else if (path.equals("/delete.php")) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			metierDao.deletProduit(id);
			
			response.sendRedirect("search.php?moCle=");
			
			
		}else if (path.equals("/edit.php")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Produit produit = metierDao.getProduit(id);
			ProduitModel model = new ProduitModel();
			model.setProduit(produit);
			
			request.setAttribute("model", model);
			
			request.getRequestDispatcher("EditProduit.jsp").forward(request, response);
	
			
			
		}else if (path.equals("/update.php") && (request.getMethod().equals("POST")) ) {
			
			Long id = Long.parseLong(request.getParameter("id"));
			String designation = request.getParameter("designation");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int qantite = Integer.parseInt(request.getParameter("qantite"));
			ProduitModel model = new ProduitModel();
			Produit p =  new Produit(designation,prix,qantite);
			p.setId(id);
			metierDao.updateProduit(p);
			model.setProduit(p);
			
			request.setAttribute("model", model);
			request.getRequestDispatcher("Confirmation.jsp").forward(request, response);
			
			
		}
		
		
		
		else {
		request.getRequestDispatcher("404.jsp").forward(request, response);
	}
	
			
	}
	
	//------------------------------------------------------------------------
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse respone) throws ServletException, IOException {
        doGet(request, respone);
	}
	
	//--------------------------------------------------------------------------------
	
	
}
