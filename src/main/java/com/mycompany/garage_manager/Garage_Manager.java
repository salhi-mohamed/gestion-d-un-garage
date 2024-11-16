
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


public class Garage_Manager {

    public static void main(String[] args) {    
        Receptionniste r=new Receptionniste(0, "salhi", "pp", 20, "d",2500 ,  50, "dd");
          try 
          {
              r.creerClient(0, "bastino", "bastino", 0, "mourouj", "douteux");
          }
          catch(ClientExisteException ce)
          {
              System.out.println("client existe deja !");
          }
          r.creer_employe(1, "ahmed", "ahmed", 202020, "mourouj", 2500, "laveur");
          r.creer_employe(2, "salhi", "med", 0, "dd", 0, "laveur");
          r.creer_employe(3, "salhi", "dd", 0, "dd", 0, "chef");
          try 
          {
               r.creerVoiture(0, "bmw", "m1", 2020, 111, "250 tun 250");
               r.creerVoiture(0, "bmw", "m2", 2020, 111, "250 tun 251");

          }
          catch(VoitureDejaExistanteClientException ve)
          {
              System.out.println("voiture deja existe pour client");
          }
          r.ajouterVoitureMecLaveur(2, "250 tun 250");
          r.afficherVoituresParLaveur(2);
                  
    }
}




