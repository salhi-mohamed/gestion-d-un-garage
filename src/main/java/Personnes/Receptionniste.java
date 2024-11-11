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
//****************GESTION DES VOITURES********************
    //creer voiture
public void creerVoiture(int idClient, String marque, String modele, int annee, long kilometrage, String immatriculation) {
    // Vérifier si le client avec l'id donné existe dans la liste des clients
    Client clientExist = null;
    for (Client client : listeClients) {
        if (client.get_id() == idClient) {
            clientExist = client;
            break;
        }
    }

    // Si le client existe, créer la voiture et l'ajouter au client
    if (clientExist != null) {
        // Création de la nouvelle voiture avec les informations données
        Voiture voiture = new Voiture(marque, modele, annee, kilometrage, immatriculation, clientExist);
        this.ListeVoitures.add(voiture);

        // Ajouter la voiture à la collection de voitures du client
        clientExist.ajouterVoiture(voiture);  // On suppose que Client a une méthode ajouterVoiture()
        System.out.println("Voiture créée et ajoutée au client avec succès.");
    } else {
        // Si le client n'existe pas
        System.out.println("Client avec ID " + idClient + " n'existe pas. La voiture n'a pas été créée.");
    }
}
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
            }
        } else {
            System.out.println("Aucune voiture associée à ce client.");
        }
    }
}
//supprimer voiture
/*public void supprimerVoiture(int idVoiture) {
    // Parcourir la liste des voitures
    Iterator<Voiture> iterator = listeVoitures.iterator();
    boolean voitureSupprimee = false;

    while (iterator.hasNext()) {
        Voiture voiture = iterator.next();

        // Vérifier si l'ID de la voiture correspond à l'ID passé en argument
        if (voiture.get_() == idVoiture) {
            // Supprimer la voiture de la liste
            iterator.remove();
            voitureSupprimee = true;
            System.out.println("Voiture supprimée avec succès.");
            break;
        }
    }

    // Si aucune voiture n'a été supprimée
    if (!voitureSupprimee) {
        System.out.println("Aucune voiture trouvée avec l'ID " + idVoiture);
    }
}*/




   

    // Méthode pour planifier un rendez-vous
  /* public void PlanifierRendezVous(Client client, Voiture voiture) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Entrez l'ID du rendez-vous : ");
        int idRendezVous = scanner.nextInt();
        scanner.nextLine(); // Pour consommer la nouvelle ligne

        System.out.println("La description du rendez-vous : ");
        String desc = scanner.nextLine();

        System.out.println("Confirmation du rendez-vous (confirmée/non confirmée) : ");
        String confirmationInput = scanner.nextLine();
        
        boolean confirme = confirmationInput.equalsIgnoreCase("confirmée");

        // Créer le nouveau rendez-vous avec les informations fournies
        Rendez_vous nouveauRendezVous = new Rendez_vous(idRendezVous, desc, confirme, voiture, client);
        
        // Ajouter le rendez-vous à la liste
        listeRendezVous.add(nouveauRendezVous);
        System.out.println("Rendez-vous planifié avec succès pour le client " + client.get_nom());
    }
   @Override
   public void afficher() {
    System.out.println("=== Informations du Réceptionniste ===");
    super.afficher();
    System.out.println("Numéro de Bureau : " + numeroBureau);
    System.out.println("Email : " + email);
    System.out.println("Liste des Rendez-vous :");

    if (listeRendezVous.isEmpty()) {
        System.out.println("Aucun rendez-vous programmé.");
    } else {
        for (Rendez_vous rendezVous : listeRendezVous) {
            System.out.println("-----------------------------------");
            System.out.println("ID Rendez-vous : " + rendezVous.getId_rendez_vous());
            System.out.println("Date du Rendez-vous : " + rendezVous.getDate_rendez_vous());
            System.out.println("Description : " + rendezVous.getDescription_rendez_vous());
            System.out.println("Confirmation : " + (rendezVous.isConfirme() ? "confirmée" : "non confirmée"));
            System.out.println("Voiture Concernée : " + rendezVous.getVoiture().get_immatriculation());
            System.out.println("Client Concerné : " + rendezVous.getClient().get_nom());
        }
    }
}
   public void annuler_rendez_vous() {
    if (listeRendezVous.isEmpty()) {
        System.out.println("Aucun rendez-vous à supprimer.");
        return;
    }

    System.out.println("=== Liste des Rendez-vous ===");
    for (Rendez_vous rendezVous : listeRendezVous) {
        System.out.println("ID Rendez-vous : " + rendezVous.getId_rendez_vous() +
                           ", Date : " + rendezVous.getDate_rendez_vous() +
                           ", Description : " + rendezVous.getDescription_rendez_vous() +
                           ", Confirmation : " + (rendezVous.isConfirme() ? "confirmée" : "non confirmée"));
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("Entrez l'ID du rendez-vous à supprimer : ");
    int idRendezVous = scanner.nextInt();

    boolean rendezVousTrouve = false;

    for (int i = 0; i < listeRendezVous.size(); i++) {
        if (listeRendezVous.get(i).getId_rendez_vous() == idRendezVous) {
            listeRendezVous.remove(i);
            System.out.println("Rendez-vous avec l'ID " + idRendezVous + " supprimé avec succès.");
            rendezVousTrouve = true;
            break;
        }
    }

    if (!rendezVousTrouve) {
        System.out.println("Aucun rendez-vous trouvé avec l'ID fourni.");
    }
}
   @Override
public void modifier() {
    int choice;
    Scanner sc = new Scanner(System.in);

    do {
        do {
            System.out.println("Que voulez-vous modifier ?");
            System.out.println("1 : nom");
            System.out.println("2 : prenom");
            System.out.println("3 : adresse");
            System.out.println("4 : telephone");
            System.out.println("5 : salaire");
            System.out.println("6 : date d'embauche");
            System.out.println("7 : email");
            System.out.println("8 : numero de guichet");
            System.out.println("0 : quitter");

            while (!sc.hasNextInt()) {
                System.out.println("Saisie invalide, veuillez entrer un nombre entre 0 et 8.");
                sc.next(); // Consume invalid input
            }
            choice = sc.nextInt();

            if (choice < 0 || choice > 8) {
                System.out.println("Choix invalide, veuillez entrer un nombre entre 0 et 8.");
            }
        } while (choice < 0 || choice > 8);

        sc.nextLine(); // Consume the newline after nextInt()
        switch (choice) {
            case 1:
                System.out.println("Saisir le nouveau nom : ");
                super.set_nom(sc.nextLine());
                System.out.println("Nom mis à jour.");
                break;

            case 2:
                System.out.println("Saisir le nouveau prénom : ");
                super.set_prenom(sc.nextLine());
                System.out.println("Prénom mis à jour.");
                break;

            case 3:
                System.out.println("Saisir la nouvelle adresse : ");
                super.set_adresse(sc.nextLine());
                System.out.println("Adresse mise à jour.");
                break;

            case 4:
                System.out.println("Saisir le nouveau téléphone : ");
                while (!sc.hasNextInt()) {
                    System.out.println("Saisie invalide, veuillez entrer un numéro de téléphone valide.");
                    sc.next(); // Consume invalid input
                }
                super.set_telephone(sc.nextInt());
                sc.nextLine(); // Consume the newline
                System.out.println("Téléphone mis à jour.");
                break;

            case 5:
                System.out.println("Saisir le nouveau salaire : ");
                while (!sc.hasNextDouble()) {
                    System.out.println("Saisie invalide, veuillez entrer un salaire valide.");
                    sc.next(); // Consume invalid input
                }
                set_salaire(sc.nextDouble());
                sc.nextLine(); // Consume the newline
                System.out.println("Salaire mis à jour.");
                break;

            case 6:
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                boolean dateValide = false;
                while (!dateValide) {
                    System.out.println("Veuillez entrer la nouvelle date d'embauche (format: dd/MM/yyyy) : ");
                    String dateInput = sc.nextLine();
                    try {
                        set_date_embauche(LocalDate.parse(dateInput, formatter));
                        System.out.println("Date d'embauche mise à jour.");
                        dateValide = true;
                    } catch (DateTimeParseException e) {
                        System.out.println("Format de date invalide. Utilisez le format dd/MM/yyyy.");
                    }
                }
                break;

            case 7:
                System.out.println("Saisir le nouvel email : ");
                String email = sc.nextLine();
                if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                    set_email(email);
                    System.out.println("Email mis à jour.");
                } else {
                    System.out.println("Format d'email invalide.");
                }
                break;

            case 8:
                System.out.println("Saisir le nouveau numéro de guichet : ");
                while (!sc.hasNextInt()) {
                    System.out.println("Saisie invalide, veuillez entrer un numéro de guichet valide.");
                    sc.next(); // Consume invalid input
                }
                set_num_bureau(sc.nextInt());
                sc.nextLine(); // Consume the newline
                System.out.println("Numéro de guichet mis à jour.");
                break;

            case 0:
                System.out.println("Quitter le menu.");
                break;
        }
    } while (choice != 0);

    sc.close(); // Close the scanner after usage
}
public void set_email(String email)
{
    this.email=email;
}
public void set_num_bureau(int num)
{
    this.numeroBureau=num;
}
public void confirmerRendezVous(Rendez_vous rendezVous) {
        Iterator<Rendez_vous> iterator = listeRendezVous.iterator();
        boolean found = false;

        try {
            while (iterator.hasNext()) {
                Rendez_vous rv = iterator.next();
                
                // Check if it's the same rendezvous
                if (rv.equals(rendezVous)) {  
                    rv.setConfirme(true); // Update the confirmation status
                    System.out.println("Le rendez-vous a été confirmé.");
                    found = true;
                    break;
                }
            }

            // If no match was found, throw a custom exception
            if (!found) {
                throw new RendezVousNotFoundException("Rendez-vous non trouvé dans la liste.");
            }

        } catch (RendezVousNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Une erreur inattendue s'est produite : " + e.getMessage());
        }



}
public void modifierRendezVous() {
    if (listeRendezVous.isEmpty()) {
        System.out.println("Aucun rendez-vous à modifier.");
        return;
    }

    // Afficher tous les rendez-vous avec un index pour le choix
    System.out.println("Liste des rendez-vous :");
    int index = 1;
    for (Rendez_vous rv : listeRendezVous) {
        System.out.println(index + ". " + rv);
        index++;
    }

    // Demander à l'utilisateur de choisir un rendez-vous à modifier
    Scanner scanner = new Scanner(System.in);
    int choix = -1;
    boolean choixValide = false;

    while (!choixValide) {
        try {
            System.out.print("Veuillez entrer le numéro du rendez-vous à modifier : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Pour consommer la nouvelle ligne

            if (choix > 0 && choix <= listeRendezVous.size()) {
                choixValide = true;
            } else {
                System.out.println("Numéro invalide. Veuillez réessayer.");
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrée invalide. Veuillez entrer un numéro.");
            scanner.nextLine(); // Consommer l'entrée incorrecte
        }
    }

    // Sélectionner et modifier le rendez-vous choisi
    Rendez_vous rendezVousChoisi = listeRendezVous.get(choix - 1);
    rendezVousChoisi.modifier();  // Appel de la méthode modifier de Rendez_vous
    System.out.println("Rendez-vous modifié avec succès.");
*/
}







