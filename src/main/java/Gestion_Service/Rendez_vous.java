package Gestion_Service;
import Personnes.Client;
import java.util.ArrayList;
import java.util.Date;

public class Rendez_vous {
    //attribut
   private int id_rendez_vous;
   private Date Date_rendez_vous;
   private String Description_rendez_vous;
   private boolean confirme;
   private Voiture voiture;
   private Client client;
   private ArrayList<Service> Services;

                                  //////////////////////////methodes//////////////////////////


    // constructeur
   public Rendez_vous(int id_rendez_vous, Date Date_rendez_vous, String Description_rendez_vous, boolean confirme, Voiture voiture, Client client, ArrayList<Service> Services) {
       this.id_rendez_vous = id_rendez_vous;
       this.Date_rendez_vous = Date_rendez_vous;
       this.Description_rendez_vous = Description_rendez_vous;
       this.confirme = confirme;
       this.voiture = voiture;
       this.client = client;
       this.Services = Services;
   }






   //geter et seter
    public int getId_rendez_vous() {
        return id_rendez_vous;
    }

    public void setId_rendez_vous(int id_rendez_vous) {
        this.id_rendez_vous = id_rendez_vous;
    }

    public String getDescription_rendez_vous() {
        return Description_rendez_vous;
    }

    public void setDescription_rendez_vous(String description_rendez_vous) {
        Description_rendez_vous = description_rendez_vous;
    }

    public Date getDate_rendez_vous() {
        return Date_rendez_vous;
    }

    public void setDate_rendez_vous(Date date_rendez_vous) {
        Date_rendez_vous = date_rendez_vous;
    }

    public boolean isConfirme() {
        return confirme;
    }

    public void setConfirme(boolean confirme) {
        this.confirme = confirme;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<Service> getServices() {
        return Services;
    }

    public void setServices(ArrayList<Service> services) {
        Services = services;
    }




    // Méthode pour ajouter un service

    public void ajouterService(Service service) {
        if (Services == null) {
            Services = new ArrayList<>(); // Initialiser la liste si elle est null
        }
        Services.add(service); // Ajouter le service à la liste
    }



    // Méthode pour supprimer un service par index

    public void supprimerService(int index) {
        if (Services != null && index >= 0 && index < Services.size()) {
            Services.remove(index); // Supprime le service à l'indice spécifié
        } else {
            System.out.println("Index invalide ou liste de services vide.");
        }
    }


    // Méthode pour annuler un rendez-vous
    public void annulerRendezVous() {
        this.confirme = false; // Modifier l'état de confirmation à false
        if (Services != null) {
            Services.clear(); // Vider la liste des services associés
        }
    }


    // Redéfinition de la méthode toString()
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rendez_vous {\n");
        sb.append("  id : ").append(id_rendez_vous).append("\n");
        sb.append("  date : ").append(Date_rendez_vous).append("\n");
        sb.append("  description : '").append(Description_rendez_vous).append("'\n");
        sb.append("  confirmé : ").append(confirme).append("\n");
        sb.append("  voiture : ").append(voiture).append("\n");
        sb.append("  client : ").append(client).append("\n");
        sb.append("  services : ").append(Services).append("\n");
        sb.append("}");
        return sb.toString();
    }











}
