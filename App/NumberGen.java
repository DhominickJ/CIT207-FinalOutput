package App;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class NumberGen {
  // A better implementation of duplicate checking and randomized number
  // generation compared to my implementation.
  // https://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
  // answered by PhiLho
  public static int[] getRandomNumberInRange(int min, int max, int total) { // Modified for the
                                                                            // range and total number checker
    // It will create a List object that will store the arrawList so that we can use
    // the add function.
    List<Integer> numbers = new ArrayList<>();
    for (int i = min; i <= max; i++) {
      numbers.add(i); // Using the add function will add all of our number to the array.
    }
    Collections.shuffle(numbers); // Using this collection function will randomiize the "position"
    // of the numbers to ensure that the numbers are in random and not generate a
    // duplicate number which I found much more facinating, it is like thinking
    // outside the box.
    int[] numberGen = new int[total]; // Using this to return the values we have generated
    for (int i = 0; i < total; i++) {
      numberGen[i] = numbers.get(i); // It will only return the first number of elements
                                     // based on the number of total values that we have indicated above.
    }
    return numberGen;
  }
}
