package Personnes;
import java.util.Scanner;
import Stocks.Fourniture;
import java.util.ArrayList;

import java.util.InputMismatchException;

import java.util.HashSet;
import Gestion_Service.Voiture;

public class Client extends Personne {
    private HashSet<Voiture> voitures;  // Liste des voitures du client
    private String statutFinancier;  
    private ArrayList<Fourniture>  fournitures_achetees ;// Statut financier du client

    // Constructeur
    public Client(int id, String nom, String prenom, int telephone, String adresse, String statutFinancier) {
        super(id, nom, prenom, telephone, adresse);
        this.voitures = new HashSet<>();
        this.statutFinancier = statutFinancier;
    }

    // Getters et setters
    public HashSet<Voiture> getVoitures() {
        return voitures;
    }

    public void setVoitures(HashSet<Voiture> voitures) {
        this.voitures = voitures;
    }

    public String getStatutFinancier() {
        return statutFinancier;
    }

    public void setStatutFinancier(String statutFinancier) {
        this.statutFinancier = statutFinancier;
    }

    // Ajouter une voiture au client
    public void ajouterVoiture(Voiture voiture) {
        this.voitures.add(voiture);
    }
    

    // Retirer une voiture du client
  public void retirerVoiture(String immatriculation) {
    try {
        // Parcours du HashSet des voitures du client
        Voiture voitureARetirer = null;
        for (Voiture voiture : voitures) {
            if (voiture.get_immatriculation().equals(immatriculation)) {
                voitureARetirer = voiture;
                break; // Trouvé, on sort de la boucle
            }
        }

        // Si la voiture a été trouvée, on la retire
        if (voitureARetirer != null) {
            if (voitures.remove(voitureARetirer)) {
                System.out.println("La voiture avec l'immatriculation " + immatriculation + " a été retirée.");
            } else {
                throw new Exception("La voiture n'a pas pu être retirée.");
            }
        } else {
            throw new Exception("Aucune voiture avec l'immatriculation " + immatriculation + " n'a été trouvée.");
        }
    } catch (Exception e) {
        // Gérer l'exception en affichant un message d'erreur
        System.out.println("Erreur : " + e.getMessage());
    }
}


@Override
public void modifier() {
    Scanner scanner = new Scanner(System.in);
    int choix;

    do {
        // Afficher le menu de modification
        System.out.println("\nMenu de modification :");
        System.out.println("1. Modifier le nom");
        System.out.println("2. Modifier le prénom");
        System.out.println("3. Modifier le téléphone");
        System.out.println("4. Modifier l'adresse");
        System.out.println("5. Modifier le statut financier");
        System.out.println("6. Quitter");
        System.out.print("Choisissez une option (1-6): ");

        // Contrôle de saisie pour choisir une option
        while (true) {
            try {
                choix = scanner.nextInt();
                if (choix < 1 || choix > 6) {
                    System.out.print("Choix invalide. Veuillez entrer un nombre entre 1 et 6: ");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.print("Entrée invalide. Veuillez entrer un nombre entier: ");
                scanner.next(); // Nettoyer l'entrée
            }
        }

        scanner.nextLine(); // Consommer le retour à la ligne restant

        switch (choix) {
            case 1:
                // Modifier le nom
                System.out.print("Entrez le nouveau nom: ");
                String nouveauNom = scanner.nextLine();
                this.set_nom(nouveauNom);  // Utilisation du setter de la classe Personne
                System.out.println("Nom modifié avec succès.");
                break;

            case 2:
                // Modifier le prénom
                System.out.print("Entrez le nouveau prénom: ");
                String nouveauPrenom = scanner.nextLine();
                this.set_prenom(nouveauPrenom);  // Utilisation du setter de la classe Personne
                System.out.println("Prénom modifié avec succès.");
                break;

            case 3:
                // Modifier le téléphone
                System.out.print("Entrez le nouveau téléphone: ");
                int nouveauTelephone = scanner.nextInt();
                this.set_telephone(nouveauTelephone);  // Utilisation du setter de la classe Personne
                System.out.println("Téléphone modifié avec succès.");
                break;

            case 4:
                // Modifier l'adresse
                System.out.print("Entrez la nouvelle adresse: ");
                String nouvelleAdresse = scanner.nextLine();
                this.set_adresse(nouvelleAdresse);  // Utilisation du setter de la classe Personne
                System.out.println("Adresse modifiée avec succès.");
                break;

            case 5:
                // Modifier le statut financier
                System.out.print("Entrez le nouveau statut financier: ");
                String nouveauStatut = scanner.nextLine();
                this.statutFinancier = nouveauStatut;
                System.out.println("Statut financier modifié avec succès.");
                break;

            case 6:
                // Quitter
                System.out.println("Sortie du menu.");
                break;

            default:
                System.out.println("Option invalide.");
                break;
        }

    } while (choix != 6); // Répéter jusqu'à ce que l'utilisateur choisisse de quitter
}


    // Redéfinition de la méthode toString() pour afficher les informations du client
    @Override
    public String toString() {
        return super.toString() + "\n" + "Statut financier : " + this.statutFinancier + "\n" + 
               "Voitures : " + this.voitures.toString();
    }
}
