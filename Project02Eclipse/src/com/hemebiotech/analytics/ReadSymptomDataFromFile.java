package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}


//	@Override
//	public Map<String, Integer> GetDictionnaireSymptomes() {
//		HashMap<String, Integer> resultDictionnaire = new HashMap<String, Integer>();
//		if (filepath != null) {
//			try {
//				BufferedReader Lecture = new BufferedReader(new FileReader(filepath));
//				String ligne = Lecture.readLine();
//				while (ligne != null) {
//					AddSymptome(resultDictionnaire, ligne);
//					ligne = Lecture.readLine();
//				}
//				Lecture.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return resultDictionnaire;
//	}

//	public Map<String, Integer> CountSymptoms(String fileToRead) {
	@Override
	public void CountSymptoms() {
		// TODO Auto-generated method stub
		HashMap<String, Integer> resultDictionnaire = new HashMap<String, Integer>();
		if (filepath != null) {
			try {
				BufferedReader Lecture = new BufferedReader(new FileReader(filepath));
				String ligne = Lecture.readLine();
				while (ligne != null) {
					AddSymptome(resultDictionnaire, ligne);
					ligne = Lecture.readLine();
				}
				Lecture.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		//return resultDictionnaire;
	}

	

	public void AddSymptome(Map<String, Integer> Dictionnaire, String symptome) {
		if (Dictionnaire.containsKey(symptome)) {
			Integer Quantity = Dictionnaire.get(symptome);
			Quantity += 1;
			Dictionnaire.put(symptome, Quantity);

		} else {
			Dictionnaire.put(symptome, 1);
		}

	}

}
