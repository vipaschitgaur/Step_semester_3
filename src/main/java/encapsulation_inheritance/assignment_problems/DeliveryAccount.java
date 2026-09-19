package encapsulation_inheritance.class_problems;
public class DeliveryAccount {
    protected String studentId;
    protected double orderValue;
    private static boolean systemInitialized;

    static {
        systemInitialized = true;
    }

    public DeliveryAccount(String studentId, double orderValue) {
        this.studentId = studentId;
        this.orderValue = orderValue;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 0.0);
    }

    public final double calculateSurgeFee(int delayMinutes) {
        return (delayMinutes > 0) ? (this.orderValue * 0.05) : 0.0; 
    }

    public void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
        
    }

    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        if (accounts.length != amounts.length || accounts.length != delayMinutesArray.length) {
            throw new IllegalArgumentException("Input arrays must have matching lengths.");
        }

        int processed = 0;
        int nullSkipped = 0;
        int premiumCount = 0;
        int regularCount = 0;
        double grandTotalSurge = 0.0;

        for (int i = 0; i < accounts.length; i++) {
            if (accounts[i] == null) {
                nullSkipped++;
                continue;
            }

            processed++;
            grandTotalSurge += accounts[i].calculateSurgeFee(delayMinutesArray[i]);

            if (accounts[i] instanceof PremiumAccount) {
                premiumCount++;
            } else {
                regularCount++;
            }
        }

        System.out.printf("%d processed | %d null skipped | %d premium | %d regular | grand total surge fees = %.2f\n",
                processed, nullSkipped, premiumCount, regularCount, grandTotalSurge);
    }
}

class PremiumAccount extends DeliveryAccount {
    public PremiumAccount(String studentId, double orderValue) {
        super(studentId, orderValue);
    }
}
