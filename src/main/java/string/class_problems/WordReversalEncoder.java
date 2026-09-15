package string.class_problems;
public class WordReversalEncoder {
    public static void main(String[] args) {
        WordReversalEncoder encoder = new WordReversalEncoder();
        System.out.println(encoder.reverseEachWord("hello club"));
    }

    public String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            StringBuilder reversedWord = new StringBuilder(words[i]);
            result.append(reversedWord.reverse().toString());
            
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }
}
