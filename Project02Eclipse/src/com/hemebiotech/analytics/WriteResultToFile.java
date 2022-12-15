package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.util.*;
import java.io.IOException;

public class WriteResultToFile {
    public WriteResultToFile(Map<String, Integer> listSymp){
        try{
        FileWriter writer = new FileWriter ("C:/Users/Thibault Carabasse/OneDrive - ITBRM Consulting/Bureau/OpenClassrooms/P4_Carabasse_Thibault/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.txt");
		//For each line of symptom, write name of this symptom and his occurence in the new file
		for(String symp : listSymp.keySet()){
			writer.write(symp + " : " + listSymp.get(symp) + "\n");
		}
		writer.close();
        }
        catch (IOException e) 
		{
			e.printStackTrace();
		}	
    }
    
}
