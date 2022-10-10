package com.hemebiotech.analytics;
/**
 * 
 * @author Aboubakary OUATTARA
 * Programme permettant de lire un fichier de symptomes "symptoms.txt"
 *  et d'écrire dans un fichier "results.out" les occurences des différents symptomes
 * 
 *
 */
public class MainAnalytics {

	public static void main(String args[]) throws Exception {

		
		/**
		 * Accès au fichier à traiter
		 */
		AnalyticsCounter MyFile = new AnalyticsCounter(".//Project02Eclipse//symptoms.txt");
		
		/**
		 * Lecture du Fichier
		 */
		MyFile.readTheFile();
		
		
		/**
		 * Comptage des occurences et ordonnancement
		 */
		MyFile.countSymptoms();
		
		/**
		 * Ecriture dans un fichier results.out
		 */
		MyFile.WriteToFile(".//Project02Eclipse//results3.out");

	}

}
