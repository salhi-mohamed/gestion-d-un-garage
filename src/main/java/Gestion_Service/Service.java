package Gestion_Service;

import java.util.ArrayList;
import Stocks.Piece_Rechange;
import Personnes.Employe;
import Personnes.Client;

public class Service {
    // Attributs
    private int idService;
    private String description;
    private double cout;
    private ArrayList<Employe> effecteurs; // Liste des employés effectuant le service
    private Client client; // Client associé au service
    private Voiture voiture; // Voiture associée au service
    private Rendez_vous rendezVous; // Rendez-vous associé au service
    private ArrayList<Piece_Rechange> piecesUtilisees; // Liste des pièces de rechange utilisées dans le service

    //constructeur


    public Service(String description, double cout, ArrayList<Employe> effecteurs, int idService, Client client, Voiture voiture, ArrayList<Piece_Rechange> piecesUtilisees, Rendez_vous rendezVous) {
        this.description = description;
        this.cout = cout;
        this.effecteurs = effecteurs;
        this.idService = idService;
        this.client = client;
        this.voiture = voiture;
        this.piecesUtilisees = piecesUtilisees;
        this.rendezVous = rendezVous;
    }

    //geter & seter


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }

    public ArrayList<Employe> getEffecteurs() {
        return effecteurs;
    }

    public void setEffecteurs(ArrayList<Employe> effecteurs) {
        this.effecteurs = effecteurs;
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

    public ArrayList<Piece_Rechange> getPiecesUtilisees() {
        return piecesUtilisees;
    }

    public void setPiecesUtilisees(ArrayList<Piece_Rechange> piecesUtilisees) {
        this.piecesUtilisees = piecesUtilisees;
    }

    public Rendez_vous getRendezVous() {
        return rendezVous;
    }

    public void setRendezVous(Rendez_vous rendezVous) {
        this.rendezVous = rendezVous;
    }


    // Méthode Afficher_Service : affiche les informations du service
    public void afficherService() {
        System.out.println(this.toString());
    }

    // Méthode Ajouter_Effecteur : ajoute un employé effecteur au service
    public void ajouterEffecteur(Employe employe) {
        effecteurs.add(employe);
    }

    // Méthode Ajouter_Piece : ajoute une pièce de rechange au service
    public void ajouterPiece(Piece_Rechange piece) {
        piecesUtilisees.add(piece);
    }

    // Méthode Supprimer_Effecteur : supprime un effecteur par son index
    public void supprimerEffecteur(int index) {
        if (index >= 0 && index < effecteurs.size()) {
            effecteurs.remove(index);
        } else {
            System.out.println("Index invalide pour la suppression de l'effecteur.");
        }
    }

    // Méthode Afficher_Rendez_vous : affiche les informations du rendez-vous associé au service
    public void afficherRendezVous() {
        if (rendezVous != null) {
            System.out.println(rendezVous.toString());
        } else {
            System.out.println("Aucun rendez-vous associé à ce service.");
        }
    }



    @Override
    public String toString() {
        return "Service{" +
                "idService=" + idService +
                ", description='" + description + '\'' +
                ", cout=" + cout +
                ", effecteurs=" + effecteurs +
                ", client=" + client +
                ", voiture=" + voiture +
                ", rendezVous=" + rendezVous +
                ", piecesUtilisees=" + piecesUtilisees +
                '}';
    }
}












