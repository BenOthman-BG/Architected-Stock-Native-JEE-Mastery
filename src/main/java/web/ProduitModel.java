package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Produit;

public class ProduitModel {

	private String mc ;
	private List<Produit> produits = new ArrayList<Produit>();
	private Produit produit = new Produit();
	
	
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public String getMc() {
		return mc;
	}
	public void setMc(String mc) {
		this.mc = mc;
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	
	
	
}
