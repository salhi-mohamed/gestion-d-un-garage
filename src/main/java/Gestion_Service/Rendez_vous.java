package Gestion_Service;
import Personnes.Client;
import java.util.ArrayList;
import java.util.Date;
import Gestion_Service.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;




public class Rendez_vous {
    //attribut
   private int id_rendez_vous;
  private LocalDate Date_rendez_vous;
   private String Description_rendez_vous;
   private boolean confirme;
   private Voiture voiture;
   private Client client;





    // constructeur

   public Rendez_vous(int id_rendez_vous, String Description_rendez_vous, boolean confirme, Voiture voiture, Client client) {
        this.id_rendez_vous = id_rendez_vous;
        this.Description_rendez_vous = Description_rendez_vous;
        this.confirme = confirme;
        this.client = client;
        this.voiture = voiture;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        boolean dateValide = false;
        // Boucle jusqu'à ce que l'utilisateur entre une date valide
        while (!dateValide) {
            System.out.println("Veuillez entrer la date du rendez_vous (format: dd/MM/yyyy) : ");
            String dateInput = scanner.nextLine();
            try {
                // Convertir la chaîne saisie en LocalDate
                this.Date_rendez_vous = LocalDate.parse(dateInput, formatter);
                dateValide = true;  // Si aucune exception, la date est valide, on sort de la boucle
            } catch (DateTimeParseException e) {
                // En cas de format de date incorrect
                System.out.println("Format de date invalide. Utilisez le format dd/MM/yyyy.");
            } 
        
        
        }

         
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

   public LocalDate getDate_rendez_vous() {
        return Date_rendez_vous;
    }

    /*public void setDate_rendez_vous(Date date_rendez_vous) {
        Date_rendez_vous = date_rendez_vous;
    }*/

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

                         /////////Mehode */////////////
    public void ajouter_client(Client C){
        
    {
        this.client=client;
    }
    }


    // Redéfinition de la méthode toString()
    @Override
    public String toString() {
       return "id rendez-vous :  " + this.getId_rendez_vous() +"\n" +" date rendez-vous : "+ this.getDate_rendez_vous()+ "\n " +"Description rendez-vous : "+this.getDescription_rendez_vous()+ "\n" +" voiture concernée : "+this.getVoiture().get_immatriculation()+ "\n" +" client concerné : "+ this.getClient().get_id();
        
    }











}
