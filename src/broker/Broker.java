package broker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Dete;
import entity.Korisnik;
import entity.Podatak;
import entity.Wishlist;

public class Broker {

	private static Broker instanca;
	private Connection con;
	
	private Broker() {
		ucitajDrajver();
	}
	
	public static Broker getInstanca() {
		
		if(instanca==null) {
			instanca=new Broker();
		}
		return instanca;
	}
	
	private void ucitajDrajver() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void otvoriKonekciju() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/merkle2023", "root", "");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void zatvoriKonekciju() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Podatak> ucitajPodatkeIzBaze() {
		List<Podatak> lista = new ArrayList();
		
		String sql = "SELECT * FROM dete "
				+ "INNER JOIN wishlista ON dete.id_dete=wishlista.id_dete";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Podatak p = new Podatak();
				p.setIme(rs.getString("ime"));
				p.setGodine(rs.getInt("godine"));
				p.setLista(rs.getString("lista"));
				p.setIdDete(rs.getInt("id_dete"));
				p.setGrad(rs.getString("grad"));
				lista.add(p);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return lista;
	}

	public void upisiDeteUBazu(Dete d) {
		String sql = "INSERT INTO dete(ime,prezime,godine,adresa,grad) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getIme());
			ps.setString(2, d.getPrezime());
			ps.setInt(3, d.getGodine());
			ps.setString(4, d.getAdresa());
			ps.setString(5, d.getGrad());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	public List<Dete> ucitajDecuIzBaze() {
		List<Dete> lista = new ArrayList();
		
		String sql = "SELECT * FROM dete WHERE status = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, false);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Dete d = new Dete();
				d.setIme(rs.getString("ime"));
				d.setId(rs.getInt("id_dete"));
				d.setAdresa(rs.getString("adresa"));
				d.setGodine(rs.getInt("godine"));
				d.setOdabrano(false);
				d.setPrezime(rs.getString("prezime"));
				d.setGrad(rs.getString("grad"));
				lista.add(d);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		return lista;
	}

	public void updateDeteUBazi(Dete d) {
		// TODO Auto-generated method stub
		String sql = "UPDATE dete SET ime=?,prezime=?,godine=?,adresa=?,grad=? WHERE id_dete=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, d.getIme());
			ps.setString(2, d.getPrezime());
			ps.setInt(3, d.getGodine());
			ps.setString(4, d.getAdresa());
			ps.setString(5, d.getGrad());
			ps.setInt(6, d.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	public void deleteDeteIzBaze(int idDete) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM dete WHERE id_dete = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, idDete);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	public void dodajListuUBazu(Wishlist w) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO wishlista (id_dete,lista) VALUES (?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, w.getId_deteta());
			ps.setString(2, w.getPoklon());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}

	public void upisiKorisnikaUBazu(Korisnik k) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO korisnik (ime,prezime,telefon,emial,id_dete) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, k.getIme());
			ps.setString(2, k.getPrezime());
			ps.setString(3, k.getBroj_telefona());
			ps.setString(4, k.getEmail());
			ps.setInt(5, k.getId_deteta());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

	public void updateStatusUBazi(int id_dete) {
		// TODO Auto-generated method stub
		String sql = "UPDATE dete SET status=? WHERE id_dete=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setBoolean(1, true);
			ps.setInt(2, id_dete);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
}
