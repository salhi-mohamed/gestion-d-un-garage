package Gestion_Service;

import Personnes.Client;
import Personnes.Employe;
import Stocks.Piece_Rechange;

import java.util.ArrayList;

public class Service {
    // Attributs
   private int IdService;
   private String Description;
   private double Cout;
   private ArrayList<Employe> Effecteurs;
   private Client client;
   private Voiture voiture;
   private Rendez_vous rendez_vous;
   private ArrayList<Piece_Rechange> Piece_Utilises;

   //constructeur
   public Service(int idService, String description, double cout, ArrayList<Employe> effecteurs, Client client, Voiture voiture, Rendez_vous rendez_vous, ArrayList<Piece_Rechange> piece_Utilises) {
       this.IdService = idService;
       this.Description = description;
       this.Cout = cout;
       this.Effecteurs = effecteurs;
       this.client = client;
       this.voiture = voiture;
       this.rendez_vous = rendez_vous;
       this.Piece_Utilises = piece_Utilises;
   }



    //geters et setres


    public int getIdService() {
        return IdService;
    }

    public void setIdService(int idService) {
        IdService = idService;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public double getCout() {
        return Cout;
    }

    public void setCout(double cout) {
        Cout = cout;
    }

    public ArrayList<Employe> getEffecteurs() {
        return Effecteurs;
    }

    public void setEffecteurs(ArrayList<Employe> effecteurs) {
        Effecteurs = effecteurs;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Voiture getVoiture() {
        return voiture;
    }

    public void setVoiture(Voiture voiture) {
        this.voiture = voiture;
    }

    public Rendez_vous getRendez_vous() {
        return rendez_vous;
    }

    public void setRendez_vous(Rendez_vous rendez_vous) {
        this.rendez_vous = rendez_vous;
    }

    public ArrayList<Piece_Rechange> getPiece_Utilises() {
        return Piece_Utilises;
    }

    public void setPiece_Utilises(ArrayList<Piece_Rechange> piece_Utilises) {
        Piece_Utilises = piece_Utilises;
    }
   //methode pour modifier le service
    public void modifierService(Service service) {
        if (service != null) {
            this.IdService = service.getIdService();  // Modifier l'ID du service
            this.Description = service.getDescription();  // Modifier la description
            this.Cout = service.getCout();  // Modifier le coût
            this.Effecteurs = service.getEffecteurs();  // Modifier la liste des effecteurs
            this.client = service.getClient();  // Modifier le client associé
            this.voiture = service.getVoiture();  // Modifier la voiture associée
            this.rendez_vous = service.getRendez_vous();  // Modifier le rendez-vous associé
            this.Piece_Utilises = service.getPiece_Utilises();  // Modifier la liste des pièces utilisées
        } else {
            System.out.println("Le service fourni est nul.");
        }
    }
    //methode pour afficher le service

    public void afficherService() {
        System.out.println("ID Service: " + IdService);
        System.out.println("Description: " + Description);
        System.out.println("Coût: " + Cout);

        if (Effecteurs != null && !Effecteurs.isEmpty()) {
            System.out.println("Effecteurs:");
            for (Employe employe : Effecteurs) {
                System.out.println(" - " + employe);
            }
        } else {
            System.out.println("Aucun effecteur assigné.");
        }

        if (client != null) {
            System.out.println("Client: " + client.getNom());
        } else {
            System.out.println("Aucun client assigné.");
        }

        if (voiture != null) {
            System.out.println("Voiture: " + voiture.getImmatriculation());
        } else {
            System.out.println("Aucune voiture assignée.");
        }

        if (Piece_Utilises != null && !Piece_Utilises.isEmpty()) {
            System.out.println("Pièces Utilisées:");
            for (Piece_Rechange piece : Piece_Utilises) {
                System.out.println(" - " + piece);
            }
        } else {
            System.out.println("Aucune pièce utilisée.");
        }
    }


}
