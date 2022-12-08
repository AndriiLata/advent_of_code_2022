package day8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class day8_second_star {

    private static int countVisibleTrees(int[][] grid, int i, int j){
        int hightMain = grid[i][j];

        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        //top check
        for(int x = i - 1; x >= 0; x--){
            if(hightMain > grid[x][j]){
                top++;
            }
            else{
                top++;
                break;
            }
        }
        //bottom check
        for(int x = i + 1; x < grid.length; x++){
            if(hightMain > grid[x][j]) bottom++;
            else{
                bottom++;
                break;
            }
        }
        //left check
        for(int x = j - 1; x >= 0; x--){
            if(hightMain > grid[i][x]){
                left++;
            } else{
                left++;
                break;
            }
        }
        //right check
        for(int x = j + 1; x < grid[i].length; x++){
            if(hightMain > grid[i][x]) right++;
            else{
                top++;
                break;
            }
        }

        return top * bottom * left * right;
    }

    public static int solveSecondStar(int[][] grid){
        int highestTreeScore = 0;

        for(int i = 1; i < grid.length - 1; i++){
            for(int j = 1; j < grid[i].length - 1; j++){
                if(countVisibleTrees(grid, i, j) > highestTreeScore) {
                    highestTreeScore = countVisibleTrees(grid, i, j);
                }
            }
        }
        return highestTreeScore;
    }



    public static void main(String[] args) {

        System.out.println(solveSecondStar(day8_treetop_tree_house.createGrid(day8_treetop_tree_house.link)));
    }
}
