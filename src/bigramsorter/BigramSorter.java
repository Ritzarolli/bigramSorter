/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigramsorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 *
 * @author mnhammond0
 */
public class BigramSorter {
    
    static String[] inputText;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        HashMap<String, Integer> bigramsSorted = new HashMap<>();
        Scanner input = new Scanner(new File("./../test_input.txt"));
        List<String> list = new ArrayList<>();
        ArrayList<String> bigrams = new ArrayList<>();
        
        while (input.hasNext()){
            inputText = input.next().split("\\s+");
            //for (String word : inputText){    //used for testing
                //System.out.println(word);     //used for testing
            //}
        }
        
        
        for (int i = 0; i < list.size()-1; i++){
            String bigram;
            if (i != 0){
                bigram = (list.get(i-1))+" "+list.get(i);
                bigrams.add(bigram);
            }
            else {
                bigram = list.get(i)+" "+list.get(i+1);
                bigrams.add(bigram);
            }
        }
        
        //System.out.print(bigrams.size());
        
        //for (int i = 0; i < bigrams.size(); i++){
        //    System.out.println(i);
        //}
        
        bigrams.forEach((combo) -> {        //used for testing
          System.out.println(combo);     //used for testing
        });
        
    }
}
    /**
    private static String getBigrams(String[] words){
        String bigram = "";
                
        for (int i = 0; i < words.length-1; i++){
            if (i == 0){
                bigram = words[i]+" "+words[i+1];
            }
            else {
                bigram = (words[i-1])+" "+words[i];
            }
        }
        return bigram;
        }
    }
    */
    

