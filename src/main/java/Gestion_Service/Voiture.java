package Gestion_Service;
import Personnes.Client;
import java.util.ArrayList;

public class Voiture {

    // Attributs
    private String marque;
    private String modele;
    private int annee;
    private long kilometrage;
    private String immatriculation; // Ajout de l'attribut immatriculation
    private Client client;
   // private ArrayList<Service> services;

    // Constructeur
    public Voiture(String marque, String modele, int annee, long kilometrage, String immatriculation , Client client ) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.kilometrage = kilometrage;
        this.immatriculation = immatriculation;
        this.client=client;
     //   this.services=new ArrayList<Service>();
    }

    ////////////////////////// Méthodes //////////////////////////

    // Méthode pour afficher les informations de la voiture
    public void afficher() {
        System.out.println("=== Informations de la Voiture ===");
        System.out.println("Marque : " + marque);
        System.out.println("Modèle : " + modele);
        System.out.println("Année : " + annee);
        System.out.println("Kilométrage : " + kilometrage);
        System.out.println("Immatriculation : " + immatriculation);
        System.out.println("Client : " + client.get_id());
       // System.out.println("Services réalisés : " + services);
    }

    // Méthode pour modifier les informations de la voiture
    
    //modifier voiture 
    

    // Méthode pour ajouter un service
    /*public void ajouterService(Service service) {
        services.add(service);
        System.out.println("Service ajouté avec succès à la voiture.");
    }*/

    // Méthode pour supprimer le dernier service ajouté
    /*public void supprimerService() {
        if (!services.isEmpty()) {
            services.remove(services.size() - 1);
            System.out.println("Le dernier service a été supprimé avec succès.");
        } else {
            System.out.println("Aucun service à supprimer.");
        }
    }
*/
    // Méthode pour afficher le client propriétaire de la voiture
    public void afficherClient() {
        System.out.println("=== Informations du Client Propriétaire ===");
        System.out.println(client);
    }

    // Méthode pour calculer le coût total d'entretien annuel de la voiture
  /*  public double coutEntretienAnnuel() {
        double total = 0;
        for (Service service : services) {
            total += service.getCout();
        }
        return total;
    }*/

    @Override
    public String toString() {
        return "Voiture{" +
                "marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", annee=" + annee +
                ", kilometrage=" + kilometrage +
                ", immatriculation='" + immatriculation + '\'' +
                ", client=" + client.get_id() +
       //         ", services=" + services +
                '}';
    }
    public String get_immatriculation()
    {
        return this.immatriculation;
    }
    
}
