package day4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class day4_camp_cleanup {

    private static String link = "/Users/andriilata/Desktop/Andrii/advent_of_code_2022/day4input.txt";

    public static int solveCode(String link){
        int totalScore = 0;
        try{
            File file = new File(link);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
//                totalScore += calculateFirstPart(line);
                totalScore += calculateSecondPart(line);
            }

            bufferedReader.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return totalScore;
    }

    private static int calculateFirstPart(String line){
        String[] split = line.split(",");

        int[] first = {Integer.parseInt(split[0].split("-")[0]), Integer.parseInt(split[0].split("-")[1])};
        int[] second = {Integer.parseInt(split[1].split("-")[0]), Integer.parseInt(split[1].split("-")[1])};

        if(first[0] >= second[0] && first[1] <= second[1]){
            return 1;
        } else if(second[0] >= first[0] && second[1] <= first[1]){
            return 1;
        }
        return 0;
    }

    private static int calculateSecondPart(String line){
        String[] split = line.split(",");

        int[] first = {Integer.parseInt(split[0].split("-")[0]), Integer.parseInt(split[0].split("-")[1])};
        int[] second = {Integer.parseInt(split[1].split("-")[0]), Integer.parseInt(split[1].split("-")[1])};

        if(first[0] >= second[0] && first[0] <= second[1]){
            return 1;
        } else if(second[0] >= first[0] && second[0] <= first[1]){
            return 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solveCode(link));
    }
}
