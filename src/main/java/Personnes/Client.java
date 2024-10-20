package Personnes;

public class Client {
    // Attributs
    private int idClient;
    private String nom;
    private String adresse;
    private String telephone;

    // Constructeur
    public Client(int idClient, String nom, String adresse, String telephone) {
        this.idClient = idClient;
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    // Méthodes
    public void afficherClient() {
        System.out.println("ID Client: " + idClient);
        System.out.println("Nom: " + nom);
        System.out.println("Adresse: " + adresse);
        System.out.println("Téléphone: " + telephone);
    }

    public void modifier(String nom, String adresse, String telephone) {
        this.nom = nom;
        this.adresse = adresse;
        this.telephone = telephone;
    }

    // Getters et Setters
    public int getIdClient() {
        return idClient;
    }

    public String getNom() {
        return nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
