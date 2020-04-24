package edu.scu.Input;

import java.io.FileReader;
import java.util.*;

public class ReadText {

    public List<Map.Entry<String, Long>> read(String url) {
        TreeMap<String, Long> map = new TreeMap<String, Long>();
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
        List<Map.Entry<String, Long>> list = new ArrayList<Map.Entry<String, Long>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Long>>() {

            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }

        });

        return list;

    }

    public void getTopK(List<Map.Entry<String, Long>> list, int K) {
        List<String> res = new ArrayList<>();

        for (Map.Entry<String, Long> mapping : list) {
            if (--K < 0) break;
            System.out.println(mapping.getKey() + ":" + mapping.getValue());
        }
    }

}
