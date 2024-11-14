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
import java.util.Optional;

public class Receptionniste extends Employe
{
    private int numeroBureau;
    private String email;
    private ArrayList<Rendez_vous> listeRendezVous; // Liste pour stocker les rendez-vous
    private ArrayList<Client> listeClients;
    private ArrayList<Voiture> ListeVoitures;
    private ArrayList<Fourniture> listeFournitures;
    private ArrayList<Piece_Rechange> listPiecesRechange;
    private ArrayList<Employe> ListeEmployes;



    // Constructeur
    public Receptionniste(int id, String nom, String prenom, int telephone, String adresse,double salaire ,  int numeroBureau, String email) {
        super(id, nom, prenom, telephone, adresse,salaire);
        this.numeroBureau = numeroBureau;
        this.email = email;
        this.listeRendezVous = new ArrayList<>();
        this.listeClients = new ArrayList<>();
        this.ListeVoitures=new ArrayList<Voiture>();
        this.listeFournitures=new ArrayList<Fourniture>();
        this.ListeEmployes=new ArrayList<Employe>();
        

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




   
    /**************** GESTION DES VOITURES ********************/
/*
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
*/



    // Méthode pour créer une voiture
    public void creerVoiture(int idClient, String marque, String modele, int annee, long kilometrage, String immatriculation) throws VoitureDejaExistanteClientException {
        // Vérifier si le client avec l'ID donné existe dans la liste des clients
        Client clientExist = listeClients.stream()
                .filter(client -> client.get_id() == idClient)
                .findFirst()
                .orElse(null);

        if (clientExist != null) {
            // Vérifier si la voiture existe déjà pour ce client
            for (Voiture v : clientExist.getVoitures()) {
                if (v.get_immatriculation().equals(immatriculation)) {
                    throw new VoitureDejaExistanteClientException("Cette voiture est déjà associée à ce client.");
                }
            }

            // Vérifier si la voiture existe déjà dans la liste générale des voitures
            for (Voiture v : ListeVoitures) {
                if (v.get_immatriculation().equals(immatriculation)) {
                    System.out.println("Cette voiture existe déjà dans la liste générale.");
                    return; // On sort de la méthode si la voiture existe déjà
                }
            }

            // Création de la nouvelle voiture avec les informations fournies
            Voiture voiture = new Voiture(marque, modele, annee, kilometrage, immatriculation, clientExist);

            // Ajouter la voiture à la liste générale des voitures
            ListeVoitures.add(voiture);

            // Ajouter la voiture à la liste des voitures du client
            clientExist.ajouterVoiture(voiture);

            System.out.println("Voiture créée et ajoutée au client avec succès.");
        } else {
            System.out.println("Client avec ID " + idClient + " n'existe pas. La voiture n'a pas été créée.");
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



    // Méthode pour afficher toutes les voitures
    public void afficherVoitures() {
        if (ListeVoitures.isEmpty()) {
            System.out.println("Aucune voiture n'est disponible dans la liste.");
            return;
        }

        System.out.println("Liste des voitures :");
        for (Voiture voiture : ListeVoitures) {
            System.out.println("Immatriculation : " + voiture.get_immatriculation());
            System.out.println("Marque : " + voiture.getMarque());
            System.out.println("Modèle : " + voiture.getModele());
            System.out.println("Année : " + voiture.getAnnee());
            System.out.println("Kilométrage : " + voiture.getKilometrage());

            // Informations du client associé
            Client client = voiture.getClient();
            if (client != null) {
                System.out.println("Client associé : " + client.get_nom() + " " + client.get_prenom());
                System.out.println("ID du client : " + client.get_id());
            } else {
                System.out.println("Aucun client associé.");
            }
            System.out.println("--------------------------");
        }
    }











































































































































































































    //testt















































                               /////////// GESTION DES CLIENTS/////////////////////////
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
    System.out.println("Client créé et ajouté à la liste des clients. ");
}



  
   //**************SUPPRIMER UN CLIENT*************************
   // Méthode pour supprimer un client en fonction de son ID
/*public void supprimerClient(int idClient) {
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
}*/
public void supprimerClient(int idClient) {
    // Vérifier si la liste des clients est vide
    if (listeClients.isEmpty()) {
        System.out.println("La liste des clients est vide, aucune suppression possible.");
        return; // Sortir de la méthode si la liste est vide
    }

    // Utilisation d'un Stream pour rechercher et supprimer le client
    Optional<Client> clientASupprimer = listeClients.stream()
            .filter(client -> client.get_id() == idClient)  // Filtrer le client avec l'ID spécifié
            .findFirst();  // Récupérer le premier élément trouvé (s'il y en a un)

    if (clientASupprimer.isPresent()) {
        Client client = clientASupprimer.get();

        // Supprimer les voitures associées à ce client dans la liste globale des voitures
        ListeVoitures.removeIf(voiture -> client.getVoitures().contains(voiture));

        // Supprimer le client de la liste des clients
        listeClients.remove(client);
        System.out.println("Client avec ID " + idClient + " et ses voitures associées ont été supprimés.");
    } else {
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
    //****************GESTION DES EMPLOYEES********************
    /*public void creerEmploye() {
    Scanner scanner = new Scanner(System.in);

    // Demander le type d'employé à créer
    System.out.println("Quel type d'employé voulez-vous créer ? (Laveur, Mécanicien, Chef)");
    String type = scanner.nextLine().trim().toLowerCase();

    // Demander les informations communes pour tous les employés
    System.out.println("Entrez l'ID de l'employé :");
    int id = scanner.nextInt();
    scanner.nextLine(); // Consomme la ligne restante après nextInt

    // Vérifier si un employé avec cet ID existe déjà
    for (Employe e : ListeEmployes) {
        if (e.get_id() == id) {
            System.out.println("Un employé avec cet ID existe déjà. Impossible de créer un nouvel employé.");
            return;
        }
    }

    System.out.println("Entrez le nom de l'employé :");
    String nom = scanner.nextLine();

    System.out.println("Entrez le prénom de l'employé :");
    String prenom = scanner.nextLine();

    System.out.println("Entrez le téléphone de l'employé :");
    int telephone = scanner.nextInt();
    scanner.nextLine(); // Consomme la ligne restante

    System.out.println("Entrez l'adresse de l'employé :");
    String adresse = scanner.nextLine();

    System.out.println("Entrez le salaire de l'employé :");
    double salaire = scanner.nextDouble();
    scanner.nextLine(); // Consomme la ligne restante

    // Création de l'employé en fonction du type spécifié
    Employe nouvelEmploye = null;
    switch (type) {
        case "laveur":
            // Créer un laveur
            nouvelEmploye = new Laveur(id, nom, prenom, telephone, adresse, salaire);
            break;

        case "mécanicien":
            // Demander la spécialité pour le mécanicien
            System.out.println("Entrez la spécialité du mécanicien :");
            String specialite = scanner.nextLine(); // Saisie libre pour la spécialité
            // Créer un mécanicien avec la spécialité
            nouvelEmploye = new Mecanicien(id, nom, prenom, telephone, adresse, salaire, specialite);
            break;

        case "chef":
            // Créer un chef
            nouvelEmploye = new Chef(id, nom, prenom, telephone, adresse, salaire);
            break;

        default:
            System.out.println("Type d'employé invalide !");
            return; // Sortir si le type est invalide
    }

    // Ajouter l'employé à la liste
    if (nouvelEmploye != null) {
        ListeEmployes.add(nouvelEmploye);
        System.out.println("L'employé " + nouvelEmploye.get_nom() + " a été créé et ajouté à la liste.");
    }
}*/
    //*************CREER EMPLOYE*****************
    public void creerEmploye(int id, String nom, String prenom, int telephone, String adresse, double salaire, String typeEmploye) {
    // Vérifier si un employé avec cet ID existe déjà
    for (Employe e : ListeEmployes) {
        if (e.get_id() == id) {
            System.out.println("Un employé avec cet ID existe déjà. Impossible de créer un nouvel employé.");
            return;
        }
    }

    // Créer l'employé en fonction du type
    Employe nouvelEmploye = null;
    switch (typeEmploye.toLowerCase()) {
        case "laveur":
            // Créer un laveur
            nouvelEmploye = new Laveur(id, nom, prenom, telephone, adresse, salaire);
            break;

        case "mécanicien":
            // Demander la spécialité pour le mécanicien
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez la spécialité du mécanicien :");
            String specialite = scanner.nextLine(); // Demander la spécialité du mécanicien

            // Vérifier que la spécialité n'est pas vide
            if (specialite == null || specialite.trim().isEmpty()) {
                System.out.println("La spécialité du mécanicien ne peut pas être vide !");
                return;
            }

            // Créer un mécanicien avec la spécialité
///            nouvelEmploye = new Mecanicien(id, nom, prenom, telephone, adresse, salaire, specialite);
            break;

        case "chef":
            // Créer un chef
            nouvelEmploye = new Chef(id, nom, prenom, telephone, adresse, salaire);
            break;

        default:
            System.out.println("Type d'employé invalide !");
            return;  // Sortir si le type est invalide
    }

    // Ajouter l'employé à la liste
    if (nouvelEmploye != null) {
        ListeEmployes.add(nouvelEmploye);
        System.out.println("L'employé " + nouvelEmploye.get_nom() + " a été créé et ajouté à la liste.");
    }
}
    public void creer_employe(int id, String nom, String prenom, int telephone, String adresse, double salaire, String typeEmploye) {
    // Vérifier si un employé avec cet ID existe déjà
    for (Employe e : ListeEmployes) {
        if (e.get_id() == id) {
            System.out.println("Un employé avec cet ID existe déjà. Impossible de créer un nouvel employé.");
            return;
        }
    }

    // Créer l'employé en fonction du type
    Employe nouvelEmploye = null;
    switch (typeEmploye.toLowerCase()) {
        case "laveur":
            // Créer un laveur
            nouvelEmploye = new Laveur(id, nom, prenom, telephone, adresse, salaire);
            break;

        case "mécanicien":
            // Demander la spécialité pour le mécanicien
            Scanner scanner = new Scanner(System.in);
            System.out.println("Entrez la spécialité du mécanicien :");
            String specialite = scanner.nextLine(); // Demander la spécialité du mécanicien

            // Demander l'expertise du mécanicien
            Expertise expertise = null;
            while (expertise == null) {
                System.out.println("Entrez l'expertise du mécanicien (CHOISIR PARMI : MOTEUR, ELECTRONIQUE, CARROSSERIE) :");
                String expertiseStr = scanner.nextLine().toUpperCase();
                
                // Vérifier que l'expertise correspond à une valeur valide de l'énumération
                try {
                    expertise = Expertise.valueOf(expertiseStr);
                } catch (IllegalArgumentException e) {
                    System.out.println("Expertise invalide ! Veuillez entrer une expertise valide.");
                }
            }

            // Créer un mécanicien avec la spécialité et l'expertise
            nouvelEmploye = new Mecanicien(id, nom, prenom, telephone, adresse, salaire, specialite, expertise);
            break;

        case "chef":
            // Créer un chef
            nouvelEmploye = new Chef(id, nom, prenom, telephone, adresse, salaire);
            break;

        default:
            System.out.println("Type d'employé invalide !");
            return;  // Sortir si le type est invalide
    }

    // Ajouter l'employé à la liste
    if (nouvelEmploye != null) {
        ListeEmployes.add(nouvelEmploye);
        System.out.println("L'employé " + nouvelEmploye.get_nom() + " a été créé et ajouté à la liste.");
    }
}


    //******************afficher employe*****************************
   /* public void afficherEmployes() {
    // Vérifie si la liste des employés est vide
    if (ListeEmployes.isEmpty()) {
        System.out.println("Aucun employé dans la liste.");
        return;
    }

    // Affiche les employés en fonction de leur type
    System.out.println("Liste des Employés :");

    for (Employe employe : ListeEmployes) {
        System.out.println("------------------------------");
        // Affichage des informations de base
        System.out.println("ID: " + employe.get_id());
        System.out.println("Nom: " + employe.get_nom());
        System.out.println("Prénom: " + employe.get_prenom());
        System.out.println("Téléphone: " + employe.get_telephone());
        System.out.println("Adresse: " + employe.get_adresse());
        System.out.println("Salaire: " + employe.get_salaire());

        // Vérification du type d'employé pour afficher des détails spécifiques
        if (employe instanceof Mecanicien) {
            Mecanicien mecanicien = (Mecanicien) employe;
            System.out.println("Type: Mécanicien");
            System.out.println("Spécialité: " + mecanicien.get_specialite());
        } else if (employe instanceof Laveur) {
            Laveur laveur = (Laveur) employe;
            System.out.println("Type: Laveur");

            // Affichage des spécialités du laveur de manière conviviale
            if (laveur.get_specialise_exterieur()) {
                System.out.println("Spécialité: Extérieur (Nettoyage extérieur)");
            } else if (laveur.get_specialise_interieur()) {
                System.out.println("Spécialité: Intérieur (Nettoyage intérieur)");
            } else {
                System.out.println("Spécialité: Non spécifiée");
            }
        } else if (employe instanceof Chef) {
            System.out.println("Type: Chef");
        }

        System.out.println("------------------------------\n");
    }
}*/

public void afficherTousLesEmployes() {
    if (ListeEmployes.isEmpty()) {
        System.out.println("Il n'y a pas d'employés à afficher.");
        return;
    }

    // Parcours de tous les employés dans la liste
    for (Employe employe : ListeEmployes) {
        // Afficher les informations de base de l'employé
        System.out.println("ID : " + employe.get_id());
        System.out.println("Nom : " + employe.get_nom());
        System.out.println("Prénom : " + employe.get_prenom());
        System.out.println("Téléphone : " + employe.get_telephone());
        System.out.println("Adresse : " + employe.get_adresse());
        System.out.println("Salaire : " + employe.get_salaire());
        
        // Vérifier le type d'employé et afficher des informations supplémentaires
        if (employe instanceof Laveur) {
            // Si l'employé est un Laveur, afficher les voitures lavées
            Laveur laveur = (Laveur) employe;
            System.out.println("Type : Laveur");
            try {
                laveur.afficher_historique_voitures();// Affiche les voitures lavées
            } catch (HistoriqueVoituresVideLavMecException e) {
                System.out.println("Aucune voiture lavée.");
            }
        } 
        else if (employe instanceof Mecanicien) {
            // Si l'employé est un Mécanicien, afficher les voitures réparées
            Mecanicien mecanicien = (Mecanicien) employe;
            System.out.println("Type : Mécanicien");
            try {
                mecanicien.afficher_historique_voitures();// Affiche les voitures réparées
            } catch (HistoriqueVoituresVideLavMecException e) {
                System.out.println("Aucune voiture réparée.");
            }
        } 
        else if (employe instanceof Chef) {
            // Si l'employé est un Chef, afficher l'équipe
            Chef chef = (Chef) employe;
            System.out.println("Type : Chef");
            try {
                chef.afficherEquipe();// Affiche l'équipe du chef
            } catch (EquipeVideException e) {
                System.out.println("L'équipe est vide.");
            }
        } 
        else {
            System.out.println("Type d'employé inconnu.");
        }
        System.out.println(); // Ajouter une ligne vide pour séparer chaque employé
    }
}
public void afficher_tous_les_employes() {
    if (ListeEmployes.isEmpty()) {
        System.out.println("Il n'y a pas d'employés à afficher.");
        return;
    }

    // Parcours de tous les employés dans la liste
    for (Employe employe : ListeEmployes) {
        // Afficher les informations de base de l'employé
        System.out.println("ID : " + employe.get_id());
        System.out.println("Nom : " + employe.get_nom());
        System.out.println("Prénom : " + employe.get_prenom());
        System.out.println("Téléphone : " + employe.get_telephone());
        System.out.println("Adresse : " + employe.get_adresse());
        System.out.println("Salaire : " + employe.get_salaire());
        
        // Vérifier le type d'employé et afficher des informations supplémentaires
        if (employe instanceof Laveur) {
            // Si l'employé est un Laveur, afficher les voitures lavées
            Laveur laveur = (Laveur) employe;
            System.out.println("Type : Laveur");
            try {
                laveur.afficher_historique_voitures(); // Affiche les voitures lavées
            } catch (HistoriqueVoituresVideLavMecException e) {
                System.out.println("Aucune voiture lavée.");
            }
        } 
        else if (employe instanceof Mecanicien) {
            // Si l'employé est un Mécanicien, afficher les voitures réparées, la spécialité et l'expertise
            Mecanicien mecanicien = (Mecanicien) employe;
            System.out.println("Type : Mécanicien");
            System.out.println("Spécialité : " + mecanicien.get_specialite());  // Affichage de la spécialité
            System.out.println("Expertise : " + mecanicien.get_expertise());  // Affichage de l'expertise
            try {
                mecanicien.afficher_historique_voitures(); // Affiche les voitures réparées
            } catch (HistoriqueVoituresVideLavMecException e) {
                System.out.println("Aucune voiture réparée.");
            }
        } 
        else if (employe instanceof Chef) {
            // Si l'employé est un Chef, afficher l'équipe
            Chef chef = (Chef) employe;
            System.out.println("Type : Chef");
            try {
                chef.afficherEquipe(); // Affiche l'équipe du chef
            } catch (EquipeVideException e) {
                System.out.println("L'équipe est vide.");
            }
        } 
        else {
            System.out.println("Type d'employé inconnu.");
        }
        System.out.println(); // Ajouter une ligne vide pour séparer chaque employé
    }
}

//Supprimer employe
public void supprimerEmploye(int id) {
    // Vérifier si la liste des employés est vide
    if (ListeEmployes.isEmpty()) {
        System.out.println("La liste des employés est vide.");
        return;
    }

    // Chercher l'employé par son ID
    Iterator<Employe> iterator = ListeEmployes.iterator();
    while (iterator.hasNext()) {
        Employe employe = iterator.next();
        
        // Si l'employé avec l'ID donné est trouvé, le supprimer
        if (employe.get_id() == id) {
            iterator.remove();
            System.out.println("L'employé  " + employe.get_nom() + " "+employe.get_prenom()+" a été supprimé.");
            return;
        }
    }
    
    // Si l'employé n'est pas trouvé
    System.out.println("Aucun employé trouvé avec l'ID " + id + ".");
}
// ajouter voiture a mecanicien ou laveur 
public void ajouterVoitureMecLaveur(int employeId, String voitureId) {
    try {
        // Recherche de la voiture par son ID
        Voiture voiture = trouverVoitureParId(voitureId); // Méthode pour récupérer la voiture par son ID
        
        if (voiture == null) {
            System.out.println("Erreur : Aucune voiture trouvée avec l'ID " + voitureId);
            return; // Sortir de la méthode si la voiture n'existe pas
        }

        // Vérification si la voiture existe dans la liste des voitures disponibles
        if (!get_liste_voitures().contains(voiture)) {
            System.out.println("Erreur : La voiture n'existe pas dans la liste des voitures disponibles.");
            return; // Sortir de la méthode si la voiture n'est pas présente
        }

        // Recherche de l'employé par son ID
        Employe employe = trouverEmployeParId(employeId); // Méthode pour récupérer l'employé par ID
        
        if (employe == null) {
            System.out.println("Erreur : Aucun employé trouvé avec l'ID " + employeId);
            return;
        }

        // Vérification que l'employé est un mécanicien ou un laveur
        if (employe instanceof Mecanicien) {
            Mecanicien mecanicien = (Mecanicien) employe; // Cast de l'employé en mécanicien
            mecanicien.ajouter_voiture(voiture); // Appel à la méthode ajouterVoiture du mécanicien
            System.out.println("La voiture a été ajoutée à l'historique du mécanicien.");
        } else if (employe instanceof Laveur) {
            Laveur laveur = (Laveur) employe; // Cast de l'employé en laveur
            laveur.ajouter_voiture(voiture); // Appel à la méthode ajouterVoiture du laveur
            System.out.println("La voiture a été ajoutée à l'historique du laveur.");
        } else {
            System.out.println("L'employé avec l'ID " + employeId + " n'est ni un mécanicien ni un laveur.");
        }
    } catch (VoitureExistanteDejaPourLavMecException e) {
        // Gestion de l'exception si la voiture est déjà dans l'historique du mécanicien ou laveur
        System.out.println("Erreur : " + e.getMessage());
    }
}
private Voiture trouverVoitureParId(String immatriculation) {
    // Recherche de la voiture dans la liste des voitures disponibles
    for (Voiture v : this.ListeVoitures) { // get_liste_voitures() renvoie la liste des voitures
        if (v.get_immatriculation() == immatriculation) {
            return v; // Retourne la voiture trouvée
        }
    }
    return null; // Retourne null si la voiture n'a pas été trouvée
}
private Employe trouverEmployeParId(int id) {
    // Recherche de l'employé dans la collection d'employés (par exemple une liste ou un ensemble)
    for (Employe e : ListeEmployes) { // listeEmployes est la collection d'employés
        if (e.get_id() == id) {
            return e; // Retourne l'employé trouvé
        }
    }
    return null; // Retourne null si aucun employé n'a été trouvé
}


// ajouter un employe a l equipe d un chef
public void ajouterEmployeAuChef(int chefId, int employeId) {
    try {
        // Rechercher le chef par son ID
        Employe chef = trouverEmployeParId(chefId); // Utilise une méthode existante pour trouver un employé par ID
        if (!(chef instanceof Chef)) {
            System.out.println("Erreur : Aucun chef trouvé avec l'ID " + chefId);
            return;
        }
        
        // Rechercher l'employé par son ID
        Employe employe = trouverEmployeParId(employeId);
        if (employe == null) {
            System.out.println("Erreur : Aucun employé trouvé avec l'ID " + employeId);
            return;
        }

        // Ajouter l'employé à l'équipe du chef
        Chef chefInstance = (Chef) chef; // Cast de l'employé en Chef pour accéder à la méthode ajouterEmploye
        chefInstance.ajouterEmploye(employe); // Appel à la méthode ajouterEmploye
        System.out.println("L'employé a été ajouté avec succès à l'équipe du chef.");
        
    } catch (EmployeExistantException e) {
        System.out.println("Erreur : " + e.getMessage());
    }
}
// afficher les chefs
public void afficherChefs() {
    boolean chefTrouve = false;
    System.out.println("Liste des chefs :");

    // Parcours de la liste des employés
    for (Employe employe : ListeEmployes) { // listeEmployes représente la collection d'employés
        if (employe instanceof Chef) { // Vérifie si l'employé est une instance de Chef
            System.out.println(employe); // Affiche les détails du chef
            chefTrouve = true;
        }
    }

    // Message si aucun chef n'a été trouvé
    if (!chefTrouve) {
        System.out.println("Aucun chef trouvé dans la liste des employés.");
    }
}
// afficher les mecaniciens 
public void afficherMecaniciens() {
    boolean mecanicienTrouve = false;
    System.out.println("Liste des mécaniciens :");

    // Parcours de la liste des employés
    for (Employe employe : ListeEmployes) { // listeEmployes représente la collection d'employés
        if (employe instanceof Mecanicien) { // Vérifie si l'employé est une instance de Mecanicien
            System.out.println(employe); // Affiche les détails du mécanicien
            mecanicienTrouve = true;
        }
    }

    // Message si aucun mécanicien n'a été trouvé
    if (!mecanicienTrouve) {
        System.out.println("Aucun mécanicien trouvé dans la liste des employés.");
    }
}
// afficher les laveurs
public void afficherLaveurs() {
    boolean laveurTrouve = false;
    System.out.println("Liste des laveurs :");

    // Parcours de la liste des employés
    for (Employe employe : ListeEmployes) { // listeEmployes représente la collection d'employés
        if (employe instanceof Laveur) { // Vérifie si l'employé est une instance de Laveur
            System.out.println(employe); // Affiche les détails du laveur
            laveurTrouve = true;
        }
    }

    // Message si aucun laveur n'a été trouvé
    if (!laveurTrouve) {
        System.out.println("Aucun laveur trouvé dans la liste des employés.");
    }
}


public ArrayList<Voiture> get_liste_voitures()
{
    return this.ListeVoitures;

}





}









