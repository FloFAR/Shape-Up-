package Moteur_Jeu;

import java.util.*;

import Moteur_Jeu.Carte.Couleur;
import Moteur_Jeu.Carte.Forme;
import Moteur_Jeu.Carte.Rempli;

/**
* La classe JeuDeCartes va contenir différents objets provenant de la classe {@link Moteur_Jeu.Carte}.
* Un jeu de cartes va être utilisé par les joueurs afin de tirer leur carte victoire,
* tirer une carte et de la jouer.
* @author Farcy Florentin
*/
public class JeuDeCartes {
	
	/**
	* Le nombre total de couleurs (excepté RIEN).
	*/
	public final static int NOMBRE_COULEUR = Couleur.values().length-1;
	
	/**
	* Le nombre total de formes (excepté RIEN).
	*/
	public final static int NOMBRE_FORME = Forme.values().length-1;
	
	/**
	* Le nombre total de remplissage (excepté RIEN).
	*/
	public final static int NOMBRE_REMPLI = Rempli.values().length-1;
	
	/**
	* Le nombre total de {@link Moteur_Jeu.Carte cartes} jouables dans le paquet.
	*/
	public final static int NOMBRE_CARTES_PAQUET= NOMBRE_COULEUR*NOMBRE_FORME*NOMBRE_REMPLI;
	
	/**
	* Paquet de cartes contenant les différentes {@link Moteur_Jeu.Carte cartes}.
	*/
	private LinkedList<Carte> tasDeCartes;

	
	/**
	* Instancie un jeu de cartes en créant une {@link Moteur_Jeu.Carte carte}
	* avec chaque {@linkplain Moteur_Jeu.Carte.Forme forme},
	* {@linkplain Moteur_Jeu.Carte.Couleur couleur} et {@linkplain Moteur_Jeu.Carte.Rempli remplissage}.
	* 
	* @author Farcy Florentin
	*/
	public JeuDeCartes() {
		tasDeCartes = new LinkedList<Carte>();
		for (int i=0; i < NOMBRE_COULEUR; i++) {
			for (int j=0; j < NOMBRE_FORME; j++) {
				for (int k=0; k < NOMBRE_REMPLI; k++) {
					Carte card = new Carte(Couleur.values()[i],Forme.values()[j],Rempli.values()[k]);
					tasDeCartes.add(card);
				}
			}
		}
	}

	
	/**
	* Change la position de tous les élements de la liste {@link tasDeCartes}.
	* Cela permet d'avoir des parties différentes et d'éviter la triche en connaissant l'ordre préalable 
	* des cartes en sachant leur indice dans la liste {@link tasDeCartes}.
	* @author Farcy Florentin
	*/
	public void mélanger() {
		for (int i=0; i < JeuDeCartes.NOMBRE_CARTES_PAQUET; i++) {
			int position = (int)
			Math.round((JeuDeCartes.NOMBRE_CARTES_PAQUET -1) * Math.random());
			Carte carte = tasDeCartes.pop();
			tasDeCartes.add(position,carte);
		}
	}
	
	/**
	* Retire le dernier élément de la liste {@link tasDeCartes}.
	* Cette méthode va être utilisé par les joueurs pour piocher leur carte.
	* @return Renvoie la carte qui a été retiré.
	* @author Farcy Florentin
	*/
	public Carte tirerCarteDessus() {
		return tasDeCartes.pop();
	}
	
	/**
	* Redéfinis l'affichage du jeu de cartes. 
	* @return La liste contenant les différentes cartes qui la composent sous la forme [{@linkplain Moteur_Jeu.Carte.Forme FORME} {@linkplain Moteur_Jeu.Carte.Couleur COULEUR} {@linkplain Moteur_Jeu.Carte.Rempli REMPLI}, ..., {@linkplain Moteur_Jeu.Carte.Forme FORME} {@linkplain Moteur_Jeu.Carte.Couleur COULEUR} {@linkplain Moteur_Jeu.Carte.Rempli REMPLI} ]
	* @author Farcy Florentin
	*/
	public String toString() {
		return tasDeCartes.toString();
	}
}