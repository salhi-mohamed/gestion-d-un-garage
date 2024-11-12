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




   
    /**************** GESTION DES VOITURES ********************/

    // Méthode pour créer une voiture
    public void creerVoiture(int idClient, String marque, String modele, int annee, long kilometrage, String immatriculation) throws VoitureDejaExistanteClientException {
        // Vérifier si le client avec l'ID donné existe dans la liste des clients
        Client clientExist = listeClients.stream()
                .filter(client -> client.get_id() == idClient)
                .findFirst()
                .orElse(null);

        if (clientExist != null) {
            // Création de la nouvelle voiture avec les informations fournies
            Voiture voiture = new Voiture(marque, modele, annee, kilometrage, immatriculation, clientExist);
            ListeVoitures.add(voiture);  // Ajouter la voiture à la liste générale des voitures
            clientExist.ajouterVoiture(voiture);  // Ajouter la voiture au client
            System.out.println("Voiture créée et ajoutée au client avec succès.");
        } else {
            System.out.println("Client avec ID " + idClient + " n'existe pas. La voiture n'a pas été créée.");
        }
    }

    // Méthode pour afficher les voitures avec leur propriétaire directement depuis ListeVoitures
    public void afficherVoitures() {
        if (ListeVoitures.isEmpty()) {
            System.out.println("Aucune voiture à afficher.");
            return;
        }

        for (Voiture voiture : ListeVoitures) {
            Client proprietaire = voiture.getClient(); // Supposons que chaque voiture ait une référence à son client

            if (proprietaire != null) {
                System.out.println("\nPropriétaire : " + proprietaire.get_nom() + " " + proprietaire.get_prenom());
            } else {
                System.out.println("\nPropriétaire : Non spécifié");
            }

            System.out.println("-------------------------");
            voiture.afficher(); // Afficher les informations de la voiture
            System.out.println();
        }
    }


    // Méthode pour supprimer une voiture en fonction de l'ID
    public void supprimerVoiture(String immatriculation) {
        boolean voitureSupprimee = false;

        Iterator<Voiture> iterator = ListeVoitures.iterator();
        while (iterator.hasNext()) {
            Voiture voiture = iterator.next();

            if (voiture.get_immatriculation().equals(immatriculation)) {
                iterator.remove();  // Supprime la voiture de la liste générale
                voiture.getClient().getVoitures().remove(voiture);  // Supprime la voiture de la collection du client
                voitureSupprimee = true;
                System.out.println("Voiture supprimée avec succès.");
                break;
            }
        }

        if (!voitureSupprimee) {
            System.out.println("Aucune voiture trouvée avec l'immatriculation " + immatriculation);
        }
    }

    // Méthode pour mettre à jour les informations d'une voiture
    public void modifierVoiture(String immatriculation, String nouvelleMarque, String nouveauModele, int nouvelleAnnee, long nouveauKilometrage) {
        Voiture voiture = ListeVoitures.stream()
                .filter(v -> v.get_immatriculation().equals(immatriculation))
                .findFirst()
                .orElse(null);

        if (voiture != null) {
            voiture.setMarque(nouvelleMarque);
            voiture.setModele(nouveauModele);
            voiture.setAnnee(nouvelleAnnee);
            voiture.setKilometrage(nouveauKilometrage);
            System.out.println("Les informations de la voiture ont été mises à jour avec succès.");
        } else {
            System.out.println("Aucune voiture trouvée avec l'immatriculation " + immatriculation);
        }
    }





    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //testt















































    // GESTION DES CLIENTS
    //**********************CREER UN CLIENT************************************
public void creerClient(int id, String nom, String prenom, int telephone, String adresse, String statutFinancier) throws ClientExisteException {
    // Création d'un nouveau client avec les informations fournies
    Client client = new Client(id, nom, prenom, telephone, adresse, statutFinancier);

    // Vérifier si un client avec le même ID existe déjà dans la liste
    for (Client c : listeClients) {
        if (c.get_id() == client.get_id()) {  // Comparaison basée sur l'ID
            throw new ClientExisteException("Un client avec cet ID existe déjà.");
        }
    }

    // Si le client n'existe pas, on l'ajoute à la liste des clients
    listeClients.add(client);
    System.out.println("Client créé et ajouté à la liste des clients.");
}



  
   //**************SUPPRIMER UN CLIENT*************************
   // Méthode pour supprimer un client en fonction de son ID
public void supprimerClient(int idClient) {
    // Vérifier si la liste des clients est vide
    if (listeClients.isEmpty()) {
        System.out.println("La liste des clients est vide, aucune suppression possible.");
        return; // Sortir de la méthode si la liste est vide
    }

    // Utilisation d'un Stream pour rechercher et supprimer le client
    boolean clientTrouve = listeClients.stream()
            .filter(client -> client.get_id() == idClient)  // Filtrer les clients avec l'ID spécifié
            .peek(client -> { // Utiliser peek pour effectuer une action sur l'élément trouvé
                listeClients.remove(client);  // Supprimer le client de la liste
                System.out.println("Client avec ID " + idClient + " supprimé.");
            })
            .findFirst() // Récupérer le premier élément trouvé (s'il y en a un)
            .isPresent();  // Vérifier si un client a été trouvé et supprimé

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
    public void affichv()
    {
        for (Voiture v : this.ListeVoitures)
        {
            System.out.println(v);
        }
    }
   
    public void ajouterVoitureAuClient(int idClient, Voiture voiture) {
    // Trouver le client par son ID
    Client clientExist = null;
    for (Client client : listeClients) {
        if (client.get_id() == idClient) {
            clientExist = client;
            break; // Si le client est trouvé, on peut sortir de la boucle
        }
    }

    // Vérification si le client existe
    if (clientExist != null) {
        // Vérifier si la voiture existe déjà pour ce client
        try {
            clientExist.ajouterVoiture(voiture); // Cette méthode lève une exception si la voiture existe déjà pour le client
            this.ListeVoitures.add(voiture); // Ajouter la voiture à la liste des voitures de la réceptionniste
            System.out.println("La voiture a été ajoutée au client.");
        } catch (VoitureDejaExistanteClientException e) {
            // Si la voiture existe déjà pour ce client, on lève l'exception et on sort
            System.out.println("Erreur: " + e.getMessage());
            return; // On sort immédiatement de la méthode si la voiture existe déjà pour ce client
        }

        // Si la voiture n'existe pas pour ce client, on vérifie dans la liste générale des voitures
        boolean voitureExistanteGlobale = false;
        for (Voiture v : this.ListeVoitures) { // Vérifier la voiture dans la liste globale des voitures
            if (v.get_immatriculation().equals(voiture.get_immatriculation())) {
                voitureExistanteGlobale = true;
                break; // La voiture existe déjà globalement
            }
        }

        // Si la voiture existe déjà dans la liste générale, on affiche un message
        if (voitureExistanteGlobale) {
            System.out.println("Cette voiture existe  dans la liste générale.");
        } else {
            // Si elle n'existe ni pour ce client ni dans la liste générale, on l'ajoute
            this.ListeVoitures.add(voiture); // Ajouter la voiture à la liste des voitures globales
            clientExist.add_car(voiture); // Ajouter la voiture à la liste du client concerné
            System.out.println("La voiture a été ajoutée à la liste générale et au client.");
        }

    } else {
        System.out.println("Client non trouvé.");
    }
}









}