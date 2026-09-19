package string.assigment_problems;
public class VowelConsonantCounter {
    public static void main(String[] args) {
        VowelConsonantCounter counter = new VowelConsonantCounter();
        counter.countVowelsAndConsonants("Java Programming");
    }

    public void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        String lowerText = text.toLowerCase();
        
        for (int i = 0; i < lowerText.length(); i++) {
            char ch = lowerText.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (ch >= 'a' && ch <= 'z') {
                consonants++;
            }
        }
        
        System.out.printf("Vowels: %d | Consonants: %d\n", vowels, consonants);
    }
}
