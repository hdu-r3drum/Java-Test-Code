package com.SimpleProject.SimpleRandomNamed;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
// import java.util.function.Consumer;
// import com.classes.Student;

public class SimpleRandomNamed {
    public static void main(String[] args) throws Exception {
        ArrayList<String> Studentlist = new ArrayList<>();
        Studentlist = readNameFile();
        // random1(Studentlist, 50);
        // random2(Studentlist, 0.7f, 1000);
        random4(Studentlist, 30);

        // ArrayList<Student> stus = new ArrayList<>();
        // Studentlist.forEach(new Consumer<String>(){
        //     @Override
        //     public void accept(String s) {
        //         String[] info = s.split("-");
        //         // age name sex
        //         Student stu = new Student(Integer.parseInt(info[2]), info[0], info[1]);
        //         // System.out.println(stu.getClass());
        //         stus.add(stu);
        //     }
        // });
        // stus.forEach(System.out::println);
    }

    private static ArrayList<String> readNameFile() throws Exception {
        FileReader fr = new FileReader(new File("com\\SimpleProject\\SimpleRandomNamed\\Names.txt"));
        int ch;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> nameList = new ArrayList<>();
        while((ch = fr.read()) != -1) {
            if(ch != '\n' && ch != '\r') {
                sb.append((char) ch);
            }else {
                nameList.add(sb.toString());
                sb.setLength(0); // Clear the StringBuilder for the next name
            }
        }
        fr.close();
        return nameList;
    }
    
    private static void random1(ArrayList<String> Studentlist, long time){
        Random r = new Random();
        int index = r.nextInt(Studentlist.size());
        String[] info = Studentlist.get(index).split("-");
        while(time > 0){
            time--;
            index = r.nextInt(Studentlist.size());
            info = Studentlist.get(index).split("-");
            System.out.println(info[0]);
        }
    }

    private static void random2(ArrayList<String> Studentlist, float percent, long times){
        int male = 0;
        int female = 0;
        Random r = new Random();
        int time = 0;
        while(time <= times){
            time++;
            float f = r.nextFloat(1);
            if(f <= percent){
                int index = r.nextInt(Studentlist.size());
                String[] info = Studentlist.get(index).split("-");
                while(!(info[1].equals("男"))){
                    index = r.nextInt(Studentlist.size());
                    info = Studentlist.get(index).split("-");
                }
                System.out.println(Arrays.toString(info));
                male++;
            }else{
                int index = r.nextInt(Studentlist.size());
                String[] info = Studentlist.get(index).split("-");
                while(!(info[1].equals("女"))){
                    index = r.nextInt(Studentlist.size());
                    info = Studentlist.get(index).split("-");
                }
                System.out.println(Arrays.toString(info));
                female++;
            }
        }
        System.out.println("Male:" + String.valueOf(male));
        System.out.println("Female:" + String.valueOf(female));
        System.out.println(String.valueOf(male * 1.0 / (male + female)));
    }

    private static void random4(ArrayList<String> Studentlist, int time){
        int times = 0;
        Random r = new Random();
        while(times < time){
            times++;
            int index = r.nextInt(Studentlist.size());
            String[] info = Studentlist.get(index).split("-");
            System.out.println(Arrays.toString(info));
            Studentlist.remove(index);
            if(Studentlist.isEmpty()){
                break;
            }
        }
    }
} 