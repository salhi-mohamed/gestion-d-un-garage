package Gestion_Service;

public class Voiture {
    // Attributs
    private String immatriculation;
    private String marque;
    private String modele;
    private int annee;

    // Constructeur
    public Voiture(String immatriculation, String marque, String modele, int annee) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    // Méthodes
    public void afficherVoiture() {
        System.out.println("Immatriculation: " + immatriculation);
        System.out.println("Marque: " + marque);
        System.out.println("Modèle: " + modele);
        System.out.println("Année: " + annee);
    }

    public void modifier(String marque, String modele, int annee) {
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    // Getters et Setters
    public String getImmatriculation() {
        return immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public int getAnnee() {
        return annee;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }
}
