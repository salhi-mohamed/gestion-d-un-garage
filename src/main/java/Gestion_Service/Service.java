package Gestion_Service;

public class Service {
    // Attributs
    private int idService;
    private String nom;
    private String description;
    private double prix;

    // Constructeur
    public Service(int idService, String nom, String description, double prix) {
        this.idService = idService;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    // Méthodes
    public void afficherService() {
        System.out.println("ID Service: " + idService);
        System.out.println("Nom: " + nom);
        System.out.println("Description: " + description);
        System.out.println("Prix: " + prix);
    }

    public void modifier(String nom, String description, double prix) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
    }

    // Getters et Setters
    public int getIdService() {
        return idService;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public double getPrix() {
        return prix;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
