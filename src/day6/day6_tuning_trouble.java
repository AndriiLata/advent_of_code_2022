package day6;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class day6_tuning_trouble {

    private static int findFirstMarker(String dataStream){

        LinkedList<Character> characters = new LinkedList<>();
        int counter = 0;
        for(int i = 0; i < dataStream.length(); i++){
            char current = dataStream.charAt(i);
            if(!characters.contains(current)){
                counter++;
                characters.addLast(current);
                //firstPart
                if(counter == 4) return ++i;
                //secondPart
                //if(counter == 14) return ++i;

            } else{
                characters.addLast(current);
                counter++;
                while (true){

                    counter--;
                    if(characters.removeFirst() == current) break;
                }

            }
        }

        return 0;
    }
    public static void main(String[] args) {
        String input = "";
        System.out.println(findFirstMarker(input));
    }
}
