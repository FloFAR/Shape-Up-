package Moteur_Jeu;

/**
* La classe AfficheurScore implémente les méthodes de l'interface {@link Moteur_Jeu.ScoreVisitor}
* 
* @author Farcy Florentin
*/
public class AfficheurScore implements ScoreVisitor {

	/**
	* Instancie un objet qui va compter les scores des joueurs.
	*/
	public AfficheurScore() {
		
	}

	/**
	* Renvoie le score provenant de la {@linkplain Moteur_Jeu.Carte.Forme forme} de la carte victoire du joueur.
	* <br/>
	* On balaye chaque ligne et colonne du {@link Moteur_Jeu.Board plateau de jeu} et en fonction
	* du nombre de {@link Moteur_Jeu.Carte cartes} possédant la même {@linkplain Moteur_Jeu.Carte.Forme forme}
	* que la carte victoire, on vérifie chaque cas de positionnement des {@link Moteur_Jeu.Carte cartes}.
	* @param J Le joueur dont on va compter les scores en retournant sa carte victoire.
	* @param board {@link Moteur_Jeu.Board Plateau de jeu} sur lequel va agir le visiteur.
	* @return Le score venant de la {@linkplain Moteur_Jeu.Carte.Forme forme} de la carte victoire du joueur.
	* @author Farcy Florentin
	*/
	public int ScoreForme(Joueur J, Board board) {
		int scoreForme=0;
		for (int i = 0; i < board.DIMENSIONX; i++) {
			int nmbX=0;
			for (int j = 0; j < board.DIMENSIONY; j++) {
				if ( board.getPlateau().get(i).get(j).getForme()==J.getCarteVictoire().getForme() ) {
					nmbX++;
				}
			}
			if ( nmbX>=2 ) {
				if ( nmbX==2 ) {
					if ( ( board.getPlateau().get(i).get(0).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(1).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(i).get(1).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(2).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(i).get(2).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(3).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(i).get(3).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(4).getForme()==J.getCarteVictoire().getForme() ) ) {
						scoreForme+=1;
					}
				}
				else if ( nmbX==3 ) {
					if ( ( board.getPlateau().get(i).get(0).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(1).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(2).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(i).get(1).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(2).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(3).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(i).get(2).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(3).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(4).getForme()==J.getCarteVictoire().getForme() ) ) {
						scoreForme+=2;
					}
					
				}
				else if ( nmbX==4 ) {
					if ( (board.getPlateau().get(i).get(0).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(1).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(2).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(3).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(i).get(1).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(2).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(3).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(4).getForme()==J.getCarteVictoire().getForme() ) )  {
						scoreForme+=3;
					}
					else if ( board.getPlateau().get(i).get(0).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(1).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(3).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(i).get(4).getForme()==J.getCarteVictoire().getForme() ) {
						scoreForme+=2;
					}
				}
				else {
					scoreForme+=4;
				}
			}
		}
		for (int j = 0; j < board.DIMENSIONY; j++) {
			int nmbY=0;
			for (int i = 0; i < board.DIMENSIONX; i++) {
				if ( board.getPlateau().get(i).get(j).getForme()==J.getCarteVictoire().getForme() ) {
					nmbY++;
				}
			}
			if ( nmbY>=2 ) {
				if ( nmbY==2 ) {
					if ( ( board.getPlateau().get(0).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(1).get(j).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(1).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(2).get(j).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(2).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(3).get(j).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(3).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(4).get(j).getForme()==J.getCarteVictoire().getForme() ) ) {
						scoreForme+=1;
					}
				}
				else if ( nmbY==3 ) {
					if ( ( board.getPlateau().get(0).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(1).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(2).get(j).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(1).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(2).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(3).get(j).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(2).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(3).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(4).get(j).getForme()==J.getCarteVictoire().getForme() ) ) {
						scoreForme+=2;
					}		
				}
				else if ( nmbY==4 ) {
					if ( (board.getPlateau().get(0).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(1).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(2).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(3).get(j).getForme()==J.getCarteVictoire().getForme() ) || ( board.getPlateau().get(1).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(2).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(3).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(4).get(j).getForme()==J.getCarteVictoire().getForme() ) )  {
						scoreForme+=3;
					}
					else if ( board.getPlateau().get(0).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(1).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(3).get(j).getForme()==J.getCarteVictoire().getForme() && board.getPlateau().get(4).get(j).getForme()==J.getCarteVictoire().getForme() ) {
						scoreForme+=2;
					}
				}
				else {
					scoreForme+=4;
				}
			}
				
		}
		return scoreForme;
	}
	
	/**
	* Renvoie le score provenant de la {@linkplain Moteur_Jeu.Carte.Couleur couleur} de la carte victoire du joueur.
	* On balaye chaque ligne et colonne du {@link Moteur_Jeu.Board plateau de jeu} et en fonction
	* du nombre de {@link Moteur_Jeu.Carte cartes} possédant la même {@linkplain Moteur_Jeu.Carte.Couleur couleur}
	* que la carte victoire, on vérifie chaque cas de positionnement des {@link Moteur_Jeu.Carte cartes}.
	* @param J Le joueur dont on va compter les scores en retournant sa carte victoire.
	* @param board {@link Moteur_Jeu.Board Plateau de jeu} sur lequel va agir le visiteur.
	* @return Le score venant de la {@linkplain Moteur_Jeu.Carte.Couleur couleur} de la carte victoire du joueur.
	* @author Farcy Florentin
	*/
	public int ScoreCouleur(Joueur J, Board board) {
		int scoreCouleur=0;
		for (int i = 0; i < board.DIMENSIONX; i++) {
			int nmbX=0;
			for (int j = 0; j < board.DIMENSIONY; j++) {
				if ( board.getPlateau().get(i).get(j).getCouleur()==J.getCarteVictoire().getCouleur() ) {
					nmbX++;
				}
			}
			if ( nmbX>=3 ) {
				 if ( nmbX==3 ) {
					if ( ( board.getPlateau().get(i).get(0).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(1).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(2).getCouleur()==J.getCarteVictoire().getCouleur() ) || ( board.getPlateau().get(i).get(1).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(2).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(3).getCouleur()==J.getCarteVictoire().getCouleur() ) || ( board.getPlateau().get(i).get(2).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(3).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(4).getCouleur()==J.getCarteVictoire().getCouleur() ) ) {
						scoreCouleur+=4;
					}
					
				}
				else if ( nmbX==4 ) {
					if ( ( board.getPlateau().get(i).get(0).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(1).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(2).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(3).getCouleur()==J.getCarteVictoire().getCouleur() ) || ( board.getPlateau().get(i).get(1).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(2).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(3).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(i).get(4).getCouleur()==J.getCarteVictoire().getCouleur() ) )  {
						scoreCouleur+=5;
					}
				}
				else {
					scoreCouleur+=6;
				}
			}
		}
		for (int j = 0; j < board.DIMENSIONY; j++) {
			int nmbY=0;
			for (int i = 0; i < board.DIMENSIONX; i++) {
				if ( board.getPlateau().get(i).get(j).getCouleur()==J.getCarteVictoire().getCouleur() ) {
					nmbY++;
				}
			}
			if ( nmbY>=3 ) {
				if ( nmbY==3 ) {
					if ( ( board.getPlateau().get(0).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(1).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(2).get(j).getCouleur()==J.getCarteVictoire().getCouleur() ) || ( board.getPlateau().get(1).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(2).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(3).get(j).getCouleur()==J.getCarteVictoire().getCouleur() ) || ( board.getPlateau().get(2).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(3).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(4).get(j).getCouleur()==J.getCarteVictoire().getCouleur() ) ) {
						scoreCouleur+=4;
					}
					
				}
				else if ( nmbY==4 ) {
					if ( (board.getPlateau().get(0).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(1).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(2).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(3).get(j).getCouleur()==J.getCarteVictoire().getCouleur() ) || ( board.getPlateau().get(1).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(2).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(3).get(j).getCouleur()==J.getCarteVictoire().getCouleur() && board.getPlateau().get(4).get(j).getCouleur()==J.getCarteVictoire().getCouleur() ) )  {
						scoreCouleur+=5;
					}
				}
				else {
					scoreCouleur+=6;
				}
			}
				
		}
		return scoreCouleur;
	}
	
	/**
	* Renvoie le score provenant du {@linkplain Moteur_Jeu.Carte.Rempli remplissage} de la carte victoire du joueur.
	* @param J Le joueur dont on va compter les scores en retournant sa carte victoire.
	* @param board {@link Moteur_Jeu.Board Plateau de jeu} sur lequel va agir le visiteur.
	* @return Le score venant du {@linkplain Moteur_Jeu.Carte.Rempli remplissage} de la carte victoire du joueur.
	* @author Farcy Florentin
	*/
	public int ScoreRempli(Joueur J, Board board) {
		int scoreRempli=0;
		for (int i = 0; i < board.DIMENSIONX; i++) {
			int nmbX=0;
			for (int j = 0; j < board.DIMENSIONY; j++) {
				if ( board.getPlateau().get(i).get(j).getRempli()==J.getCarteVictoire().getRempli() ) {
					nmbX++;
				}
			}
			if ( nmbX>=3 ) {
				
				if ( nmbX==3 ) {
					if ( ( board.getPlateau().get(i).get(0).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(1).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(2).getRempli()==J.getCarteVictoire().getRempli() ) || ( board.getPlateau().get(i).get(1).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(2).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(3).getRempli()==J.getCarteVictoire().getRempli() ) || ( board.getPlateau().get(i).get(2).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(3).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(4).getRempli()==J.getCarteVictoire().getRempli() ) ) {
						scoreRempli+=3;
					}
					
				}
				else if ( nmbX==4 ) {
					if ( (board.getPlateau().get(i).get(0).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(1).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(2).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(3).getRempli()==J.getCarteVictoire().getRempli() ) || ( board.getPlateau().get(i).get(1).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(2).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(3).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(i).get(4).getRempli()==J.getCarteVictoire().getRempli() ) )  {
						scoreRempli+=4;
					}
				}
				else {
					scoreRempli+=5;
				}
			}
		}
		for (int j = 0; j < board.DIMENSIONY; j++) {
			int nmbY=0;
			for (int i = 0; i < board.DIMENSIONX; i++) {
				if ( board.getPlateau().get(i).get(j).getRempli()==J.getCarteVictoire().getRempli() ) {
					nmbY++;
				}
			}
			if ( nmbY>=3 ) {
				
				if ( nmbY==3 ) {
					if ( ( board.getPlateau().get(0).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(1).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(2).get(j).getRempli()==J.getCarteVictoire().getRempli() ) || ( board.getPlateau().get(1).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(2).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(3).get(j).getRempli()==J.getCarteVictoire().getRempli() ) || ( board.getPlateau().get(2).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(3).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(4).get(j).getRempli()==J.getCarteVictoire().getRempli() ) ) {
						scoreRempli+=3;
					}
					
				}
				else if ( nmbY==4 ) {
					if ( (board.getPlateau().get(0).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(1).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(2).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(3).get(j).getRempli()==J.getCarteVictoire().getRempli() ) || ( board.getPlateau().get(1).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(2).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(3).get(j).getRempli()==J.getCarteVictoire().getRempli() && board.getPlateau().get(4).get(j).getRempli()==J.getCarteVictoire().getRempli() ) )  {
						scoreRempli+=4;
					}
				}
				else {
					scoreRempli+=5;
				}
			}
				
		}
		return scoreRempli;
	}
	
	/**
	* Change le score du joueur.
	* Cette méthode utilise les trois autres méthodes {@link #ScoreForme(Joueur, Board) ScoreForme}
	* , #ScoreCouleur(Joueur, Board) ScoreCouleur} et #ScoreRempli(Joueur, Board) ScoreRempli}
	* afin de calculer le score total du joueur.
	* @param J Le joueur dont on va compter les scores en grâce à sa carte victoire.
	* @param board {@link Moteur_Jeu.Board Plateau de jeu} sur lequel va agir le visiteur.
	* @author Farcy Florentin
	*/
	public void ScoreJoueur(Joueur J, Board board) {
		J.setScore(ScoreCouleur(J, board)+this.ScoreForme(J, board)+this.ScoreRempli(J, board));
	}

}