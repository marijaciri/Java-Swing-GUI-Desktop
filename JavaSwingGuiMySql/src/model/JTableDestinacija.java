package model;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class JTableDestinacija extends AbstractTableModel {
   ArrayList<Destinacija> lista;
   
   
   public JTableDestinacija(ArrayList<Destinacija> lista) {
	super();
	this.lista = lista;
}

@Override
	public int getRowCount() {
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return 2;
	}

	@Override
	public Object getValueAt(int r, int c) {
		Destinacija p = lista.get(r);
		switch(c) {
		case 0: return p.getId_destinacije();
		case 1: return p.getNaziv_destinacije();
		default: return "GRESKA";
		}
	}
	@Override
	public String getColumnName(int c) {
		switch(c) {
		case 0: return "ID_Destinacije";
		case 1: return "NAZIV";
		default: return "GRESKA";
		}
	}
	public ArrayList<Destinacija> getDestinacija(){
		return lista;
	}
	}


