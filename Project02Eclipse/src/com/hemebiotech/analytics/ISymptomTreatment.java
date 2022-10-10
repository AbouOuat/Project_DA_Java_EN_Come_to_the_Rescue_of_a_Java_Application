package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomTreatment {
	String getFileName();
	void setFileName(String fileName);
	void addSymptome(Map<String, Integer> dictionnaire, String symptome);
	void printSymptoms(Map <String, Integer> map);
	void countSymptoms();
	void WriteToFile(String fileName);
}
