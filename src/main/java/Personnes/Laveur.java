/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnes;
import Gestion_Service.Voiture;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author LENOVO
 */
public class Laveur extends Employe {
    private boolean specialise_interieur;
    private boolean specialise_exterieur;
   /* private ArrayList<Voiture> voitures;
    public Laveur(int id , String nom , String prenom,int telephone,String adresse , double salaire )
    {
        super(id,nom,prenom,telephone,adresse,salaire);
        Scanner sc=new Scanner(System.in);    
        do {
             System.out.println(" quelle est la spécialité de ce laveur ? I : Intérieur / E : Extérieur ");
      char specialite=sc.next().charAt(0);
      switch (specialite)
      {
          case 'E' :
              this.Specialise_exterieur=true;
              this.Specialise_interieur=false;
              break;
                
          case 'I' :  
              this.Specialise_interieur=true;
              this.Specialise_exterieur=false;
              break ;
          default : 
              System.out.println("Choix invalide ! ");
            
        }

    
    
      }while((specialite!='I')&(specialite!='i')&
      

     
    }   
      */
    //    public Employe(int id , String nom , String prenom , int telephone , String adresse,double salaire)
    public void set_specialise_interieur(boolean spec )
    {
        this.specialise_interieur=spec;
    }
    public void set_specialise_exterieur(boolean spec)
    {
        this.specialise_exterieur=spec;
    }
    public boolean get_specialise_interieur()
    {
        return this.specialise_interieur;
    }
    public boolean get_specialise_exterieur()
    {
        return this.specialise_exterieur;
    }
    @Override
    public String toString()
    {
        if (this.specialise_exterieur)
            return super.toString()+" specialité : extérieur";
        else
            return super.toString()+" spécialité : intérieur";
    }
    public void modifier()
    {
        
    }
    
}
