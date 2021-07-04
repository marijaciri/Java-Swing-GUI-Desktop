package model;

import java.util.Date;

public class Putovanje {
  private int id_putovanja;
  private Korisnik korisnik;
  private Destinacija destinacija;
  private Date polazak;
  private Date povratak;
  private double cena;
  private int duzina;
  private TipPrevoza prevoz;
  
 public  Putovanje(int id_putovanja, Korisnik idKorisnik, Destinacija idDestinacija, Date polazak, Date povratak,
		 int duzina, double cena,  TipPrevoza idVrstaprevoza) {
	super();
	this.id_putovanja = id_putovanja;
	this.korisnik = idKorisnik;
	this.destinacija = idDestinacija;
	this.polazak = polazak;
	this.povratak = povratak;
	this.cena = cena;
	this.duzina = duzina;
	this.prevoz = idVrstaprevoza;
}
public Putovanje() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId_putovanja() {
	return id_putovanja;
}
public void setId_putovanja(int id_putovanja) {
	this.id_putovanja = id_putovanja;
}
public Korisnik getIdKorisnik() {
	return korisnik;
}
public void setIdKorisnik(Korisnik idKorisnik) {
	this.korisnik = idKorisnik;
}
public Destinacija getIdDestinacija() {
	return destinacija;
}
public void setIdDestinacija(Destinacija idDestinacija) {
	this.destinacija = idDestinacija;
}
public Date getPolazak() {
	return polazak;
}
public void setPolazak(Date polazak) {
	this.polazak = polazak;
}
public Date getPovratak() {
	return povratak;
}
public void setPovratak(Date povratak) {
	this.povratak = povratak;
}
public double getCena() {
	return cena;
}
public void setCena(double cena) {
	this.cena = cena;
}
public int getDuzina() {
	return duzina;
}
public void setDuzina(int duzina) {
	this.duzina = duzina;
}
public TipPrevoza getIdVrstaprevoza() {
	return prevoz;
}
public void setIdVrstaprevoza(TipPrevoza idVrstaprevoza) {
	this.prevoz = idVrstaprevoza;
}
@Override
public String toString() {
	return "Putovanje [id_putovanja=" + id_putovanja + ", idKorisnik=" + korisnik + ", idDestinacija=" + destinacija
			+ ", polazak=" + polazak + ", povratak=" + povratak + ", cena=" + cena + ", duzina=" + duzina
			+ ", idVrstaprevoza=" + prevoz + "]";
}
  
  
}
