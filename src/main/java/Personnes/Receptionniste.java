package Personnes;
import Personnes.Client;
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;
import Gestion_Service.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import Stocks.Fourniture;
import Stocks.Piece_Rechange;
import Exceptions.*;


public class Receptionniste extends Employe
{
    private int numeroBureau;
    private String email;
    private ArrayList<Rendez_vous> listeRendezVous; // Liste pour stocker les rendez-vous
        private ArrayList<Client> listeClients;
        private ArrayList<Voiture> ListeVoitures;
    private ArrayList<Fourniture> listeFournitures;
    private ArrayList<Piece_Rechange> listPiecesRechange;

    //listeservices
    //listeclients
    //listevoitures
    //listeemployes

    // Constructeur
    public Receptionniste(int id, String nom, String prenom, int telephone, String adresse,double salaire ,  int numeroBureau, String email) {
        super(id, nom, prenom, telephone, adresse,salaire);
        this.numeroBureau = numeroBureau;
        this.email = email;
        this.listeRendezVous = new ArrayList<>();
        this.listeClients = new ArrayList<>();
        this.ListeVoitures=new ArrayList<Voiture>();
        this.listeFournitures=new ArrayList<Fourniture>();

    }





                                                    /////////GESTION DES FOURNITURES///////////

    //******** Méthode pour creer une fourniture***********
    public void creerFourniture(int idFourniture, String nom, String description, double prix, int quantiteStock) {
        Fourniture nouvelleFourniture = new Fourniture(idFourniture, nom, description, prix, quantiteStock);
        listeFournitures.add(nouvelleFourniture);
        System.out.println("Fourniture ajoutée avec succès.");
    }





    // ******Méthode pour supprimer une fourniture************
    public void supprimerFourniture(int idFourniture) {
        Iterator<Fourniture> iterator = listeFournitures.iterator();
        boolean trouve = false;

        while (iterator.hasNext()) {
            Fourniture f = iterator.next();
            if (f.getIdFourniture() == idFourniture) {
                iterator.remove();
                System.out.println("Fourniture supprimée avec succès.");
                trouve = true;
                break;
            }
        }

        if (!trouve) {
            System.out.println("Aucune fourniture trouvée avec cet ID.");
        }
    }






    // Méthode pour chercher une fourniture par son ID
    private Fourniture chercherFournitureParId(int idFourniture) {
        for (Fourniture f : listeFournitures) {
            if (f.getIdFourniture() == idFourniture) {
                return f;
            }
        }
        return null;
    }
    // Méthode pour modifier une fourniture
    public void ModifierFourniture(int idFourniture) {
        Fourniture fourniture = chercherFournitureParId(idFourniture);

        if (fourniture != null) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Modifier le nom de la fourniture : ");
            String nom = sc.nextLine();

            System.out.println("Modifier la description : ");
            String description = sc.nextLine();

            System.out.println("Modifier le prix : ");
            double prix = sc.nextDouble();

            System.out.println("Modifier la quantité en stock : ");
            int quantiteStock = sc.nextInt();

            fourniture.modifierFourniture(idFourniture,nom, description, prix, quantiteStock);
        } else {
            System.out.println("Fourniture non trouvée.");
        }
    }








    // Méthode pour afficher toutes les fournitures
    public void afficherFournitures() {
        if (listeFournitures.isEmpty()) {
            System.out.println("Aucune fourniture à afficher.");
        } else {
            for (Fourniture f : listeFournitures) {
                f.afficherFourniture();
                System.out.println();
            }
        }
    }





                                                              ///////////GESTION DES PIECES DE RECHANGE //////////////




    //**************** Créer Piece_Rechange

    public void creerPieceRechange(int idPiece, String nom, String description, double prix, int quantiteStock) {
        Piece_Rechange nouvellePiece = new Piece_Rechange(idPiece, nom, description, prix, quantiteStock);

        listPiecesRechange.add(nouvellePiece);

        System.out.println("La pièce de rechange a été créée et ajoutée avec succès.");
    }





 //******Supprimer piece rechange
    public void supprimerPieceRechange(int idPiece) {
        Iterator<Piece_Rechange> iterator = listPiecesRechange.iterator();

        while (iterator.hasNext()) {
            Piece_Rechange piece = iterator.next();

            if (piece.getIdPiece() == idPiece) {
                iterator.remove(); // Supprimer l'élément de la liste
                System.out.println("La pièce de rechange avec l'ID " + idPiece + " a été supprimée avec succès.");
                return;
            }
        }

        System.out.println("Aucune pièce de rechange trouvée avec l'ID " + idPiece);
    }






/////modifier piece rechange

    public Piece_Rechange chercherPieceRechangeParId(int idPieceRechange) {
        for (Piece_Rechange piece : listPiecesRechange) {
            if (piece.getIdPiece() == idPieceRechange) {
                return piece;
            }
        }
        return null; // Retourner null si aucune pièce n'a été trouvée
    }

    public void modifierPieceRechange(int idPieceRechange) {
        Piece_Rechange pieceRechange = chercherPieceRechangeParId(idPieceRechange);

        if (pieceRechange != null) {
            Scanner sc = new Scanner(System.in);

            System.out.println("Modifier le nom de la pièce de rechange : ");
            String nom = sc.nextLine();

            System.out.println("Modifier la description : ");
            String description = sc.nextLine();

            System.out.println("Modifier le prix : ");
            double prix = sc.nextDouble();

            System.out.println("Modifier la quantité en stock : ");
            int quantiteStock = sc.nextInt();

            // Appeler la méthode pour modifier les informations de la pièce de rechange
            pieceRechange.modifier(idPieceRechange, nom, description, prix, quantiteStock);
        } else {
            System.out.println("Pièce de rechange non trouvée.");
        }
    }





    ////methode pour afficher  toute les pieces

    public void afficherToutesLesPiecesRechange() {
        if (listPiecesRechange.isEmpty()) {
            System.out.println("Aucune pièce de rechange à afficher.");
        } else {
            for (Piece_Rechange p : listPiecesRechange) {
                p.afficherPieceRechange();
                System.out.println();
            }
        }
    }




    // GESTION DES CLIENTS
    //**********************CREER UN CLIENT************************************
   public void creerClient(int id, String nom, String prenom, int telephone, String adresse, String statutFinancier) {
        // Création d'un nouveau client avec les informations fournies
        Client client = new Client(id, nom, prenom, telephone, adresse, statutFinancier);
        
        // Ajout du client à la liste des clients
        listeClients.add(client);
        System.out.println("Client créé et ajouté à la liste des clients.");
    } 
   //**************SUPPRIMER UN CLIENT*************************
   // Méthode pour supprimer un client en fonction de son ID
 public void supprimerClient(int idClient) {
        Iterator<Client> iterator = listeClients.iterator(); // Création de l'Iterator
        boolean clientTrouve = false;

        while (iterator.hasNext()) { // Vérifie s'il y a encore un client à parcourir
            Client client = iterator.next(); // Récupère le client suivant
            if (client.get_id() == idClient) { // Si le client avec l'ID correspond
                iterator.remove(); // Supprime le client de la liste
                System.out.println("Client avec ID " + idClient + " supprimé.");
                clientTrouve = true;
                break; // Arrête la boucle une fois que le client est supprimé
            }
        }

        if (!clientTrouve) {
            System.out.println("Client avec ID " + idClient + " non trouvé.");
        }
    }
 public void modifierClient(int idClient) {
    // Chercher le client à partir de l'ID
    Client client = chercherClientParId(idClient);  // Supposons que tu as une méthode pour chercher un client par ID

    if (client != null) {
        // Si le client est trouvé, appeler la méthode modifier de la classe Client
        client.modifier();  // Cette méthode est déjà définie dans la classe Client
    } else {
        // Si le client n'est pas trouvé, afficher un message d'erreur
        System.out.println("Client non trouvé.");
    }
}
 private Client chercherClientParId(int idClient) {
    for (Client client : listeClients) {
        if (client.get_id() == idClient) {  // Supposons que la méthode getId() existe dans la classe Client
            return client;
        }
    }
    return null;  // Si le client n'est pas trouvé
}
    public void afficherListeClients() {
    // Vérifier si la liste des clients est vide
    if (listeClients.isEmpty()) {
        System.out.println("Aucun client à afficher.");
        return;
    }

    // Parcourir la liste des clients
    Iterator<Client> iterator = listeClients.iterator();
    while (iterator.hasNext()) {
        Client client = iterator.next();
        
        // Afficher les informations du client
        System.out.println("\n--- Client : " + client.get_nom() + " " + client.get_prenom() + " ---");
        System.out.println("Téléphone : " + client.get_telephone());
        System.out.println("Adresse : " + client.get_adresse());
        System.out.println("Statut Financier : " + client.getStatutFinancier());

        // Afficher les voitures du client
        System.out.println("Voitures du client :");
        Iterator<Voiture> voitureIterator = client.getVoitures().iterator();  // On suppose qu'il y a un getter pour la liste de voitures
        if (voitureIterator.hasNext()) {
            while (voitureIterator.hasNext()) {
                Voiture voiture = voitureIterator.next();
                voiture.afficher();  // Appeler la méthode afficher() de la classe Voiture
            }
        } else {
            System.out.println("Aucune voiture associée à ce client.");
        }
    }
}
<<<<<<< HEAD
=======
//****************GESTION DES VOITURES********************
    //creer voiture
/*public void creerVoiture(int idClient, String marque, String modele, int annee, long kilometrage, String immatriculation) {
    // Vérifier si le client avec l'id donné existe dans la liste des clients
    Client clientExist = null;
    for (Client client : listeClients) {
        if (client.get_id() == idClient) {
            clientExist = client;
            break;
        }
    }
>>>>>>> da276c87e4176d468511ae856bc27c5ef76ac476

    /****************** GESTION DES VOITURES ******************/

<<<<<<< HEAD
    /*// Créer une voiture
    public void creerVoiture(int idClient, String marque, String modele, int annee, long kilometrage, String immatriculation) {
        // Vérifier si le client avec l'id donné existe dans la liste des clients
        Client clientExist = null;
        for (Client client : listeClients) {
            if (client.get_id() == idClient) {
                clientExist = client;
                break;
=======
        // Ajouter la voiture à la collection de voitures du client
        clientExist.ajouterVoiture(voiture);  // On suppose que Client a une méthode ajouterVoiture()
        System.out.println("Voiture créée et ajoutée au client avec succès.");
    } else {
        // Si le client n'existe pas
        System.out.println("Client avec ID " + idClient + " n'existe pas. La voiture n'a pas été créée.");
    }
}*/
//afficher voiture 
public void afficherVoitures() {
    // Vérifier si la liste des clients est vide
    if (listeClients.isEmpty()) {
        System.out.println("Aucun client n'a de voiture à afficher.");
        return;
    }

    // Parcourir la liste des clients
    Iterator<Client> iterator = listeClients.iterator();
    while (iterator.hasNext()) {
        Client client = iterator.next();

        // Afficher le nom du client
        System.out.println("\nClient : " + client.get_nom() + " " + client.get_prenom());
        System.out.println("-------------------------");

        // Parcourir les voitures de chaque client
        Iterator<Voiture> voitureIterator = client.getVoitures().iterator();  // On suppose qu'il y a un getter pour la liste de voitures
        if (voitureIterator.hasNext()) {
            while (voitureIterator.hasNext()) {
                Voiture voiture = voitureIterator.next();
                
                // Utiliser la méthode afficher de la classe Voiture pour afficher les informations de la voiture
                voiture.afficher();
                System.out.println();  // Ajouter une ligne vide entre les voitures
>>>>>>> da276c87e4176d468511ae856bc27c5ef76ac476
            }
        }

        // Si le client existe, créer la voiture et l'ajouter au client
        if (clientExist != null) {
            // Création de la nouvelle voiture avec les informations données
            Voiture voiture = new Voiture(marque, modele, annee, kilometrage, immatriculation, clientExist);
            this.listeVoitures.add(voiture);

            // Ajouter la voiture à la collection de voitures du client
            clientExist.ajouterVoiture(voiture);  // On suppose que Client a une méthode ajouterVoiture()
            System.out.println("Voiture créée et ajoutée au client avec succès.");
        } else {
            // Si le client n'existe pas
            System.out.println("Client avec ID " + idClient + " n'existe pas. La voiture n'a pas été créée.");
        }
    }

    // Afficher toutes les voitures de tous les clients
    public void afficherVoitures() {
        // Vérifier si la liste des clients est vide
        if (listeClients.isEmpty()) {
            System.out.println("Aucun client n'a de voiture à afficher.");
            return;
        }

        // Parcourir la liste des clients
        for (Client client : listeClients) {
            // Afficher le nom du client
            System.out.println("\nClient : " + client.get_nom() + " " + client.get_prenom());
            System.out.println("-------------------------");

            // Parcourir les voitures de chaque client
            if (!client.getVoitures().isEmpty()) {
                for (Voiture voiture : client.getVoitures()) {
                    voiture.afficher(); // Utiliser la méthode afficher de la classe Voiture
                    System.out.println();  // Ajouter une ligne vide entre les voitures
                }
            } else {
                System.out.println("Aucune voiture associée à ce client.");
            }
        }
    }

    // Supprimer une voiture par ID
    public void supprimerVoiture(int idVoiture) {
        Iterator<Voiture> iterator = listeVoitures.iterator();
        boolean voitureSupprimee = false;

        while (iterator.hasNext()) {
            Voiture voiture = iterator.next();

            // Vérifier si l'ID de la voiture correspond à l'ID passé en argument
            if (voiture.get_id() == idVoiture) {  // Assurez-vous que Voiture a un getter pour l'ID
                // Supprimer la voiture de la liste principale
                iterator.remove();
                voitureSupprimee = true;

                // Supprimer la voiture de la liste de voitures du client
                voiture.getClient().getVoitures().remove(voiture);
                System.out.println("Voiture supprimée avec succès.");
                break;
            }
        }

        // Si aucune voiture n'a été supprimée
        if (!voitureSupprimee) {
            System.out.println("Aucune voiture trouvée avec l'ID " + idVoiture);
        }
    }

    // Mise à jour des informations d'une voiture
    public void mettreAJourVoiture(int idVoiture, String nouvelleMarque, String nouveauModele, int nouvelleAnnee, long nouveauKilometrage) {
        Voiture voitureAMettreAJour = null;

        // Rechercher la voiture par ID
        /*for (Voiture voiture : ListeVoitures) {
            if (voiture.get_id() == idVoiture) {
                voitureAMettreAJour = voiture;
                break;
            }
        }

        if (voitureAMettreAJour != null) {
            // Mettre à jour les informations de la voiture
            voitureAMettreAJour.setMarque(nouvelleMarque);
            voitureAMettreAJour.setModele(nouveauModele);
            voitureAMettreAJour.setAnnee(nouvelleAnnee);
            voitureAMettreAJour.setKilometrage(nouveauKilometrage);

            System.out.println("Voiture mise à jour avec succès.");
        } else {
            System.out.println("Aucune voiture trouvée avec l'ID " + idVoiture);
        }
    }
}*/
}







