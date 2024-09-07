/*
https://www.metacareers.com/profile/coding_practice_question/?problem_id=297209572413814&psid=600891527799620&practice_plan=0&p=DATA_ENG&b=0121222

Given an input of two strings consisting of english letters (a-z; A-Z) and spaces, complete a function that returns a list containing all the mismatched words (case sensitive) between them.
You can assume that a word is a group of characters delimited by spaces.
A mismatched word is a word that is only in one string but not the other.
Add mismatched words from the first string before you add mismatched words from the second string in the output array.
Signature
static String[] returnMismatched(String str1, String str2)
Input
str1: a string
str2: a string
Note: You can only expect valid english letters (a-z; A-Z) and spaces.
Output
An array containing all words that do not match between str1 and str2.
Examples
str1: "Firstly this is the first string"
str2: "Next is the second string"
output: ["Firstly", "this", "first", "Next", "second"]

str1: ""
str2: ""
output: []

str1: ""
str2: "This is the second string"
output: ["This","is","the","second","string"]

str1: "This is the first string"
str2: "This is the second string"
output: ["first", "second"]

str1: "This is the first string extra"
str2: "This is the second string"
output: ["first", "extra", "second"]

str1: "This is the first text"
str2: "This is the second string"
output: ["first", "text", "second", "string"]
 */

import java.util.ArrayList;
import java.util.List;

public class returnMismatchedWords {
    public static void main(String[] args) {
        String str1="This is the first string extra";
        String str2="This is the second string";

        String[] result = new String[] {};
        result = returnMismatchedWords(str1, str2);
        for (String s: result)
            System.out.println(s);
    }

    public static String[] returnMismatchedWords(String str1, String str2) {
        //String[] resultStrArray = new String[] {};
        List<String> list = new ArrayList<>();

        // Add all elements for str1 to the list.
        for (String s:str1.split("\\s")) {
            list.add(s);
        }

        //Check the str2
        for (String s:str2.split("\\s")) {
            if (list.contains(s)) {
                list.remove(s);
            }
            else list.add(s);
        }

        String[] resultStrArray = new String[list.size()];

        int i=0;
        for (String s:list) {
            resultStrArray[i]=s;
            i++;
        }

        return resultStrArray;
    }
}
