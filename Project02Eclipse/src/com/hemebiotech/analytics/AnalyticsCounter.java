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
public class AnalyticsCounter implements ISymptomReader, ISymptomWriter, ISymptomTreatment {

	private String fileToAnalyze;
	private Map<String, Integer> dictionnaireTrie;

	AnalyticsCounter(String fileToAnalyze) {
		this.fileToAnalyze = fileToAnalyze;
	}

	

	/**
	 * Affichage stylé des symptomes
	 * 
	 * @param map : dictionnaire à afficher
	 */
	@Override
	public void printSymptoms(Map<String,Integer> map) {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Symptome : " + entry.getKey() + " - Occurence : " + entry.getValue());
		}
	}

		
	/**
	 * Ordonne et écrit dans le fichier en argument
	 * 
	 * @param fileToWrite
	 */
	@Override
	public void WriteToFile(String fileToWrite) {
		if (fileToWrite != null) {
			try {
			FileWriter myWriter = new FileWriter(fileToWrite);
			if (dictionnaireTrie.isEmpty() == false) {
				dictionnaireTrie.forEach((k, v) -> {
					try {
						myWriter.write(k + " = " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}

				});
			} 
			myWriter.close();
			} catch (IOException e) {
				System.out.println("Erreur d'ouverture");
			}
			
		}

	}

	/**
	 * Ajoute le symptome dans le dictionnaire
	 * 
	 * @param Dictionnaire
	 * @param symptome
	 */
	@Override
	public void addSymptome(Map<String, Integer> dictionnaire, String symptome) {
		if (dictionnaire.containsKey(symptome)) {
			Integer quantity = dictionnaire.get(symptome);
			quantity += 1;
			dictionnaire.put(symptome, quantity);

		} else {
			dictionnaire.put(symptome, 1);
		}
		

	}


	/**
	 * Comptage des occurences
	 */

	@Override
	public void countSymptoms() {
		HashMap<String, Integer> resultDictionnaire = new HashMap<String, Integer>();
		if (fileToAnalyze != null) {
			try {
				BufferedReader lecture = new BufferedReader(new FileReader(fileToAnalyze));
				String ligne = lecture.readLine();
				while (ligne != null) {
					addSymptome(resultDictionnaire, ligne);
					ligne = lecture.readLine();
				}
				lecture.close();

				this.dictionnaireTrie = new TreeMap<String, Integer>(resultDictionnaire);
			} catch (FileNotFoundException e) {
				System.out.println("Erreur d'ouverture");
			} catch (IOException e) {
				System.out.println("Erreur de lecture");
			}
		}
		
	}



	@Override
	public void iSymptomToWrite(String fileToWrite) {
		if (fileToWrite != null) {
			try {
			FileWriter myWriter = new FileWriter(fileToWrite);
			if (dictionnaireTrie.isEmpty() == false) {
				dictionnaireTrie.forEach((k, v) -> {
					try {
						myWriter.write(k + " = " + v + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}

				});
			} 
			myWriter.close();
			} 
			catch (FileNotFoundException e) {
				System.out.println("Erreur d'ouverture");
			} catch (IOException e) {
				System.out.println("Erreur de lecture");
			}
			
		}
	}


	/**
	 * Lecture du fichier et affichage dans la console
	 */
	@Override
	public void readTheFile() {
		if (fileToAnalyze != null) {
			try {
				BufferedReader lecture = new BufferedReader(new FileReader(fileToAnalyze));
				String ligne = lecture.readLine();
				System.out.println("liste des symptomes");
				while (ligne != null) {
					System.out.println(ligne);
					ligne = lecture.readLine();
				}
				lecture.close();
			} catch (FileNotFoundException e) {
				System.out.println("Erreur d'ouverture");
			} catch (IOException e) {
				System.out.println("Erreur de lecture");
			}
		}
		
	}


	@Override
	public String getFileName() {
		return this.fileToAnalyze;
	}



	@Override
	public void setFileName(String fileName) {
		if (fileName != null) this.fileToAnalyze = fileName;
		
	}
}
