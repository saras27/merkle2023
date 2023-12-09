package kontroler;

import java.util.ArrayList;
import java.util.List;

import broker.Broker;
import entity.Dete;
import entity.Podatak;
import entity.Wishlist;

public class Kontroler {

	private static Kontroler instanca;
	private Kontroler() {
		
	}
	
	public static Kontroler getInstanca() {
		if(instanca==null) {
			instanca= new Kontroler();
		}
		return instanca;
	}

	public List<Podatak> ucitajPodatke() {
		List<Podatak> lista = new ArrayList();
		Broker.getInstanca().otvoriKonekciju();
		lista = Broker.getInstanca().ucitajPodatkeIzBaze();
		Broker.getInstanca().zatvoriKonekciju();
		return lista;
	}

	public void upisiDete(String ime, String prezime, int godine, String adresa) {
		Dete d = new Dete();
		d.setIme(ime);
		d.setGodine(godine);
		d.setPrezime(prezime);
		d.setAdresa(adresa);
		Broker.getInstanca().otvoriKonekciju();
		Broker.getInstanca().upisiDeteUBazu(d);
		Broker.getInstanca().zatvoriKonekciju();
		
	}

	public List<Dete> ucitajDecu() {
		List<Dete> lista = new ArrayList();
		Broker.getInstanca().otvoriKonekciju();
		lista = Broker.getInstanca().ucitajDecuIzBaze();
		Broker.getInstanca().zatvoriKonekciju();
		return lista;
	}

	public void updateDete(int idDete, String ime, String prezime, int godine, String adresa) {
		Dete d = new Dete();
		d.setAdresa(adresa);
		d.setId(idDete);
		d.setIme(ime);
		d.setPrezime(prezime);
		d.setGodine(godine);
		
		Broker.getInstanca().otvoriKonekciju();
		Broker.getInstanca().updateDeteUBazi(d);
		Broker.getInstanca().zatvoriKonekciju();
		
	}

	public void deleteDete(int idDete) {
		Broker.getInstanca().otvoriKonekciju();
		Broker.getInstanca().deleteDeteIzBaze(idDete);
		Broker.getInstanca().zatvoriKonekciju();
		// TODO Auto-generated method stub
		
	}

	public void dodajListu(int id, String wishlist) {
		// TODO Auto-generated method stub
		Wishlist w = new Wishlist();
		w.setId_deteta(id);
		w.setPoklon(wishlist);
		Broker.getInstanca().otvoriKonekciju();
		Broker.getInstanca().dodajListuUBazu(w);
		Broker.getInstanca().zatvoriKonekciju();
		
	}
}
