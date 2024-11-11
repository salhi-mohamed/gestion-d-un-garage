


package com.mycompany.garage_manager;
import Stocks.*;
import Gestion_Service.*;
import Personnes.*;


public class Garage_Manager {

   public static void main(String[] args) {
       
       
       
        

       
       Client c=new Client(00, "hamma", "salhi", 20592345, "mourouj", "douteux");
       Voiture v1=new Voiture("bmw", "m2", 2020, 1555, "250 tun 555" , c);
       Voiture v2=new Voiture("bmw", "m3", 2020, 1555, "251 tun 555" , c);
       /* c.ajouterVoiture( v1);
        c.ajouterVoiture(v2);
              

       c.modifier();
         // public Rendez_vous(int id_rendez_vous, String Description_rendez_vous, boolean confirme, Voiture voiture , Client client) {

       System.out.println(c);
       Rendez_vous r =new Rendez_vous(000,"ddd",true,v1,c);
       Piece_Rechange p=new Piece_Rechange(006,"moula","kbira",1111,1000);
         Piece_Rechange p1=new Piece_Rechange(007,"moueee","kbira",1111,1000);

      Service s=new Service("tabdil " , 2000 , 4444,v1,r,c);
      s.ajouterPiece(p);
      s.ajouterPiece(p1);*/
     
     // Laveur l=new Laveur(001,"salhi" , "med" , 50000, "mourouj" , 2500);
      //l.ajouter_voiture(v1);
      //l.ajouter_voiture(v2);
     //l.afficher();
     //l.supprimer_voiture("7 tun 555");
     //System.out.println("*********************");
     //l.afficher();
 /* Mecanicien m=new Mecanicien(00,"salhi","med",20592345,"mourouj",2500,"tourneur");
  m.ajouter_voiture(v1);
  m.ajouter_voiture(v2);
  m.afficher();
  m.modifier();
  
    System.out.println("**********");
m.afficher();*/
  Receptionniste r = new Receptionniste(012,"salah","aymen",2058888,"mannouba",40005,10,"ahmed@gmailcom");
  r.PlanifierRendezVous(c, v1);
  r.PlanifierRendezVous(c, v2);
  r.AfficherReceptionniste();
  r.annuler_rendez_vous();
  System.out.println("*********************************");
  r.AfficherReceptionniste();
  /*
              public Receptionniste(int id, String nom, String prenom, int telephone, String adresse,double salaire ,  int numeroBureau, String email) {

          */
  
   

          
              

       
       
       

   }
  
 }
