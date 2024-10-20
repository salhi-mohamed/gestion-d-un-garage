
package com.mycompany.garage_manager;
import Gestion_Service.Service;
import Gestion_Service.Voiture;
import Gestion_Service.Rendez_vous;

import Personnes.Client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Garage_Manager {

    public static void main(String[] args) {
 /*
       ////////////////test du classe rendez_vous/////////////////////////////////
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Saisie des données du rendez-vous
        System.out.print("Entrez l'ID du rendez-vous : ");
        int idRendezVous = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        System.out.print("Entrez la date du rendez-vous (format: yyyy-MM-dd HH:mm:ss) : ");
        String dateString = scanner.nextLine();
        Date dateRendezVous = null;
        try {
            dateRendezVous = formatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Format de date invalide. Utilisation de la date actuelle.");
            dateRendezVous = new Date(); // Utiliser la date actuelle si l'entrée est invalide
        }

        System.out.print("Entrez la description du rendez-vous : ");
        String description = scanner.nextLine();

        System.out.print("Le rendez-vous est-il confirmé ? (true/false) : ");
        boolean confirme = scanner.nextBoolean();
        scanner.nextLine(); // Consommer la nouvelle ligne

        // Création des objets fictifs pour voiture et client
        System.out.print("Entrez l'immatriculation de la voiture : ");
        String immatriculation = scanner.nextLine();
        System.out.print("Entrez la marque de la voiture : ");
        String marque = scanner.nextLine();
        System.out.print("Entrez le modèle de la voiture : ");
        String modele = scanner.nextLine();
        System.out.print("Entrez l'année de la voiture : ");
        int annee = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        Voiture voiture = new Voiture(immatriculation, marque, modele, annee);

        System.out.print("Entrez l'ID du client : ");
        int idClient = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne
        System.out.print("Entrez le nom du client : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez l'adresse du client : ");
        String adresse = scanner.nextLine();
        System.out.print("Entrez le téléphone du client : ");
        String telephone = scanner.nextLine();

        Client client = new Client(idClient, nom, adresse, telephone);

        // Initialisation de la liste de services
        ArrayList<Service> services = new ArrayList<>();
        System.out.print("Combien de services voulez-vous ajouter ? ");
        int nombreServices = scanner.nextInt();
        scanner.nextLine(); // Consommer la nouvelle ligne

        for (int i = 0; i < nombreServices; i++) {
            System.out.print("Entrez l'ID du service " + (i + 1) + " : ");
            int idService = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne
            System.out.print("Entrez le nom du service " + (i + 1) + " : ");
            String nomService = scanner.nextLine();
            System.out.print("Entrez la description du service " + (i + 1) + " : ");
            String descriptionService = scanner.nextLine();
            System.out.print("Entrez le prix du service " + (i + 1) + " : ");
            double prixService = scanner.nextDouble();
            scanner.nextLine(); // Consommer la nouvelle ligne

            services.add(new Service(idService, nomService, descriptionService, prixService));
        }

        // Création d'un rendez-vous
        Rendez_vous rendezVous = new Rendez_vous(idRendezVous, dateRendezVous, description, confirme, voiture, client, services);

        // Affichage de l'objet rendezVous
        System.out.println("\nInformations du rendez-vous :");
        System.out.println(rendezVous.toString());

        // Test de la méthode Ajouter_Service
        System.out.print("\nVoulez-vous ajouter un service ? (true/false) : ");
        boolean ajouterService = scanner.nextBoolean();
        scanner.nextLine(); // Consommer la nouvelle ligne

        if (ajouterService) {
            System.out.print("Entrez l'ID du nouveau service : ");
            int nouveauIdService = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne
            System.out.print("Entrez le nom du nouveau service : ");
            String nouveauNomService = scanner.nextLine();
            System.out.print("Entrez la description du nouveau service : ");
            String nouvelleDescriptionService = scanner.nextLine();
            System.out.print("Entrez le prix du nouveau service : ");
            double nouveauPrixService = scanner.nextDouble();
            scanner.nextLine(); // Consommer la nouvelle ligne

            Service nouveauService = new Service(nouveauIdService, nouveauNomService, nouvelleDescriptionService, nouveauPrixService);
            rendezVous.ajouterService(nouveauService);
            System.out.println("\nAprès ajout d'un service :");
            System.out.println(rendezVous.toString());
        }

        // Test de la méthode Supprimer_Service
        System.out.print("\nVoulez-vous supprimer un service ? (true/false) : ");
        boolean supprimerService = scanner.nextBoolean();
        if (supprimerService) {
            System.out.print("Entrez l'index du service à supprimer (0 à " + (services.size() - 1) + ") : ");
            int indexASupprimer = scanner.nextInt();
            rendezVous.supprimerService(indexASupprimer); // Suppression du service
            System.out.println("\nAprès suppression d'un service :");
            System.out.println(rendezVous.toString());
        }

        // Test de la méthode Annuler_Rendez_Vous
        System.out.print("\nVoulez-vous annuler le rendez-vous ? (true/false) : ");
        boolean annuler = scanner.nextBoolean();
        if (annuler) {
            rendezVous.annulerRendezVous();
            System.out.println("\nAprès annulation du rendez-vous :");
            System.out.println(rendezVous.toString());
        }

        scanner.close(); // Ferme le scanner
            
*/
        
        
    }
}
