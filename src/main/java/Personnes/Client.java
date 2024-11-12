package Personnes;
import java.util.Scanner;
import Stocks.Fourniture;
import java.util.ArrayList;

import java.util.InputMismatchException;

import java.util.HashSet;
import Gestion_Service.Voiture;
import Exceptions.*;

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
   public void ajouterVoiture(Voiture voiture) throws VoitureDejaExistanteClientException {
    for (Voiture v : this.getVoitures()) {
        if (v.get_immatriculation().equals(voiture.get_immatriculation())) {
            throw new VoitureDejaExistanteClientException("Cette voiture existe déjà pour ce client.");
        }
    }
    this.voitures.add(voiture);
}
    

    // Retirer une voiture du client
 public void retirerVoiture(String immatriculation) throws VoitureNonTrouveeClientException, ArgumentInvalideException {
    if (immatriculation == null || immatriculation.isEmpty()) {
        throw new ArgumentInvalideException("L'immatriculation fournie est invalide.");
    }

    boolean voitureTrouvee = false;
    for (Voiture v : this.getVoitures()) {
        if (v.get_immatriculation().equals(immatriculation)) {
            this.voitures.remove(v);
            voitureTrouvee = true;
            break;
        }
    }

    if (!voitureTrouvee) {
        throw new VoitureNonTrouveeClientException("Aucune voiture trouvée avec l'immatriculation : " + immatriculation);
    }
}
 public void afficherVoitures() throws VoituresNonDisponiblesClientException {
        if (this.getVoitures() == null || this.getVoitures().isEmpty()) {
            throw new VoituresNonDisponiblesClientException("Aucune voiture disponible pour ce client.");
        }

        System.out.println("Liste des voitures de " + this.get_nom() + " " + this.get_prenom() + ":");
        for (Voiture voiture : this.getVoitures()) {
            System.out.println(voiture);
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
