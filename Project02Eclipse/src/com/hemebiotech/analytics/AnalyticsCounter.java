package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Cette classe caractérise l'objet fichier à traiter
 *
 */
public class AnalyticsCounter implements ISymptomReader {

	private String fileToAnalyze;
	private Map<String, Integer> DictionnaireTrie;

	AnalyticsCounter(String fileToAnalyze) {
		this.fileToAnalyze = fileToAnalyze;
	}

	

	/**
	 * Affichage stylé des symptomes
	 * 
	 * @param map : dictionnaire à afficher
	 */
	public static <K, V> void printSymptoms(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println("Symptome : " + entry.getKey() + " - Occurence : " + entry.getValue());
		}
	}

	/**
	 * Lecture du fichier et afficaheg dans la commande
	 */
	public void ReadTheFile() {
		if (fileToAnalyze != null) {
			try {
				BufferedReader Lecture = new BufferedReader(new FileReader(fileToAnalyze));
				String ligne = Lecture.readLine();
				System.out.println("----Liste des symptomes----");
				while (ligne != null) {
					System.out.println(ligne);
					ligne = Lecture.readLine();
				}
				Lecture.close();
			} catch (FileNotFoundException e) {
				System.out.println("Erreur d'ouverture");
			} catch (IOException e) {
				System.out.println("Erreur de lecture");
			}
		}
	}

	
	/**
	 * Ordonne et écrit dans le fichier en argument
	 * 
	 * @param fileToWrite
	 */
	public void OrderAndWriteToFile(String fileToWrite) throws IOException {
		if (fileToWrite != null) {
			FileWriter myWriter = new FileWriter(fileToWrite);
			if (DictionnaireTrie.isEmpty() == false) {
				DictionnaireTrie.forEach((k, v) -> {
					try {
						myWriter.write(k + " = " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}

				});
			} else {
				CountSymptoms();
				DictionnaireTrie.forEach((k, v) -> {
					try {
						myWriter.write(k + " = " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}

				});

			}
			myWriter.close();
		}

	}

	/**
	 * Ajoute le symptome dans le dictionnaire
	 * 
	 * @param Dictionnaire
	 * @param symptome
	 */
	public static void AddSymptome(Map<String, Integer> Dictionnaire, String symptome) {
		if (Dictionnaire.containsKey(symptome)) {
			Integer Quantity = Dictionnaire.get(symptome);
			Quantity += 1;
			Dictionnaire.put(symptome, Quantity);

		} else {
			Dictionnaire.put(symptome, 1);
		}
		

	}

	/**
	 * Comptage des occurences
	 */
	@Override
	public void CountSymptoms() {
		HashMap<String, Integer> resultDictionnaire = new HashMap<String, Integer>();
		if (fileToAnalyze != null) {
			try {
				BufferedReader Lecture = new BufferedReader(new FileReader(fileToAnalyze));
				String ligne = Lecture.readLine();
				while (ligne != null) {
					AddSymptome(resultDictionnaire, ligne);
					ligne = Lecture.readLine();
				}
				Lecture.close();

				DictionnaireTrie = new TreeMap<String, Integer>(resultDictionnaire);
				printSymptoms(resultDictionnaire);

			} catch (FileNotFoundException e) {
				System.out.println("Erreur d'ouverture");
			} catch (IOException e) {
				System.out.println("Erreur de lecture");
			}
		}
	}
}
