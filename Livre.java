import java.util.ArrayList;
import java.util.Random;

public class Livre {
	
	// variables d'instances
	private int code;
	private String titre;
	private String auteur;
	private boolean disponible;
	
	// Variables de classe
	public static ArrayList<Integer> listeCode = new ArrayList<Integer>(); // les codes des livres qui sont dans la bibliotheque

	// Constructeur
	public Livre(String titre, String auteur) {
		Random r = new Random();
		int c;
		this.titre = titre;
		this.auteur = auteur;
		do {
				 c = r.nextInt(8999)+1000; // generer des code entre 1000 et 9999
				
		   } while (listeCode.contains(c));
		
		this.code = c;
		listeCode.add(c);
		this.disponible= true;
	}

	// Les méthodes get et set de la classe
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public int getCode() {
		return code;
	}

	public String estDisponible() {
		if (this.disponible == true)
			return "Oui";
		else
			return
					"Non";
	}

	
	public String toString() {
		return String.format("%-10d %-30s%-30s%-6s", code, titre, auteur, this.estDisponible());
	}
	
	// Une méthode de classe
	public static void getListeCode() {   // Integer la classe qui repr/sente les entiers
		
		for (Integer code : listeCode) {
			System.out.println(code);
		}
		
	}

}
