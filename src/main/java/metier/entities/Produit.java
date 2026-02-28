package metier.entities;

public class Produit {

	private long id ;
	private String designation ;
	private double prix ; 
	private int qantite ;
	
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Produit( String designation, double prix, int qantite) {
		super();
		this.designation = designation;
		this.prix = prix;
		this.qantite = qantite;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQantite() {
		return qantite;
	}
	public void setQantite(int qantite) {
		this.qantite = qantite;
	}
	
	@Override
	public String toString() {
		return "Produit [id=" + id + ", designation=" + designation + ", prix=" + prix + ", qantite=" + qantite + "]";
	}
	
	
}
