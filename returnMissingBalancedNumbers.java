/*
https://www.metacareers.com/profile/coding_practice_question/?problem_id=452084462968620&psid=600891527799620&practice_plan=0&p=DATA_ENG&b=0121222

A balanced array would be an array in which each element appears the same number of times.
Given an array with n elements, return a dictionary with the key as the element and the value as the count of elements needed to balance the given array.
Signature
HashMap<Object, Integer> returnMissingBalancedNumbers(Object[] elements)
Input
Array of mixed elements (integers, strings, etc.)
Output
Object with a mixed key, and an integer value
Examples
elements: ["a", "b", "abc", "c", "a"]
output: {"b":1, "abc":1, "c":1}

elements: [1,3,4,2,1,4,1]
output: {2:2, 3:2, 4:1}

elements: [4,5,11,5,6,11]
output: {4:1,6:1}
 */

import java.util.HashMap;

public class returnMissingBalancedNumbers {
    public static void main(String[] args) {
        Object[] objects = new Object[]{"a", "b", "abc", "c", "a"};

        System.out.println(returnMissingBalancedNumbers(objects));

    }

    static HashMap<Object, Integer> returnMissingBalancedNumbers(Object[] objects) {
        HashMap<Object, Integer> resultDict = new HashMap<>();
        HashMap<Object, Integer> inputDict = new HashMap<>();

        // Create a dictionary of objects from the input array of object.
        for (Object o: objects) {
            if (inputDict.containsKey(o))
                inputDict.put(o, inputDict.get(o)+1);
            else inputDict.put(o,1);
        }

        // Find the max value
        int max = Integer.MIN_VALUE;
        for (Object o: inputDict.keySet()) {
            if (inputDict.get(o) > max)
                max = inputDict.get(o);
        }

        // Create result dictionary referring the input object array and the max value.
        for (Object o: inputDict.keySet()) {
            if (inputDict.get(o) != max)
                resultDict.put(o, (max - inputDict.get(o)));
        }

        return resultDict;
    }
}
