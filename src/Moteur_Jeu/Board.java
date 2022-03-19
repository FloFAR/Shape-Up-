package Moteur_Jeu;

import java.util.ArrayList;
import Moteur_Jeu.Carte.Couleur;
import Moteur_Jeu.Carte.Forme;
import Moteur_Jeu.Carte.Rempli;

/**
* La classe Board va permettre de stocker les diff�rentes {@link Moteur_Jeu.Carte cartes} du
* {@link Moteur_Jeu.JeuDeCartes paquet de cartes}.
* Lors de l'instanciation, tous les emplacements poss�dent la {@link Moteur_Jeu.Carte carte} ayant comme 
* {@linkplain Moteur_Jeu.Carte.Forme forme}, 
* {@linkplain Moteur_Jeu.Carte.Couleur couleur} et
* {@linkplain Moteur_Jeu.Carte.Rempli remplissage} {@link Moteur_Jeu.Carte.Couleur#RIEN RIEN}.
* 
* @author Farcy Florentin
*/
public class Board {
	
	/**
	* Le nombre de cases en abscisse du plateau. La valeur doit �tre positive et suffisament importante pour
	* pouvoir y placer des {@link Moteur_Jeu.Carte cartes}.
	*/
	public final int DIMENSIONX=5;
	
	/**
	* Le nombre de cases en ordonn�e du plateau. La valeur doit �tre positive et suffisament importante pour
	* pouvoir y placer des {@link Moteur_Jeu.Carte cartes}.
	*/
	public final int DIMENSIONY=5;
	
	/**
	* Le quadrillage du plateau de dimension {@link DIMENSIONX} x {@link DIMENSIONY}.
	*/
	private ArrayList<ArrayList<Carte>> plateau;
	
	/**
	* Instancie un plateau de jeu de dimension {@link DIMENSIONX} x {@link DIMENSIONY}. 
	* Chaque emplacement poss�de initialement la {@link Moteur_Jeu.Carte carte}
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
			ArrayList<Carte> listeInterm�diaire = new ArrayList<Carte>();
			this.getPlateau().add(listeInterm�diaire);
			for (int j = 0; j < DIMENSIONY; j++){
				listeInterm�diaire.add(c);
			}
		}
	}
	
	/**
	* Retourne un bool�en selon la conformit� de l'adjacence de l'emplacement donn� par le {@link Moteur_Jeu.Joueur joueur}.
	* Pour une case avec des dimensions valides, on inspecte si au moins une case adjacente contient une {@link Moteur_Jeu.Carte carte}.
	* Si les coordonn�es donn�es ne respectent pas les dimensions du plateau, un message est envoy� au joueur
	* pour lui demander de fournir de nouvelles coordonn�es.
	* @param x La x-i�me ligne du tableau. Doit �tre compris entre 1 et {@link DIMENSIONX}.
	* @param y La y-i�me colonne du tableau. Doit �tre compris entre 1 et {@link DIMENSIONY}.
	* <br/>
	* On consid�re que le joueur peut ne pas �tre un habitu� des langages de programmation. 
	* Les param�tres x et y seront donc d�cal�s de 1 par rapport � leur position r�elle dans le tableau plateau.
	* @return true si l'emplacement demand� par le {@link Moteur_Jeu.Joueur joueur} est adjacent � une autre {@link Moteur_Jeu.Carte carte},
	* false sinon.
	* @author Farcy Florentin
	*/
	public boolean v�rifierAdjacence(int x,int y) {
		// La case en haut � gauche
		if ( x==1 && y==1 ) {
			if (getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en bas � droite
		else if ( x==5 && y==5 ) {
			if (getPlateau().get(x-1).get(y-2).getCouleur()!= Couleur.RIEN || getPlateau().get(x-2).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en haut � droite
		else if ( x==1 && y==5 ) {
			if (getPlateau().get(x-1).get(y-2).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en bas � gauche
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
			System.out.println("Les coordonn�es fournies sont hors du tableau de jeu !");
			System.out.println("Veuillez redonnez de nouvelles coordonn�es : ");
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
	* Similaire � la m�thode {@link #v�rifierAdjacence(int, int) v�rifierAdjacence}, retourne un bool�en si l'emplacement du plateau de jeu est adjacent � une autre {@link Moteur_Jeu.Carte carte}.
	* @param x L''indice i de la m�thode {@linkplain Moteur_Jeu.Strat�gie#poserCarte(Carte) poserCarte} de l'interface {@link Moteur_Jeu.Strat�gie}.
	* @param y L''indice j de la m�thode {@linkplain Moteur_Jeu.Strat�gie#poserCarte(Carte) poserCarte} de l'interface {@link Moteur_Jeu.Strat�gie}.
	* <br/>
	* �tant donn�e que c'est l'ordinateur qui va inspecter si un emplacement est adjacent � une carte,
	* les param�tres x et y repr�senteront vraiment l'�l�ment d'indice y de la liste x du tableaau plateau.
	* @return true si l'emplacement demand� par le {@link Moteur_Jeu.JoueurVirtuel joueur virtuel} est adjacent � une autre {@link Moteur_Jeu.Carte carte}, 
	* false sinon.
	* @author Farcy Florentin
	*/
	public boolean v�rifierAdjacenceVirtuel(int x,int y) {
		// La case en haut � gauche
		if ( x==0 && y==0 ) {
			if (getPlateau().get(x).get(y+1).getCouleur()!= Couleur.RIEN || getPlateau().get(x+1).get(y).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en bas � droite
		else if ( x==4 && y==4 ) {
			if (getPlateau().get(x-1).get(y).getCouleur()!= Couleur.RIEN || getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en haut � droite
		else if ( x==0 && y==4 ) {
			if (getPlateau().get(x).get(y-1).getCouleur()!= Couleur.RIEN || getPlateau().get(x+1).get(y).getCouleur()!= Couleur.RIEN) {
				return true;
			}
			else {
				return false;
			}
		}
		
		// La case en bas � gauche
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
	* Red�finis la m�thode toString() afin d'afficher le plateau de jeu.
	* @return Un tableau simple mod�lisant le plateau de jeu afin de faciliter la compr�hension du jeu au {@link Moteur_Jeu.Joueur joueur}.
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
	* Attribue une {@link Moteur_Jeu.Carte carte} � un �l�ment du tableau.
	* Cette m�thode est notamment utilis�e lors de l'instanciation d'un Board.
	* @param plateau Le plateau que l'on veut modifier.
	* @author Farcy Florentin
	*/
	public void setPlateau(ArrayList<ArrayList<Carte>> plateau) {
		this.plateau = plateau;
	}
}