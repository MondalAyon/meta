/*
https://www.metacareers.com/profile/coding_puzzles?puzzle=958513514962507
*/

import java.util.*;

public class Kaitenzushi {
    public static void main(String[] args) {
        int N = 6;
        int[] D = {1, 2, 3, 3, 2, 1};
        //int[] D = {1, 2, 1, 2, 1, 2, 1};
        //int [] D = {1};
        int K = 2;

        //System.out.println(getMaximumEatenDishCount(N,D,K));
        //System.out.println(getMaximumEatenDishCountV2(N,D,K));
        System.out.println(getMaximumEatenDishCountV3(N,D,K));

    }

    public static int getMaximumEatenDishCountV3(int N, int[] D, int K) {

        /* This version is accepted within time limit */

        Set<Integer> consumed = new LinkedHashSet<>(); // Linkedhashset used since it maintain the order of elements.
        int consumeCounter = 0;

        for (int i=0; i<N; i++) {
            // Act only when item doesn't exist in the consumed set.
            if (!consumed.contains(D[i])) {
                consumeCounter++;
                // Remove the first element, same like queue.remove() but effiecient in HashSet.
                // iterator().next() returns the first element always and the set automatically shifts left.
                if (consumed.size() == K) {
                    consumed.remove(consumed.iterator().next());
                }
                consumed.add(D[i]);
            }
        }
        return consumeCounter;
    }

    public static int getMaximumEatenDishCountV2(int N, int[] D, int K) {

        Queue<Integer> consumed = new LinkedList<>();
        int consumeCounter = 0;

        for (int i=0; i<N; i++) {

            if (!consumed.contains(D[i])) {
                consumeCounter++;

                if (consumed.size() == K) {
                    consumed.remove();
                    //consumed.add(D[i]);
                }
                //else consumed.add(D[i]);
                consumed.add(D[i]);
            }
        }
        return consumeCounter;
    }

    public static int getMaximumEatenDishCount(int N, int[] D, int K) {

        int[] consumedArray = new int[K];
        int cosumeCounter = 0;
        int consumedArrayPointer = 0;
        boolean ifAlreadyConsumed = false;


        for (int i=0; i<N; i++) {

            for (int j=0; j<consumedArray.length; j++) {
                if (consumedArray[j] == D[i]) {
                    ifAlreadyConsumed = true;
                    break;
                }
                ifAlreadyConsumed = false;
            }

            //if (!ifAlreadyConsumed(consumedArray, D[i])) {
            if (!ifAlreadyConsumed) {
                if (consumedArrayPointer < K) {
                    consumedArray[consumedArrayPointer] = D[i];
                    consumedArrayPointer++;
                    cosumeCounter++;
                }
                else if (consumedArrayPointer == K) {
                    consumedArray[(consumedArrayPointer % K)] = D[i];
                    consumedArrayPointer = consumedArrayPointer % K + 1;
                    cosumeCounter++;
                }
            }
        }
        return cosumeCounter;
    }
/*
    public static boolean ifAlreadyConsumed (int[] consumed, int item) {
        for (int i=0; i<consumed.length; i++) {
            if (consumed[i] == item)
                return true;
        }
        return false;
    }

 */

}
