package arrays_basics.class_problems;
public class TypingAccuracyChecker {
    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }

    public static void checkTypingAccuracy(String original, String typed) {
        int matched = 0;
        int total = original.length();
        int firstMismatchPosition = -1;
        
        for (int i = 0; i < total; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } else if (firstMismatchPosition == -1) {
                firstMismatchPosition = i;
            }
        }
        
        double accuracy = ((double) matched / total) * 100;
        
        if (firstMismatchPosition == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", 
                              matched, total, accuracy);
        } else {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n", 
                              matched, total, accuracy, firstMismatchPosition + 1, 
                              original.charAt(firstMismatchPosition), typed.charAt(firstMismatchPosition));
        }
    }
}
