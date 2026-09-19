package arrays_basics.assigment_problems;
import java.util.*;

public class palindrome{
    public static void main(String[] args){
        if (args.length == 0){
            System.out.println("Please provide a string to check for palindrome.");
            return;
        }
        String textword = args[0];
        if (isPalindromeItr(textword) && isPalindromeRec(textword) && isPalindromeArr(textword)){
            System.out.println(textword + " is a palindrome.");
        }
        else
            System.out.println(textword + " is not a palindrome.");
    
    }

    public static boolean isPalindromeItr(String text){
        int start = 0;
        int end = text.length() -1;

        while(start<end){
            if (text.charAt(end) != text.charAt(start)){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }

    public static boolean isPalindromeRec(String text){
        if (text.length() <= 1) {
            return true;
        }
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        return isPalindromeRec(text.substring(1, text.length() - 1));


    }

    public static boolean isPalindromeArr(String text){
        char[] arr = text.toCharArray();
        char[] reversedArr = text.toCharArray();

        for (int i = 0; i < reversedArr.length / 2; i++){
            char temp = reversedArr[i];
            reversedArr[i] = reversedArr[reversedArr.length - 1 - i];
            reversedArr[reversedArr.length - 1 - i] = temp;

        }
        return Arrays.equals(arr, reversedArr);
    }
}

