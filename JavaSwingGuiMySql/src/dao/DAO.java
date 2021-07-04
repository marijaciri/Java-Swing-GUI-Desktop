package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Destinacija;
import model.Korisnik;
import model.Putovanje;
import model.TipPrevoza;


public class DAO {
	private static DAO dao;
	private Statement statement = null;
	private Connection connect = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	private void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connect = DriverManager.getConnection("jdbc:mysql://localhost/agencija_putovanja", "root", "");
	}
	
	public ArrayList<Korisnik> putnik() throws ClassNotFoundException, SQLException{
		ArrayList<Korisnik> pom = new ArrayList<Korisnik>();
		
		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM korisnici");
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id_korisnika");
			String ime = resultSet.getString("ime");
			String prezime = resultSet.getString("prezime");
			String korisnickoIme = resultSet.getString("korisnicko_ime");
			String lozinka = resultSet.getString("lozinka");
			Korisnik k = new Korisnik(id, ime, prezime, korisnickoIme, lozinka);
			pom.add(k);
		}
		close();
		return pom;
	}
   public int insertKorisnikLastInsertID(Korisnik a) throws ClassNotFoundException, SQLException {
		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO `korisnici`( `ime`, `prezime`, `korisnicko_ime`, `lozinka`) VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
		
		preparedStatement.setString(1, a.getIme());
		preparedStatement.setString(2, a.getPrezime());
		preparedStatement.setString(3, a.getKorisnicko_ime());
		preparedStatement.setString(4, a.getLozinka());
		
		preparedStatement.execute();
		
		resultSet = preparedStatement.getResultSet();
		
		ResultSet keys = preparedStatement.getGeneratedKeys();
		keys.next();
		int id = keys.getInt(1);
		close();
		return id;
	}
	
	public ArrayList<Destinacija> destinacija() throws ClassNotFoundException, SQLException{
		ArrayList<Destinacija> pom = new ArrayList<Destinacija>();
		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM `destinacija`");
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id_destinacija");
			String naziv = resultSet.getString("naziv_destinacije");
			Destinacija d = new Destinacija(id, naziv);
			pom.add(d);
		}
		close();
		return pom;
	}
    public int insertDestinacijaLastInsertID(Destinacija a) throws ClassNotFoundException, SQLException {
		

		connect();
		preparedStatement = connect.prepareStatement("INSERT INTO `destinacija`( `naziv_destinacije`) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, a.getNaziv_destinacije());
	
		preparedStatement.execute();
		
		resultSet = preparedStatement.getResultSet();
		
		ResultSet keys = preparedStatement.getGeneratedKeys();
		keys.next();
		int id = keys.getInt(1);
		close();
		return id;
	}
	
	public ArrayList<TipPrevoza> tipPrevoza() throws ClassNotFoundException, SQLException{
		ArrayList<TipPrevoza> pom = new ArrayList<TipPrevoza>();
		connect();
		preparedStatement = connect.prepareStatement("SELECT * FROM `tip_prevoza`");
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		
		while(resultSet.next()) {
			int id = resultSet.getInt("id_tip_prevoza");
			String naziv = resultSet.getString("vrsta_prevoza");
			TipPrevoza p = new TipPrevoza(id, naziv);
			pom.add(p);
		}
		close();
		return pom;
	}
	
	public ArrayList<Putovanje> putovanje() throws ClassNotFoundException, SQLException{
		ArrayList<Putovanje> pom = new ArrayList<Putovanje>();
		String Putovanje = "SELECT putovanja.id_putovanja, korisnici.id_korisnika, korisnici.ime, korisnici.prezime, destinacija.id_destinacija, destinacija.naziv_destinacije, putovanja.datum_polaska, putovanja.datum_povratka, putovanja.duzina, putovanja.cena, tip_prevoza.id_tip_prevoza, tip_prevoza.vrsta_prevoza\r\n"
				+ "FROM putovanja join korisnici on putovanja.id_korisnika=korisnici.id_korisnika\r\n"
				+ "JOIN destinacija ON putovanja.id_destinacija=destinacija.id_destinacija\r\n"
				+ "JOIN tip_prevoza on putovanja.id_tip_prevoza= tip_prevoza.id_tip_prevoza";
		connect();
		preparedStatement = connect.prepareStatement(Putovanje);
		preparedStatement.execute();
		resultSet = preparedStatement.getResultSet();
		
		while(resultSet.next()) {
			int idPutovanja = resultSet.getInt("id_putovanja");
			
			int idKorisnika = resultSet.getInt("id_korisnika");
			String ime = resultSet.getString("ime");
			String prezime = resultSet.getString("prezime");
			Korisnik korisnik = new Korisnik();
			korisnik.setId_korisnik(idKorisnika);
			korisnik.setIme(ime);
			korisnik.setPrezime(prezime);
			
			int idDestinacije = resultSet.getInt("id_destinacija");
			String naziv = resultSet.getString("naziv_destinacije");
			Destinacija destinacija = new Destinacija(idDestinacije, naziv);
			
			Date vremePolaska = resultSet.getDate("datum_polaska");
			Date datumPovratka = resultSet.getDate("datum_povratka");
			int duzinaPuta = resultSet.getInt("duzina");
			double cena = resultSet.getDouble("cena");
			
			int idPrevoza = resultSet.getInt("id_tip_prevoza");
			String nazivPrevoza = resultSet.getString("vrsta_prevoza");
			TipPrevoza prevoz = new TipPrevoza(idPrevoza, nazivPrevoza);
			
			Putovanje novoPutovanje = new Putovanje(idPutovanja, korisnik, destinacija, vremePolaska, datumPovratka, duzinaPuta, cena, prevoz);
			pom.add(novoPutovanje);
		}
		close();
		return pom;
	}
	
	public void insertPutovanje(Putovanje p) throws ClassNotFoundException, SQLException {
		String InsertPutovanja = "INSERT INTO `putovanja`( `id_korisnika`, `id_destinacija`, `datum_polaska`, `datum_povratka`, `duzina`, `cena`, `id_tip_prevoza`) \r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String datumPolaska = sdf.format(p.getPolazak());
		String datumPovratka = sdf.format(p.getPovratak());
		
		connect();
		preparedStatement = connect.prepareStatement(InsertPutovanja);
		preparedStatement.setInt(1, p.getIdKorisnik().getId_korisnik());
		preparedStatement.setInt(2, p.getIdDestinacija().getId_destinacije());
		preparedStatement.setString(3, datumPolaska);
		preparedStatement.setString(4, datumPovratka);
		preparedStatement.setInt(5, p.getDuzina());
		preparedStatement.setDouble(6, p.getCena());
		preparedStatement.setInt(7, p.getIdVrstaprevoza().getId_tip_prevoza());
		preparedStatement.execute();
		
		close();
	}
	
	public void brisanjePutovanja(int id) throws ClassNotFoundException, SQLException {
		String BrisanjePutovanja = "DELETE FROM `putovanja` WHERE id_putovanja = ?";
		connect();
		preparedStatement = connect.prepareStatement(BrisanjePutovanja);
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		
		close();
	}
	
	public int putovanjeLastInsertID(Putovanje p) throws ClassNotFoundException, SQLException {
		String InsertPutovanja = "INSERT INTO `putovanja`( `id_korisnika`, `id_destinacija`, `datum_polaska`, `datum_povratka`, `duzina`, `cena`, `id_tip_prevoza`) \r\n"
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		String datumPolaska = sdf.format(p.getPolazak());
		String datumPovratka = sdf.format(p.getPovratak());
		
		connect();
		preparedStatement = connect.prepareStatement(InsertPutovanja,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setInt(1, p.getIdKorisnik().getId_korisnik());
		preparedStatement.setInt(2, p.getIdDestinacija().getId_destinacije());
		preparedStatement.setString(3, datumPolaska);
		preparedStatement.setString(4, datumPovratka);
		preparedStatement.setInt(5, p.getDuzina());
		preparedStatement.setDouble(6, p.getCena());
		preparedStatement.setInt(7, p.getIdVrstaprevoza().getId_tip_prevoza());
		preparedStatement.execute();
		
		resultSet =preparedStatement.getResultSet();
		ResultSet keys =preparedStatement.getGeneratedKeys();
		keys.next();
		int id = keys.getInt(1);
		
		close();
		return id;
	}
	
	private void close() {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			
			if(statement != null) {
				statement.close();
			}
			
			if(connect != null) {
				connect.close();
			   }
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Doslo je do greske!" +e.getMessage());
		   }
	   }
	
	  public static DAO getInstance() {
		 if(dao == null) {
			dao = new DAO();
		       }
		   return dao;
	  }
	  public DAO() {
		super();
		
	}
 }

