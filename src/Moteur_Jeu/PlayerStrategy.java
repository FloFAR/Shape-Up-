package Moteur_Jeu;

/**
* L'interface PlayerStrategy permet de donner au {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} 
* une {@link Moteur_Jeu.Strat�gie strat�gie} afin de jouer. 
* L'interface suit le patron de conception Strategy.
* @see <a href="https://www.codingame.com/playgrounds/10741/design-pattern-strategy/exemple">https://www.codingame.com/playgrounds/10741/design-pattern-strategy/exemple"</a>
* @author Farcy Florentin
*/
public interface PlayerStrategy {
	
	/**
	* M�thode permettant au {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} 
	* de poser sa {@link Moteur_Jeu.Carte carte}. 
	* Elle sera impl�ment�e dans la classe {@link Moteur_Jeu.Strat�gie}
	* @param carte La {@link Moteur_Jeu.Carte carte} dans la main du {@link Moteur_Jeu.JoueurVirtuel joueur virtuel}.
	* @author Farcy Florentin
	*/
	public void poserCarte(Carte carte);
}