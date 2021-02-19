import java.util.ArrayList;
import java.util.Scanner;

public class Main {	
	public static ArrayList <Client> listeClient = new ArrayList <> ();
	public static ArrayList <Livre> listeLivre = new ArrayList <> ();
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int Option; 							
		Client C = null;
		int Code; 
		Livre L = null;
		int CodeL;	
		listeLivre.add(new Livre("Les Misérables", "Victor Hugo"));
		listeLivre.add(new Livre("Programmation avec Java", "Alain Poirier"));
		listeLivre.add(new Livre("Les mathématiques modernes", "Julie Leblanc"));
		listeLivre.add(new Livre("Science Physique", "Mohamed Rahhali"));
		listeLivre.add(new Livre("Histoire du Canada", "Étienne Laforet"));						
		do 
		{							
		System.out.println("1. Inscrire un nouveau client");
		System.out.println("2. Enregistrer un nouveau livre dans la bibliothèque ");
		System.out.println("3. Emprunter un livre");
		System.out.println("4. Retourner un livre");
		System.out.println("5. Afficher l’état d’un livre");
		System.out.println("6. Afficher les informations d’un client");
		System.out.println("7. Afficher la liste de tous les livres");
		System.out.println("8. Quitter le programme");		
		Option = input.nextInt();
	
		switch (Option) {
		
		case 1 :
			{
				
		Scanner InfoClient = new Scanner(System.in);				
		System.out.println("Nom :");
		String nom = InfoClient.nextLine();
		System.out.println("Prénom :");
		String prenom = InfoClient.nextLine();
		System.out.println("Numéro de Téléphone :");
		String telephone = InfoClient.nextLine();				
		C = new Client(nom, prenom, telephone);
		listeClient.add(0, C);				
		Code = C.getCode();				
		System.out.println("Le client est enregistrer dans la liste ");
		System.out.println(Code + " est le code de " + prenom );				
			}			
		break;				
		case 2 :
			{
				
		Scanner info = new Scanner(System.in);				
		System.out.println("Nom du livre :");
		String nomLivre = info.nextLine();
		System.out.println("Auteur :");
		String auteur = info.nextLine();				
		L = new Livre(nomLivre, auteur);
		listeLivre.add(0, L);				
		Code = L.getCode();				
		System.out.println(nomLivre + " par " + auteur + " peut être emprunter ");
		System.out.println("Son code est " + Code);				
			}			
	    break;				
	    case 3:
			{
	    Code = 0; 
	    CodeL = 0;				
		Scanner info = new Scanner(System.in);				
	    do
				{					
		System.out.println("Code du client :");
		Code = info.nextInt();					
		if (Client.listeCodeClient.contains(Code) == false)
		System.out.println("Ce client n'existe pas");
		else
				{					
		for (int i = 0; i < listeClient.size(); i ++)
					{						
		if (listeClient.get(i).getCode() == Code)
		C = listeClient.get(i);
					}					
				}				
				} while (Client.listeCodeClient.contains(Code) == false);				
		if (C.liste.size() < 4)
				{						
		do
				{						
		System.out.println("Code du livre :");
		CodeL = info.nextInt();					
		if(Livre.listeCode.contains(CodeL) == false)
		System.out.println("Ce livre n'existe pas");
		else
				   {				 		
		for (int i = 0; i < listeLivre.size(); i ++)
				{							
		if (listeLivre.get(i).getCode() == CodeL)
		L = listeLivre.get(i);
				}					
				  }					
				}					
		while (Livre.listeCode.contains(CodeL) == false);
		if (L.disponible == true)
					{				
		C.liste.add(0, L);
		L.disponible = false;				
		System.out.println("Livre emprunté");					
					}					
		else
		System.out.println("Ce livre n'est pas disponible");				
				}			
		else
		System.out.println("Le client emprunte déjà 4 livre");				
			}			
		break;				
		case 4 :			
		Code = 0; 
		CodeL = 0;				
		Scanner info = new Scanner(System.in);				
		do
				{						
		System.out.println("Code du livre :");
		CodeL = info.nextInt();					
		if (Livre.listeCode.contains(CodeL) == false)
		System.out.println("Ce livre n'a pas été trouvé dans le système.");
		else
					{					
		for (int i = 0; i < listeLivre.size(); i ++)
						{						
		if (listeLivre.get(i).getCode() == CodeL)
		listeLivre.get(i).setDisponible(true);
						}				
					}				
				} while (Livre.listeCode.contains(CodeL) == false);			
		for (int a = 0; a < listeClient.size(); a++)
				{					
		C = listeClient.get(a);				
		for (int b = 0; b < C.liste.size(); b++)
					{					
		if (C.liste.get(b).getCode() == CodeL)
						{						
		C.liste.remove(b);
		System.out.println("Ce livre est retourné");
							break;					
						}						
					}					
				}				
		break;				
		case 5 :				
		Code = 0;
		String titre = "";			
		int choix = 0;			
		info = new Scanner(System.in);				
		do
				{
		System.out.println("Choisissez une des deux options");
		System.out.println("1-Le code du livre");
		System.out.println("2-Le titre du livre");
		choix = info.nextInt();				
		if (choix == 1)
				{					
		System.out.println("Code :");
		Code = info.nextInt();					
				}					
		else
				{				
		System.out.println("Titre :");
		titre = info.nextLine();					
				}				
		if (choix != 1 && choix != 2)
		System.out.println("Veulliez choisir une des deux options ");			
				}				
		while (choix != 1 && choix != 2);				
		for (int i = 0; i < listeLivre.size(); i ++)
				{				
		if (listeLivre.get(i).getCode() == Code || listeLivre.get(i).getTitre().equals(titre))
		L = listeLivre.get(i);					
				}				
		System.out.println(L);		
		break;				
		case 6 :				
		Code = 0;				
		info = new Scanner(System.in);				
		do
				{					
		System.out.println("Code du client :");
		Code = info.nextInt();					
		if (Client.listeCodeClient.contains(Code) == false)
		System.out.println("Ce client n'existe pas");
		else
					{
		for (int i = 0; i < listeClient.size(); i ++)
						{						
		if (listeClient.get(i).getCode() == Code)
		C = listeClient.get(i);
					    }					
					}				
				} while (Client.listeCodeClient.contains(Code) == false);				
				System.out.println(C);			
	   break;				
	   case 7 : 
		   afficherListeLivre(listeLivre); 
	   break;				
	   case 8 : 				
	   System.out.println("Vous avez quitter le programme");
	   System.exit(0); 			
	   break;				
			}				
		} 		
		while (Option != 8 || Option > 8 || Option < 1);
	}
	public static void afficherListeLivre(ArrayList <Livre> l) {		
		System.out.printf("%-10s %-30s%-30s%-10s%n", "Code", "Titre", "Auteur", "Disponibilité");		
		for (Livre livre : l) {			
			System.out.println(livre);			
		}		
	}
}
