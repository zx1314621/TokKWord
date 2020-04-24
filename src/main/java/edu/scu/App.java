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

        long a=System.currentTimeMillis();
        ReadText readText = new ReadText();
        List<Map.Entry<String, Long>> map =  readText.read(small_txt);
        readText.getTopK(map, K);

//这里放需要测试执行时间的代码段。
        System.out.println("\r<br> 执行耗时 : "+(System.currentTimeMillis()-a)/1000f+" 秒 ");

    }


}
