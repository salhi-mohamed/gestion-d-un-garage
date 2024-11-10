package Stocks;

public class Piece_Rechange {

    // Attributs
    private int idPiece;
    private String nom;
    private String description;
    private double prix;
    private int quantiteStock;


    //constucteur


    public Piece_Rechange(int idPiece, String nom, String description, double prix, int quantiteStock) {
        this.idPiece = idPiece;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
    }

    //geters & seters

    public int getIdPiece() {
        return idPiece;
    }

    public void setIdPiece(int idPiece) {
        this.idPiece = idPiece;
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

    ////////////////////////// Méthodes //////////////////////////

    // Méthode pour modifier les informations de la pièce de rechange
    public void modifier(int idPiece, String nom, String description, double prix, int quantiteStock) {
        this.idPiece = idPiece;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        System.out.println("Informations de la pièce de rechange modifiées avec succès.");
    }

    // Méthode pour afficher les informations de la pièce de rechange
    public void afficherPieceRechange() {
        System.out.println("=== Informations de la Pièce de Rechange ===");
        System.out.println("ID Pièce : " + idPiece);
        System.out.println("Nom : " + nom);
        System.out.println("Description : " + description);
        System.out.println("Prix : " + prix);
        System.out.println("Quantité en Stock : " + quantiteStock);
    }

}
