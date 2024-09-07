/*
https://www.metacareers.com/profile/coding_practice_question/?problem_id=313591923957227&psid=600891527799620&practice_plan=0&p=DATA_ENG&b=0121222
You are given an input dictionary with keys as strings, and values as integers. Complete a function that returns the key with the nth smallest value.
If the solution involves two keys that have the same value, return the the key that is lexicographically earliest.
If n is larger than the number of distinct keys or equal to 0, then return null.
Signature
String returnSmallestKey(HashMap<String, Integer> inputDict, int n)
Input
inputDict: Map with a string as the key and integer as the value
n: Integer representing the nth smallest value to be returned
Output
string representing the key
Examples
inputDict: {"laptop": 999,"smartphone": 999,"smart tv": 500,"smart watch": 300,"smart home": 9999999}
n: 2
output: "smart tv"

inputDict: {"a": 10,"b": 20}
n: 0
output: null

inputDict: {"a": 1,"b": 2,"c": 3,"d": 4,"e": 5}
n: 6
output: null

inputDict: {"a": 10,"b": 20,"c": 3,"d": 2,"e": 9}
n: 1
output: "d"
 */

import java.util.*;
import java.util.stream.Collectors;

public class returnSmallestKey {
    public static void main(String[] args) {
        HashMap<String, Integer> dict = new HashMap<String, Integer>() {{
            put("laptop", 999);
            put("smartphone", 999);
            put("smart tv", 500);
            put("smart watch", 300);
            put("smart home", 9999999);
        }};
        int n = 3;

        System.out.println(returnSmallestKey(dict, n));
    }

    static String returnSmallestKey(HashMap<String, Integer> inputDict, int n)  {
        List<Integer> valueList = new ArrayList<>();
        List<String> resultString = new ArrayList<>();

        // As per the given condition if "n" is 0 (or negative) then return null.
        if (n <=0 ) return null;

        for (String s:inputDict.keySet()) {
            if (!valueList.contains(inputDict.get(s))) {
                valueList.add(inputDict.get(s));
            }
        }
        //System.out.println(valueList);
        Collections.sort(valueList);
        System.out.println(valueList);

        System.out.println(valueList.get(n-1));

        // As per the given condition if "n" is greater than the size of the value set then return null.
        if (n>valueList.size()) return null;

        /*
        System.out.println(inputDict
                            .entrySet()
                            .stream()
                            .filter(e -> Objects.equals(e.getValue(), 999))
                            .map(Map.Entry::getKey)
                            .collect(Collectors.toList()));
         */
        int a = valueList.get(n-1);
        for (String k: inputDict.keySet()) {
            //if (inputDict.get(k) == valueList.get(n-1)) {
            if (inputDict.get(k) == a) {
                resultString.add(k);

            }
        }
        // As per the given condition if mulyiple keys exists then return the first one by lexicographical order.
        Collections.sort(resultString);

        System.out.println(resultString);

        return resultString.get(0);
    }


}
