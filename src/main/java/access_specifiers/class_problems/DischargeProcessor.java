import java.util.Arrays;

public class DischargeProcessor {
    static {
        // Shared state initialization
    }
    
    public static String processNightlyBatch(DischargeSummary[] summaries) {
        int processed = 0;
        int nullSkipped = 0;
        int criticalCare = 0;
        int routine = 0;

        for (DischargeSummary summary : summaries) {
            if (summary == null) {
                nullSkipped++;
                continue;
            }
            processed++;
            if (summary instanceof CriticalCareDischargeSummary) {
                criticalCare++;
            } else {
                routine++;
            }
        }
        return processed + " processed | " + nullSkipped + " null skipped | " + 
               criticalCare + " critical-care | " + routine + " routine";
    }

    public static void main(String[] args) {
        System.out.println("--- Testing DischargeProcessor ---");
        DischargeSummary s1 = new DischargeSummary("P101", new String[]{"MED-A", "MED-B"});
        CriticalCareDischargeSummary s2 = new CriticalCareDischargeSummary("P102", new String[]{"MED-C"}, 4);
        DischargeSummary[] batch = new DischargeSummary[]{s1, null, s2};
        
        System.out.println("Batch summary: " + processNightlyBatch(batch));
        System.out.println("ICU Days for critical care patient: " + s2.getIcuDays());
        DischargeSummary corrected = s1.withCorrectedMedication(0, "MED-Z");
        System.out.println("Corrected medication code: " + corrected.getMedicationCodes()[0]);
    }
}

class DischargeSummary {
    private final String patientId;
    private final String[] medicationCodes;

    public DischargeSummary(String patientId, String[] medicationCodes) {
        this.patientId = patientId;
        if (medicationCodes == null) {
            throw new IllegalArgumentException("construction rejected");
        }
        for (String code : medicationCodes) {
            if (code == null || !code.matches("MED-[A-Z]")) {
                throw new IllegalArgumentException("construction rejected");
            }
        }
        this.medicationCodes = Arrays.copyOf(medicationCodes, medicationCodes.length);
    }

    public String[] getMedicationCodes() {
        return Arrays.copyOf(this.medicationCodes, this.medicationCodes.length);
    }

    public String getPatientId() {
        return this.patientId;
    }

    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        String[] newCodes = getMedicationCodes();
        newCodes[index] = newCode;
        return new DischargeSummary(this.patientId, newCodes);
    }
}

final class CriticalCareDischargeSummary extends DischargeSummary {
    private final int icuDays;

    public CriticalCareDischargeSummary(String patientId, String[] medicationCodes, int icuDays) {
        super(patientId, medicationCodes);
        this.icuDays = icuDays;
    }

    public int getIcuDays() {
        return this.icuDays;
    }
}
