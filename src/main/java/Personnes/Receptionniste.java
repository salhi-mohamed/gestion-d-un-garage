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

    // ******** Méthode pour créer une fourniture ***********
    public void creerFourniture(int idFourniture, String nom, String description, double prix, int quantiteStock) {
        try {
            // Vérifier les arguments
            if (nom == null || nom.isEmpty()) {
                throw new ArgumentInvalideException("Le nom de la fourniture ne peut pas être vide.");
            }
            if (description == null || description.isEmpty()) {
                throw new ArgumentInvalideException("La description ne peut pas être vide.");
            }
            if (prix <= 0) {
                throw new ArgumentInvalideException("Le prix doit être supérieur à 0.");
            }
            if (quantiteStock < 0) {
                throw new QuantiteNegatifException("La quantité en stock ne peut pas être négative.");
            }

            // Créer et ajouter la nouvelle fourniture
            Fourniture nouvelleFourniture = new Fourniture(idFourniture, nom, description, prix, quantiteStock);
            listeFournitures.add(nouvelleFourniture);
            System.out.println("Fourniture ajoutée avec succès.");
        } catch (ArgumentInvalideException | QuantiteNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }




    // ****** Méthode pour supprimer une fourniture ************
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
        try {
            Fourniture fourniture = chercherFournitureParId(idFourniture);

            if (fourniture != null) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Modifier le nom de la fourniture : ");
                String nom = sc.nextLine();
                if (nom == null || nom.isEmpty()) {
                    throw new ArgumentInvalideException("Le nom de la fourniture ne peut pas être vide.");
                }

                System.out.println("Modifier la description : ");
                String description = sc.nextLine();
                if (description == null || description.isEmpty()) {
                    throw new ArgumentInvalideException("La description ne peut pas être vide.");
                }

                System.out.println("Modifier le prix : ");
                double prix = sc.nextDouble();
                if (prix <= 0) {
                    throw new ArgumentInvalideException("Le prix doit être supérieur à 0.");
                }

                System.out.println("Modifier la quantité en stock : ");
                int quantiteStock = sc.nextInt();
                if (quantiteStock < 0) {
                    throw new QuantiteNegatifException("La quantité en stock ne peut pas être négative.");
                }

                // Modifier les informations de la fourniture
                fourniture.modifierFourniture(idFourniture, nom, description, prix, quantiteStock);
            } else {
                System.out.println("Fourniture non trouvée.");
            }
        } catch (ArgumentInvalideException | QuantiteNegatifException e) {
            System.out.println("Erreur : " + e.getMessage());
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















































    //test 2/////////////////////////////
}