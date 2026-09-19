package access_specifiers.assignment_problems;
public class LibraryMember {
    private String membershipId;
    private String branchCode;
    private double finesOwed;
    private String displayName;

    public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
        if (membershipId == null || membershipId.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.membershipId = membershipId.trim();
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    public static void main(String[] args) {
        System.out.println("--- Testing LibraryMember ---");
        LibraryMember member = new LibraryMember("LIB-1234", "CENTRAL", 15.50, "Alice Smith");
        System.out.println("Created member: " + member.displayName + " (ID: " + member.membershipId + ")");
        System.out.println("Branch: " + member.branchCode + ", Fines owed: $" + member.finesOwed);
        try {
            new LibraryMember("12", "CENTRAL", 0.0, "Bob");
        } catch (IllegalArgumentException e) {
            System.out.println("Successfully caught invalid membershipId: " + e.getMessage());
        }
    }
}
