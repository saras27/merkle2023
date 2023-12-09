package entity;

public class Wishlist {
	
	private int id;
	private int id_deteta;
	private String poklon;
	
	
	public Wishlist() {
		super();
	}
	public Wishlist(int id, int id_deteta, String poklon) {
		super();
		this.id = id;
		this.id_deteta = id_deteta;
		this.poklon = poklon;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getPoklon() {
		return poklon;
	}
	public void setPoklon(String poklon) {
		this.poklon = poklon;
	}
	public int getId_deteta() {
		return id_deteta;
	}
	public void setId_deteta(int id_deteta) {
		this.id_deteta = id_deteta;
	}
	
	
	
}
