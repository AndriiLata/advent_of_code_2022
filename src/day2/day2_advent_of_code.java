package day2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class day2_advent_of_code {

    private static String link = "/Users/andriilata/Desktop/Andrii/advent_of_code_2022/input.txt";

    public static int solveCode(String link){
        int totalScore = 0;
        try{
            File file = new File(link);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                totalScore += oneGameResult(line);
            }

            bufferedReader.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return totalScore;
    }

    public static int oneGameResult(String oneGame){
        String codeSum = oneGame.replace(" ", "");
        /*
        A = Rock
        B = Paper
        C = Scissors

        X = Rock (1)
        Y = Paper (2)
        Z = Scissors (3)
         */

        return switch (codeSum) {
            case "AX" -> 3;
            case "AY" -> 4;
            case "AZ" -> 8;
            case "BX" -> 1;
            case "BY" -> 5;
            case "BZ" -> 9;
            case "CX" -> 2;
            case "CY" -> 6;
            case "CZ" -> 7;
            default -> 0;
        };
    }


    public static void main(String[] args) {
        System.out.println(solveCode(link));
    }
}
