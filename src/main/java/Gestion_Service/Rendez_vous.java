package Gestion_Service;
import java.util.Date;
public class Rendez_vous {
    // Attributs
    private int idRendezVous;
    private int idClient;
    private int idService;
    private Date date;

    // Constructeur
    public Rendez_vous(int idRendezVous, int idClient, int idService, Date date) {
        this.idRendezVous = idRendezVous;
        this.idClient = idClient;
        this.idService = idService;
        this.date = date;
    }

    // Méthodes
    public void afficherRendezVous() {
        System.out.println("ID Rendez-vous: " + idRendezVous);
        System.out.println("ID Client: " + idClient);
        System.out.println("ID Service: " + idService);
        System.out.println("Date: " + date);
    }

    public void modifier(int idClient, int idService, Date date) {
        this.idClient = idClient;
        this.idService = idService;
        this.date = date;
    }

    // Getters et Setters
    public int getIdRendezVous() {
        return idRendezVous;
    }

    public int getIdClient() {
        return idClient;
    }

    public int getIdService() {
        return idService;
    }

    public Date getDate() {
        return date;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
