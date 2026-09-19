package encapsulation_inheritance.assignment_problems;

public final class SurgeFeeCalculator {
    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0) {
            throw new IllegalArgumentException("Order value and delay minutes cannot be negative.");
        }
        
        if (delayMinutes == 0) {
            return 0.0;
        }

        double percentCharge = 0.0;

        int tier1Mins = Math.min(delayMinutes, 5);
        percentCharge += tier1Mins * 0.5;

        if (delayMinutes > 5) {
            int tier2Mins = Math.min(delayMinutes - 5, 10);
            percentCharge += tier2Mins * 1.0;
        }

        if (delayMinutes > 15) {
            int tier3Mins = delayMinutes - 15;
            percentCharge += tier3Mins * 2.0;
        }

        double calculatedFee = (percentCharge / 100.0) * orderValue;
        double floorFee = (minimumSurgePercent / 100.0) * orderValue;

        return Math.max(calculatedFee, floorFee);
    }
}
