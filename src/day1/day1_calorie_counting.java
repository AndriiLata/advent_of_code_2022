package day1;

public class day1_calorie_counting {

    public static int[] firstSolution(String caloriesCode){

        String[] split = caloriesCode.split("\\s");
        int[] result = new int[split.length];
        int x = 0;
        for(int i = 0; i < split.length; i++){
            try{
                result[x] += Integer.parseInt(split[i]);

            } catch (NumberFormatException e){
                x++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String test = "62797\n" +
                "\n" +
                "1137\n" +
                "6086\n" +
                "6104\n";
        int[] firstSolution = firstSolution(test);

        int temp;

        for(int i = firstSolution.length - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(firstSolution[j] > firstSolution[j + 1]){
                    temp = firstSolution[j];
                    firstSolution[j] = firstSolution[j + 1];
                    firstSolution[j + 1] = temp;
                }
            }
        }

        System.out.println(firstSolution[firstSolution.length - 1] + firstSolution[firstSolution.length - 2] + firstSolution[firstSolution.length - 3]);

    }
}
