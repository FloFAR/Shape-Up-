package Moteur_Jeu;

import java.util.*;

import Moteur_Jeu.Carte.Couleur;
import Moteur_Jeu.Carte.Forme;
import Moteur_Jeu.Carte.Rempli;

/**
* La classe Joueur apporte différentes méthodes afin de jouer au jeu.
* Le joueur va être capable de donner les coordonnées de l'emplacement
* sur lequel il veut {@link Moteur_Jeu.ShapeUpGame#bougerCarte(Carte, int, int) bouger} 
* ou {@link Moteur_Jeu.ShapeUpGame#placerCarte(Carte, int, int) placer}  une {@link Moteur_Jeu.Carte carte}.
* 
* @author Farcy Florentin
*/
public class Joueur {
	
	/**
	* Le nom du joueur.
	*/
	private String nomJ;
	
	/**
	* La carte victoire du joueur.
	*/
	private Carte carteVictoire;
	
	/**
	* La {@link Moteur_Jeu.Carte carte} que le joueur a pioché avec la méthode {@linkplain Moteur_Jeu.JeuDeCartes#tirerCarteDessus() tirerCarteDessus}.
	*/
	private Carte main; 
	
	/**
	* Le score du joueur. Au début de la partie, il n'a pas de point.
	*/
	private int Score=0;
	
	/**
	* Instancie un joueur avec son nom et lui donne la {@linkplain Moteur_Jeu.Carte carte} ayant RIEN comme {@linkplain Moteur_Jeu.Carte.Forme forme}, {@link Moteur_Jeu.Carte.Couleur couleur} et {@link Moteur_Jeu.Carte.Rempli remplissage}.
	* @param nom Le nom du joueur.
	* @author Farcy Florentin
	*/
	public Joueur(String nom) {
		Carte a = new Carte(Couleur.RIEN,Forme.RIEN,Rempli.RIEN);
		this.nomJ=nom;
		this.main=a;
	}
	
	/**
	* Renvoie le numéro de la ligne entré par le joueur.
	* @return Le numéro de la ligne que le joueur a tapé au clavier. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @exception InputMismatchException Si le joueur rentre un caractère non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public int demanderCarteX() {
		Scanner in = new Scanner(System.in);
		System.out.println("Entrez le numéro de ligne");
	    int x = in.nextInt();
	    return x;
	}
	
	/**
	* Renvoie le numéro de la colonne entré par le joueur.
	* @return Le numéro de la colonne que le joueur a tapé au clavier. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}
	* @exception InputMismatchException Si le joueur rentre un caractère non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public int demanderCarteY() {
		Scanner in = new Scanner(System.in);
	    System.out.println("Entrez le numéro de colonne");
	    int y = in.nextInt();
	    return y;
	}
	
	/**
	* Renvoie le score du joeuur.
	* @return Le score du joueur.
	* @author Farcy Florentin
	*/
	public int getScore() {
		return Score;
	}
	
	/**
	* Attribue un score au joueur.
	* @param score Le score que l'on veut attribuer au joueur.
	* @author Farcy Florentin
	*/
	public void setScore(int score) {
		Score = score;
	}

	/**
	* Renvoie la carte victoire du joueur.
	* @return La carte victoire du joueur.
	* @author Farcy Florentin
	*/
	public Carte getCarteVictoire() {
		return carteVictoire;
	}
	
	/**
	* Attribue une carte victoire au joueur.
	* @param carteVictoire La carte victoire que l'on va attribuer au joueur lors du {@linkplain Moteur_Jeu.ShapeUpGame#débutPartie() début de partie}.
	* @author Farcy Florentin
	*/
	public void setCarteVictoire(Carte carteVictoire) {
		this.carteVictoire = carteVictoire;
	}
	
	/**
	* Attribue une carte au joueur et la met dans sa main.
	* On va utiliser cette méthode avec {@link Moteur_Jeu.JeuDeCartes#tirerCarteDessus() tirerCarteDessus}
	* pour que le joueur prenne dans sa main la {@link Moteur_Jeu.Carte carte} qu'il vient de {@link piocherCarte(Carte) piocher}.
	* @param carte La carte que le joueur vient de piocher
	* @author Farcy Florentin
	*/
	public void piocherCarte(Carte carte) {
		this.main=carte;
	}
	
	/**
	* Renvoie la main du joueur.
	* @return La main du joueur.
	* @author Farcy Florentin
	*/
	public Carte getMain() {
		return main;
	}
	
	/**
	* Redéfini la méthode toString() afin de renvoyer le nom du joueur.
	* @return Le nom du joueur.
	* @author Farcy Florentin
	*/
	public String toString() {
		return nomJ.toString();
	}
}