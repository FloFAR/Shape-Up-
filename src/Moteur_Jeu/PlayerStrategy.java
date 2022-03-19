package Moteur_Jeu;

/**
* L'interface PlayerStrategy permet de donner au {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} 
* une {@link Moteur_Jeu.Stratégie stratégie} afin de jouer. 
* L'interface suit le patron de conception Strategy.
* @see <a href="https://www.codingame.com/playgrounds/10741/design-pattern-strategy/exemple">https://www.codingame.com/playgrounds/10741/design-pattern-strategy/exemple"</a>
* @author Farcy Florentin
*/
public interface PlayerStrategy {
	
	/**
	* Méthode permettant au {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} 
	* de poser sa {@link Moteur_Jeu.Carte carte}. 
	* Elle sera implémentée dans la classe {@link Moteur_Jeu.Stratégie}
	* @param carte La {@link Moteur_Jeu.Carte carte} dans la main du {@link Moteur_Jeu.JoueurVirtuel joueur virtuel}.
	* @author Farcy Florentin
	*/
	public void poserCarte(Carte carte);
}