package com.hemebiotech.analytics;

/**
 * Lit les symptomes et compte des occurences 
 */
public interface ISymptomReader {
	/**
	 * If no data is available, return an empty List
	 * 
	 * @return a raw listing of all Symptoms obtained from a data source, duplicates are possible/probable
	 */
	void CountSymptoms ();
}
