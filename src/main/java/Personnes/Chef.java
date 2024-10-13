/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnes;
import java.util.Arrays;

/**
 *
 * @author LENOVO
 */
public class Chef extends Personne {
    
    private double salaireC;
    private Employe[] equipe;
    public Chef(int id , String nom ,String prenom ,int telephone,String adresse , double salaireC)
    {
        super(id,nom,prenom,telephone,adresse);
        this.salaireC=salaireC;
        equipe=new Array();
    }
}
