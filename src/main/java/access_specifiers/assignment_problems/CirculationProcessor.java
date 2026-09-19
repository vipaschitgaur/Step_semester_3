package access_specifiers.assignment_problems;
import java.util.Arrays;

public class CirculationProcessor {
    static {
        // One-time shared state setup
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (LoanReceipt receipt : receipts) {
            if (receipt == null) {
                nullSkipped++;
                continue;
            }
            
            processed++;
            if (receipt instanceof ReferenceOnlyLoanReceipt) {
                referenceOnly++;
            } else {
                regular++;
            }
        }
        
        return processed + " processed | " + nullSkipped + " null skipped | " + 
               referenceOnly + " reference-only | " + regular + " regular";
    }

    public static void main(String[] args) {
        System.out.println("--- Testing CirculationProcessor ---");
        LoanReceipt r1 = new LoanReceipt("MEM001", new String[]{"BK-001", "BK-002"});
        ReferenceOnlyLoanReceipt r2 = new ReferenceOnlyLoanReceipt("MEM002", new String[]{"BK-003"}, "Room 101");
        LoanReceipt[] batch = new LoanReceipt[]{r1, null, r2};
        
        System.out.println("Batch result: " + processNightlyCirculation(batch));
        System.out.println("Reference receipt room: " + r2.getRoomNumber());
        LoanReceipt corrected = r1.withCorrectedBookId(0, "BK-999");
        System.out.println("Corrected book id: " + corrected.getBookIds()[0]);
    }
}

class LoanReceipt {
    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        this.memberId = memberId;
        if (bookIds == null) {
            throw new IllegalArgumentException("construction rejected");
        }
        for (String id : bookIds) {
            if (id == null || !id.matches("BK-\\d{3}")) {
                throw new IllegalArgumentException("construction rejected");
            }
        }
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String[] getBookIds() {
        return Arrays.copyOf(this.bookIds, this.bookIds.length);
    }
    
    public String getMemberId() {
        return this.memberId;
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        String[] newIds = getBookIds();
        newIds[index] = newId;
        return new LoanReceipt(this.memberId, newIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {
    private final String roomNumber;

    public ReferenceOnlyLoanReceipt(String memberId, String[] bookIds, String roomNumber) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
    
    public String getRoomNumber() {
        return this.roomNumber;
    }
}
