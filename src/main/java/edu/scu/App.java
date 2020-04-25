package edu.scu;

import edu.scu.Input.ReadText;

import java.util.List;
import java.util.Map;

public class App 
{
    private static final String small_txt = "../data/dataset-400MB.txt";
    private static final String medium_txt = "../data/dataset-8GB.txt";
    private static final String large_txt = "../data/Big Data.txt";
    private static final int K = 10;
    public static void main( String[] args )
    {
        Runtime runtime = Runtime.getRuntime();
        // record application start Memory
        long preTotalMemory = runtime.totalMemory() / 1024 / 1024;

        // record application start time
        long a=System.currentTimeMillis();

        ReadText readText = new ReadText();
        // Read Save As TreeMap
        //List<Map.Entry<String, Long>> map =  readText.read(small_txt);

        // Read Save As HashMap
        Map<String, Long> map =  readText.readAsHashMap(small_txt);

        //Sort Firstly, then get TopK
        //readText.getTopK(map, K);

        //get Directly, K loop, K max
        readText.getTopKDirectly(map, K);


        // record application end Memory
        long totalMemory = runtime.totalMemory() / 1024 / 1024;

        // print Memory usage
        System.out.println("Memory usage: " + (totalMemory - preTotalMemory) + " M");


        // print running time
        System.out.println("running time: "+(System.currentTimeMillis()-a)/1000f+" second ");

    }


}
