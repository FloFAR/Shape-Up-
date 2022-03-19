package Moteur_Jeu;

import java.util.InputMismatchException;
import java.util.Scanner;
import Moteur_Jeu.Carte.Couleur;
import Moteur_Jeu.Carte.Forme;
import Moteur_Jeu.Carte.Rempli;

/**
* La classe ShapeUp Game apporte plusieurs méthodes permettant le déroulement d'une partie.
* @author Farcy Florentin
*/
public class ShapeUpGame implements ÉlémentMoteurJeu {
	
	/**
	* Le {@link Moteur_Jeu.Board plateau de jeu} de la partie.
	*/
	private Board plateauJeu;
	
	/**
	* Le {@link Moteur_Jeu JeuDeCartes paquet de cartes} de la partie.
	*/
	private JeuDeCartes jeu;
	
	/**
	* Booléen permettant de s'assurer que le joueur a bien poser sa {@link Moteur_Jeu.Carte carte} 
	* ou s'il demande une action impossible.
	* <br/>
	* Il vaut true si le joueur a posé la {@link Moteur_Jeu.Carte carte} qu'il a pioché, false sinon.
	* <br/>
	* Cet attribut est utilisé dans les méthodes suivantes : {@link placerCarte(Carte carte, int x, int y) placerCarte},
	* {@link bougerCarte(Carte carte, int x, int y) bougerCarte}, {@link débutPartie() débutPartie},
	* {@link poserPremierecarte(Carte carte, int x, int y) poserPremireCarte},
	* {@link jouerTour(Joueur) jouerTour}.
	*/
	private boolean carteJouée;
	
	/**
	* Le {@link Moteur_Jeu.Joueur joueur} du logiciel.
	*/
	private Joueur J1;
	
	/**
	* Le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} du logiciel.
	*/
	private JoueurVirtuel J2;
	
	
	/**
	* Instancie une partie de ShapeUp Game.
	* @param plateauJeu Le {@link Moteur_Jeu.Board plateau de jeu} de la partie.
	* @param jeu Le {@link Moteur_Jeu.JeuDeCartes paquet de cartes} de la partie.
	* @param j2 Le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} de la partie.
	* @author Farcy Florentin
	*/
	public ShapeUpGame(Board plateauJeu, JeuDeCartes jeu, JoueurVirtuel j2) {
		this.plateauJeu = plateauJeu;
		this.jeu = jeu;
		this.J2 = j2;
		this.carteJouée=false;
	}

	/**
	* Retourne la carte aux coordonnées données en paramètres.
	* <br/>
	* Cette méthode servant d'intermédiaires aux méthodes pour bouger et/ou placer une {@link Moteur_Jeu.Carte carte}
	* va utiliser les méthodes {@link Moteur_Jeu.Joueur#demanderCarteX() demanderCarteX}
	* et {@link Moteur_Jeu.Joueur#demanderCarteY() demanderCarteY} de la classe {@link Moteur_Jeu.Joueur Joueur}.
	* <br/>
	* Si les coordonnées données ne respectent pas les dimensions du plateau, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* @param x la x-ième colonne de la carte demandée. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @param y la y-ième colonne de la carte demandée. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}.
	* @return La {@link Moteur_Jeu.Carte carte} aux coordonnées fournies par le {@link Moteur_Jeu.Joueur joueur}.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caractère non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public Carte trouverCarte(int x, int y) {
		if ( x>=0 && x<=5 && y>=0 && y<=5 ) {
			return this.plateauJeu.getPlateau().get(x-1).get(y-1);
		}
		else {
			System.out.println("Les coordonnées fournies sont hors du tableau de jeu !");
			System.out.println("Veuillez redonnez de nouvelles coordonnées pour la carte que vous voulez déplacer : ");
			return this.trouverCarte(this.J1.demanderCarteX(),this.J1.demanderCarteY());
		}
	}

	
	/**
	* Place la carte donnée en paramètre aux coordonnées fournies.
	* <br/>
	* Si les coordonnées données ne respectent pas les dimensions du plateau, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* <br/>
	* Si les coordonnées d'une case ne sont pas adjacentes à une carte préalablement posée, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* <br/>
	* Si les coordonnées données correspondent déjà à une carte préalablement posée, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* <br/>
	* Tant que la carte n'est pas placée, l'attribut carteJouée prend la valeur false.
	* @param carte La {@link Moteur_Jeu.Carte carte} que le {@link Moteur_Jeu.Joueur joueur} veut placer.
	* @param x Le numéro de la ligne que le {@link Moteur_Jeu.Joueur joueur} a tapé au clavier. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @param y Le numéro de la colonne que le {@link Moteur_Jeu.Joueur joueur} a tapé au clavier. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caractère non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void placerCarte(Carte carte, int x, int y){
		if ( x>=0 && x<=5 && y<=5 & y>=0 ) {
			if (plateauJeu.getPlateau().get(x-1).get(y-1).getCouleur()==Couleur.RIEN ) {
				if (plateauJeu.vérifierAdjacence(x,y)==true){
					plateauJeu.getPlateau().get(x-1).set(y-1,carte);
					this.carteJouée=true;
				}
				else {
					 System.out.println("Cet emplacement n'est pas adjacent à une autre carte.");
					 this.carteJouée=false;
				}
			}
		    else{
		      System.out.println("Cet emplacement est déjà pris.");
		      this.carteJouée=false;
		    }
		}
		else {
		System.out.println("Les coordonnées fournies sont hors du tableau de jeu !");
		System.out.println("Veuillez redonnez de nouvelles coordonnées : ");
		this.carteJouée=false;
		}
	}
	
	/**
	* Bouge la carte donnée en paramètre aux coordonnées fournies.
	* <br/>
	* Si les coordonnées données ne respectent pas les dimensions du plateau, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* <br/>
	* Si les coordonnées d'une case ne sont pas adjacentes à une carte préalablement posée, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* <br/>
	* Si les coordonnées données correspondent déjà à une carte préalablement posée, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* <br/>
	* Si les coordonnées données correspondent à un emplacement où aucune carte n'est posée, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* <br/>
	* Tant que la carte n'est pas déplacée, l'attribut carteJouée garde la valeur false.
	* @param carte La {@link Moteur_Jeu.Carte carte} que le {@link Moteur_Jeu.Joueur joueur} veut bouger.
	* @param x Le numéro de la ligne que le {@link Moteur_Jeu.Joueur joueur} a tapé au clavier. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @param y Le numéro de la colonne que le {@link Moteur_Jeu.Joueur joueur} a tapé au clavier. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caractère non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void bougerCarte(Carte carte, int x, int y){
		if ( x<=5 && x>=1 && y<=5 && y>=1 ) {
			if ( carte.getCouleur()!=Couleur.RIEN ) {
				if (plateauJeu.getPlateau().get(x-1).get(y-1).getCouleur()==Couleur.RIEN) {
					if(plateauJeu.vérifierAdjacence(x,y)==true) {
						for (int i=0; i<this.plateauJeu.DIMENSIONX; i++ ) {
							for (int j=0; j<this.plateauJeu.DIMENSIONY; j++ ) {
								if (plateauJeu.getPlateau().get(i).get(j)==carte) {
									Carte a = new Carte(Couleur.RIEN,Forme.RIEN,Rempli.RIEN);
									plateauJeu.getPlateau().get(i).set(j,a);
								}
							}
						}
						plateauJeu.getPlateau().get(x-1).set(y-1,carte);
						this.carteJouée=true;
					}
					else {
						System.out.println("Cet emplacement n'est pas adjacent à une autre carte");
						this.carteJouée=false;
					}
				}
				else {
					System.out.println("Cet emplacement est déjà attribué à une autre carte");
					this.carteJouée=false;
				}
			}
			else if ( carte.getCouleur()==Couleur.RIEN ) {
				System.out.println("Il n'y avait pas de carte à déplacer ! (RIEN RIEN RIEN)");
				this.carteJouée=false;
			}
		}
		else {System.out.println("Les coordonnées fournies sont hors du tableau de jeu !");
		System.out.println("Veuillez redonnez de nouvelles coordonnées : ");
		this.carteJouée=false;
		}
	}				
						
	 
	/**
	* Lance un tour de jeu.
	* <br/>
	* Cette méthode va permettre au joueur donnée en paramètre de placer sa carte qu'il vient de piocher
	* et de bouger une carte du plateau pour le joueur. Les méthodes {@link #placerCarte(Carte, int, int) placerCarte} 
	* et {@link #bougerCarte(Carte, int, int) bougerCarte} vont être utilisées ici.
	* <br/>
	* Le joueur doit taper des caractères appropriés pour confirmer qu'il souhaite déplacer une carte.
	* Tant que la carte n'est pas placée ou déplacée, l'attribut carteJouée prend la valeur false.
	* <br/>
	* Quand une carte est placée ou déplacée, l'attribut carteJouée prend la valeur true, ce qui permet de sortir des 
	* boucles conditionnelles et cet attribut reprend immédiatement la valeur false, ce qui permet d'enchaîner les
	* différentes actions possibles avec les cartes.
	* @param J Le {@link Moteur_Jeu.Joueur joueur} qui va jouer son tour.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caractère non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void jouerTour(Joueur J) {
		this.carteJouée=false;
		System.out.append("C'est au tour de " + J + " de jouer ! \n");
		J.piocherCarte(this.jeu.tirerCarteDessus());
		if (J==this.J1) {
			System.out.println("Vous avez pioché " + this.J1.getMain());
			Scanner in = new Scanner(System.in);
			System.out.println("Voulez vous bouger une carte ? Ecrivez Oui ou Non (évitez les fautes !)");
			String réponse =in.nextLine();
			if ( réponse.equalsIgnoreCase("Oui") || réponse.equalsIgnoreCase("O") || réponse.equalsIgnoreCase("Yes")|| réponse.equalsIgnoreCase("Y") ) {
				while ( this.carteJouée== false ) {
					System.out.println("Quelles sont les coordonnées de la carte que vous voulez déplacer ? ");
					Carte a = trouverCarte(this.J1.demanderCarteX(),this.J1.demanderCarteY());
					System.out.println("Vous voulez déplacer la carte "+ a);
					if ( a.getCouleur()==Couleur.RIEN ) {
						System.out.println("/!\\ Vous voulez déplacer un emplacement vide, quelles que soient les coordonnées que vous rentrerez, vous serez obligé de rechoisir une carte à déplacer");
					}
					this.bougerCarte(a,this.J1.demanderCarteX(), this.J1.demanderCarteY());
				}
				carteJouée= false;
				System.out.println(this.plateauJeu);
				System.out.println("Où voulez vous posez votre carte dans la main ?");
				while (this.carteJouée==false) {
					this.placerCarte(this.J1.getMain(), this.J1.demanderCarteX(),this.J1.demanderCarteY());
				}
				System.out.println(this.plateauJeu);
				System.out.println("Très bien, c'est au tour de " + this.J2 + " de jouer.");
			}
			else if ( réponse.equalsIgnoreCase("Non") || réponse.equalsIgnoreCase("N") || réponse.equalsIgnoreCase("No") ) {
			    System.out.println("Où voulez vous posez votre carte dans la main ?");
				while ( this.carteJouée== false) {
					this.placerCarte(this.J1.getMain(),this.J1.demanderCarteX(), this.J1.demanderCarteY());
				}
				carteJouée=false;
				System.out.println(this.plateauJeu);
				System.out.println("Voulez vous bouger une carte ? Ecrivez Oui ou Non (évitez les fautes !)");
				Scanner inFin = new Scanner(System.in);
				String réponseFin =inFin.nextLine();
				if ( réponseFin.equalsIgnoreCase("Oui") || réponseFin.equalsIgnoreCase("O") || réponseFin.equalsIgnoreCase("Yes") || réponseFin.equalsIgnoreCase("Y") ) {
					while ( this.carteJouée== false ) {
						System.out.println("Quelles sont les coordonnées de la carte que vous voulez déplacer ? ");
						Carte a = trouverCarte(this.J1.demanderCarteX(),this.J1.demanderCarteY());
						System.out.println("Vous voulez déplacer la carte "+ a);
						if ( a.getCouleur()==Couleur.RIEN ) {
							System.out.println("/!\\ Vous voulez déplacer un emplacement vide, quelles que soient les coordonnées que vous rentrerez, vous serez obligé de rechoisir une carte à bouger");
						}
						this.bougerCarte(a,this.J1.demanderCarteX(), this.J1.demanderCarteY());
					}
				}
			}
		}
		else {
			System.out.println(J +" a pioché sa carte. ");
			this.J2.poserCarte();
			System.out.println(this.plateauJeu);
		}
	}
	
	/**
	* Méthode qui va permettre de jouer un round de jeu.
	* <br/>
	* Chaque joueur va alors jouer chacun son tour avec la méthode {@link #jouerTour(Joueur) jouerTour}.
	* Le {@link Moteur_Jeu.Joueur joueur} va piocher une {@link Moteur_Jeu.Carte carte},
	* peut éventuellement bouger une {@link Moteur_Jeu.Carte carte} et va finalement jouer sa {@link Moteur_Jeu.Carte carte}
	* tel que décrit dans la méthode {@link #jouerTour(Joueur) jouerTour}.
	* Le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} va piocher sa {@link Moteur_Jeu.Carte carte} et la jouer.
	* @author Farcy Florentin
	*/
	public void jouerRound() {
			this.jouerTour(this.J1);
			this.jouerTour(this.J2);
		}
	
	/**
	* Méthode qui va permettre au {@link Moteur_Jeu.Joueur joueur} de poser sa première {@link Moteur_Jeu.Carte carte}.
	* <br/>
	* Le jeu impose une adjacence des cartes entre elles. La première carte ne pouvant être adjacente avec une autre,
	* cette méthode permet de s'affranchir de cette condition.
	* @param carte La première carte que le {@link Moteur_Jeu.Joueur joueur} va jouer.
	* @param x Le numéro de la ligne que le {@link Moteur_Jeu.Joueur joueur} a tapé au clavier. Doit être compris 
 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @param y Le numéro de la colonne que le {@link Moteur_Jeu.Joueur joueur} a tapé au clavier. Doit être compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caractère non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void poserPremierecarte(Carte carte, int x, int y) {
		if ( x<=5 && x>=0 && y<=5 && y>=0) {
			this.plateauJeu.getPlateau().get(x-1).set(y-1,carte);
			this.carteJouée=true;
		}
		else {
			System.out.println("Les coordonnées sont hors du plateau !");
			this.carteJouée=false;
		}
	}

	/**
	* Méthode qui va gérer le début de partie.
	* <br/>
	* Les règles du jeu vont être présentées au joueur et ce dernier
	* va pouvoir piocher sa carte victoire, poser sa première carte avec la méthode
	* {@link #poserPremierecarte(Carte, int, int) poserPremierecarte}.
	* Le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} va piocher sa carte victoire et poser sa {@link Moteur_Jeu.Joueur#getMain() carte} avec sa {@link Moteur_Jeu.Stratégie stratégie}.
	* @exception InputMismatchException Si le joueur rentre un caractère non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void débutPartie() {
		
		System.out.println("Bienvenue sur la version logicielle de ShapeUp Game !!! \n");
		System.out.println("Quel est votre prénom ? Écrivez le dans la console :");
		Scanner clavier = new Scanner(System.in);
		String nom = clavier.nextLine();
		System.out.println("\nBienvenue " + nom + " !!!");
		Joueur J1 = new Joueur(nom);
		this.setJ1(J1);
		System.out.println("Vous allez jouer contre l'ordinateur, voici votre Carte Victoire :");
		this.J1.setCarteVictoire(this.jeu.tirerCarteDessus());
		System.out.println(this.J1.getCarteVictoire());
		System.out.println("Essayer de placer les cartes ayant la même forme/couleur/remplissage que votre carte Victoire sur une ligne/colonne les unes à côtés des autres pour marquer le plus de points ! \n");
		System.out.println("Forme :");
		System.out.println("2 cartes de même forme : 1 points");
		System.out.println("3 cartes de même forme : 2 points");
		System.out.println("4 cartes de même forme : 3 points");
		System.out.println("une ligne/colonne de même forme : 4 points \n");
		System.out.println("Remplissage :");
		System.out.println("3 cartes de même remplissage : 3 points");
		System.out.println("4 cartes de même remplissage : 4 points");
		System.out.println("une ligne/colonne de même remplissage : 5 points \n");
		System.out.println("Couleur :");
		System.out.println("3 cartes de même couleur : 4 points");
		System.out.println("4 cartes de même couleur : 5 points");
		System.out.println("une ligne/colonne de même couleur : 6 points \n");
		System.out.println("C'est à vous de jouer ! \n");
		
		this.J1.piocherCarte(this.jeu.tirerCarteDessus());
		this.carteJouée=false;
		System.out.println("Vous avez pioché " + J1.getMain());
		System.out.println("Voici à quoi ressemble le plateau de jeu : \n");
		System.out.println(this.plateauJeu);
		System.out.println("Où voulez vous posez la carte ?");
		while (this.carteJouée==false) {
			this.poserPremierecarte(this.J1.getMain(), this.J1.demanderCarteX(),this.J1.demanderCarteY());
		}
		System.out.println(this.plateauJeu);
		System.out.println(this.J2 + " pioche sa Carte Victoire ");
		this.J2.setCarteVictoire(this.jeu.tirerCarteDessus());
		System.out.println(this.J2 + " pioche sa Carte ");
		this.J2.piocherCarte(this.jeu.tirerCarteDessus());
		System.out.print(this.J2.getMain()+"\n");
		System.out.print("\nC'est au tour de " + this.J2 +" de jouer !\n");
		this.J2.poserCarte();
		System.out.print("\n" + this.J2 + " a joué sa carte. \n");
		System.out.println(this.plateauJeu);
	}
	
	/**
	* Méthode qui va gérer toute une partie.
	* <br/>
	* Elle utilise la méthode {@link #jouerRound() jouerRound} plusieurs fois pour vider le {@link Moteur_Jeu.JeuDeCartes paquet de cartes}.
	* Lorsqu'il n'y a plus de {@link Moteur_Jeu.Carte carte} à jouer, le décompte des points va se faire grâce à un {@link Moteur_Jeu.AfficheurScore}.
	* En fonction des scores, un message de victoire, de défaite ou d'égalité est affiché.
	* @param visitor L'instance qui va compter les scores des joueurs.
	* @author Farcy Florentin
	*/
	public void jouerPartie(AfficheurScore visitor) {
		int nmbCarte=0;
		this.débutPartie();
		nmbCarte=4;
		while ( nmbCarte<JeuDeCartes.NOMBRE_CARTES_PAQUET ) {
			this.jouerRound();
			nmbCarte+=2;
		}
		System.out.println("C'est la fin de la partie !!!");
		System.out.println("Voici les cartes Victoire de chaque joueur :\n");
		System.out.println(this.J1 + " : " + this.J1.getCarteVictoire());
		System.out.println(this.J2 + " : " + this.J2.getCarteVictoire() + "\n");
		this.accepterJ1(visitor);
		this.accepterJ2(visitor);
		//this.ScoreJoueur(this.J2);
	//	this.ScoreJoueur(this.J1);
		System.out.println(this.J1 + " a marqué " + this.J1.getScore() + " points !");
		System.out.println(this.J2 + " a marqué " + this.J2.getScore() + " points ! \n");
		if ( this.J1.getScore() > this.J2.getScore()) {
			System.out.println("Bravo, vous avez gagné !!!");
		}
		else if ( this.J1.getScore() < this.J2.getScore()) {
			System.out.println("Dommage, vous avez perdu :'( ");
		}
		else {
			System.out.println("Ça alors, égalité !!!!!!");
		}
		System.out.println("Merci d'avoir joué ! A très vite !!!");
	}
	
	/**
	* Donne un nom au joueur. 
	* @param j1 Attribue un nom au {@link Moteur_Jeu.Joueur joueur}.
	* @author Farcy Florentin
	*/
	public void setJ1(Joueur j1) {
		J1 = j1;
	}
	
	/**
	* Autorise le visiteur à calculer le score du {@link Moteur_Jeu.Joueur joueur}.
	* @param visitor L'instance qui va compter les scores du {@link Moteur_Jeu.Joueur joueur}.
	* @author Farcy Florentin
	*/
	public void accepterJ1(ScoreVisitor visitor) {
		visitor.ScoreJoueur(this.J1, this.plateauJeu);
	}
	
	/**
	* Autorise le visiteur à calculer le score du {@link Moteur_Jeu.JoueurVirtuel joueur virtuel}.
	* @param visitor L'instance qui va compter les scores du {@link Moteur_Jeu.JoueurVirtuel joueur virtuel}.
	* @author Farcy Florentin
	*/
	public void accepterJ2(ScoreVisitor visitor) {
		visitor.ScoreJoueur(this.J2, this.plateauJeu);
	}
	
	/**
	* La méthode main qui va lancer une partie.
	* @param args 
	* @author Farcy Florentin
	*/
	public static void main(String[] args) {
		Board table = new Board();
		JoueurVirtuel J2 = new JoueurVirtuel("Ordi");
		JeuDeCartes jeuCartes = new JeuDeCartes();
		ShapeUpGame partie = new ShapeUpGame(table,jeuCartes,J2);
		Stratégie strat = new Stratégie(table);
		AfficheurScore visitor = new AfficheurScore();
		J2.setStrat(strat);
		jeuCartes.mélanger();
		partie.jouerPartie(visitor);
	}

}	