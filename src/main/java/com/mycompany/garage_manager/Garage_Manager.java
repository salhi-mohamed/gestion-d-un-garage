


package com.mycompany.garage_manager;
import Stocks.*;
import Gestion_Service.*;
import Personnes.*;
import Personnes.Receptionniste;
import Exceptions.*;


public class Garage_Manager {

   public static void main(String[] args) {
       
       
       //Employe e=new Employe(00 , "salah" , "mahdi" , 20592345 , "mourouj , ",2500);
     //Employe e1=new Employe(03 , "salah" , "mahdi" , 20592345 , "mourouj , ",2500);

     Chef c=new Chef(05 , "ali" , "hmadi" , 22,"kk" , 5000);
     try 
     {
         c.afficherEquipe();
     }
     catch(EquipeVideException ev)
     {
         System.out.println("erreur  : " + ev.getMessage());
     }
   

   

          
              

       
       
       

   
  
 }}
