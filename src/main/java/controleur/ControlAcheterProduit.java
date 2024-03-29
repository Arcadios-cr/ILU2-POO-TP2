package controleur;

import villagegaulois.Village;
import personnages.Gaulois;
import villagegaulois.Etal;
import java.util.Scanner;


public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] obtenirMarchand(String produit) {
		Gaulois[] listeMarchands = village.rechercherVendeursProduit(produit);
		StringBuilder chaine = new StringBuilder();
		String[] marchands = null;
		Scanner scanner = new Scanner(System.in);
		if (listeMarchands == null) {
			chaine.append("Désolé, personne ne vend ce produit au marché.\n");
		} else {
			marchands = new String[listeMarchands.length];
			chaine.append("Chez quel commerçant voulez-vous acheter des ");
			chaine.append(produit);
			chaine.append(" ?\n");
			for (int i = 0; i < listeMarchands.length; i++) {
				int j = i + 1;
				chaine.append(j);
				chaine.append(" \n- ");
				chaine.append(listeMarchands[i].getNom());
				marchands[i] = listeMarchands[i].getNom();
			}
			int choix = -1;
            boolean choixValide = false;
            while (!choixValide) {
                System.out.print(chaine);
                if (scanner.hasNextInt()) {
                    choix = scanner.nextInt();
                    if (choix >= 1 && choix <= listeMarchands.length) {
                        choixValide = true;
                    } else {
                        System.out.println("Numéro invalide. Veuillez réessayer.");
                    }
                } else {
                    System.out.println("Veuillez entrer un numéro valide.");
                    scanner.next(); 
                }
            }
		}
		System.out.println(chaine);
		return marchands;
	}

	public boolean verifierIdentite(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}

	public int acheterProduit(String nomVendeur, int quantite) {
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		return etal.acheterProduit(quantite);
	}
}
