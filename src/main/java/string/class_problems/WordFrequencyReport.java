package string.class_problems;
import java.util.*;

public class WordFrequencyReport {
    public static void main(String[] args) {
        WordFrequencyReport report = new WordFrequencyReport();
        report.printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }

    public void printFilteredWordFrequency(String feedback) {
        String[] stopWordsArray = {"the", "was", "and", "a", "is", "of", "in"};
        Set<String> stopWords = new HashSet<>(Arrays.asList(stopWordsArray));
        
        String cleanedText = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleanedText.split("\\s+");
        
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (String word : words) {
            if (!stopWords.contains(word) && !word.isEmpty()) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());
        entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
