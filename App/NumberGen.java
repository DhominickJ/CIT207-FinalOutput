package App;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;



public class NumberGen {
    public static void main(String args[]){
        // Test Sequence will be placed
        // int[] b_Ranges =  {1, 15}, i_Range = {16, 30};
        // int[] randomNumbers = getRandomNumberInRange(20, 40, 5);

        // Example implementation, simply comment it: Don't Remove for documentation and debugging.
        int[] b_randNumbers = getRandomNumberInRange(1, 15, 5);
        int[] i_randNumbers = getRandomNumberInRange(16, 30, 5);
        int[] n_randNumbers = getRandomNumberInRange(31, 45, 5);
        int[] g_randNumbers = getRandomNumberInRange(46, 60, 5);
        int[] o_randNumbers = getRandomNumberInRange(61, 75, 5);
        for (int number : o_randNumbers){
            System.out.println(number);
        }
    }

    // Initial attempt for function generation. For documentation, don't remove. Thanks.
    // The problem with it is the least number of samples that we can generate which then ensure that there is a large probability that the same number will appear so, I abandon this function.
    // private static int[] getRandomNumberInRange(int min, int max, int total) {
    //     Random rand = new Random();
    //     int[] numberGen = new int[total];
    //     for(int i = 0; i <= total - 1; i++){
    //         int randNumber = rand.nextInt((max - min) + 1) + min; // The purpose is to generate a random number that we can add to the minimum number that is within the range.
    //         for(int j = 0; j <= total - 1; j++){
    //             if(randNumber == numberGen[j]){
    //                 randNumber = rand.nextInt((max - min) + 1) + min;
    //             }
    //             else{
    //                 numberGen[i] = randNumber;
    //             }
    //         }
    //     }
    //     return numberGen;
    // }

    // A better implementation of duplicate checking and randomized number generation compared to my implementation.
    // https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array answered by PhiLho
    public static int[] getRandomNumberInRange(int min, int max, int total) { // Modified for the range and total number checker
        // It will create a List object that will store the arrawList so that we can use the add function.
        List<Integer> numbers = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            numbers.add(i); // Using the add function will add all of our number to the array. 
        }
        Collections.shuffle(numbers); // Using this collection function will randomiize the "position" of the numbers to ensure that the numbers are in random and not generate a duplicate number which I found much more facinating, it is like thinking outside the box.
        int[] numberGen = new int[total]; // Using this to return the values we have generated
        for (int i = 0; i < total; i++) {
            numberGen[i] = numbers.get(i); // It will only return the first number of elements based on the number of total values that we have indicated above.
        }
        return numberGen;
    }
}
