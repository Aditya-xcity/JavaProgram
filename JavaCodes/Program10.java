/*Program 10: Define a class WordExample with: 
A private data member String strdata to store a sentence in uppercase, terminated by ., ?, or !. 
A parameterized constructor to initialize the sentence. 
A method countWord() to count the number of words that begin and end with a vowel. 
A method placeWord() to rearrange the sentence by placing words that begin and end with a 
vowel at the beginning, followed by the remaining words in their original order.*/


// Name - ADITYA BHARDWAJ
// Section - D2
// Roll No - 07
// Course – B TECH
// Branch – CSE


import java.util.*;

public class Program10 {

    private String strdata;

    Program10(String s) {
        strdata = s;
    }

    private boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) != -1;
    }

    void countWord() {
        String sentence = strdata.trim();
        sentence = sentence.substring(0, sentence.length() - 1);

        String[] words = sentence.split("\\s+");

        int count = 0;

        for (String word : words) {
            if (isVowel(word.charAt(0)) &&
                isVowel(word.charAt(word.length() - 1))) {
                count++;
            }
        }

        System.out.println("Number of words beginning and ending with vowel: " + count);
    }

    void placeWord() {
        String sentence = strdata.trim();
        sentence = sentence.substring(0, sentence.length() - 1);

        String[] words = sentence.split("\\s+");

        String vowelWords = "";
        String otherWords = "";

        for (String word : words) {
            if (isVowel(word.charAt(0)) &&
                isVowel(word.charAt(word.length() - 1))) {
                vowelWords += word + " ";
            } else {
                otherWords += word + " ";
            }
        }

        String result = (vowelWords + otherWords).trim();
        System.out.println("Rearranged Sentence: " + result + ".");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter sentence in UPPERCASE:");
        String input = sc.nextLine();

       Program10 obj = new Program10(input);


        obj.countWord();
        obj.placeWord();
    }
}
