import java.util.ArrayList;
import java.util.Random;

public class Client {

	private int code;
	private String nom;
	private String prenom;
	private String telephone;
	public ArrayList<Livre> liste = new ArrayList<>();
	public static ArrayList<Integer> listeCodeClient = new ArrayList<Integer>();

	public Client(String nom, String prenom, String telephone) {

		Random r = new Random();
		int code;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;

		do {
			code = r.nextInt(8999) + 1000;
		} while (listeCodeClient.contains(code));
		this.code = code;
		listeCodeClient.add(code);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPreom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return telephone;
	}

	public void setTel(String tel) {
		this.telephone = tel;
	}

	public int getCode() {
		return code;
	}

	public int livresEmprunté() {
		return liste.size();
	}

	public String afficherListeLivre() {
		String s = String.format("%-10s %-30s%-30s%n", "Code", "Titre", "Auteur");
		for (Livre livre : liste) {
			s += String.format("%-10d %-30s%-30s%n", livre.getCode(), livre.getTitre(), livre.getAuteur());
		}
		return s;
	}

	public String toString() {

		return String.format(" %d%nNom : %s%nPrénom : %s%nTéléphone : %s%nLivres empruntés : %ns%s", this.code,
				this.nom, this.prenom, this.telephone, this.afficherListeLivre());
	}
}