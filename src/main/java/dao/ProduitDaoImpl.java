package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import metier.entities.Produit;

public class ProduitDaoImpl implements IProduitDAO {


	// implements saveProduit
	@Override
	public Produit saveProduit(Produit p) {
		
		// get connection from singleton class that already(if it is runnable) have the connection saved in connection variable 
		Connection connection = SingletonConnection.getConnection();
		
		// Statement query for saving the product in PRODUITS table 
		
		try {
			// prepare statement for save query 
			PreparedStatement ps = connection.prepareStatement("INSERT INTO PRODUITS (DESIGNATION , PRIX ,QANTITE) VALUES (?,?,?) ");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQantite());
			// executeUpdate because -> (insert , update , delete ) 
			ps.executeUpdate();
			
			// ID is auto Increment -> we need to return the id that created after insert the product
			// create another statement for taking the id 
			PreparedStatement ps2 = connection.prepareStatement ("SELECT MAX(ID) AS MAX_ID FROM PRODUITS ");
			//execute query because -> (Select )
			ResultSet rSet = ps2.executeQuery();
			// we selected a table that is ( metadata [table name] , data [ id number ]) -> we need to move the cursor into data 
			// we use just if 
			if(rSet.next()) {
				// after moving the cursor we save the data in product.id 
			   p.setId(rSet.getLong("MAX_ID"));
			}
			
			// we need to close just the statements , note the connection
			ps.close();
			ps2.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// we return the Product that we created for just help the user to see what he created 
	     return p ;
	     
	}
	
	//--------------------------------------------------------------------------

	// implements search product 
	@Override
	public List<Produit> ProduitsParMC(String mc) {
		
		// create a list that contain all product that returned from the statement
		List<Produit> produits = new ArrayList<Produit>() ;
		
		// get the connection from connection variable 
		Connection connection = SingletonConnection.getConnection();
		
		try {
			// statement form returning the products from DB 
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM PRODUITS WHERE DESIGNATION LIKE ? ");
			ps.setString(1, mc);
			ResultSet rSet = ps.executeQuery();
			
			// save all product that are in rSet into list of product 
			while (rSet.next()) {
				Produit p = new Produit();
				p.setId(rSet.getLong("ID"));
				p.setDesignation(rSet.getString("DESIGNATION"));
				p.setPrix(rSet.getDouble("PRIX"));
				p.setQantite(rSet.getInt("QANTITE"));
				produits.add(p);		
			}
			
		ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	// return List of products 	
	 return produits;
	}
	
	// ----------------------------------------------------------------------

	@Override
	public Produit getProduit(Long id) {
       
		// get connection from singleton class that already(if it is runnable) have the connection saved in connection variable 
		Connection connection = SingletonConnection.getConnection();
		
        Produit p = new Produit();
		// Statement query for saving the product in PRODUITS table 
		
		try {

			PreparedStatement ps2 = connection.prepareStatement ("SELECT * FROM PRODUITS WHERE ID = ? ");
			ps2.setLong(1, id);
			ResultSet rSet = ps2.executeQuery();
			// we selected a table that is ( metadata [table name] , data [ id number ]) -> we need to move the cursor into data 
			// we use just if

			if(rSet.next()) {

	         p.setId(rSet.getLong("ID"));
	         p.setDesignation(rSet.getString("DESIGNATION"));
	         p.setPrix(rSet.getDouble("PRIX"));
	         p.setQantite(rSet.getInt("QANTITE"));
			}
			
			// we need to close just the statements , note the connection
			ps2.close();
	
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// we return the Product that we created for just help the user to see what he created 
	     return p ;
	     
	}

	//---------------------------------------------------------------------------------------
	
	@Override
	public Produit updateProduit(Produit p) {
		// get connection from singleton class that already(if it is runnable) have the connection saved in connection variable 
		Connection connection = SingletonConnection.getConnection();
		
		// Statement query for saving the product in PRODUITS table 
		
		try {
			// prepare statement for save query 
			PreparedStatement ps = connection.prepareStatement("UPDATE PRODUITS SET DESIGNATION = ? , PRIX = ? , QANTITE = ? WHERE ID = ? ");
			ps.setString(1, p.getDesignation());
			ps.setDouble(2, p.getPrix());
			ps.setInt(3, p.getQantite());
			ps.setLong(4, p.getId());
			// executeUpdate because -> (insert , update , delete ) 
			ps.executeUpdate();
				
        	// we need to close just the statements , note the connection
			ps.close();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// we return the Product that we created for just help the user to see what he created 
	     return p ;
	}
	
	//--------------------------------------------------------------------------------------------
	

	@Override
	public void deletProduit(Long id) {
		// get connection from singleton class that already(if it is runnable) have the connection saved in connection variable 
		Connection connection = SingletonConnection.getConnection();
		
		// Statement query for deleting the product in PRODUITS table 
		
		try {
			// prepare statement for save query 
			PreparedStatement ps = connection.prepareStatement("DELETE FROM PRODUITS WHERE ID = ? ");
			ps.setLong(1,id);
			
			// executeUpdate because -> (insert , update , delete ) 
			ps.executeUpdate();
			
			ps.close();


		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

