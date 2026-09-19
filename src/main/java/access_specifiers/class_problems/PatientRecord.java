public class PatientRecord {
    private String patientId;
    private String wardCode;
    private double vitalsScore;
    private String facilityName;

    public PatientRecord(String patientId, String wardCode, double vitalsScore, String facilityName) {
        if (patientId == null || patientId.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.patientId = patientId.trim();
        this.wardCode = wardCode;
        this.vitalsScore = vitalsScore;
        this.facilityName = facilityName;
    }

    public static void main(String[] args) {
        System.out.println("--- Testing PatientRecord ---");
        PatientRecord record = new PatientRecord("PAT-9001", "WARD-B", 98.6, "St. Jude Hospital");
        System.out.println("Created Patient Record for " + record.patientId);
        System.out.println("Ward: " + record.wardCode + ", Vitals: " + record.vitalsScore + ", Facility: " + record.facilityName);
        try {
            new PatientRecord("12", "WARD-B", 98.6, "Hospital");
        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught invalid patientId: " + e.getMessage());
        }
    }
}
