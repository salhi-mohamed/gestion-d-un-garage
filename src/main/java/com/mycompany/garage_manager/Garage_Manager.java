


package com.mycompany.garage_manager;
import Stocks.*;
import Gestion_Service.*;
import Personnes.*;
import Personnes.Receptionniste;


public class Garage_Manager {

   public static void main(String[] args) {
       
       
       
        

       Receptionniste r=new Receptionniste(01 ,"admin", "admin",20592345, "moutouj",1500 ,  12, "salhi@gmail.com");
       
      r.creerClient(1, "mekni", "jihed", 20598888, "mourouj",  "mrigel");
      r.creerClient(2, "srasra", "yousef", 20598888, "manouba",  "mrigel");
      r.creerVoiture(1, "kia", "ev", 2023, 10000, "200 tun 2000");
      r.creerVoiture(1, "mahindra", "ev", 2023, 10000, "200 tun 2000");
            r.creerVoiture(2, "puntp", "ev", 2023, 10000, "200 tun 2000");

r.afficherVoitures();
   

          
              

       
       
       

   }
  
 }
