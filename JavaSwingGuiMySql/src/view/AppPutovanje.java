package view;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle.Control;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import controlor.Controler;
import model.Destinacija;
import model.JTableDestinacija;
import model.JTableKorisnik;
import model.JTablePutovanje;
import model.Korisnik;
import model.Putovanje;
import model.TipPrevoza;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;


public class AppPutovanje {

	private JFrame frame;
	private JTextField txtKorisnickoIme;
	private JPasswordField passwordField;
	private JPanel panel_1;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField txtDuzinaPuta;
	private JTextField txtCena;
	private JTable table;
	private ArrayList<Putovanje> listaPutovanja;
	private ArrayList<Korisnik> listaKorisnika;
	private ArrayList<Destinacija> listaDestinacija;
	private JDateChooser dateDatumPovratka;
	private JDateChooser dateDatumPolaska;
	private JRadioButton rdbtAvion;
	private JRadioButton rdbtAutobus;
	private ButtonGroup grupa;
	private JTextField textIme;
	private JTextField textPrezime;
	private JTextField textKorisnicko;
	private JTextField textLozinka;
	private JTable tableKorisnik;
	private JTextField textDestinacija;
	private JTable tableDestinacija;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppPutovanje window = new AppPutovanje();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppPutovanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	frame = new JFrame();
	frame.getContentPane().setBackground(new Color(216, 191, 216));
	frame.setBounds(100, 100, 774, 567);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(new CardLayout(0, 0));
	panel_3 = new JPanel();
	panel_3.setForeground(new Color(25, 25, 112));
    panel_3.setBackground(new Color(173, 255, 47));
    panel_2 = new JPanel();
    panel_2.setBackground(new Color(173, 255, 47));
  
	panel = new JPanel();
	panel.setBackground(new Color(173, 255, 47));
	frame.getContentPane().add(panel, "name_389192157333200");
	frame.getContentPane().add(panel_2, "name_11111");
	frame.getContentPane().add(panel_3, "name_22222");
	panel_3.setLayout(null);
	
	JLabel lblNaslov = new JLabel("DESTINACIJE");
	lblNaslov.setForeground(new Color(25, 25, 112));
	lblNaslov.setHorizontalAlignment(SwingConstants.CENTER);
	lblNaslov.setFont(new Font("Serif", Font.BOLD, 25));
	lblNaslov.setBounds(272, 17, 229, 37);
	panel_3.add(lblNaslov);
	
	JLabel lblNazivDestinacije = new JLabel("NAZIV DESTINACIJE");
	lblNazivDestinacije.setForeground(new Color(25, 25, 112));
	lblNazivDestinacije.setFont(new Font("Serif", Font.BOLD, 15));
	lblNazivDestinacije.setBounds(43, 107, 163, 28);
	panel_3.add(lblNazivDestinacije);
	
	textDestinacija = new JTextField();
	textDestinacija.setFont(new Font("Serif", Font.BOLD, 15));
	textDestinacija.setBounds(43, 146, 163, 28);
	panel_3.add(textDestinacija);
	textDestinacija.setColumns(10);
	
	JScrollPane scrollPane_1 = new JScrollPane();
	scrollPane_1.setBounds(43, 201, 671, 295);
	panel_3.add(scrollPane_1);
	
	tableDestinacija = new JTable();
	scrollPane_1.setViewportView(tableDestinacija);
	
	JButton btnIzlazD = new JButton("IZLAZ");
	btnIzlazD.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panel_3.setVisible(false);
			panel_1.setVisible(true);
		}
	});
	btnIzlazD.setIcon(new ImageIcon("D:\\IT Java materijali\\close-window.png"));
	btnIzlazD.setBounds(706, 17, 42, 37);
	panel_3.add(btnIzlazD);
	
	JButton btnDdodaj = new JButton("DODAJ");
	btnDdodaj.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String naziv= textDestinacija.getText().trim();
				Destinacija d = new Destinacija(0, naziv);
				if(!(naziv.equals(""))){
				int a = Controler.getInstanceOf().insertDestinacijaLastInsertID(d);
				d.setId_destinacije(a);
				listaDestinacija.add(d);
				updateTableDestinacija(listaDestinacija);
				JOptionPane.showMessageDialog(getContentPane(), "USPESNO STE SE UNELI DESTINACIJU!" );
			    textDestinacija.grabFocus();
			    ocistiKontrole();
				}
				else
					JOptionPane.showMessageDialog(getContentPane(), "MORATE DA UNESETE NAZIV DESTINACIJE!");
			} catch (ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(getContentPane(), "DOSLO JE DO GRESKE!"+e1.getMessage());
			}
			textDestinacija.grabFocus();
		    ocistiKontrole();
		}
	});
	btnDdodaj.setForeground(new Color(25, 25, 112));
	btnDdodaj.setFont(new Font("Serif", Font.BOLD, 15));
	btnDdodaj.setBounds(358, 138, 138, 45);
	panel_3.add(btnDdodaj);
	
	JButton btnDesSve = new JButton("PRIKAZI");
	btnDesSve.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				updateTableDestinacija(Controler.getInstanceOf().vratiuDestinacije());
			} catch (ClassNotFoundException | SQLException e3) {
				e3.printStackTrace();
			}
			
		}
	});
	btnDesSve.setForeground(new Color(25, 25, 112));
	btnDesSve.setFont(new Font("Serif", Font.BOLD, 15));
	btnDesSve.setBounds(552, 137, 138, 46);
	panel_3.add(btnDesSve);
	panel_2.setLayout(null);
	
	JLabel lblregistracija = new JLabel("REGISTRACIJA KORISNIKA");
	lblregistracija.setForeground(new Color(0, 0, 139));
	lblregistracija.setFont(new Font("Serif", Font.BOLD, 25));
	lblregistracija.setHorizontalAlignment(SwingConstants.CENTER);
	lblregistracija.setBounds(162, 11, 469, 31);
	panel_2.add(lblregistracija);
	
	JLabel lblNewLabel = new JLabel("IME");
	lblNewLabel.setForeground(new Color(25, 25, 112));
	lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel.setFont(new Font("Serif", Font.BOLD, 15));
	lblNewLabel.setBounds(47, 77, 99, 31);
	panel_2.add(lblNewLabel);
	
	JLabel lblPrezime = new JLabel("PREZIME");
	lblPrezime.setForeground(new Color(25, 25, 112));
	lblPrezime.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPrezime.setFont(new Font("Serif", Font.BOLD, 15));
	lblPrezime.setBounds(47, 125, 99, 31);
	panel_2.add(lblPrezime);
	
	JLabel lblIme = new JLabel("KORISNICKO IME");
	lblIme.setForeground(new Color(25, 25, 112));
	lblIme.setHorizontalAlignment(SwingConstants.RIGHT);
	lblIme.setFont(new Font("Serif", Font.BOLD, 15));
	lblIme.setBounds(10, 170, 136, 31);
	panel_2.add(lblIme);
	
	JLabel lblLozinka_1 = new JLabel("LOZINKA");
	lblLozinka_1.setForeground(new Color(25, 25, 112));
	lblLozinka_1.setHorizontalAlignment(SwingConstants.RIGHT);
	lblLozinka_1.setFont(new Font("Serif", Font.BOLD, 15));
	lblLozinka_1.setBounds(47, 209, 99, 31);
	panel_2.add(lblLozinka_1);
	
	textIme = new JTextField();
	textIme.setFont(new Font("Serif", Font.BOLD, 15));
	textIme.setBounds(170, 84, 190, 20);
	panel_2.add(textIme);
	textIme.setColumns(10);
	
	textPrezime = new JTextField();
	textPrezime.setFont(new Font("Serif", Font.BOLD, 15));
	textPrezime.setColumns(10);
	textPrezime.setBounds(170, 132, 190, 20);
	panel_2.add(textPrezime);
	
	textKorisnicko = new JTextField();
	textKorisnicko.setFont(new Font("Serif", Font.BOLD, 15));
	textKorisnicko.setColumns(10);
	textKorisnicko.setBounds(170, 177, 190, 20);
	panel_2.add(textKorisnicko);
	
	textLozinka = new JTextField();
	textLozinka.setFont(new Font("Serif", Font.BOLD, 15));
	textLozinka.setColumns(10);
	textLozinka.setBounds(170, 216, 190, 20);
	panel_2.add(textLozinka);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 251, 727, 267);
	panel_2.add(scrollPane);
	
	tableKorisnik = new JTable();
	scrollPane.setViewportView(tableKorisnik);
	
	JButton btDodajKontakt = new JButton("DODAJ");
	btDodajKontakt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String ime= textIme.getText().trim();
				String prezime=textPrezime.getText().trim();
				String korisnicko=textKorisnicko.getText().trim();
				String lozinka=textLozinka.getText().trim();
				
				if(!(ime.equals("")) && !(prezime.equals("")) && !(lozinka.equals("")) && !(korisnicko.equals(""))) {
					Korisnik k = new Korisnik(0, ime,prezime,korisnicko, lozinka);
					int a  = Controler.getInstanceOf().insertKorisnikLastInsertID(k);
					k.setId_korisnik(a);
		            listaKorisnika.add(k);
			        updateTableKorisnik(listaKorisnika);
			        JOptionPane.showMessageDialog(getContentPane(), "USPESNO STE SE REGISTROVALI!" );
			        textIme.grabFocus();
			        ocistiKontrole();
				       }
				   else 
				JOptionPane.showMessageDialog(getContentPane(), "MORATE UNETI SVE PODATKE!");
			} catch (ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(getContentPane(), "DOSLO JE DO GRESKE!"+e1.getMessage());
			}
			   textIme.grabFocus();
		       ocistiKontrole();
		}
	});
	btDodajKontakt.setForeground(new Color(25, 25, 112));
	btDodajKontakt.setFont(new Font("Serif", Font.BOLD, 15));
	btDodajKontakt.setBounds(479, 181, 113, 59);
	panel_2.add(btDodajKontakt);
	
	JButton btPrikazi = new JButton("PRIKAZI");
	btPrikazi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				updateTableKorisnik(Controler.getInstanceOf().vratiListuKorisnika());
			} catch (ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(getContentPane(), "DOSLO JE DO GRESKE!"+e1.getMessage());
			}
		}
	});
	btPrikazi.setForeground(new Color(25, 25, 112));
	btPrikazi.setFont(new Font("Serif", Font.BOLD, 15));
	btPrikazi.setBounds(479, 111, 113, 59);
	panel_2.add(btPrikazi);
	
	JButton btnIzlaz1 = new JButton("IZLAZ");
	btnIzlaz1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			panel_2.setVisible(false);
			panel.setVisible(true);
		}
	});
	btnIzlaz1.setIcon(new ImageIcon("D:\\IT Java materijali\\close-window.png"));
	btnIzlaz1.setBounds(706, 17, 48, 31);
	panel_2.add(btnIzlaz1);
	panel.setLayout(null);
	
	JLabel lbLoginPage = new JLabel("LOGIN PAGE");
	lbLoginPage.setForeground(new Color(25, 25, 112));
	lbLoginPage.setBackground(new Color(154, 205, 50));
	lbLoginPage.setFont(new Font("Serif", Font.BOLD, 47));
	lbLoginPage.setBounds(183, 100, 351, 55);
	panel.add(lbLoginPage);

	JLabel lblKorisnikIme = new JLabel("KORISNICKO IME:");
	lblKorisnikIme.setForeground(new Color(25, 25, 112));
	lblKorisnikIme.setFont(new Font("Modern No. 20", Font.BOLD, 25));
	lblKorisnikIme.setBounds(39, 241, 260, 33);
	panel.add(lblKorisnikIme);

	txtKorisnickoIme = new JTextField();
	txtKorisnickoIme.setFont(new Font("Serif", Font.BOLD, 25));
	txtKorisnickoIme.setBounds(337, 236, 272, 36);
	panel.add(txtKorisnickoIme);
	txtKorisnickoIme.setColumns(10);

	passwordField = new JPasswordField();
	passwordField.setFont(new Font("Serif", Font.BOLD, 25));
	passwordField.setBounds(337, 323, 272, 46);
	panel.add(passwordField);

	JLabel lblLozinka = new JLabel("LOZINKA:");
	lblLozinka.setForeground(new Color(25, 25, 112));
	lblLozinka.setFont(new Font("Modern No. 20", Font.BOLD, 25));
	lblLozinka.setBounds(39, 327, 244, 43);
	panel.add(lblLozinka);
	
		
	JButton btnUlogujSe = new JButton("ULOGUJ SE");
	btnUlogujSe.setForeground(new Color(25, 25, 112));
	btnUlogujSe.setBackground(new Color(230, 230, 250));
	btnUlogujSe.setFont(new Font("Serif", Font.BOLD, 25));
	btnUlogujSe.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				String korisnickoIme = txtKorisnickoIme.getText().toString().trim();
				String lozinka = passwordField.getText().toString().trim();
				System.out.println(korisnickoIme + "----"+ lozinka);
				if(!(korisnickoIme.equals("")) || !(lozinka.equals(""))) {
				for (Korisnik k : listaKorisnika) {
					if (k.getKorisnicko_ime().equals(korisnickoIme) && k.getLozinka().equals(lozinka)) {
						JOptionPane.showMessageDialog(null, "USPESNO STE SE LOGOVALI ");
						panel.setVisible(false);
						panel_1.setVisible(true);
						ocistiLoginKontrole();
					         }
				          }
				    if(panel.isVisible()) {
					JOptionPane.showMessageDialog(null, "POGRESNO KORISNICKO IME ILI LOZINKA! POKUSAJTE PONOVO");
					ocistiLoginKontrole();
				               }
				         }
				   else 
					JOptionPane.showMessageDialog(getContentPane(), "MORATE UNETI SVE PODATKE!");
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "DOSLO JE DO GRESKE!");
				ocistiLoginKontrole();
			}
		}
	});
	
	btnUlogujSe.setBounds(76, 435, 207, 61);
	panel.add(btnUlogujSe);
	
	JButton btnRegistracija = new JButton("REGISTRUJ SE");
	btnRegistracija.setForeground(new Color(25, 25, 112));
	btnRegistracija.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			panel.setVisible(false);
			panel_2.setVisible(true);
			
		}
	});
	btnRegistracija.setFont(new Font("Serif", Font.BOLD, 25));
	btnRegistracija.setBounds(379, 435, 230, 61);
	panel.add(btnRegistracija);

	panel_1 = new JPanel();
	panel_1.setBackground(new Color(173, 255, 47));
	frame.getContentPane().add(panel_1, "name_389206402831500");
	panel_1.setLayout(null);

	JLabel lblImePrezime = new JLabel("IME I PREZIME");
	lblImePrezime.setFont(new Font("Serif", Font.BOLD, 11));
	lblImePrezime.setHorizontalAlignment(SwingConstants.RIGHT);
	lblImePrezime.setBounds(38, 24, 98, 17);
	panel_1.add(lblImePrezime);

	JComboBox combImePrezime = new JComboBox();
	try {
		combImePrezime.setModel(izgledImePrezime());
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	combImePrezime.setBounds(164, 22, 170, 21);
	panel_1.add(combImePrezime);

	JLabel lblDestinacija = new JLabel("DESTINACIJA");
	lblDestinacija.setFont(new Font("Serif", Font.BOLD, 11));
	lblDestinacija.setHorizontalAlignment(SwingConstants.RIGHT);
	lblDestinacija.setBounds(10, 62, 126, 13);
	panel_1.add(lblDestinacija);

	JComboBox combDestinacija = new JComboBox();
	try {
		combDestinacija.setModel(izgledDestinacija());
	} catch (ClassNotFoundException e1) {
		e1.printStackTrace();
	} catch (SQLException e1) {
		e1.printStackTrace();
	}
	combDestinacija.setBounds(164, 58, 172, 21);
	panel_1.add(combDestinacija);

	dateDatumPolaska = new JDateChooser();
	dateDatumPolaska.setBounds(164, 93, 170, 19);
	panel_1.add(dateDatumPolaska);

	JLabel lblPolazak = new JLabel("DATUM POLASKA");
	lblPolazak.setFont(new Font("Serif", Font.BOLD, 11));
	lblPolazak.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPolazak.setBounds(10, 99, 126, 13);
	panel_1.add(lblPolazak);

	dateDatumPovratka = new JDateChooser();
	dateDatumPovratka.setBounds(166, 124, 170, 19);
	panel_1.add(dateDatumPovratka);

	JLabel lblPovratak = new JLabel("DATUM POVRATKA");
	lblPovratak.setFont(new Font("Serif", Font.BOLD, 11));
	lblPovratak.setHorizontalAlignment(SwingConstants.RIGHT);
	lblPovratak.setBounds(10, 130, 126, 13);
	panel_1.add(lblPovratak);

	txtDuzinaPuta = new JTextField();
	txtDuzinaPuta.setFont(new Font("Serif", Font.BOLD, 11));
	txtDuzinaPuta.setBounds(166, 163, 170, 19);
	panel_1.add(txtDuzinaPuta);
	txtDuzinaPuta.setColumns(10);

	JLabel lblDuzina = new JLabel("DUZINA PUTA");
	lblDuzina.setFont(new Font("Serif", Font.BOLD, 11));
	lblDuzina.setHorizontalAlignment(SwingConstants.RIGHT);
	lblDuzina.setBounds(10, 154, 126, 25);
	panel_1.add(lblDuzina);
	JLabel lblCena = new JLabel("CENA KARTE");
	lblCena.setFont(new Font("Serif", Font.BOLD, 11));
	lblCena.setHorizontalAlignment(SwingConstants.RIGHT);
	lblCena.setBounds(10, 201, 126, 13);
	panel_1.add(lblCena);
	txtCena = new JTextField();
	txtCena.setFont(new Font("Serif", Font.BOLD, 11));
	txtCena.setBounds(166, 198, 170, 19);
	panel_1.add(txtCena);
	txtCena.setColumns(10);
	JRadioButton rdbtAutobus = new JRadioButton("AUTOBUS");
	rdbtAutobus.setFont(new Font("Serif", Font.BOLD, 11));
	rdbtAutobus.setBounds(176, 224, 109, 23);
	panel_1.add(rdbtAutobus);
	
	JRadioButton rdbtAvion = new JRadioButton("AVION");
	rdbtAvion.setFont(new Font("Serif", Font.BOLD, 11));
	rdbtAvion.setBounds(176, 250, 109, 23);
	panel_1.add(rdbtAvion);
	grupa = new ButtonGroup();
	rdbtAutobus.setSelected(true);
	grupa.add(rdbtAvion);
	grupa.add(rdbtAutobus);
	JButton btnDodaj = new JButton("DODAJ PUTOVANJE");
	btnDodaj.setFont(new Font("Serif", Font.BOLD, 15));
	btnDodaj.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				int korisnikId = combImePrezime.getSelectedIndex() + 1;
				String imeIprezime = combImePrezime.getSelectedItem().toString();
				String [] reci = imeIprezime.split(" ", 2);
				String imeKorisnika = reci[0];
				String prezimeKorisnika = reci[1];
				Korisnik korisnik = new Korisnik();
				korisnik.setId_korisnik(korisnikId);
				korisnik.setIme(imeKorisnika);
				korisnik.setPrezime(prezimeKorisnika);
				int destinacijaId = combDestinacija.getSelectedIndex() + 1;
				Destinacija destinacija = new Destinacija();
				destinacija.setId_destinacije(destinacijaId);
				String nazivDestinacije = combDestinacija.getSelectedItem().toString();
				destinacija.setNaziv_destinacije(nazivDestinacije);
				
				Date vremePolaska = dateDatumPolaska.getDate();
				Date datumPovratka = dateDatumPovratka.getDate();				
				String duzina = txtDuzinaPuta.getText().trim();
				int duzinaPuta = Integer.parseInt(duzina);
				String cena = txtCena.getText().trim();
				Double cenaN = Double.parseDouble(cena);
				boolean autobus = rdbtAutobus.isSelected();
				TipPrevoza prevoz = new TipPrevoza();
				
				int pom =0;
				if (autobus) {
					prevoz.setVrsta_prevoza("Avion");
					prevoz.setId_tip_prevoza(1);
					pom=1;
				}
					else {
					prevoz.setVrsta_prevoza("Autobus");
					prevoz.setId_tip_prevoza(2);
					pom=2;
					}
				
				    prevoz.setId_tip_prevoza(pom);
				
				  if ((!datumPovratka.before(vremePolaska) )&& pom != 0 && cenaN>0) {
					Putovanje p = new Putovanje(0, korisnik, destinacija, vremePolaska, datumPovratka, duzinaPuta, cenaN, prevoz);
					int idPutovanja = Controler.getInstanceOf().insertPutovanjeLastInsertID(p);
					p.setId_putovanja(idPutovanja);
					listaPutovanja.add(p);
					updateTable(Controler.getInstanceOf().vratiPutovanje());
					JOptionPane.showMessageDialog(null, "USPESNO STE DODALI PUTOVANJE.");
				} else {
					JOptionPane.showMessageDialog(null, "MORATE UNETI SVA POLJA. CENA MORA BITI VECA OD NULE. PUTOVANJE MORA DA TRAJE MINIMUM JEDAN DAN.");
				}
				 ocistiKontrole();
				 rdbtAutobus.setSelected(true);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "DOSLO JE DO GRESKE PRILIKOM UNOSA PUTOVANJA!");
			    }
		     }
	     });

	btnDodaj.setBounds(381, 48, 246, 38);
	panel_1.add(btnDodaj);

	JButton btnPrikazi = new JButton("PRIKAZI SVA PUTOVANJA");
	btnPrikazi.setFont(new Font("Serif", Font.BOLD, 15));
	btnPrikazi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				updateTable(Controler.getInstanceOf().vratiPutovanje());
			} catch (ClassNotFoundException | SQLException e1) {
				JOptionPane.showMessageDialog(null, "DOSLO JE DO GRESKE! " );
			}
		}
	});
	btnPrikazi.setBounds(381, 144, 246, 38);
	panel_1.add(btnPrikazi);

	JButton btNObrisi = new JButton("OBRISI PUTOVANJE");
	btNObrisi.setFont(new Font("Serif", Font.BOLD, 15));
	btNObrisi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JTablePutovanje model = (JTablePutovanje) table.getModel();
			int brojIndexa = table.getSelectedRow();
			if (brojIndexa != -1) {
				int id = listaPutovanja.get(brojIndexa).getId_putovanja();
				try {
					Controler.getInstanceOf().deletePutovanje(id);
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				listaPutovanja.remove(brojIndexa);
				updateTable(listaPutovanja);
			} else {
				JOptionPane.showMessageDialog(null, "MORATE DA SELEKTUJETE PUTOVANJE KOJE ZELITE DA OBRISETE!");
			}
		}
	});
	btNObrisi.setBounds(381, 93, 246, 38);
	panel_1.add(btNObrisi);
	
	JLabel lblTipPrevoza = new JLabel("VRSTA PREVOZA");
	lblTipPrevoza.setFont(new Font("Serif", Font.BOLD, 11));
	lblTipPrevoza.setHorizontalAlignment(SwingConstants.RIGHT);
	lblTipPrevoza.setBounds(10, 231, 126, 38);
	panel_1.add(lblTipPrevoza);
		
		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBounds(0, 280, 768, 368);
		panel_1.add(scrollPaneTabela);
	
		table = new JTable();
		scrollPaneTabela.setViewportView(table);
		
		JButton btnIzlaz = new JButton("IZLAZ");
		btnIzlaz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
			}
		});
		btnIzlaz.setIcon(new ImageIcon("D:\\IT Java materijali\\close-window.png"));
		btnIzlaz.setFont(new Font("Serif", Font.BOLD, 15));
		btnIzlaz.setBounds(665, 11, 45, 38);
		panel_1.add(btnIzlaz);
		
		JButton btnPrikaziDestinacija = new JButton("UNESI NOVU DESTINACIJU");
		btnPrikaziDestinacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.setVisible(false);
				panel_3.setVisible(true);
			}
		});
		btnPrikaziDestinacija.setFont(new Font("Serif", Font.BOLD, 15));
		btnPrikaziDestinacija.setBounds(381, 198, 246, 38);
		panel_1.add(btnPrikaziDestinacija);
		 try {
				listaPutovanja = Controler.getInstanceOf().vratiPutovanje();
			} catch (ClassNotFoundException | SQLException e5) {
				e5.printStackTrace();
			}
		
			try {
				listaKorisnika = Controler.getInstanceOf().vratiListuKorisnika();
			} catch (ClassNotFoundException | SQLException e4) {
				e4.printStackTrace();
			}
	     try {
				listaDestinacija= Controler.getInstanceOf().vratiuDestinacije();
			} catch (ClassNotFoundException | SQLException e3) {
				e3.printStackTrace();
			}
		
		
}

     protected Component getContentPane() {
		return null;
	}

	DefaultComboBoxModel izgledImePrezime() throws ClassNotFoundException, SQLException {
	 DefaultComboBoxModel izgled = new DefaultComboBoxModel();
	  ArrayList<Korisnik> listaKorisnika = Controler.getInstanceOf().vratiListuKorisnika();
	  for (Korisnik k : listaKorisnika) {
		  izgled.addElement(k.getIme() + " " + k.getPrezime());
	                   }
	      return izgled;
        }

     DefaultComboBoxModel izgledDestinacija() throws ClassNotFoundException, SQLException {
	 DefaultComboBoxModel izgled = new DefaultComboBoxModel();
	ArrayList<Destinacija> listaDestinacija = Controler.getInstanceOf().vratiuDestinacije();
	for (Destinacija d : listaDestinacija) {
		izgled.addElement(d.getNaziv_destinacije());
	               }
	     return izgled;
         }
    
   private void updateTable(ArrayList<Putovanje> l) {
	      try {
		JTablePutovanje model = new JTablePutovanje(l);
		table.setModel(model);
	     } catch (Exception e) {
		JOptionPane.showMessageDialog(null, "DOSLO JE DO GRESKE!");
	           }
          }
   private void updateTableKorisnik(ArrayList<Korisnik> k) {
	   try {
			JTableKorisnik model = new JTableKorisnik(k);
			tableKorisnik.setModel(model);
		     } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DOSLO JE DO GRESKE!");
		           }
	   
   }
   private void updateTableDestinacija(ArrayList<Destinacija> d) {
	   try {
			JTableDestinacija model = new JTableDestinacija(d);
			tableDestinacija.setModel(model);
		     } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DOSLO JE DO GRESKE!");
		           }
	   
   }
   
      private void ocistiKontrole() {
       dateDatumPolaska.setCalendar(null);
       dateDatumPovratka.setCalendar(null);
	   txtCena.setText("");
	   txtDuzinaPuta.setText("");
	   txtCena.setText("");
	   textIme.setText("");
	   textPrezime.setText("");
	   textKorisnicko.setText("");
	   textLozinka.setText("");
	   textDestinacija.setText("");
	
              }

    private void ocistiLoginKontrole() {
	 txtKorisnickoIme.setText("");
	 passwordField.setText("");
        }
}

