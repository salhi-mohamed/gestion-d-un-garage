package Stocks;

public class Piece_Rechange {
    // Attributs
    private int idPiece;        // Identifiant de la pièce de rechange
    private String nom;         // Nom de la pièce de rechange
    private String description;  // Description de la pièce de rechange
    private double prix;        // Prix de la pièce de rechange
    private int quantiteStock;  // Quantité en stock de la pièce de rechange

    // Constructeur
    public Piece_Rechange(int idPiece, String nom, String description, double prix, int quantiteStock) {
        this.idPiece = idPiece;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    // Méthodes
    public void afficherPiece() {
        System.out.println("ID Pièce: " + idPiece);
        System.out.println("Nom: " + nom);
        System.out.println("Description: " + description);
        System.out.println("Prix: " + prix);
        System.out.println("Quantité en stock: " + quantiteStock);
    }

    public void modifier(String nom, String description, double prix, int quantiteStock) {
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    @Override
    public String toString() {
        return "Piece_Rechange{" +
                "idPiece=" + idPiece +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", quantiteStock=" + quantiteStock +
                '}';
    }

    // Getters et Setters (facultatifs)
    public int getIdPiece() {
        return idPiece;
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

    public int getQuantiteStock() {
        return quantiteStock;
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

    public void setQuantiteStock(int quantiteStock) {
        this.quantiteStock = quantiteStock;
    }
}
