package Moteur_Jeu;

/**
* L'interface ScoreVisitor apporte différentes méthodes qui vont s'occuper du décompte des points de chaque joueur.
* L'interface suit le patron de conception Visitor.
* @see <a href="https://www.codingame.com/playgrounds/8339/design-pattern-visitor/exemple-dutilisation">https://www.codingame.com/playgrounds/8339/design-pattern-visitor/exemple-dutilisation"</a>
* @author Farcy Florentin
*/
public interface ScoreVisitor {
	
	/**
	* Renvoie le score provenant de la forme de la carte victoire du joueur.
	* @param J Le joueur dont on va compter les scores en retournant sa carte victoire.
	* @param board Plateau de jeu sur lequel va agir le visiteur.
	* @return Le score venant de la forme de la carte victoire du joueur.
	* @author Farcy Florentin
	*/
	public abstract int ScoreForme(Joueur J, Board board);
	
	
	/**
	* Renvoie le score provenant de la couleur de la carte victoire du joueur.
	* @param J Le joueur dont on va compter les scores en retournant sa carte victoire.
	* @param board Plateau de jeu sur lequel va agir le visiteur.
	* @return Le score venant de la couleur de la carte victoire du joueur.
	* @author Farcy Florentin
	*/
	public abstract int ScoreCouleur(Joueur J, Board board);
	
	/**
	* Renvoie le score provenant du remplissage de la carte victoire du joueur.
	* @param J Le joueur dont on va compter les scores en retournant sa carte victoire.
	* @param board Plateau de jeu sur lequel va agir le visiteur.
	* @return Le score venant du remplissage de la carte victoire du joueur.
	* @author Farcy Florentin
	*/
	public abstract int ScoreRempli(Joueur J, Board board);
	
	/**
	* Change le score du joueur.
	* @param J Le joueur dont on va compter les scores en retournant sa carte victoire.
	* @param board Plateau de jeu sur lequel va agir le visiteur.
	* @author Farcy Florentin
	*/
	public abstract void ScoreJoueur(Joueur J, Board board);
}
