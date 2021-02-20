import java.util.ArrayList;
import java.util.Random;

public class Livre {
	
	
	private int code;
	private String titre;
	private String auteur;
	private boolean disponible;
	
	
	public static ArrayList<Integer> listeCode = new ArrayList<Integer>(); 

	
	public Livre(String titre, String auteur) {
		Random r = new Random();
		int c;
		this.titre = titre;
		this.auteur = auteur;
		do {
				 c = r.nextInt(8999)+1000; 
				
		   } while (listeCode.contains(c));
		
		this.code = c;
		listeCode.add(c);
		this.setDisponible(true);
	}

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
		if (this.isDisponible() == true)
			return "Oui";
		else
			return
				   "Non";
	}

	
	public String toString() {
		return String.format("%-10d %-30s%-30s%-6s", code, titre, auteur, this.estDisponible());
	}
	

	public static void getListeCode() {  
		
		for (Integer code : listeCode) {
			System.out.println(code);
		}
		
	}

	public void setDisponible(boolean b) {
		
		if (b == true) {
			this.disponible = true;	
		}
		
		if (b == false) {
			this.disponible = false;	
		}
		
	}

	public boolean isDisponible() {
		return disponible;
	}

}