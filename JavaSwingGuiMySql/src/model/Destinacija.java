package model;

public class Destinacija {
   public int id_destinacije;
   public String naziv_destinacije;
public int getId_destinacije() {
	return id_destinacije;
}
public void setId_destinacije(int id_destinacije) {
	this.id_destinacije = id_destinacije;
}
public String getNaziv_destinacije() {
	return naziv_destinacije;
}
public void setNaziv_destinacije(String naziv_destinacije) {
	this.naziv_destinacije = naziv_destinacije;
}
public Destinacija() {
	super();
	// TODO Auto-generated constructor stub
}
public Destinacija(int id_destinacije, String naziv_destinacije) {
	super();
	this.id_destinacije = id_destinacije;
	this.naziv_destinacije = naziv_destinacije;
}
@Override
public String toString() {
	return "Destinacija [id_destinacije=" + id_destinacije + ", naziv_destinacije=" + naziv_destinacije + "]";
}
   
   
}
