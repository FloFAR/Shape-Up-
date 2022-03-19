package Moteur_Jeu;

import java.util.ArrayList;
import Moteur_Jeu.Carte.Couleur;
import Moteur_Jeu.Carte.Forme;
import Moteur_Jeu.Carte.Rempli;

/**
* La classe Board va permettre de stocker les différentes {@link Moteur_Jeu.Carte cartes} du
* {@link Moteur_Jeu.JeuDeCartes paquet de cartes}.
* Lors de l'instanciation, tous les emplacements possèdent la {@link Moteur_Jeu.Carte carte} ayant comme 
* {@linkplain Moteur_Jeu.Carte.Forme forme}, 
* {@linkplain Moteur_Jeu.Carte.Couleur couleur} et
* {@linkplain Moteur_Jeu.Carte.Rempli remplissage} {@link Moteur_Jeu.Carte.Couleur#RIEN RIEN}.
* 
* @author Farcy Florentin
*/
public class Board {
	
	/**
	* Le nombre de cases en abscisse du plateau. La valeur doit être positive et suffisament importante pour
	* pouvoir y placer des {@link Moteur_Jeu.Carte cartes}.
	*/
	public final int DIMENSIONX=5;
	
	/**
	* Le nombre de cases en ordonnée du plateau. La valeur doit être positive et suffisament importante pour
	* pouvoir y placer des {@link Moteur_Jeu.Carte cartes}.
	*/
	public final int DIMENSIONY=5;
	
	/**
	* Le quadrillage du plateau de dimension {@link DIMENSIONX} x {@link DIMENSIONY}.
	*/
	private ArrayList<ArrayList<Carte>> plateau;
	
	/**
	* Instancie un plateau de jeu de dimension {@link DIMENSIONX} x {@link DIMENSIONY}. 
	* Chaque emplacement possède initialement la {@link Moteur_Jeu.Carte carte}
	* ayant comme {@linkplain Moteur_Jeu.Carte.Forme forme}, 
	* {@linkplain Moteur_Jeu.Carte.Couleur couleur} et
	* {@linkplain Moteur_Jeu.Carte.Rempli remplissage} {@link Moteur_Jeu.Carte.Couleur#RIEN RIEN}.
	* afin de signaler au {@link Moteur_Jeu.Joueur joueur} que l'emplacement est vide.
	* 
	* @author Farcy Florentin
	*/
	public Board(){
		Carte c = new Carte(Couleur.RIEN,Forme.RIEN,Rempli.RIEN);
		this.setPlateau(new ArrayList<ArrayList<Carte>>(DIMENSIONX));
		for (int i = 0; i < DIMENSIONX; i++) {
			ArrayList<Carte> listeIntermédiaire = new ArrayList<Carte>();
			this.getPlateau().add(listeIntermédiaire);
			for (int j = 0; j < DIMENSIONY; j++){
				listeIntermédiaire.add(c);
			}
		}
	}
	
	/**
	* Retourne un booléen selon la conformité de l'adjacence de l'emplacement donné par le {@link Moteur_Jeu.Joueur joueur}.
	* Pour une case avec des dimensions valides, on inspecte si au moins une case adjacente contient une {@link Moteur_Jeu.Carte carte}.
	* Si les coordonnées données ne respectent pas les dimensions du plateau, un message est envoyé au joueur
	* pour lui demander de fournir de nouvelles coordonnées.
	* @param x La x-ième ligne du tableau. Doit être compris entre 1 et {@link DIMENSIONX}.
	* @param y La y-ième colonne du tableau. Doit être compris entre 1 et {@link DIMENSIONY}.
	* <br/>
	* On considère que le joueur peut ne pas être un habitué des langages de programmation. 
	* Les paramètres x et y seront donc décalés de 1 par rapport à leur position réelle dans le tableau plateau.
	* @return true si l'emplacement demandé par le {@link Moteur_Jeu.Joueur joueur} est adjacent à une autre {@link Moteur_Jeu.Carte carte},
	* false sinon.
	* @author Farcy Florentin
	*/
	public boolean vérifierAdjacence(int x,int y) {
		// La case en haut à gauche
		if ( x==1 && y==1 ) {
			if (getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en bas à droite
		else if ( x==5 && y==5 ) {
			if (getPlateau().get(x-1).get(y-2).getCouleur()!= Couleur.RIEN || getPlateau().get(x-2).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en haut à droite
		else if ( x==1 && y==5 ) {
			if (getPlateau().get(x-1).get(y-2).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en bas à gauche
		else if ( x==5 && y==1 ) {
			if (getPlateau().get(x-2).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// Les cases de la colonne de gauche
		else if ( (x==2 || x==3 || x==4) && y==1) {
			if ( getPlateau().get(x-2).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN ) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		// Les cases de la colonne de droite
		else if ( (x==2 || x==3 || x==4) && y==5) {
			if ( getPlateau().get(x-2).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x-1).get(y-2).getCouleur()!= Couleur.RIEN ) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// Les cases de la ligne en haut
		else if ( x==1 && (y==2 || y==3 || y==4) ) {
			if ( getPlateau().get(x-1).get(y-2).getCouleur()!= Couleur.RIEN || getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN ) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// Les cases de la ligne en bas
		else if ( x==5 && (y==2 || y==3 || y==4) ) {
			if ( getPlateau().get(x-1).get(y-2).getCouleur()!= Couleur.RIEN || getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x-2).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		else if ( x<=0 || x>=6 || y<=0 || y>=6 ) {
			System.out.println("Les coordonnées fournies sont hors du tableau de jeu !");
			System.out.println("Veuillez redonnez de nouvelles coordonnées : ");
			return false;
		}
		
		// Les cases "centrales", qui ne seront pas sur les bords du plateau
		else {
			if ( getPlateau().get(x-2).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x-1).get(y-2).getCouleur()!= Couleur.RIEN|| getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN ) {
				return true;
			}
			else {
				return false;
			}
		}
		
	}
	
	/**
	* Similaire à la méthode {@link #vérifierAdjacence(int, int) vérifierAdjacence}, retourne un booléen si l'emplacement du plateau de jeu est adjacent à une autre {@link Moteur_Jeu.Carte carte}.
	* @param x L''indice i de la méthode {@linkplain Moteur_Jeu.Stratégie#poserCarte(Carte) poserCarte} de l'interface {@link Moteur_Jeu.Stratégie}.
	* @param y L''indice j de la méthode {@linkplain Moteur_Jeu.Stratégie#poserCarte(Carte) poserCarte} de l'interface {@link Moteur_Jeu.Stratégie}.
	* <br/>
	* Étant donnée que c'est l'ordinateur qui va inspecter si un emplacement est adjacent à une carte,
	* les paramètres x et y représenteront vraiment l'élément d'indice y de la liste x du tableaau plateau.
	* @return true si l'emplacement demandé par le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} est adjacent à une autre {@link Moteur_Jeu.Carte carte}, 
	* false sinon.
	* @author Farcy Florentin
	*/
	public boolean vérifierAdjacenceVirtuel(int x,int y) {
		// La case en haut à gauche
		if ( x==0 && y==0 ) {
			if (getPlateau().get(x).get(y+1).getCouleur()!= Couleur.RIEN || getPlateau().get(x+1).get(y).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en bas à droite
		else if ( x==4 && y==4 ) {
			if (getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en haut à droite
		else if ( x==0 && y==4 ) {
			if (getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x+1).get(y).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en bas à gauche
		else if ( x==4 && y==0 ) {
			if (getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y+1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// Les cases de la colonne de gauche
		else if ( (x==1 || x==2 || x==3) && y==0) {
			if ( getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y+1).getCouleur()!= Couleur.RIEN || getPlateau().get(x+1).get(y).getCouleur()!= Couleur.RIEN ) {
				return true;
			}
			
			else {
				return false;
			}
		}
		
		// Les cases de la colonne de droite
		else if ( (x==1 || x==2 || x==3) && y==4) {
			if ( getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x+1).get(y).getCouleur()!= Couleur.RIEN ) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// Les cases de la ligne en haut
		else if ( x==0 && (y==1 || y==2 || y==3) ) {
			if ( getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x+1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y+1).getCouleur()!= Couleur.RIEN ) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// Les cases de la ligne en bas
		else if ( x==4 && (y==1 || y==2 || y==3) ) {
			if ( getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y+1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// Les cases "centrales", qui ne seront pas sur les bords du plateau
		else {
			if ( getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN|| getPlateau().get(x).get(y+1).getCouleur()!= Couleur.RIEN || getPlateau().get(x+1).get(y).getCouleur()!= Couleur.RIEN ) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
   
	/**
	* Redéfinis la méthode toString() afin d'afficher le plateau de jeu.
	* @return Un tableau simple modélisant le plateau de jeu afin de faciliter la compréhension du jeu au {@link Moteur_Jeu.Joueur joueur}.
	* @author Farcy Florentin
	*/
	public String toString() {
		StringBuffer sb =new StringBuffer();
		sb.append("[ ".toString());
		sb.append("   ".toString());
		sb.append(getPlateau().get(0).get(0).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(0).get(1).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(0).get(2).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(0).get(3).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(0).get(4).toString());
		sb.append("   ".toString());
		sb.append("]  \n".toString());
		sb.append("[ ".toString());
		sb.append("   ".toString());
		sb.append(getPlateau().get(1).get(0).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(1).get(1).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(1).get(2).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(1).get(3).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(1).get(4).toString());
		sb.append("   ".toString());
		sb.append("]  \n".toString());
		sb.append("[ ".toString());
		sb.append("   ".toString());
		sb.append(getPlateau().get(2).get(0).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(2).get(1).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(2).get(2).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(2).get(3).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(2).get(4).toString());
		sb.append("   ".toString());
		sb.append("]  \n".toString());
		sb.append("[ ".toString());
		sb.append("   ".toString());
		sb.append(getPlateau().get(3).get(0).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(3).get(1).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(3).get(2).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(3).get(3).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(3).get(4).toString());
		sb.append("   ".toString());
		sb.append("]  \n".toString());
		sb.append("[ ".toString());
		sb.append("   ".toString());
		sb.append(getPlateau().get(4).get(0).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(4).get(1).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(4).get(2).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(4).get(3).toString());
		sb.append("            ".toString());
		sb.append(getPlateau().get(4).get(4).toString());
		sb.append("   ".toString());
		sb.append("]  \n".toString());
		return sb.toString();
	}
	
	/**
	* Retourne le tableau de {@link Moteur_Jeu.Carte cartes}.
	* @return Le tableau comportant les {@link Moteur_Jeu.Carte cartes}. 
	* @author Farcy Florentin
	*/
	public ArrayList<ArrayList<Carte>> getPlateau() {
		return plateau;
	}
	
	/**
	* Attribue une {@link Moteur_Jeu.Carte carte} à un élément du tableau.
	* Cette méthode est notamment utilisée lors de l'instanciation d'un Board.
	* @param plateau Le plateau que l'on veut modifier.
	* @author Farcy Florentin
	*/
	public void setPlateau(ArrayList<ArrayList<Carte>> plateau) {
		this.plateau = plateau;
	}
}