/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.garage_manager;
import Gestion_Service.*;
import Personnes.*;/**
 *
 * @author LENOVO
 */
public class Garage_Manager {

    public static void main(String[] args) {
        // Création d'un objet Client
        /*Client client = new Client(1, "Ahmed Memni", "Rue des Jasmins, Tunis", "98765432");

        // Afficher les informations initiales du client
        System.out.println("Informations initiales du client :");
        client.afficherClient();

        // Modifier les informations du client
        client.modifier("Ahmed Ben Ali", "Avenue Habib Bourguiba, Tunis", "12345678");

        // Afficher les informations après modification
        System.out.println("\nInformations du client après modification :");
        client.afficherClient();*/
        /*
          private String immatriculation;
    private String marque;
    private String modele;
    private int annee;
        */
       
          Employe M1=new Mecanicien(01, "salhi", "med",  2001, "mourouj", 350.2,  "moteur");
          M1.modifier();
          System.out.println(M1);
         
            

        
        
    }
}
