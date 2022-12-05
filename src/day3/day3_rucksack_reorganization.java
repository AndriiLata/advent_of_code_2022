package day3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class day3_rucksack_reorganization {
    private static String link = "/Users/andriilata/Desktop/Andrii/advent_of_code_2022/day3input.txt";

    public static int solveCode(String link){
        int count = 0;

        try{
            File file = new File(link);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                count += solveLine(line, bufferedReader.readLine(), bufferedReader.readLine());
            }

            bufferedReader.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return count;
    }

    private static int solveLine(String line, String secondLine, String thirdLine){

        Set arrSet1 = new HashSet(convertToList(line));
        Set arrSet2 = new HashSet(convertToList(secondLine));
        Set arrSet3 = new HashSet(convertToList(thirdLine));
        arrSet1.retainAll(arrSet2);
        arrSet1.retainAll(arrSet3);
        if(arrSet1.size() < 1){
            return 0;
        }
        char sameLetter = arrSet1.toArray()[0].toString().charAt(0);


        if(Character.isUpperCase(sameLetter)){
            return (int) sameLetter - 38;
        } else if(Character.isLowerCase(sameLetter)){
            return (int) sameLetter - 96;
        }
        return 0;
    }

    private static List convertToList(String str) {
        List tempList = new ArrayList();
        char[] arr = str.toCharArray();
        for (char a : arr) {
            tempList.add(String.valueOf(a));
        }
        return tempList;
    }

    public static void main(String[] args) {
        System.out.println(solveCode(link));
    }
}
