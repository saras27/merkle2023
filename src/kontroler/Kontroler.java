package kontroler;

import java.util.ArrayList;
import java.util.List;

import broker.Broker;
import entity.Dete;
import entity.Korisnik;
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

	public void upisiDete(String ime, String prezime, int godine, String adresa,String grad) {
		Dete d = new Dete();
		d.setIme(ime);
		d.setGodine(godine);
		d.setPrezime(prezime);
		d.setAdresa(adresa);
		d.setGrad(grad);
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

	public void updateDete(int idDete, String ime, String prezime, int godine, String adresa,String grad) {
		Dete d = new Dete();
		d.setAdresa(adresa);
		d.setId(idDete);
		d.setIme(ime);
		d.setPrezime(prezime);
		d.setGodine(godine);
		d.setGrad(grad);
		
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

	public void upisiKorisnika(String ime, String prezime, String email, String telefon,int id_dete) {
		Korisnik k = new Korisnik();
		k.setBroj_telefona(telefon);
		k.setEmail(email);
		k.setIme(ime);
		k.setPrezime(prezime);
		k.setId_deteta(id_dete);
		Broker.getInstanca().otvoriKonekciju();
		Broker.getInstanca().upisiKorisnikaUBazu(k);
		Broker.getInstanca().zatvoriKonekciju();
		
	}

	public void updateStatusDeteta(int id_dete) {
		// TODO Auto-generated method stub
		Broker.getInstanca().otvoriKonekciju();
		Broker.getInstanca().updateStatusUBazi(id_dete);
		Broker.getInstanca().zatvoriKonekciju();

		
	}

	public List<Podatak> ucitajPodatkePretrage(String pretraga) {
		List<Podatak> lista = new ArrayList();
		Broker.getInstanca().otvoriKonekciju();
		lista = Broker.getInstanca().ucitajPodatkePretrageIzBaze(pretraga);
		Broker.getInstanca().zatvoriKonekciju();
		return lista;
	}

	public List<Podatak> filtriraj(String grad, String odgod, String dogod) {
		List<Podatak> lista = new ArrayList();
		Broker.getInstanca().otvoriKonekciju();
		lista = Broker.getInstanca().ucitajPodatkePretrageIzBaze(grad,odgod,dogod);
		Broker.getInstanca().zatvoriKonekciju();
		return lista;
	}
}
