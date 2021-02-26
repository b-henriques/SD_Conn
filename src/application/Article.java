package application;

import java.sql.ResultSet;
import java.util.Map.Entry;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleMapProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableMap;

public class Article {

	private SimpleIntegerProperty id;
	private SimpleStringProperty nom;
	private SimpleDoubleProperty prix;
	private SimpleStringProperty marque;
	private SimpleStringProperty categorie;
	private SimpleMapProperty<Couple, Integer> quantites;
	
	
	private class Couple {
		String taille;
		String couleur;

		public Couple(String taille, String couleur) {
			this.taille = taille;
			this.couleur = couleur;
		}
	}

	

	/**
	 * ajoute 1 article a la bdd
	 * 
	 * @param valeurs = nom, prix, marque, categorie. lorsqu'un type de val est
	 *                varchar dans la bdd, indiquer entre guillemets simples ie
	 *                't-shirt'
	 * @return rep = le id de l'article
	 */
	public static int ajout(String valeurs) {
		int rep = SQLcoms.ajout("Produits", "nom, prix, marque, categorie", valeurs);
		return rep;
	}

	/**
	 * retourne la table Produits
	 * 
	 * @return reponse = la table sous la forme ResultSet
	 */
	public static ResultSet table() {
		ResultSet reponse;
		reponse = SQLcoms.table("Produits");
		return reponse;
	}

	/**
	 * ajoute une ligne a la table Quantites
	 * 
	 * @param taille
	 * @param couleur
	 * @param qte
	 * 
	 */
	public void ajoutQtes(String taille, String couleur, int qte) {
		SQLcoms.ajout("Quantites", "idProduit, taille, couleur, quantite",
				"'" + taille + "' , '" + couleur + "' , " + qte);
	}

	/**
	 * construit un article: l'ajoute a la bdd dans Produits, et ajoute aussi les quantites si param non null
	 * 
	 * @param quantites = observableMap<\Couple, Integer\> avec couple {@link Couple} et integer la qte
	 * 
	 */
	public Article(String nom, Double prix, String marque, String categorie, ObservableMap<Couple, Integer> quantites) {
		this.nom = new SimpleStringProperty(nom);
		this.prix = new SimpleDoubleProperty(prix);
		this.marque = new SimpleStringProperty(marque);
		this.categorie = new SimpleStringProperty(categorie);
		this.id = new SimpleIntegerProperty(
				ajout("'" + nom + "' , " + prix + " , '" + marque + "' , '" + categorie + "'"));
		// si l'user a deja insere des tailles, couleurs, qtes, on met à jour la table
		// qtes
		if (quantites != null) {
			this.quantites = new SimpleMapProperty<>(quantites);
			for (Entry<Couple, Integer> e : quantites.entrySet()) {
				this.ajoutQtes(e.getKey().taille, e.getKey().couleur, e.getValue());
			}
		}
	}

	
	
	public final SimpleIntegerProperty idProperty() {
		return this.id;
	}
	

	public final int getId() {
		return this.idProperty().get();
	}
	

	public final void setId(final int id) {
		this.idProperty().set(id);
	}
	

	public final SimpleStringProperty nomProperty() {
		return this.nom;
	}
	

	public final String getNom() {
		return this.nomProperty().get();
	}
	

	public final void setNom(final String nom) {
		this.nomProperty().set(nom);
	}
	

	public final SimpleDoubleProperty prixProperty() {
		return this.prix;
	}
	

	public final double getPrix() {
		return this.prixProperty().get();
	}
	

	public final void setPrix(final double prix) {
		this.prixProperty().set(prix);
	}
	

	public final SimpleStringProperty marqueProperty() {
		return this.marque;
	}
	

	public final String getMarque() {
		return this.marqueProperty().get();
	}
	

	public final void setMarque(final String marque) {
		this.marqueProperty().set(marque);
	}
	

	public final SimpleStringProperty categorieProperty() {
		return this.categorie;
	}
	

	public final String getCategorie() {
		return this.categorieProperty().get();
	}
	

	public final void setCategorie(final String categorie) {
		this.categorieProperty().set(categorie);
	}
	

	public final SimpleMapProperty<Couple, Integer> quantitesProperty() {
		return this.quantites;
	}
	

	public final ObservableMap<Couple, Integer> getQuantites() {
		return this.quantitesProperty().get();
	}
	

	public final void setQuantites(final ObservableMap<Couple, Integer> quantites) {
		this.quantitesProperty().set(quantites);
	}
	

	
}
