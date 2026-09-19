package arrays_basics.assigment_problems;
public class FirstNonRepeatingCharApp {
    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc"};
        
        for (String text : inputs) {
            char result = findFirstNonRepeatingChar(text);
            if (result != '\0') {
                System.out.printf("Input: \"%s\" | Output: First Non-Repeating Character: '%c'\n", text, result);
            } else {
                System.out.printf("Input: \"%s\" | Output: No Non-Repeating Character Found\n", text);
            }
        }
    }

    public static char findFirstNonRepeatingChar(String text) {
        int[] counts = new int[256];
        
        for (char c : text.toCharArray()) {
            counts[c]++;
        }
        
        for (char c : text.toCharArray()) {
            if (counts[c] == 1) {
                return c;
            }
        }
        
        return '\0'; 
    }
}
