


package com.mycompany.garage_manager;
import Stocks.*;
import Gestion_Service.*;
import Personnes.*;
import Personnes.Receptionniste;
import Exceptions.*;


public class Garage_Manager {

   public static void main(String[] args) {


// Création de la réceptionniste
       Receptionniste receptionniste = new Receptionniste(00,"j","m", 5, "d",4,7, "mp");

       try {
           // Création de deux clients
           receptionniste.creerClient(1, "John", "Doe", 123456789, "123 Rue Exemple", "Solvable");
           receptionniste.creerClient(2, "Jane", "Smith", 987654321, "456 Avenue Exemple", "Ins solvable");

           // Essayer d'ajouter une voiture pour chaque client
           receptionniste.creerVoiture(1, "Toyota", "Corolla", 2020, 15000, "123ABC"); // Voiture pour le client 1
           receptionniste.creerVoiture(2, "Honda", "Civic", 2021, 10000, "456DEF"); // Voiture pour le client 2

           // Essayer d'ajouter la même voiture à un autre client
           receptionniste.creerVoiture(1, "Honda", "Civic", 2021, 10000, "456DEF"); // Cette voiture existe déjà, ne doit pas être ajoutée

           // Essayer d'ajouter la même voiture au même client (devrait être refusé)
           receptionniste.creerVoiture(2, "Toyota", "Corolla", 2020, 15000, "123ABC"); // Cette voiture existe déjà, ne doit pas être ajoutée

       } catch (Exception e) {
           System.out.println("Erreur: " + e.getMessage());
       }

       // Afficher les voitures des clients pour vérifier que tout est correct
       receptionniste.afficherListeClients();
       System.out.println("----------------*******************************----------");
       receptionniste.afficherVoitures();

   }
          
              

       
       
       

   
  
 }
