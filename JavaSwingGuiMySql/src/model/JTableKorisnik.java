package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class JTableKorisnik extends AbstractTableModel {
    ArrayList<Korisnik> lista;
    
    
    
    
	public JTableKorisnik(ArrayList<Korisnik> lista) {
		super();
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Korisnik p = lista.get(r);
		switch(c) {
		case 0: return p.getId_korisnik();
		case 1: return p.getIme();
		case 2: return p.getPrezime();
		case 3: return p.getKorisnicko_ime();
		case 4: return p.getLozinka();
		default: return "GRESKA";
		}
	}
	@Override
	public String getColumnName(int c) {
		switch(c) {
		case 0: return "IDKORISNIKA";
		case 1: return "IME";
		case 2: return "PREZIME";
		case 3: return "KORISNICKO IME";
		case 4: return "LOZINKA";
		default: return "GRESKA";
		}
	}
	public ArrayList<Korisnik> getKorisnik(){
		return lista;
	}
}
