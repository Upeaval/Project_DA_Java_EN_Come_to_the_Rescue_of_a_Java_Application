package com.hemebiotech.analytics;

public class AnalyticsCounter {
	
	public static void main(String args[]) throws Exception {
		// Read the Symptoms.txt file and stock value in map
		ReadSymptomDataFromFile Read = new ReadSymptomDataFromFile("C:/Users/Thibault Carabasse/OneDrive - ITBRM Consulting/Bureau/OpenClassrooms/P4_Carabasse_Thibault/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt");
		// With the return map, write new file with symptoms and count of him
		new WriteResultToFile(Read.GetSymptoms());
	}
}
