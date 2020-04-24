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
        long preTotalMemory = runtime.totalMemory() / 1024 / 1024;


        long a=System.currentTimeMillis();
        ReadText readText = new ReadText();
        //List<Map.Entry<String, Long>> map =  readText.read(small_txt);
        List<Map.Entry<String, Long>> map =  readText.readAsHashMap(small_txt);
        readText.getTopK(map, K);

        runtime = Runtime.getRuntime();

        long totalMemory = runtime.totalMemory() / 1024 / 1024;

        System.out.println("Memory usage: " + (totalMemory - preTotalMemory) + " M");


        System.out.println("running time: "+(System.currentTimeMillis()-a)/1000f+" second ");

    }


}
