package edu.scu;

import edu.scu.Input.ReadText;

import java.util.List;
import java.util.Map;

public class App 
{
    // data and code file save in same directory
    private static final String small_txt = "../data/dataset-400MB.txt";
    private static final String medium_txt = "../data/dataset-8GB.txt";
    private static final String large_txt = "../data/Big Data.txt";

    // K parameter
    private static final int K = 10;
    public static void main( String[] args )
    {

        ReadText readText = new ReadText();


        // The Two lines represents two different store data structure
        // Read Save As TreeMap
        Map<String, Long> map =  readText.read(small_txt);

        // Read Save As HashMap
        //Map<String, Long> map =  readText.readAsHashMap(medium_txt);


        // The Two lines represents two get algorithm
        //Sort Firstly, then get TopK
        readText.getTopK(map, K);

        //get Directly, K loop, K max
        //readText.getTopKDirectly(map, K);

    }


}
