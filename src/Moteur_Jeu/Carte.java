package Moteur_Jeu;

/**
* La classe Carte est un élément principal du logiciel.
* Chaque joueur va pouvoir effectuer plusieurs actions avec celles-ci commes les {@link Moteur_Jeu.ShapeUpGame#placerCarte(Carte, int, int) placer} ou les {@link Moteur_Jeu.ShapeUpGame#bougerCarte(Carte, int, int)  bouger}.
* Chaque carte possède une {@linkplain Moteur_Jeu.Carte.Forme forme}, une {@link Moteur_Jeu.Carte.Couleur couleur} et un {@link Moteur_Jeu.Carte.Rempli remplissage} propre à elle-même.
* 
* @author Farcy Florentin
*/
public class Carte {

	/**
	* La forme de la carte.
	*/
	private Forme forme;
	
	/**
	* La couleur de la carte.
	*/
	private Couleur couleur;
	
	/**
	* Le remplissage de la carte.
	*/
	private Rempli rempli;
	
	
	/**
	* Instancie une carte avec sa couleur, sa forme et son remplissage.
	* 
	* @param couleur La couleur que l'on veut donner à la carte.
	* @param forme La forme que l'on veut donner à la carte.
	* @param rempli Le remplissage que l'on veut donner à la carte.
	* @author Farcy Florentin
	*/
	public Carte(Couleur couleur,Forme forme, Rempli rempli) {
		this.couleur=couleur;
		this.forme=forme;
		this.rempli=rempli;
	}
	
	/**
	* Donne la forme de la carte.
	* @return Renvoie la forme de la carte.
	* @author Farcy Florentin
	*/
	public Forme getForme() {
		return forme;
	}
	
	/**
	* Donne la couleur de la carte.
	* @return Renvoie la couleur de la carte.
	* @author Farcy Florentin
	*/
	public Couleur getCouleur() {
		return couleur;
	}
	
	/**
	* Donne le remplissage de la carte.
	* @return Renvoie le remplissage de la carte.
	* @author Farcy Florentin
	*/
	public Rempli getRempli() {
		return rempli;
	}
	

	/**
	* Énumération donnant les différentes formes possibles pour les cartes.
	* 
	* @author Farcy Florentin
	*/
	public enum Forme {
		
		/**
		* En forme de carré.
		* 
		* @author Farcy Florentin
		*/
		CARRÉ,
		/**
		* En forme de triangle.
		* 
		* @author Farcy Florentin
		*/
		TRIANGLE,
		/**
		* En forme de cercle.
		* 
		* @author Farcy Florentin
		*/
		CERCLE,
		/**
		* Aucune forme (aucune carte).
		* 
		* @author Farcy Florentin
		*/
		RIEN,
	}
	
	
	/**
	* Énumération donnant les différentes couleurs possibles pour les cartes.
	* 
	* @author Farcy Florentin
	*/
	public enum Couleur {
		/**
		* Couleur rouge.
		* 
		* @author Farcy Florentin
		*/
		ROUGE,
		/**
		* Couleur bleue.
		* 
		* @author Farcy Florentin
		*/
		BLEU,
		/**
		* Couleur verte.
		* 
		* @author Farcy Florentin
		*/
		VERT,
		/**
		* Aucune couleur (aucune carte).
		* 
		* @author Farcy Florentin
		*/
		RIEN,
	}
	
	
	/**
	* Énumération donnant les différents remplissages possibles pour les cartes.
	* 
	* @author Farcy Florentin
	*/
	public enum Rempli {
		/**
		* Remplissage vide.
		* 
		* @author Farcy Florentin
		*/
		VIDE,
		/**
		* Remplissage plein.
		* 
		* @author Farcy Florentin
		*/
		REMPLI,
		/**
		* Aucun remplissage (aucune carte).
		* 
		* @author Farcy Florentin
		*/
		RIEN,
	}
	
	/**
	* 
	* @return Renvoie la carte sous la forme : {@linkplain Moteur_Jeu.Carte.Forme FORME} {@link Moteur_Jeu.Carte.Couleur COULEUR} {@link Moteur_Jeu.Carte.Rempli REMPLISSAGE}.
	* <br/>
	* Par exemple : CARRÉ ROUGE VIDE
	* @author Farcy Florentin
	*/
	public String toString() {
		StringBuffer sb =new StringBuffer();
		sb.append(this.forme.toString());
		sb.append(" ");
		sb.append(this.couleur.toString());
		sb.append(" ");
		sb.append(this.rempli.toString());
		return sb.toString();
	}
	
}