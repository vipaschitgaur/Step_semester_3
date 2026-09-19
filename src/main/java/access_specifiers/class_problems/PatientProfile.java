public class PatientProfile {
    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPin;

    public PatientProfile() {
        this(null, null);
    }

    public PatientProfile(String name) {
        this(null, name);
    }

    public PatientProfile(String patientId, String name) {
        this.name = name;
        if (patientId != null) {
            this.patientId = patientId;
        }
    }

    public String getPatientId() {
        return this.patientId;
    }

    public void setPatientId(String patientId) {
        if (this.patientId == null) {
            this.patientId = patientId;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDischarged() {
        return this.discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public String getLockerPin() {
        return this.lockerPin;
    }

    public void setLockerPin(String pin) {
        this.lockerPin = pin;
    }
    public static void main(String[] args) {
        PatientProfile patient = new PatientProfile("John Doe");
        patient.setPatientId("12345");
        patient.setDischarged(true);
        patient.setLockerPin("67890");
        System.out.println("Patient ID: " + patient.getPatientId());
        System.out.println("Patient Name: " + patient.getName());
        System.out.println("Is Discharged: " + patient.isDischarged());
        System.out.println("Locker Pin: " + patient.getLockerPin());
    }
}
