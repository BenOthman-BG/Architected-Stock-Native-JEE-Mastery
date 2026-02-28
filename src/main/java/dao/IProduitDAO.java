package dao;

import  java.util.*;

import metier.entities.Produit;

public interface IProduitDAO {
    
	//  this method for adding the product 
	public Produit saveProduit (Produit p );
	// this method for searching for product by name 
	public List<Produit>  ProduitsParMC (String mc);
	// this method for searching in specific product 
	public Produit getProduit (Long id);
	
	public Produit updateProduit (Produit p);
	// this method for delete product 
	public void deletProduit (Long id );
	
}
