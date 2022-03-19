package Moteur_Jeu;

/**
* La classe JoueurVirtuel h�ritant de la classe {@link Moteur_Jeu.Joueur} apporte diff�rentes m�thodes
* afin de permettre au {@linkplain Moteur_Jeu.Joueur joueur } de jouer contre l'ordinateur.
* Le joueur virtuel va utiliser une {@link Moteur_Jeu.Strat�gie strat�gie} d�j� d�finie pour jouer.
* @author Farcy Florentin
*/
public class JoueurVirtuel extends Joueur {
	
	/**
	* La {@link Moteur_Jeu.Strat�gie strat�gie} que va utiliser le joueur virtuel.
	*/
	private Strat�gie strat;
	
	/**
	* Instancie un joueur virtuel.
	* @param nom Nom du joueur virtuel.
	* @author Farcy Florentin
	*/
	public JoueurVirtuel(String nom) {
		super(nom);
	}
	
	/**
	* La m�thode poserCarte du joueur virtuel va utiliser la m�thode 
	* {@link Moteur_Jeu.Strat�gie#poserCarte(Carte carte) poserCarte} de la classe {@link Moteur_Jeu.Strat�gie}.
	* De la sorte, on respecte le patron de conception Strategy.
	* @author Farcy Florentin
	*/
	public void poserCarte() {
		this.strat.poserCarte(this.getMain());
	}

	/**
	* Attribue une {@link Moteur_Jeu.Strat�gie strat�gie} au joueur virtuel.
	* @param strat La {@link Moteur_Jeu.Strat�gie strat�gie} que l'on va attribuer au joueur virtuel.
	* @author Farcy Florentin
	*/
	public void setStrat(Strat�gie strat) {
		this.strat = strat;
	}
}