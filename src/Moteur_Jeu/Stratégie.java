package Moteur_Jeu;

import Moteur_Jeu.Carte.Couleur;

/**
* La classe Strat�gie repr�sente la strat�gie que va mettre en place le
* {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} pour jouer.
* La classe va impl�menter les m�thodes de l'interface {@link Moteur_Jeu.PlayerStrategy}.
* @author Farcy Florentin
*/
public class Strat�gie implements PlayerStrategy {

	/**
	* L'attribut board sp�cifie le {@link Moteur_Jeu.Board plateau de jeu} 
	* sur lequel la strat�gie doit agir.
	*/
	private Board board;
	
	/**
	* Instancie une strat�gie.
	* @param board Le {@link Moteur_Jeu.Board plateau de jeu} sur lequel la strat�gie va agir.
	* @author Farcy Florentin
	*/
	public Strat�gie(Board board) {
		super();
		this.board = board;
	}
	
	/**
	* Sp�cifie la m�thode {@link Moteur_Jeu.PlayerStrategy#poserCarte(Carte) poserCarte}
	* de l'interface {@link Moteur_Jeu.PlayerStrategy PlayerStrategy} qui va permettre
	* au {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} de poser sa {@link Moteur_Jeu.Carte carte}.
	* La strat�gie consiste � "balayer" le {@link Moteur_Jeu.Board plateau de jeu} 
	* de gauche � droite et de haut en bas jusqu'� trouver un emplacement vide
	* et adjacent � une autre {@link Moteur_Jeu.Carte carte} gr�ce
	* � la m�thode {@linkplain Moteur_Jeu.Board#v�rifierAdjacenceVirtuel(int, int) v�rifierAdjacenceVirtuel}.
	* @param carte La carte que le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} va poser.
	* @author Farcy Florentin
	*/
	public void poserCarte(Carte carte) {
		int i=0;
		int j=0;
		boolean pos�=false;
		while (pos�==false ) {
			if ( this.board.getPlateau().get(i).get(j).getCouleur()==Couleur.RIEN && this.board.v�rifierAdjacenceVirtuel(i,j)==true ) {
				this.board.getPlateau().get(i).set(j,carte);
				pos�=true;
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