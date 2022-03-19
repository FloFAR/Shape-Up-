package Moteur_Jeu;

/**
* L'interface �l�mentMoteurJeu va apporter des m�thodes afin de permettre au
* logiciel de compter les scores des joueurs en suivant le patron de conception Visitor.
* @author Farcy Florentin
*/
public interface �l�mentMoteurJeu {
	
	/**
	* M�thode permettant � l'�l�ment du moteur de jeu de laisser le {@link Moteur_Jeu.ScoreVisitor visiteur} compter le score du {@link Moteur_Jeu.Joueur joueur}.
	* @param visitor L'instance qui va compter les scores du {@link Moteur_Jeu.Joueur joueur}.
	* @author Farcy Florentin
	*/
	public void accepterJ1(ScoreVisitor visitor);
	
	/**
	* M�thode permettant � l'�l�ment du moteur de jeu de laisser le {@link Moteur_Jeu.ScoreVisitor visiteur} compter le score du {@link Moteur_Jeu.JoueurVirtuel joueur virtuel}.
	* @param visitor L'instance qui va compter les scores du {@link Moteur_Jeu.JoueurVirtuel joueur virtuel}.
	* @author Farcy Florentin
	*/
	public void accepterJ2(ScoreVisitor visitor);
}
