package Moteur_Jeu;

import java.util.InputMismatchException;
import java.util.Scanner;
import Moteur_Jeu.Carte.Couleur;
import Moteur_Jeu.Carte.Forme;
import Moteur_Jeu.Carte.Rempli;

/**
* La classe ShapeUp Game apporte plusieurs m�thodes permettant le d�roulement d'une partie.
* @author Farcy Florentin
*/
public class ShapeUpGame implements �l�mentMoteurJeu {
	
	/**
	* Le {@link Moteur_Jeu.Board plateau de jeu} de la partie.
	*/
	private Board plateauJeu;
	
	/**
	* Le {@link Moteur_Jeu JeuDeCartes paquet de cartes} de la partie.
	*/
	private JeuDeCartes jeu;
	
	/**
	* Bool�en permettant de s'assurer que le joueur a bien poser sa {@link Moteur_Jeu.Carte carte} 
	* ou s'il demande une action impossible.
	* <br/>
	* Il vaut true si le joueur a pos� la {@link Moteur_Jeu.Carte carte} qu'il a pioch�, false sinon.
	* <br/>
	* Cet attribut est utilis� dans les m�thodes suivantes : {@link placerCarte(Carte carte, int x, int y) placerCarte},
	* {@link bougerCarte(Carte carte, int x, int y) bougerCarte}, {@link d�butPartie() d�butPartie},
	* {@link poserPremierecarte(Carte carte, int x, int y) poserPremireCarte},
	* {@link jouerTour(Joueur) jouerTour}.
	*/
	private boolean carteJou�e;
	
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
		this.carteJou�e=false;
	}

	/**
	* Retourne la carte aux coordonn�es donn�es en param�tres.
	* <br/>
	* Cette m�thode servant d'interm�diaires aux m�thodes pour bouger et/ou placer une {@link Moteur_Jeu.Carte carte}
	* va utiliser les m�thodes {@link Moteur_Jeu.Joueur#demanderCarteX() demanderCarteX}
	* et {@link Moteur_Jeu.Joueur#demanderCarteY() demanderCarteY} de la classe {@link Moteur_Jeu.Joueur Joueur}.
	* <br/>
	* Si les coordonn�es donn�es ne respectent pas les dimensions du plateau, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* @param x la x-i�me colonne de la carte demand�e. Doit �tre compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @param y la y-i�me colonne de la carte demand�e. Doit �tre compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}.
	* @return La {@link Moteur_Jeu.Carte carte} aux coordonn�es fournies par le {@link Moteur_Jeu.Joueur joueur}.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caract�re non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public Carte trouverCarte(int x, int y) {
		if ( x>=0 && x<=5 && y>=0 && y<=5 ) {
			return this.plateauJeu.getPlateau().get(x-1).get(y-1);
		}
		else {
			System.out.println("Les coordonn�es fournies sont hors du tableau de jeu !");
			System.out.println("Veuillez redonnez de nouvelles coordonn�es pour la carte que vous voulez d�placer : ");
			return this.trouverCarte(this.J1.demanderCarteX(),this.J1.demanderCarteY());
		}
	}

	
	/**
	* Place la carte donn�e en param�tre aux coordonn�es fournies.
	* <br/>
	* Si les coordonn�es donn�es ne respectent pas les dimensions du plateau, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* <br/>
	* Si les coordonn�es d'une case ne sont pas adjacentes � une carte pr�alablement pos�e, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* <br/>
	* Si les coordonn�es donn�es correspondent d�j� � une carte pr�alablement pos�e, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* <br/>
	* Tant que la carte n'est pas plac�e, l'attribut carteJou�e prend la valeur false.
	* @param carte La {@link Moteur_Jeu.Carte carte} que le {@link Moteur_Jeu.Joueur joueur} veut placer.
	* @param x Le num�ro de la ligne que le {@link Moteur_Jeu.Joueur joueur} a tap� au clavier. Doit �tre compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @param y Le num�ro de la colonne que le {@link Moteur_Jeu.Joueur joueur} a tap� au clavier. Doit �tre compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caract�re non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void placerCarte(Carte carte, int x, int y){
		if ( x>=0 && x<=5 && y<=5 & y>=0 ) {
			if (plateauJeu.getPlateau().get(x-1).get(y-1).getCouleur()==Couleur.RIEN ) {
				if (plateauJeu.v�rifierAdjacence(x,y)==true){
					plateauJeu.getPlateau().get(x-1).set(y-1,carte);
					this.carteJou�e=true;
				}
				else {
					 System.out.println("Cet emplacement n'est pas adjacent � une autre carte.");
					 this.carteJou�e=false;
				}
			}
		    else{
		      System.out.println("Cet emplacement est d�j� pris.");
		      this.carteJou�e=false;
		    }
		}
		else {
		System.out.println("Les coordonn�es fournies sont hors du tableau de jeu !");
		System.out.println("Veuillez redonnez de nouvelles coordonn�es : ");
		this.carteJou�e=false;
		}
	}
	
	/**
	* Bouge la carte donn�e en param�tre aux coordonn�es fournies.
	* <br/>
	* Si les coordonn�es donn�es ne respectent pas les dimensions du plateau, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* <br/>
	* Si les coordonn�es d'une case ne sont pas adjacentes � une carte pr�alablement pos�e, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* <br/>
	* Si les coordonn�es donn�es correspondent d�j� � une carte pr�alablement pos�e, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* <br/>
	* Si les coordonn�es donn�es correspondent � un emplacement o� aucune carte n'est pos�e, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* <br/>
	* Tant que la carte n'est pas d�plac�e, l'attribut carteJou�e garde la valeur false.
	* @param carte La {@link Moteur_Jeu.Carte carte} que le {@link Moteur_Jeu.Joueur joueur} veut bouger.
	* @param x Le num�ro de la ligne que le {@link Moteur_Jeu.Joueur joueur} a tap� au clavier. Doit �tre compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @param y Le num�ro de la colonne que le {@link Moteur_Jeu.Joueur joueur} a tap� au clavier. Doit �tre compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caract�re non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void bougerCarte(Carte carte, int x, int y){
		if ( x<=5 && x>=1 && y<=5 && y>=1 ) {
			if ( carte.getCouleur()!=Couleur.RIEN ) {
				if (plateauJeu.getPlateau().get(x-1).get(y-1).getCouleur()==Couleur.RIEN) {
					if(plateauJeu.v�rifierAdjacence(x,y)==true) {
						for (int i=0; i<this.plateauJeu.DIMENSIONX; i++ ) {
							for (int j=0; j<this.plateauJeu.DIMENSIONY; j++ ) {
								if (plateauJeu.getPlateau().get(i).get(j)==carte) {
									Carte a = new Carte(Couleur.RIEN,Forme.RIEN,Rempli.RIEN);
									plateauJeu.getPlateau().get(i).set(j,a);
								}
							}
						}
						plateauJeu.getPlateau().get(x-1).set(y-1,carte);
						this.carteJou�e=true;
					}
					else {
						System.out.println("Cet emplacement n'est pas adjacent � une autre carte");
						this.carteJou�e=false;
					}
				}
				else {
					System.out.println("Cet emplacement est d�j� attribu� � une autre carte");
					this.carteJou�e=false;
				}
			}
			else if ( carte.getCouleur()==Couleur.RIEN ) {
				System.out.println("Il n'y avait pas de carte � d�placer ! (RIEN RIEN RIEN)");
				this.carteJou�e=false;
			}
		}
		else {System.out.println("Les coordonn�es fournies sont hors du tableau de jeu !");
		System.out.println("Veuillez redonnez de nouvelles coordonn�es : ");
		this.carteJou�e=false;
		}
	}				
						
	 
	/**
	* Lance un tour de jeu.
	* <br/>
	* Cette m�thode va permettre au joueur donn�e en param�tre de placer sa carte qu'il vient de piocher
	* et de bouger une carte du plateau pour le joueur. Les m�thodes {@link #placerCarte(Carte, int, int) placerCarte} 
	* et {@link #bougerCarte(Carte, int, int) bougerCarte} vont �tre utilis�es ici.
	* <br/>
	* Le joueur doit taper des caract�res appropri�s pour confirmer qu'il souhaite d�placer une carte.
	* Tant que la carte n'est pas plac�e ou d�plac�e, l'attribut carteJou�e prend la valeur false.
	* <br/>
	* Quand une carte est plac�e ou d�plac�e, l'attribut carteJou�e prend la valeur true, ce qui permet de sortir des 
	* boucles conditionnelles et cet attribut reprend imm�diatement la valeur false, ce qui permet d'encha�ner les
	* diff�rentes actions possibles avec les cartes.
	* @param J Le {@link Moteur_Jeu.Joueur joueur} qui va jouer son tour.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caract�re non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void jouerTour(Joueur J) {
		this.carteJou�e=false;
		System.out.append("C'est au tour de " + J + " de jouer ! \n");
		J.piocherCarte(this.jeu.tirerCarteDessus());
		if (J==this.J1) {
			System.out.println("Vous avez pioch� " + this.J1.getMain());
			Scanner in = new Scanner(System.in);
			System.out.println("Voulez vous bouger une carte ? Ecrivez Oui ou Non (�vitez les fautes !)");
			String r�ponse =in.nextLine();
			if ( r�ponse.equalsIgnoreCase("Oui") || r�ponse.equalsIgnoreCase("O") || r�ponse.equalsIgnoreCase("Yes")|| r�ponse.equalsIgnoreCase("Y") ) {
				while ( this.carteJou�e== false ) {
					System.out.println("Quelles sont les coordonn�es de la carte que vous voulez d�placer ? ");
					Carte a = trouverCarte(this.J1.demanderCarteX(),this.J1.demanderCarteY());
					System.out.println("Vous voulez d�placer la carte "+ a);
					if ( a.getCouleur()==Couleur.RIEN ) {
						System.out.println("/!\\ Vous voulez d�placer un emplacement vide, quelles que soient les coordonn�es que vous rentrerez, vous serez oblig� de rechoisir une carte � d�placer");
					}
					this.bougerCarte(a,this.J1.demanderCarteX(), this.J1.demanderCarteY());
				}
				carteJou�e= false;
				System.out.println(this.plateauJeu);
				System.out.println("O� voulez vous posez votre carte dans la main ?");
				while (this.carteJou�e==false) {
					this.placerCarte(this.J1.getMain(), this.J1.demanderCarteX(),this.J1.demanderCarteY());
				}
				System.out.println(this.plateauJeu);
				System.out.println("Tr�s bien, c'est au tour de " + this.J2 + " de jouer.");
			}
			else if ( r�ponse.equalsIgnoreCase("Non") || r�ponse.equalsIgnoreCase("N") || r�ponse.equalsIgnoreCase("No") ) {
			    System.out.println("O� voulez vous posez votre carte dans la main ?");
				while ( this.carteJou�e== false) {
					this.placerCarte(this.J1.getMain(),this.J1.demanderCarteX(), this.J1.demanderCarteY());
				}
				carteJou�e=false;
				System.out.println(this.plateauJeu);
				System.out.println("Voulez vous bouger une carte ? Ecrivez Oui ou Non (�vitez les fautes !)");
				Scanner inFin = new Scanner(System.in);
				String r�ponseFin =inFin.nextLine();
				if ( r�ponseFin.equalsIgnoreCase("Oui") || r�ponseFin.equalsIgnoreCase("O") || r�ponseFin.equalsIgnoreCase("Yes") || r�ponseFin.equalsIgnoreCase("Y") ) {
					while ( this.carteJou�e== false ) {
						System.out.println("Quelles sont les coordonn�es de la carte que vous voulez d�placer ? ");
						Carte a = trouverCarte(this.J1.demanderCarteX(),this.J1.demanderCarteY());
						System.out.println("Vous voulez d�placer la carte "+ a);
						if ( a.getCouleur()==Couleur.RIEN ) {
							System.out.println("/!\\ Vous voulez d�placer un emplacement vide, quelles que soient les coordonn�es que vous rentrerez, vous serez oblig� de rechoisir une carte � bouger");
						}
						this.bougerCarte(a,this.J1.demanderCarteX(), this.J1.demanderCarteY());
					}
				}
			}
		}
		else {
			System.out.println(J +" a pioch� sa carte. ");
			this.J2.poserCarte();
			System.out.println(this.plateauJeu);
		}
	}
	
	/**
	* M�thode qui va permettre de jouer un round de jeu.
	* <br/>
	* Chaque joueur va alors jouer chacun son tour avec la m�thode {@link #jouerTour(Joueur) jouerTour}.
	* Le {@link Moteur_Jeu.Joueur joueur} va piocher une {@link Moteur_Jeu.Carte carte},
	* peut �ventuellement bouger une {@link Moteur_Jeu.Carte carte} et va finalement jouer sa {@link Moteur_Jeu.Carte carte}
	* tel que d�crit dans la m�thode {@link #jouerTour(Joueur) jouerTour}.
	* Le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} va piocher sa {@link Moteur_Jeu.Carte carte} et la jouer.
	* @author Farcy Florentin
	*/
	public void jouerRound() {
			this.jouerTour(this.J1);
			this.jouerTour(this.J2);
		}
	
	/**
	* M�thode qui va permettre au {@link Moteur_Jeu.Joueur joueur} de poser sa premi�re {@link Moteur_Jeu.Carte carte}.
	* <br/>
	* Le jeu impose une adjacence des cartes entre elles. La premi�re carte ne pouvant �tre adjacente avec une autre,
	* cette m�thode permet de s'affranchir de cette condition.
	* @param carte La premi�re carte que le {@link Moteur_Jeu.Joueur joueur} va jouer.
	* @param x Le num�ro de la ligne que le {@link Moteur_Jeu.Joueur joueur} a tap� au clavier. Doit �tre compris 
 et {@link Moteur_Jeu.Board#DIMENSIONX DIMENSIONX}.
	* @param y Le num�ro de la colonne que le {@link Moteur_Jeu.Joueur joueur} a tap� au clavier. Doit �tre compris entre 1 et {@link Moteur_Jeu.Board#DIMENSIONY DIMENSIONY}.
	* @exception InputMismatchException Si le {@link Moteur_Jeu.Joueur joueur} rentre un caract�re non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void poserPremierecarte(Carte carte, int x, int y) {
		if ( x<=5 && x>=0 && y<=5 && y>=0) {
			this.plateauJeu.getPlateau().get(x-1).set(y-1,carte);
			this.carteJou�e=true;
		}
		else {
			System.out.println("Les coordonn�es sont hors du plateau !");
			this.carteJou�e=false;
		}
	}

	/**
	* M�thode qui va g�rer le d�but de partie.
	* <br/>
	* Les r�gles du jeu vont �tre pr�sent�es au joueur et ce dernier
	* va pouvoir piocher sa carte victoire, poser sa premi�re carte avec la m�thode
	* {@link #poserPremierecarte(Carte, int, int) poserPremierecarte}.
	* Le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} va piocher sa carte victoire et poser sa {@link Moteur_Jeu.Joueur#getMain() carte} avec sa {@link Moteur_Jeu.Strat�gie strat�gie}.
	* @exception InputMismatchException Si le joueur rentre un caract�re non valide comme une lettre.
	* @author Farcy Florentin
	*/
	public void d�butPartie() {
		
		System.out.println("Bienvenue sur la version logicielle de ShapeUp Game !!! \n");
		System.out.println("Quel est votre pr�nom ? �crivez le dans la console :");
		Scanner clavier = new Scanner(System.in);
		String nom = clavier.nextLine();
		System.out.println("\nBienvenue " + nom + " !!!");
		Joueur J1 = new Joueur(nom);
		this.setJ1(J1);
		System.out.println("Vous allez jouer contre l'ordinateur, voici votre Carte Victoire :");
		this.J1.setCarteVictoire(this.jeu.tirerCarteDessus());
		System.out.println(this.J1.getCarteVictoire());
		System.out.println("Essayer de placer les cartes ayant la m�me forme/couleur/remplissage que votre carte Victoire sur une ligne/colonne les unes � c�t�s des autres pour marquer le plus de points ! \n");
		System.out.println("Forme :");
		System.out.println("2 cartes de m�me forme : 1 points");
		System.out.println("3 cartes de m�me forme : 2 points");
		System.out.println("4 cartes de m�me forme : 3 points");
		System.out.println("une ligne/colonne de m�me forme : 4 points \n");
		System.out.println("Remplissage :");
		System.out.println("3 cartes de m�me remplissage : 3 points");
		System.out.println("4 cartes de m�me remplissage : 4 points");
		System.out.println("une ligne/colonne de m�me remplissage : 5 points \n");
		System.out.println("Couleur :");
		System.out.println("3 cartes de m�me couleur : 4 points");
		System.out.println("4 cartes de m�me couleur : 5 points");
		System.out.println("une ligne/colonne de m�me couleur : 6 points \n");
		System.out.println("C'est � vous de jouer ! \n");
		
		this.J1.piocherCarte(this.jeu.tirerCarteDessus());
		this.carteJou�e=false;
		System.out.println("Vous avez pioch� " + J1.getMain());
		System.out.println("Voici � quoi ressemble le plateau de jeu : \n");
		System.out.println(this.plateauJeu);
		System.out.println("O� voulez vous posez la carte ?");
		while (this.carteJou�e==false) {
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
		System.out.print("\n" + this.J2 + " a jou� sa carte. \n");
		System.out.println(this.plateauJeu);
	}
	
	/**
	* M�thode qui va g�rer toute une partie.
	* <br/>
	* Elle utilise la m�thode {@link #jouerRound() jouerRound} plusieurs fois pour vider le {@link Moteur_Jeu.JeuDeCartes paquet de cartes}.
	* Lorsqu'il n'y a plus de {@link Moteur_Jeu.Carte carte} � jouer, le d�compte des points va se faire gr�ce � un {@link Moteur_Jeu.AfficheurScore}.
	* En fonction des scores, un message de victoire, de d�faite ou d'�galit� est affich�.
	* @param visitor L'instance qui va compter les scores des joueurs.
	* @author Farcy Florentin
	*/
	public void jouerPartie(AfficheurScore visitor) {
		int nmbCarte=0;
		this.d�butPartie();
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
		System.out.println(this.J1 + " a marqu� " + this.J1.getScore() + " points !");
		System.out.println(this.J2 + " a marqu� " + this.J2.getScore() + " points ! \n");
		if ( this.J1.getScore() > this.J2.getScore()) {
			System.out.println("Bravo, vous avez gagn� !!!");
		}
		else if ( this.J1.getScore() < this.J2.getScore()) {
			System.out.println("Dommage, vous avez perdu :'( ");
		}
		else {
			System.out.println("�a alors, �galit� !!!!!!");
		}
		System.out.println("Merci d'avoir jou� ! A tr�s vite !!!");
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
	* Autorise le visiteur � calculer le score du {@link Moteur_Jeu.Joueur joueur}.
	* @param visitor L'instance qui va compter les scores du {@link Moteur_Jeu.Joueur joueur}.
	* @author Farcy Florentin
	*/
	public void accepterJ1(ScoreVisitor visitor) {
		visitor.ScoreJoueur(this.J1, this.plateauJeu);
	}
	
	/**
	* Autorise le visiteur � calculer le score du {@link Moteur_Jeu.JoueurVirtuel joueur virtuel}.
	* @param visitor L'instance qui va compter les scores du {@link Moteur_Jeu.JoueurVirtuel joueur virtuel}.
	* @author Farcy Florentin
	*/
	public void accepterJ2(ScoreVisitor visitor) {
		visitor.ScoreJoueur(this.J2, this.plateauJeu);
	}
	
	/**
	* La m�thode main qui va lancer une partie.
	* @param args 
	* @author Farcy Florentin
	*/
	public static void main(String[] args) {
		Board table = new Board();
		JoueurVirtuel J2 = new JoueurVirtuel("Ordi");
		JeuDeCartes jeuCartes = new JeuDeCartes();
		ShapeUpGame partie = new ShapeUpGame(table,jeuCartes,J2);
		Strat�gie strat = new Strat�gie(table);
		AfficheurScore visitor = new AfficheurScore();
		J2.setStrat(strat);
		jeuCartes.m�langer();
		partie.jouerPartie(visitor);
	}

}	