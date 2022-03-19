package Moteur_Jeu;

import Moteur_Jeu.Carte.Couleur;

/**
* La classe Stratégie représente la stratégie que va mettre en place le
* {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} pour jouer.
* La classe va implémenter les méthodes de l'interface {@link Moteur_Jeu.PlayerStrategy}.
* @author Farcy Florentin
*/
public class Stratégie implements PlayerStrategy {

	/**
	* L'attribut board spécifie le {@link Moteur_Jeu.Board plateau de jeu} 
	* sur lequel la stratégie doit agir.
	*/
	private Board board;
	
	/**
	* Instancie une stratégie.
	* @param board Le {@link Moteur_Jeu.Board plateau de jeu} sur lequel la stratégie va agir.
	* @author Farcy Florentin
	*/
	public Stratégie(Board board) {
		super();
		this.board = board;
	}
	
	/**
	* Spécifie la méthode {@link Moteur_Jeu.PlayerStrategy#poserCarte(Carte) poserCarte}
	* de l'interface {@link Moteur_Jeu.PlayerStrategy PlayerStrategy} qui va permettre
	* au {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} de poser sa {@link Moteur_Jeu.Carte carte}.
	* La stratégie consiste à "balayer" le {@link Moteur_Jeu.Board plateau de jeu} 
	* de gauche à droite et de haut en bas jusqu'à trouver un emplacement vide
	* et adjacent à une autre {@link Moteur_Jeu.Carte carte} grâce
	* à la méthode {@linkplain Moteur_Jeu.Board#vérifierAdjacenceVirtuel(int, int) vérifierAdjacenceVirtuel}.
	* @param carte La carte que le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} va poser.
	* @author Farcy Florentin
	*/
	public void poserCarte(Carte carte) {
		int i=0;
		int j=0;
		boolean posé=false;
		while (posé==false ) {
			if ( this.board.getPlateau().get(i).get(j).getCouleur()==Couleur.RIEN && this.board.vérifierAdjacenceVirtuel(i,j)==true ) {
				this.board.getPlateau().get(i).set(j,carte);
				posé=true;
			}
			else {
				j++;
				if (j==5) {
					i++;
					j=0;
				}
			}
		}
	}

}