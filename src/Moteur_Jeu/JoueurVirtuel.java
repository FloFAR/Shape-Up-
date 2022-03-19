package Moteur_Jeu;

/**
* La classe JoueurVirtuel héritant de la classe {@link Moteur_Jeu.Joueur} apporte différentes méthodes
* afin de permettre au {@linkplain Moteur_Jeu.Joueur joueur } de jouer contre l'ordinateur.
* Le joueur virtuel va utiliser une {@link Moteur_Jeu.Stratégie stratégie} déjà définie pour jouer.
* @author Farcy Florentin
*/
public class JoueurVirtuel extends Joueur {
	
	/**
	* La {@link Moteur_Jeu.Stratégie stratégie} que va utiliser le joueur virtuel.
	*/
	private Stratégie strat;
	
	/**
	* Instancie un joueur virtuel.
	* @param nom Nom du joueur virtuel.
	* @author Farcy Florentin
	*/
	public JoueurVirtuel(String nom) {
		super(nom);
	}
	
	/**
	* La méthode poserCarte du joueur virtuel va utiliser la méthode 
	* {@link Moteur_Jeu.Stratégie#poserCarte(Carte carte) poserCarte} de la classe {@link Moteur_Jeu.Stratégie}.
	* De la sorte, on respecte le patron de conception Strategy.
	* @author Farcy Florentin
	*/
	public void poserCarte() {
		this.strat.poserCarte(this.getMain());
	}

	/**
	* Attribue une {@link Moteur_Jeu.Stratégie stratégie} au joueur virtuel.
	* @param strat La {@link Moteur_Jeu.Stratégie stratégie} que l'on va attribuer au joueur virtuel.
	* @author Farcy Florentin
	*/
	public void setStrat(Stratégie strat) {
		this.strat = strat;
	}
}