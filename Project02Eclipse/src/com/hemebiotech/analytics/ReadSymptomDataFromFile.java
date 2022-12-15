package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;
	
	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line
	 */
	public ReadSymptomDataFromFile (String filePath) {
		this.filePath = filePath;
	}
	
	@Override
	public Map<String, Integer> GetSymptoms() {
		//Create map for stock the Symptom and occurence
		Map<String, Integer> listSymp = new HashMap<String, Integer>();
		try
		{
			BufferedReader reader = new BufferedReader (new FileReader(filePath));
			String line = reader.readLine();

			//Loop on each line of the file
			while (line != null) {
				if(listSymp.containsKey(line))
				{
					//If symptom already exist in the map, get the value of this symptom and add +1 to him
					listSymp.replace(line, listSymp.get(line)+1);
				}
				else
				{
					//If symptom dosen't exist in the map, add it 
					listSymp.put(line, 1);
				}
				//Move to next line
				line = reader.readLine();
			}
			reader.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
		//Return the map
		return listSymp;
	}

}
