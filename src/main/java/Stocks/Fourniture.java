package Stocks;

public class Fourniture {
    private int idFourniture;
    private String nom;
    private String description;
    private double prix;
    private int quantiteStock;

    // Constructeur
    public Fourniture(int idFourniture, String nom, String description, double prix, int quantiteStock) {
        this.idFourniture = idFourniture;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    // Getters et Setters
    public int getIdFourniture() {
        return idFourniture;
    }

    public void setIdFourniture(int idFourniture) {
        this.idFourniture = idFourniture;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantiteStock() {
        return quantiteStock;
    }

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    // Méthode pour modifier les informations de la fourniture
    public void modifier(String nouveauNom, String nouvelleDescription, double nouveauPrix, int nouvelleQuantiteStock) {
        this.nom = nouveauNom;
        this.description = nouvelleDescription;
        this.prix = nouveauPrix;
        this.quantiteStock = nouvelleQuantiteStock;
        System.out.println("Les informations de la fourniture ont été mises à jour.");
    }

    // Méthode pour afficher les informations de la fourniture
    public void afficherFourniture() {
        System.out.println("ID Fourniture: " + idFourniture);
        System.out.println("Nom: " + nom);
        System.out.println("Description: " + description);
        System.out.println("Prix: " + prix);
        System.out.println("Quantité en stock: " + quantiteStock);
    }
}
