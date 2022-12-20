package com.hemebiotech.analytics;

import java.nio.file.Paths;

public class AnalyticsCounter {
	
	/** 
	 * @param args[]
	 * @throws Exception
	 * 
	 * Appel chaque fonction de ServicesSymptoms permettant en fonction du Path de récupèrer,
	 * lire, classer et ecrire les symptomes et leurs nombres d'occurence.
	 */
	
	public static void main(String args[]) throws Exception {
		ServicesSymptoms service = new ServicesSymptoms();
		service.GetSymptoms(Paths.get("C:/Users/Thiba/Desktop/OpenClassrooms/P4/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt"));
		service.ReadSymptoms();
		service.SortSymptoms();
		service.WriteSymptoms();
	}
}
