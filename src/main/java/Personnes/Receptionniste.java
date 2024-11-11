package Personnes;
import Personnes.Client;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;
import Gestion_Service.*;

public class Receptionniste extends Employe {
    private int numeroBureau;
    private String email;
    private ArrayList<Rendez_vous> listeRendezVous; // Liste pour stocker les rendez-vous

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
   public void AfficherReceptionniste() {
    System.out.println("=== Informations du Réceptionniste ===");
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


}

    // Autres méthodes à implémenter si besoin...
