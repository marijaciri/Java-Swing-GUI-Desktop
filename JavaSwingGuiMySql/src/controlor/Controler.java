package controlor;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.DAO;
import model.Destinacija;
import model.Korisnik;
import model.Putovanje;

public class Controler {
	private static Controler con;
	
	private Controler() {}
	
	public static Controler getInstanceOf() {
		if(con == null) {
			con = new Controler();
		}
		return con;
	}
	
	public ArrayList<Putovanje> vratiPutovanje() throws ClassNotFoundException, SQLException{
		return DAO.getInstance().putovanje();
	}
	
	public ArrayList<Korisnik> vratiListuKorisnika() throws ClassNotFoundException, SQLException{
		return DAO.getInstance().putnik();
	}
	
	public ArrayList<Destinacija> vratiuDestinacije() throws ClassNotFoundException, SQLException {
		return DAO.getInstance().destinacija();
	}
	
	public void deletePutovanje(int id) throws ClassNotFoundException, SQLException {
		DAO.getInstance().brisanjePutovanja(id);
	}
	public int insertDestinacijaLastInsertID(Destinacija a)throws ClassNotFoundException, SQLException {
		return DAO.getInstance().insertDestinacijaLastInsertID(a);
	}
	public int insertKorisnikLastInsertID(Korisnik a)throws ClassNotFoundException, SQLException {
		return DAO.getInstance().insertKorisnikLastInsertID(a);
	}
	public void insertPutovanja(Putovanje p) throws ClassNotFoundException, SQLException {
		DAO.getInstance().insertPutovanje(p);
	}
	public int insertPutovanjeLastInsertID(Putovanje p) throws ClassNotFoundException, SQLException {
		return DAO.getInstance().putovanjeLastInsertID(p);
	}
}
