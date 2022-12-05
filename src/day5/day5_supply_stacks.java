package day5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class day5_supply_stacks {
    private LinkedList<String>[] stacks = new LinkedList[9];
    private String link = "/Users/andriilata/Desktop/Andrii/advent_of_code_2022/day5input.txt";

    private void createStacks(){
        stacks[0] = new LinkedList<>();
        stacks[0].add("P");
        stacks[0].add("L");
        stacks[0].add("M");
        stacks[0].add("N");
        stacks[0].add("W");
        stacks[0].add("V");
        stacks[0].add("B");
        stacks[0].add("H");
        String[] arr1 = {"H", "Q", "M"};
        stacks[1] = new LinkedList<>(Arrays.asList(arr1));
        String[] arr2 = {"L", "M", "Q", "F", "G", "B", "D", "N"};
        stacks[2] = new LinkedList<>(Arrays.asList(arr2));
        String[] arr3 = {"G", "W", "M", "Q", "F", "T", "Z"};
        stacks[3] = new LinkedList<>(Arrays.asList(arr3));
        String[] arr4 = {"P", "H", "T", "M"};
        stacks[4] = new LinkedList<>(Arrays.asList(arr4));
        String[] arr6 = {"T", "G", "H", "D", "J", "M", "B", "C"};
        stacks[5] = new LinkedList<>(Arrays.asList(arr6));
        String[] arr7 = {"R", "V", "F", "B", "N", "M"};
        stacks[6] = new LinkedList<>(Arrays.asList(arr7));
        String[] arr8 = {"S", "G", "R", "M", "H", "L", "P"};
        stacks[7] = new LinkedList<>(Arrays.asList(arr8));
        String[] arr9 = {"N", "C", "B", "D", "P"};
        stacks[8] = new LinkedList<>(Arrays.asList(arr9));
    }



    public String solveCode(){
        createStacks();

        try{
            File file = new File(link);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                //solveLine(line);
                solveLineSecondStar(line);
            }

            bufferedReader.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        String result = "";
        for(int i = 0; i < 9; i++){
            result = result.concat(this.stacks[i].getFirst());
        }

        return result;
    }

    private void solveLine(String line){

        //translate string
        int move = Integer.parseInt(line.split("move ")[1].split(" from ")[0]);
        int from = Integer.parseInt(line.split("from ")[1].split(" to")[0]);
        int to = Integer.parseInt(line.split("to ")[1]);

        for(int i = 0; i < move; i++){
            this.stacks[to - 1].addFirst(this.stacks[from - 1].removeFirst());
        }

    }

    private void solveLineSecondStar(String line){

        //translate string
        int move = Integer.parseInt(line.split("move ")[1].split(" from ")[0]);
        int from = Integer.parseInt(line.split("from ")[1].split(" to")[0]);
        int to = Integer.parseInt(line.split("to ")[1]);

        LinkedList<String> current = new LinkedList<>();
        for(int i = 0; i < move; i++){
            current.add(this.stacks[from - 1].removeFirst());
        }

        for (int i = 0; i < move; i++){
            this.stacks[to - 1].addFirst(current.removeLast());
        }

    }

    public static void main(String[] args) {
        day5_supply_stacks firstStar = new day5_supply_stacks();
        System.out.println(firstStar.solveCode());

    }
}
