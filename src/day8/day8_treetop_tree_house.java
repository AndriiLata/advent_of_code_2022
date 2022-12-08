package day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class day8_treetop_tree_house {
    private static final String link = "/Users/andriilata/Desktop/Andrii/advent_of_code_2022/day8input.txt";
    private static int[][] createGrid(String link) {

        LinkedList<int[]> linkedGrid = new LinkedList<>();

        try {
            File file = new File(link);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                char[] charArray = line.toCharArray();
                int[] intArray = new int[charArray.length];
                for (int i = 0; i < charArray.length; i++) {
                    intArray[i] = Character.getNumericValue(charArray[i]);
                }
                linkedGrid.add(intArray);
            }


            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return linkedGrid.toArray(new int[linkedGrid.size()][linkedGrid.getFirst().length]);
    }

    private static boolean checkVisibility(int[][] grid, int i, int j){
        int hightMain = grid[i][j];
        int hightUp = grid[i-1][j];
        int hightLeft = grid[i][j-1];
        int hightRight = grid[i][j + 1];
        int hightBottom = grid[i + 1][j];
        boolean top = false;
        boolean bottom = false;
        boolean left = false;
        boolean right = false;
        //top check
        for(int x = i - 1; x >= 0; x--){
            top = hightMain > grid[x][j];
            if(!top) break;
        }
        //bottom check
        for(int x = i + 1; x < grid.length; x++){
            bottom = hightMain > grid[x][j];
            if(!bottom) break;
        }
        //left check
        for(int x = j - 1; x >= 0; x--){
            left = hightMain > grid[i][x];
            if(!left) break;
        }
        //right check
        for(int x = j + 1; x < grid[i].length; x++){
            right = hightMain > grid[i][x];
            if(!right) break;
        }

        return top || bottom || left || right;
    }

    public static int solveFirstStar(int[][] grid){
        int visibleTrees = grid[0].length * 2 + grid.length * 2 - 4;

        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[i].length - 1; j++){
                if(checkVisibility(grid, i, j)) {
                    visibleTrees++;
                    System.out.println(grid[i][j]);
                }
            }
        }
        return visibleTrees;
    }



    public static void main(String[] args) {
        System.out.println(solveFirstStar(createGrid(link)));
    }
}

