package Personnes;
import Personnes.Client;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;
import Gestion_Service.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import Exceptions.*;


public class Receptionniste extends Employe {
    private int numeroBureau;
    private String email;
    private ArrayList<Rendez_vous> listeRendezVous; // Liste pour stocker les rendez-vous
    //listeservices
    //listeclients
    //listevoitures
    //listeemployes

    // Constructeur
    public Receptionniste(int id, String nom, String prenom, int telephone, String adresse,double salaire ,  int numeroBureau, String email) {
        super(id, nom, prenom, telephone, adresse,salaire);
        this.numeroBureau = numeroBureau;
        this.email = email;
        this.listeRendezVous = new ArrayList<>();
    }

    // Méthode pour planifier un rendez-vous
   public void PlanifierRendezVous(Client client, Voiture voiture) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Entrez l'ID du rendez-vous : ");
        int idRendezVous = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        System.out.println("La description du rendez-vous : ");
        String desc = scanner.nextLine();

        System.out.println("Confirmation du rendez-vous (confirmée/non confirmée) : ");
        String confirmationInput = scanner.nextLine();
        
        boolean confirme = confirmationInput.equalsIgnoreCase("confirmée");

        // Créer le nouveau rendez-vous avec les informations fournies
        Rendez_vous nouveauRendezVous = new Rendez_vous(idRendezVous, desc, confirme, voiture, client);
        
        // Ajouter le rendez-vous à la liste
        listeRendezVous.add(nouveauRendezVous);
        System.out.println("Rendez-vous planifié avec succès pour le client " + client.get_nom());
    }
   @Override
   public void afficher() {
    System.out.println("=== Informations du Réceptionniste ===");
    super.afficher();
    System.out.println("Numéro de Bureau : " + numeroBureau);
    System.out.println("Email : " + email);
    System.out.println("Liste des Rendez-vous :");

    if (listeRendezVous.isEmpty()) {
        System.out.println("Aucun rendez-vous programmé.");
    } else {
        for (Rendez_vous rendezVous : listeRendezVous) {
            System.out.println("-----------------------------------");
            System.out.println("ID Rendez-vous : " + rendezVous.getId_rendez_vous());
            System.out.println("Date du Rendez-vous : " + rendezVous.getDate_rendez_vous());
            System.out.println("Description : " + rendezVous.getDescription_rendez_vous());
            System.out.println("Confirmation : " + (rendezVous.isConfirme() ? "confirmée" : "non confirmée"));
            System.out.println("Voiture Concernée : " + rendezVous.getVoiture().get_immatriculation());
            System.out.println("Client Concerné : " + rendezVous.getClient().get_nom());
        }
    }
}
   public void annuler_rendez_vous() {
    if (listeRendezVous.isEmpty()) {
        System.out.println("Aucun rendez-vous à supprimer.");
        return;
    }

    System.out.println("=== Liste des Rendez-vous ===");
    for (Rendez_vous rendezVous : listeRendezVous) {
        System.out.println("ID Rendez-vous : " + rendezVous.getId_rendez_vous() +
                           ", Date : " + rendezVous.getDate_rendez_vous() +
                           ", Description : " + rendezVous.getDescription_rendez_vous() +
                           ", Confirmation : " + (rendezVous.isConfirme() ? "confirmée" : "non confirmée"));
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Entrez l'ID du rendez-vous à supprimer : ");
    int idRendezVous = scanner.nextInt();

    boolean rendezVousTrouve = false;

    for (int i = 0; i < listeRendezVous.size(); i++) {
        if (listeRendezVous.get(i).getId_rendez_vous() == idRendezVous) {
            listeRendezVous.remove(i);
            System.out.println("Rendez-vous avec l'ID " + idRendezVous + " supprimé avec succès.");
            rendezVousTrouve = true;
            break;
        }
    }

    if (!rendezVousTrouve) {
        System.out.println("Aucun rendez-vous trouvé avec l'ID fourni.");
    }
}
   @Override
public void modifier() {
    int choice;
    Scanner sc = new Scanner(System.in);

    do {
        do {
            System.out.println("Que voulez-vous modifier ?");
            System.out.println("1 : nom");
            System.out.println("2 : prenom");
            System.out.println("3 : adresse");
            System.out.println("4 : telephone");
            System.out.println("5 : salaire");
            System.out.println("6 : date d'embauche");
            System.out.println("7 : email");
            System.out.println("8 : numero de guichet");
            System.out.println("0 : quitter");

            while (!sc.hasNextInt()) {
                System.out.println("Saisie invalide, veuillez entrer un nombre entre 0 et 8.");
                sc.next(); // Consume invalid input
            }
            choice = sc.nextInt();

            if (choice < 0 || choice > 8) {
                System.out.println("Choix invalide, veuillez entrer un nombre entre 0 et 8.");
            }
        } while (choice < 0 || choice > 8);

        sc.nextLine(); // Consume the newline after nextInt()
        switch (choice) {
            case 1:
                System.out.println("Saisir le nouveau nom : ");
                super.set_nom(sc.nextLine());
                System.out.println("Nom mis à jour.");
                break;

            case 2:
                System.out.println("Saisir le nouveau prénom : ");
                super.set_prenom(sc.nextLine());
                System.out.println("Prénom mis à jour.");
                break;

            case 3:
                System.out.println("Saisir la nouvelle adresse : ");
                super.set_adresse(sc.nextLine());
                System.out.println("Adresse mise à jour.");
                break;

            case 4:
                System.out.println("Saisir le nouveau téléphone : ");
                while (!sc.hasNextInt()) {
                    System.out.println("Saisie invalide, veuillez entrer un numéro de téléphone valide.");
                    sc.next(); // Consume invalid input
                }
                super.set_telephone(sc.nextInt());
                sc.nextLine(); // Consume the newline
                System.out.println("Téléphone mis à jour.");
                break;

            case 5:
                System.out.println("Saisir le nouveau salaire : ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Saisie invalide, veuillez entrer un salaire valide.");
                    sc.next(); // Consume invalid input
                }
                set_salaire(sc.nextDouble());
                sc.nextLine(); // Consume the newline
                System.out.println("Salaire mis à jour.");
                break;

            case 6:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                boolean dateValide = false;
                while (!dateValide) {
                    System.out.println("Veuillez entrer la nouvelle date d'embauche (format: dd/MM/yyyy) : ");
                    String dateInput = sc.nextLine();
                    try {
                        set_date_embauche(LocalDate.parse(dateInput, formatter));
                        System.out.println("Date d'embauche mise à jour.");
                        dateValide = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Format de date invalide. Utilisez le format dd/MM/yyyy.");
                    }
                }
                break;

            case 7:
                System.out.println("Saisir le nouvel email : ");
                String email = sc.nextLine();
                if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    set_email(email);
                    System.out.println("Email mis à jour.");
                } else {
                    System.out.println("Format d'email invalide.");
                }
                break;

            case 8:
                System.out.println("Saisir le nouveau numéro de guichet : ");
                while (!sc.hasNextInt()) {
                    System.out.println("Saisie invalide, veuillez entrer un numéro de guichet valide.");
                    sc.next(); // Consume invalid input
                }
                set_num_bureau(sc.nextInt());
                sc.nextLine(); // Consume the newline
                System.out.println("Numéro de guichet mis à jour.");
                break;

            case 0:
                System.out.println("Quitter le menu.");
                break;
        }
    } while (choice != 0);

    sc.close(); // Close the scanner after usage
}
public void set_email(String email)
{
    this.email=email;
}
public void set_num_bureau(int num)
{
    this.numeroBureau=num;
}
public void confirmerRendezVous(Rendez_vous rendezVous) {
        Iterator<Rendez_vous> iterator = listeRendezVous.iterator();
        boolean found = false;

        try {
            while (iterator.hasNext()) {
                Rendez_vous rv = iterator.next();
                
                // Check if it's the same rendezvous
                if (rv.equals(rendezVous)) {  
                    rv.setConfirme(true); // Update the confirmation status
                    System.out.println("Le rendez-vous a été confirmé.");
                    found = true;
                    break;
                }
            }

            // If no match was found, throw a custom exception
            if (!found) {
                throw new RendezVousNotFoundException("Rendez-vous non trouvé dans la liste.");
            }

        } catch (RendezVousNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Une erreur inattendue s'est produite : " + e.getMessage());
        }



}
}

    // Autres méthodes à implémenter si besoin...
