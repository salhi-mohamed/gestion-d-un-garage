/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnes;
import Gestion_Service.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Exception;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;



/**
 *
 * @author LENOVO
 */
public class Mecanicien extends Employe{
       public String specialite;
       public ArrayList<Voiture> historique_voitures;
     public Mecanicien(int id, String nom, String prenom, int telephone, String adresse, double salaire, String specialite) {
        // Appel du constructeur de la classe Employe
        super(id, nom, prenom, telephone, adresse, salaire);
        
        // Initialisation des attributs spécifiques à Mecanicien
        this.specialite = specialite;
        
        // Initialisation de la liste de voitures (Historique_voitures)
        this.historique_voitures = new ArrayList<Voiture>(); // Important : spécifier le type Voiture
    }
       public void ajouter_voiture(Voiture voiture) {
        try {
            if (voiture == null) {
                throw new Exception("Impossible d'ajouter une voiture nulle à l'historique.");
            }
            this.historique_voitures.add(voiture); // Ajoute la voiture si elle est valide
        } catch (Exception e) {
            System.out.println("Erreur lors de l'ajout de la voiture : " + e.getMessage());
        }
    }
    
     

public void supprimer_voiture() {
    try {
        // Vérifier si l'historique est vide
        if (this.historique_voitures.isEmpty()) {
            throw new Exception("L'historique des voitures est vide, impossible de supprimer.");
        }

        // Afficher les voitures numérotées avec leur immatriculation
        System.out.println("Liste des voitures dans l'historique :");
        for (int i = 0; i < historique_voitures.size(); i++) {
            System.out.print((i + 1) + ": ");
            historique_voitures.get(i).afficherVoiture(); // Affiche les détails de la voiture
            System.out.println(); // Nouvelle ligne
        }

        // Demander à l'utilisateur de saisir l'immatriculation de la voiture à supprimer
        Scanner scanner = new Scanner(System.in);
        System.out.print("Veuillez saisir l'immatriculation de la voiture à supprimer : ");
        String immatriculation = scanner.nextLine();

        // Chercher la voiture par immatriculation
        Voiture voitureASupprimer = null;
        for (Voiture voiture : historique_voitures) {
            if (voiture.get_immatriculation().equals(immatriculation)) {
                voitureASupprimer = voiture;
                break;
            }
        }

        // Si la voiture n'a pas été trouvée
        if (voitureASupprimer == null) {
            throw new Exception("Aucune voiture trouvée avec cette immatriculation.");
        }

        // Supprimer la voiture trouvée
        this.historique_voitures.remove(voitureASupprimer);
        System.out.println("La voiture a été supprimée avec succès.");
        
    } catch (Exception e) {
        System.out.println("Erreur lors de la suppression de la voiture : " + e.getMessage());
    }
}

public void afficher()
{
    super.afficher();
    System.out.println("Spécialité : "+ this.get_specialite());
    this.afficherHistoriqueVoitures();
}

      public void set_specialite(String specialite)
      {
          this.specialite=specialite;
      }
      public void set_historique_voitures(ArrayList<Voiture> voitures)
      {
          this.historique_voitures=voitures;
      }
    public String get_specialite()
    {
        return this.specialite;
    }
    public ArrayList<Voiture> get_historique_voitures()
    {
        return this.historique_voitures;
    }
    public void afficherHistoriqueVoitures() {
    try {
        if (historique_voitures.isEmpty()) {
            System.out.println("Aucune voiture dans l'historique.");
            return; // Sort de la méthode si l'historique est vide
        }

        System.out.println("Historique des voitures :");
        for (Voiture voiture : historique_voitures) {
            // Appelle la méthode afficherVoiture de la classe Voiture
            voiture.afficherVoiture();
            System.out.println(); // Ajoute une ligne vide pour séparer chaque voiture
        }
    } catch (Exception e) {
        System.out.println("Une erreur s'est produite lors de l'affichage de l'historique : " + e.getMessage());
    }}
    
    @Override
    public void modifier() {
        int choice;
        Scanner sc = new Scanner(System.in);

        do {
            // Menu pour modifier les informations
            System.out.println("Que voulez-vous modifier ?");
            System.out.println("1 : nom");
            System.out.println("2 : prénom");
            System.out.println("3 : adresse");
            System.out.println("4 : téléphone");
            System.out.println("5 : salaire");
            System.out.println("6 : date d'embauche");
            System.out.println("7 : spécialité");
            System.out.println("0 : quitter");

            // Vérifier que l'entrée est bien un entier
            while (!sc.hasNextInt()) {
                System.out.println("Saisie invalide, veuillez entrer un nombre entre 0 et 7.");
                sc.next(); // Consomme l'entrée invalide
            }
            choice = sc.nextInt();

            // Vérifier si l'entier est dans la plage valide (0 à 7)
            if (choice < 0 || choice > 7) {
                System.out.println("Choix invalide, veuillez entrer un nombre entre 0 et 7.");
                continue; // Retourne au début de la boucle pour un nouveau choix
            }

            // Traiter le choix valide
            sc.nextLine(); // Consommer le retour de ligne restant après nextInt()
            switch (choice) {
                case 1:
                    System.out.println("Saisir le nouveau nom : ");
                    String new_name = sc.nextLine();
                    super.set_nom(new_name);
                    System.out.println("Nom mis à jour.");
                    break;

                case 2:
                    System.out.println("Saisir le nouveau prénom : ");
                    String new_firstname = sc.nextLine();
                    super.set_prenom(new_firstname);
                    System.out.println("Prénom mis à jour.");
                    break;

                case 3:
                    System.out.println("Saisir la nouvelle adresse : ");
                    String new_address = sc.nextLine();
                    super.set_adresse(new_address);
                    System.out.println("Adresse mise à jour.");
                    break;

                case 4:
                    System.out.println("Saisir le nouveau téléphone : ");
                    int new_telephone = sc.nextInt();
                    super.set_telephone(new_telephone);
                    System.out.println("Téléphone mis à jour.");
                    break;

                case 5:
                    System.out.println("Saisir le nouveau salaire : ");
                    double new_salary = sc.nextDouble();
                    super.set_salaire(new_salary);
                    System.out.println("Salaire mis à jour.");
                    break;

                case 6:
                    System.out.println("Saisir la nouvelle date d'embauche (format: dd/MM/yyyy) : ");
                    String dateInput = sc.nextLine();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    try {
                        LocalDate newDateEmbauche = LocalDate.parse(dateInput, formatter);
                        super.set_date_embauche(newDateEmbauche);
                        System.out.println("Date d'embauche mise à jour.");
                    } catch (DateTimeParseException e) {
                        System.out.println("Format de date invalide. Utilisez le format dd/MM/yyyy.");
                    }
                    break;

                case 7:
                    System.out.println("Saisir la nouvelle spécialité : ");
                    String nouvelleSpecialite = sc.nextLine();
                    this.specialite = nouvelleSpecialite;
                    System.out.println("Spécialité mise à jour.");
                    break;

                case 0:
                    System.out.println("Sortie du menu de modification.");
                    break;

                default:
                    System.out.println("Choix invalide.");
                    break;
            }

        } while (choice != 0); // Répète jusqu'à ce que l'utilisateur choisisse de quitter
    }
    @Override 
     public String toString() {
    return super.toString() + "\n" + "specialite : "+this.specialite;
    }
}

    
            
    

