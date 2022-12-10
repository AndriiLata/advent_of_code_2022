package day9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class day9_rope_bridge {
    private HashSet<String> visitedCoordinates = new HashSet<>();
    private Coordinates head = new Coordinates(0, 0, null);
    private Coordinates tail = new Coordinates(0, 0, head);

    public int solveCode(String link){

        try{
            File file = new File(link);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null){
                solveFirstStar(line);
            }

            bufferedReader.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return this.visitedCoordinates.size();
    }

    private void solveFirstStar(String line){
        String direction = line.substring(0, 1);
        int steps = Integer.parseInt(line.substring(2, 3));
        move(direction, steps);
    }

    private void move(String direction, int steps){
        switch (direction) {
            case "R":
                for (int i = 0; i < steps; i++) {
                    tail.setHeadX(tail.getHead().getX() + 1);
                    moveTail();
                    updateVisitedCoordinates();
                }
                break;
            case "L":
                for (int i = 0; i < steps; i++) {
                    tail.setHeadX(tail.getHead().getX() - 1);
                    moveTail();
                    updateVisitedCoordinates();
                }
                break;
            case "U":
                for (int i = 0; i < steps; i++) {
                    tail.setHeadY(tail.getHead().getY() + 1);
                    moveTail();
                    updateVisitedCoordinates();
                }
                break;
            case "D":
                for (int i = 0; i < steps; i++) {
                    tail.setHeadY(tail.getHead().getY() - 1);
                    moveTail();
                    updateVisitedCoordinates();
                }
                break;
        }
    }

    private void updateVisitedCoordinates(){
//        System.out.println(this.tail.getX() + " + " + this.tail.getY());
        String coordinates = tail.getX() + "" + tail.getY();
        if(visitedCoordinates.contains(coordinates)){

        } else {
//            System.out.println("i have visited: "+ coordinates);
            visitedCoordinates.add(coordinates);
        }
    }

    private void moveTail(){
        if(!tail.isStepPossible()) {
//            System.out.println("step not possible");
            return;
        }

        double direction = tail.findDirection();
        //MOVE RIGHT
        if(direction == 0){
            tail.setX(tail.getX() + 1);

        }
        //MOVE RIGHT UP
        else if(direction > 0 && direction < 90){
            tail.setX(tail.getX() + 1);
            tail.setY(tail.getY() + 1);
//            System.out.println("i went right up");
        }
        //MOVE UP
        else if(direction == 90){
            //setX == 0
            tail.setY(tail.getY() + 1);
        }
        //MOVE LEFT UP
        else if(direction > 90 && direction < 180){
            tail.setX(tail.getX() - 1);
            tail.setY(tail.getY() + 1);
        }
        //MOVE LEFT
        else if(direction == 180 || direction == -180){
            tail.setX(tail.getX() - 1);
            //tail.setY(tail.getY() + 0);
        }
        //MOVE RIGHT DOWN
        else if(direction < 0 && direction > -90){
            tail.setX(tail.getX() + 1);
            tail.setY(tail.getY() - 1);
        }
        //MOVE LEFT DOWN
        else if(direction < -90 && direction > -180){
            tail.setX(tail.getX() - 1);
            tail.setY(tail.getY() - 1);
        }
        //MOVE DOWN
        else if(direction == - 90){
//            tail.setX(tail.getX() + 0);
            tail.setY(tail.getY() - 1);
        }

    }

    public static void main(String[] args) {
        String link = "/Users/andriilata/Desktop/Andrii/advent_of_code_2022/day9input.txt";

        day9_rope_bridge rope_bridge = new day9_rope_bridge();
        System.out.println(rope_bridge.solveCode(link));
    }
}
