
public class PatientVitals {
    private double[] readings;
    private int count;

    public PatientVitals(double[] initialReadings) {
        this.readings = new double[500];
        this.count = 0;
        if (initialReadings != null) {
            for (double reading : initialReadings) {
                recordReading(reading);
            }
        }
    }

    public void recordReading(double reading) {
        if (reading > 0 && reading <= 45) {
            if (count < this.readings.length) {
                this.readings[count++] = reading;
            }
        }
    }

    public double getAverage() {
        if (count == 0) return 0.0;
        double sum = 0;
        for (int i = 0; i < count; i++) {
            sum += this.readings[i];
        }
        return sum / count;
    }

    public double[] getAllReadings() {
        return Arrays.copyOf(this.readings, this.count);
    }

    public static void main(String[] args) {
        System.out.println("--- Testing PatientVitals ---");
        PatientVitals vitals = new PatientVitals(new double[]{36.5, 37.0, 36.8});
        System.out.println("Initial Average: " + vitals.getAverage());
        vitals.recordReading(37.2);
        vitals.recordReading(55.0); // Ignored since > 45
        System.out.println("All Readings count: " + vitals.getAllReadings().length);
        System.out.println("Updated Average: " + vitals.getAverage());
    }
}
