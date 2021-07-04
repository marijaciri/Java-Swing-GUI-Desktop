package model;

public class TipPrevoza {
  private int id_tip_prevoza;
  private String vrsta_prevoza;
public TipPrevoza() {
	super();
	// TODO Auto-generated constructor stub
}
public TipPrevoza(int id_tip_prevoza, String vrsta_prevoza) {
	super();
	this.id_tip_prevoza = id_tip_prevoza;
	this.vrsta_prevoza = vrsta_prevoza;
}
public int getId_tip_prevoza() {
	return id_tip_prevoza;
}
public void setId_tip_prevoza(int id_tip_prevoza) {
	this.id_tip_prevoza = id_tip_prevoza;
}
public String getVrsta_prevoza() {
	return vrsta_prevoza;
}
public void setVrsta_prevoza(String vrsta_prevoza) {
	vrsta_prevoza = "Autobus";
}
@Override
public String toString() {
	return "TipPrevoza [id_tip_prevoza=" + id_tip_prevoza + ", vrsta_prevoza=" + vrsta_prevoza + "]";
}
  
}
