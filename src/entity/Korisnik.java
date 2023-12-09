package entity;

public class Korisnik {

	private int id;
	private String ime;
	private String prezime;
	private String broj_telefona;
	private int id_deteta;
	private String email;
	

	public Korisnik() {
		super();
	}

	public Korisnik(int id, String ime, String prezime, String broj_telefona, int id_deteta) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.broj_telefona = broj_telefona;
		this.id_deteta = id_deteta;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getBroj_telefona() {
		return broj_telefona;
	}
	public void setBroj_telefona(String broj_telefona) {
		this.broj_telefona = broj_telefona;
	}
	public int getId_deteta() {
		return id_deteta;
	}
	public void setId_deteta(int id_deteta) {
		this.id_deteta = id_deteta;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	
}
