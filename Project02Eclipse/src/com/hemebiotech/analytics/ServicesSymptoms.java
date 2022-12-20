package com.hemebiotech.analytics;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ServicesSymptoms implements IServicesSymptoms {

    Path pathFile;
    List<String> listSymptoms;
    Map<String, Integer> mapSymptoms = new HashMap<String, Integer>();
    TreeMap<String, Integer> treeSymptoms;
 
    @Override
    public List<String> GetSymptoms(Path pathFile) {
        this.pathFile = pathFile;
        Charset charset = StandardCharsets.UTF_8;
        try {
            listSymptoms = Files.readAllLines(this.pathFile, charset);
            return listSymptoms;
        }
        catch (IOException ex) {
            System.out.format("I/O error : %s%n", ex);
        }
        return null;
    }

    @Override
    public Map<String, Integer> ReadSymptoms() {
        for(String symptom : listSymptoms) {
            if(mapSymptoms.containsKey(symptom))
				{
					//If symptom already exist in the map, get the value of this symptom and add +1 to him
					mapSymptoms.replace(symptom, mapSymptoms.get(symptom)+1);
                    continue;
				}
				//symptom dosen't exist in the map, add it 
				mapSymptoms.put(symptom, 1);
        }
        return mapSymptoms;
    }

    @Override
    public TreeMap<String, Integer> SortSymptoms() {
        treeSymptoms = new TreeMap<>(mapSymptoms);
        return treeSymptoms;
    }

    @Override
    public void WriteSymptoms() {
        try{
            FileWriter writer = new FileWriter ("C:/Users/Thiba/Desktop/OpenClassrooms/P4/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.txt");
            //For each line of symptom, write name of this symptom and his occurence in the new file
            for(String symp : treeSymptoms.keySet()){
                writer.write(symp + " : " + treeSymptoms.get(symp) + "\n");
            }
            writer.close();
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }   
}
