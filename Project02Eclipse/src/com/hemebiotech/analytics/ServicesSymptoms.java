package com.hemebiotech.analytics;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Description
 * 
 * ServicesSymptoms à pour but de récupérer les symptoms depuit un fichier texte et d'en écrire
 * le nombre d'occurence et de les affichers dans l'ordre alphabetique dans un autre fichier.
 */

public class ServicesSymptoms implements IServicesSymptoms {

    private Path pathFile;
    private List<String> listSymptoms;
    private Map<String, Integer> mapSymptoms = new HashMap<String, Integer>();
    private TreeMap<String, Integer> treeSymptoms;
 
    
    /** 
     * @param pathFile
     * @return List<String>
     * 
     * En fonction du path saisit récupère l'entièreté du fichier.txt et les stock dans une List<String>, symptome.
     */
    @Override
    public List<String> GetSymptoms(Path pathFile) {
        this.pathFile = pathFile;
        Charset charset = StandardCharsets.UTF_8;
        //Initialise le format de récupération
        try { 
            listSymptoms = Files.readAllLines(this.pathFile, charset);
            //Récupère l'entiérement du fichier.txt et le Return
            return listSymptoms;
        }
        catch (IOException ex) {
            System.out.format("I/O error : %s%n", ex);
        }
        return List.of();
    }

    
    /** 
     * @return Map<String, Integer>
     * 
     * Regarde chaque ligne de la List<String> symptome, si cette ligne existe dans la Map<String, Integer>, symptomes, occurences, 
     * ajoute +1 à la Value de la Key sinon ajout la ligne dans la Map<String, Integer>.
     */
    @Override
    public Map<String, Integer> ReadSymptoms() {
        for(String symptom : listSymptoms) {
            if(mapSymptoms.containsKey(symptom))
				{
					//Si le symptom existe, récupère la Key et ajoute +1 à la Value
					mapSymptoms.replace(symptom, mapSymptoms.get(symptom)+1);
                    continue;
				}
				//Si le symptom n'existe pas il est ajouté à la Map<String, Integer> avec pour Value 1
				mapSymptoms.put(symptom, 1);
        }
        return mapSymptoms;
    }

    
    /** 
     * @return TreeMap<String, Integer>
     * 
     * Récupère la Map<String, Integer>, symptomes, occurences, et la class dans l'orde alphabetique.
     */
    @Override
    public TreeMap<String, Integer> SortSymptoms() {
        treeSymptoms = new TreeMap<>(mapSymptoms);
        return treeSymptoms;
    }

    /**
     * Récupère la TreeMap<String, Integer>, symptomes, occurences, et ecrit dans le fichier chaque ligne.
     */

    @Override
    public void WriteSymptoms() {
        try{
            FileWriter writer = new FileWriter ("C:/Users/Thiba/Desktop/OpenClassrooms/Code/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/result.txt");
            //Pour chaque ligne de la TreeMap<String, Integer> une ligne est ecrite avec ses valeurs.
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
