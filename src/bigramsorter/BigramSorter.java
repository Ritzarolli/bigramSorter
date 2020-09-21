
package bigramsorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

/**
 *
 * @author mnhammond0
 * @version 02-SEP-2020
 * Frostburg State University
 * COSC620-701, Fall Online, Dr. Edwin Huang 
 */
public class BigramSorter {
    
    static String[] inputText;

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        Scanner input = new Scanner(new File("./../Security_in_Computing input.txt"));
        List<String> list = new ArrayList<>();
        ArrayList<String> bigrams = new ArrayList<>();
        HashMap<String, Integer> bigramsMap = new HashMap<>();
        
        // Parse the input into an ArrayList of Strings
        while (input.hasNext()){
            list.addAll(Arrays.asList(input.next().split("\\s+")));
        }
        
        // Compose bigrams using Strings in adjacent indeces
        for (int i = 0; i < list.size()-1; i++){
            String bigram;
            bigram = list.get(i)+" "+list.get(i+1);
            bigrams.add(bigram);
        }
        
        // Add a count for each occurrence of a bigram
        for (int i = 0; i < bigrams.size(); i++) {
            int frequency;
            String bigramKey;
            if (bigramsMap.containsKey(bigrams.get(i))){  //in case of existing bigram, increment count
                bigramKey = bigrams.get(i);
                frequency = bigramsMap.get(bigramKey)+1;
                bigramsMap.put(bigramKey, frequency);
            }
            else {  //in case of new bigram not in our list
                bigramKey = bigrams.get(i);
                frequency = 1;
                bigramsMap.put(bigramKey, frequency);
            }
        }
        
        // Moving bigram <key, value> sets into a LinkedList in order to use Collections.sort
        List<Map.Entry<String, Integer> > helperList = new LinkedList<Map.Entry<String, Integer> >(bigramsMap.entrySet());
        Collections.sort(helperList, new Comparator<Map.Entry<String, Integer> >(){
            public int compare(Map.Entry<String, Integer> b1,  
                               Map.Entry<String, Integer> b2) 
            { 
                return (b2.getValue()).compareTo(b1.getValue()); 
            }
        });
        
        // Putting sorted list back into a HashMap, and limiting our results to 20 most frequent
        HashMap<String, Integer> bigramsSorted = new LinkedHashMap<String, Integer>();
            for (Map.Entry<String, Integer> combo : helperList){
                if (bigramsSorted.size()<20){
                    bigramsSorted.put(combo.getKey(), combo.getValue());
                }
            }
       
        // Output to new file
        PrintWriter outputWriter = new PrintWriter(new File("./../COSC620_Bigrams_Output_mnhammond0.txt"));
        outputWriter.write("LAB 1 — MARISA HAMMOND\n\n");
        outputWriter.write("••• 20 Most Frequent Bigrams •••\n");
        
        bigramsSorted.keySet().forEach((bigram) -> {
            String key = bigram;
            String value = bigramsSorted.get(bigram).toString();
            outputWriter.write(key + ": " + value+"\n");
            });
        
        outputWriter.close();
        }
    
        /**
         * Used to print program results when testing
        bigramsSorted.keySet().forEach((bigram) -> {
            String key = bigram;
            String value = bigramsSorted.get(bigram).toString();
            System.out.println(key + ": " + value);        
            });
        */
    }


