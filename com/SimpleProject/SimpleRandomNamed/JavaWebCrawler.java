package com.simpleProject.SimpleRandomNamed;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.*;

public class JavaWebCrawler {
    public static void main(String[] args) throws Exception {
        String familyNameURL = "https://baijiaxing.256cha.com/";
        String NameURL = "https://www.mingyannet.com/qiming/1725544692.html";
        // String FemaleNameURL = "https://baijiaxing.256cha.com/renming/renmingnvxing/";

        ArrayList<String> familyNamelist = getData(webCrawler(familyNameURL), "(?<=>)([\\u4e00-\\u9fa5])(?=<\\/a>)", 1);
        // familyNamelist.forEach(System.out::println);

        ArrayList<String> Namelist = getData(webCrawler(NameURL), "([\\u4e00-\\u9fa5]{2})(、|<\\/p>)", 1);
        // <p>\\[[0-6]?[0-9]\\]&nbsp;&nbsp;((?:[\\u4e00-\\u9fa5]+(?:、[\\u4e00-\\u9fa5]+)*))<\\/p>
        // Namelist.forEach(System.out::println);

        HashMap<String, String> name = generateInfo(familyNamelist, Namelist, 100);
        name.forEach((key, value) -> {
            System.out.println(key + "-" + value);
        });

        BufferedWriter bw = new BufferedWriter(new FileWriter("com\\SimpleProject\\SimpleRandomNamed\\Names.txt"));
        for (Map.Entry<String, String> entry : name.entrySet()) {
            String s = entry.getKey() + "-" + entry.getValue();
            bw.write(s + "\n");
        }
        bw.close();
        System.out.println("Names.txt has been created successfully!");
    }

    private static String webCrawler(String webString) throws Exception {
        StringBuilder sb = new StringBuilder();

        URL url = new URL(webString);
        
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/4.76");

        InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream(), "UTF-8");
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();
        return sb.toString();
    }

    private static ArrayList<String> getData(String webString, String regex, int index){
        ArrayList<String> data = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(webString);
        while (matcher.find()) {
            data.add(matcher.group(index));
        }
        return data;
    }

    private static HashMap<String, String> generateInfo(ArrayList<String> familyName, ArrayList<String> Name,int number){
        HashMap<String, String> nameSet = new HashMap<>();
        Random r = new Random();
        while(nameSet.size() < number) {
            int familyIndex = (int) (Math.random() * familyName.size());
            int nameIndex = (int) (Math.random() * Name.size());
            String info = familyName.get(familyIndex) + Name.get(nameIndex);
            if(r.nextBoolean()) {
                info = info + "-" + "男" + "-" + String.valueOf(r.nextInt(22) + 18);
            } else {
                info = info + "-" + "女" + "-" + String.valueOf(r.nextInt(22) + 15);
            }
            nameSet.put(info.split("-")[0], info.split("-")[1] + "-" + info.split("-")[2]);
        }
        return nameSet;
    }
}