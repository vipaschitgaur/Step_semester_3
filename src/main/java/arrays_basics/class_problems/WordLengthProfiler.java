package arrays_basics.class_problems;
public class WordLengthProfiler {
    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }

    public static void classifyWordLengths(String review) {
        String[] words = review.split(" ");
        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;
        
        for (String word : words) {
            int length = word.length();
            if (length >= 1 && length <= 4) {
                shortWords++;
            } else if (length >= 5 && length <= 8) {
                mediumWords++;
            } else if (length >= 9) {
                longWords++;
            }
        }
        
        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortWords, mediumWords, longWords);
    }
}
