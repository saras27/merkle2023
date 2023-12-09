package entity;


public class Dete {

	private int id;
	private String ime;
	private String prezime;
	private String adresa;
	private String grad;
	private boolean odabrano;
	private int godine;
	
	
	public Dete() {
		super();
		odabrano = false;
	}
	public Dete(int id, String ime, String prezime, String adresa, boolean odabrano) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.adresa = adresa;
		this.odabrano = odabrano;
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
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public boolean isOdabrano() {
		return odabrano;
	}
	public void setOdabrano(boolean odabrano) {
		this.odabrano = odabrano;
	}
	public int getGodine() {
		return godine;
	}
	public void setGodine(int godine) {
		this.godine = godine;
	}
	public String getGrad() {
		return grad;
	}
	public void setGrad(String grad) {
		this.grad = grad;
	}
	@Override
	public String toString() {
		return ime+" "+godine;
	}
	
	
	
}
