


package com.mycompany.garage_manager;
import Stocks.*;
import Gestion_Service.*;
import Personnes.*;
import Personnes.Receptionniste;
import Exceptions.*;


public class Garage_Manager {

   public static void main(String[] args) {


// Création de la réceptionniste
       Receptionniste receptionniste = new Receptionniste(0077,"j","m", 5, "d",4,7, "mp");
       receptionniste.creerEmploye(0, "salah", "aymen", 0, "mourouj", 2000, "laveur");
              receptionniste.creerEmploye(1, "salah", "aymen", 0, "mourouj", 2000, "mécanicien");
              receptionniste.creerEmploye(2, "salah", "aymen", 0, "mourouj", 2000, "chef");
              receptionniste.creerEmploye(3, "salah", "aymen", 0, "mourouj", 2000, "chef");

             // receptionniste.creerEmploye(2, "salah", "aymen", 0, "mourouj", 2000, "mécanicien");
              receptionniste.afficherTousLesEmployes();

   }
          
              

       
       
       

   
  
 }
