package edu.scu.Input;

import java.io.FileReader;
import java.util.*;

public class ReadText {

    // TreeMap
    public Map<String, Long> read(String url) {
        Map<String, Long> map = new TreeMap<String, Long>();
        try {
            FileReader f = new FileReader(url);
            char[] c = new char[1];
            int b = 0;
            StringBuilder sb = new StringBuilder();

            while ((b = f.read(c)) != -1) {
                if (Character.isLetter(c[0])) {
                    sb.append(c);
                } else {

                    String key = sb.toString();
                    if(key.equals("")) continue;
                    if (!map.containsKey(key)) {
                        map.put(key, (long)1);
                    } else {
                        map.put(key, map.get(key) + 1);
                    }
                    sb.setLength(0);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;

    }

    // HashMap
    public Map<String, Long> readAsHashMap(String url) {
        Map<String, Long> map = new HashMap<String, Long>();
        try {
            FileReader f = new FileReader(url);
            char[] c = new char[1];
            int b = 0;
            StringBuilder sb = new StringBuilder();

            while ((b = f.read(c)) != -1) {
                if (Character.isLetter(c[0])) {
                    sb.append(c);
                } else {

                    String key = sb.toString();
                    if(key.equals("")) continue;
                    if (!map.containsKey(key)) {
                        map.put(key, (long)1);
                    } else {
                        map.put(key, map.get(key) + 1);
                    }
                    sb.setLength(0);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return map;

    }


    // Sort Firstly
    public void getTopK(Map<String, Long> map, int K) {
        List<Map.Entry<String, Long>> list = new ArrayList<Map.Entry<String, Long>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {

            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        List<String> res = new ArrayList<>();

        for (Map.Entry<String, Long> mapping : list) {
            if (--K < 0) break;
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }


    // Get Directly K loops
    public void getTopKDirectly(Map<String, Long> map, int K) {

        List<String> res = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            long max = Long.MIN_VALUE;
            String maxKey = "";
            for (String key : map.keySet()) {
                if (map.get(key) > max)  {
                    maxKey = key;
                    max = map.get(key);
                }

            }
            System.out.println(maxKey+ ":" + max);
            map.remove(maxKey);
        }


    }

}
