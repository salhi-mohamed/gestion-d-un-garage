/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Personnes;
import java.util.Set;
import java.util.HashSet;
/**
 *
 * @author LENOVO
 */
public class Chef extends Employe {
    // Attributs
    private Set<Employe> equipe; // L'équipe du chef (ensemble d'employés)

    // Constructeur
    public Chef(int id, String nom, String prenom, int telephone, String adresse, double salaire) {
        super(id, nom, prenom, telephone, adresse, salaire); // Appel au constructeur parent (Employe)
        this.equipe = new HashSet<>(); // Initialisation de l'ensemble d'employés
    }

    // Méthode pour ajouter un employé à l'équipe
    public void ajouterEmploye(Employe employe) {
        if (employe == null) {
            System.out.println("L'employé ne peut pas être null.");
        } else {
            equipe.add(employe); // Ajoute l'employé à l'équipe
            System.out.println("L'employé " + employe.get_nom() + " a été ajouté à l'équipe.");
        }
    }

    // Méthode pour supprimer un employé de l'équipe
    public void supprimerEmploye(Employe employe) {
        if (equipe.contains(employe)) {
            equipe.remove(employe); // Supprime l'employé de l'équipe
            System.out.println("L'employé " + employe.get_nom() + " a été supprimé de l'équipe.");
        } else {
            System.out.println("L'employé n'est pas dans l'équipe.");
        }
    }

    // Méthode pour afficher les membres de l'équipe
    public void afficherEquipe() {
        if (equipe.isEmpty()) {
            System.out.println("L'équipe est vide.");
        } else {
            System.out.println("Équipe de " + get_nom() + ":");
            for (Employe employe : equipe) {
                System.out.println(employe); // Affiche les détails de chaque employé
            }
        }
    }

    // Getter pour l'équipe
    public Set<Employe> getEquipe() {
        return equipe;
    }
}
