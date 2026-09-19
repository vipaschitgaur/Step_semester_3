package encapsulation_inheritance.assignment_problems;
public class Canteen implements Comparable<Canteen> {
    private String canteenCode;
    private String canteenName;
    private int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }

    @Override
    public int compareTo(Canteen other) {
        if (this.trustScore != other.trustScore) {
            return Integer.compare(other.trustScore, this.trustScore); 
        }
        
        int codeComparison = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        if (codeComparison != 0) {
            return codeComparison;
        }
        
        return Integer.compare(this.canteenName.length(), other.canteenName.length());
    }

    public static Canteen[] rankCanteens(Canteen[] canteens) {
        Canteen[] ranked = canteens.clone();
        for (int i = 0; i < ranked.length - 1; i++) {
            for (int j = 0; j < ranked.length - i - 1; j++) {
                if (ranked[j].compareTo(ranked[j + 1]) > 0) {
                    Canteen temp = ranked[j];
                    ranked[j] = ranked[j + 1];
                    ranked[j + 1] = temp;
                }
            }
        }
        return ranked;
    }
}
