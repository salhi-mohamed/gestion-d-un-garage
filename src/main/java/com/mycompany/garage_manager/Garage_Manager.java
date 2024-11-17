
package com.mycompany.garage_manager;
import Stocks.*;
import Gestion_Service.*;
import Personnes.*;
import Personnes.Receptionniste;
import Exceptions.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.time.LocalDate;


public class Garage_Manager{
 public static void main(String[] args){
     
     Receptionniste r=new Receptionniste(0, "ss", "d", 20592345, "dd",2500 , 55, "dd");
     try 
     {
         r.creerClient(0, "d", "d", 0, "dd", "dd");
         r.creerClient(1, "salhi","med", 0, "mourouj", "ff");
         r.creerVoiture(0, "bmw", "m1", 2020, 10000, "250 tun 250");
        r.creerVoiture(0, "mercedes", "c180", 2020, 10000, "250 tun 251");
        // r.creerVoiture(0, "mercedes", "c180", 2020, 1900, "252 tun 250");
     }
     catch (ClientExisteException ce)
     {
         System.out.println("client existe deja ");
     }
     catch(VoitureDejaExistanteClientException ve)
     {
        System.out.println("voiture deja existe pour ce client ");
             
     }
     r.afficher_voitures_par_client(7);
     //r.creer_employe(4,"salhi", "med", 0, "mourouj", 2500, "laveur");
     //     r.creer_employe(5,"salhi", "med", 0, "mourouj", 2500, "laveur");

     //r.ajouterVoitureMecLaveur(5, "251 tun 250");
     //r.ajouterVoitureMecLaveur(5, "250 tun 250");
     //r.afficherTousLesEmployes();
    //r.supprimerVoitureMecLaveur(5, "250 tun 250");
     //r.supprimerVoitureMecLaveur(5, "251 tun 250");
     //r.afficherVoituresParLaveur(7);
     //r.afficherListeClients();
     
     
 }
}


            




