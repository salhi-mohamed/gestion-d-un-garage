package com.mycompany.garage_manager;
import Stocks.*;
import Gestion_Service.*;
import Personnes.*;
import Personnes.Receptionniste;
import Exceptions.*;


public class Garage_Manager {

    public static void main(String[] args) {
        Receptionniste r=new Receptionniste(0, "d", "dd",5, "ddd",55 ,  6, "cc");
        r.creer_employe(1, "employe1", "1", 0, "mrj", 0, "mécanicien");
        r.creer_employe(2 ,"employe2", "2", 0, "mrj", 0, "chef");
        r.afficherTousLesEmployes();
        System.out.println("*******************");
        r.modifierEmploye(1);
        
    }}
