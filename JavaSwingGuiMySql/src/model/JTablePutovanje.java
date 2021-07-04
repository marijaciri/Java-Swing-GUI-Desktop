package model;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class JTablePutovanje extends AbstractTableModel {

	ArrayList<Putovanje> lista;

	public JTablePutovanje(ArrayList<Putovanje> putovanje) {
		super();
		this.lista = putovanje;
	}

	@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 9;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Putovanje p = lista.get(r);
		switch(c) {
		case 0: return p.getId_putovanja();
		case 1: return p.getIdKorisnik().getIme();
		case 2: return p.getIdKorisnik().getPrezime();
		case 3: return p.getIdDestinacija().getNaziv_destinacije();
		case 4: return p.getPolazak();
		case 5: return p.getPovratak();
		case 6: return p.getDuzina();
		case 7: return p.getCena();
		case 8: return p.getIdVrstaprevoza().getVrsta_prevoza();
		default: return "GRESKA";
		}
	}
	
	@Override
	public String getColumnName(int c) {
		switch(c) {
		case 0: return "IDPutovanja";
		case 1: return "IME";
		case 2: return "PREZIME";
		case 3: return "DESTINACIJA";
		case 4: return "POLAZAK";
		case 5: return "POVRATAK";
		case 6: return "UDALJENOST";
		case 7: return "CENA";
		case 8: return "PREVOZ";
		default: return "GRESKA";
		}
	}
	
	@Override
	public boolean isCellEditable(int r, int c) {
	  switch(c) {
	    case 0: return false;
	    case 1: return false;
		case 2: return false;
		case 3: return false;
		case 4: return true;
		case 5: return true;
		case 6: return true;
		case 7: return true;
		case 8: return false;
		
		default: return false;
		}
	}
	
	public ArrayList<Putovanje> getPutovanje() {
		return lista;
	}
	
	

}