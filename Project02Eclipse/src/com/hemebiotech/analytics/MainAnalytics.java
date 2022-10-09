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
		MyFile.ReadTheFile();
		
		
		/**
		 * Comptage des occurences
		 */
		MyFile.CountSymptoms();
		
		/**
		 * Ecriture dans un fichier results.out
		 */
		MyFile.OrderAndWriteToFile(".//Project02Eclipse//results.out");

	}

}
