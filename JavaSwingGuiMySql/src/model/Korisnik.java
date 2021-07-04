package model;

public class Korisnik {
   public int id_korisnik;
   public String ime, prezime, korisnicko_ime, lozinka;
public Korisnik(int id_korisnik, String ime, String prezime, String korisnicko_ime, String lozinka) {
	super();
	this.id_korisnik = id_korisnik;
	this.ime = ime;
	this.prezime = prezime;
	this.korisnicko_ime = korisnicko_ime;
	this.lozinka = lozinka;
}
public Korisnik() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId_korisnik() {
	return id_korisnik;
}
public void setId_korisnik(int id_korisnik) {
	this.id_korisnik = id_korisnik;
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public String getPrezime() {
	return prezime;
}
public void setPrezime(String prezime) {
	this.prezime = prezime;
}
public String getKorisnicko_ime() {
	return korisnicko_ime;
}
public void setKorisnicko_ime(String korisnicko_ime) {
	this.korisnicko_ime = korisnicko_ime;
}
public String getLozinka() {
	return lozinka;
}
public void setLozinka(String lozinka) {
	this.lozinka = lozinka;
}
@Override
public String toString() {
	return "Korisnik [id_korisnik=" + id_korisnik + ", ime=" + ime + ", prezime=" + prezime + ", korisnicko_ime="
			+ korisnicko_ime + ", lozinka=" + lozinka + "]";
}

}
