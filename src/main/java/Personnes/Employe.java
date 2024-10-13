/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/**
 *
 * @author LENOVO
 */
public class Employe extends Personne{
    
    private LocalDate  date_embauche;
    private double salaire;
    public Employe(int id , String nom , String prenom , int telephone , String adresse,double salaire)
    {
        super(id,nom,prenom,telephone,adresse);
        this.salaire=salaire;
       
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Scanner scanner = new Scanner(System.in);
        boolean dateValide = false;
        
        // Boucle jusqu'à ce que l'utilisateur entre une date valide
        while (!dateValide) {
            System.out.println("Veuillez entrer la date d'embauche (format: dd/MM/yyyy) : ");
            String dateInput = scanner.nextLine();
            
            try {
                // Convertir la chaîne saisie en LocalDate
                this.date_embauche = LocalDate.parse(dateInput, formatter);
                System.out.println("Date d'embauche enregistrée : " + this.date_embauche);
                dateValide = true;  // Si aucune exception, la date est valide, on sort de la boucle
            } catch (DateTimeParseException e) {
                // En cas de format de date incorrect
                System.out.println("Format de date invalide. Utilisez le format dd/MM/yyyy.");
            } 
        
        
    }
}
   public void modifier() {
    int choice;
    Scanner sc = new Scanner(System.in);

    do {
        // Boucle pour forcer un choix valide (entre 0 et 4)
        do {
            System.out.println("Que voulez-vous modifier ?");
            System.out.println("1 : nom");
            System.out.println("2 : prenom");
            System.out.println("3 : adresse");
            System.out.println("4 : telephone");
            System.out.println("5 : salaire");
            System.out.println("0 : quitter");

            // Vérifier que l'entrée est bien un entier
            while (!sc.hasNextInt()) {
                System.out.println("Saisie invalide, veuillez entrer un nombre entre 0 et 4.");
                sc.next(); // Consomme l'entrée invalide
            }
            choice = sc.nextInt();

            // Vérifier si l'entier est dans la plage valide (0 à 4)
            if (choice < 0 || choice > 5) {
                System.out.println("Choix invalide, veuillez entrer un nombre entre 0 et 4.");
            }

        } while (choice < 0 || choice > 5);  // Répéter tant que l'utilisateur entre un choix invalide

        // Traiter le choix valide
        sc.nextLine(); // Consommer le retour de ligne restant après nextInt()
        switch (choice) {
            case 1:
                System.out.println("Saisir le nouveau nom : ");
                String new_name = sc.nextLine();
                super.set_nom(new_name);
                System.out.println("Nom mis à jour.");
                break;

            case 2:
                System.out.println("Saisir le nouveau prénom : ");
                String new_firstname = sc.nextLine();
                super.set_prenom(new_firstname);
                System.out.println("Prénom mis à jour.");
                break;

            case 3:
                System.out.println("Saisir la nouvelle adresse : ");
                String new_adresse = sc.nextLine();
                super.set_adresse(new_adresse);
                System.out.println("Adresse mise à jour.");
                break;

            case 4:
                System.out.println("Saisir le nouveau téléphone : ");
                int new_tel = sc.nextInt();
                sc.nextLine(); // Consommer le retour de ligne
                super.set_telephone(new_tel);
                System.out.println("Téléphone mis à jour.");
                break;
            case 5 :    
                 System.out.println("Saisir le nouveau salaire : ");
                int new_salary = sc.nextInt();
                sc.nextLine(); // Consommer le retour de ligne
                super.set_telephone(new_salary);
                System.out.println("salaire mis à jour.");
                break;

            case 0:
                System.out.println("Quitter le menu.");
                break;
        }

    } while (choice != 0);  // Continuer tant que l'utilisateur ne choisit pas "quitter" (0)

    sc.close();  // Fermer le scanner après utilisation
}

    @Override
    
  public String toString() {
    return super.toString() + "\n" + "Salaire de l'employé : " + this.salaire + "\n" + "Date d'embauche de l'employé : " + this.date_embauche;
    }

}