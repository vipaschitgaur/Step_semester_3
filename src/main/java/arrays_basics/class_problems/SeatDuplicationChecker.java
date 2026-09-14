package arrays_basics.class_problems;
public class SeatDuplicationChecker {
    public static void main(String[] args) {
        int[] seatNumbers1 = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seatNumbers1);
        
        int[] seatNumbers2 = {101, 102, 103, 104, 105};
        checkDuplicateSeats(seatNumbers2);
    }

    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean duplicateFound = false;
        boolean[] printed = new boolean[seatNumbers.length];
        
        for (int i = 0; i < seatNumbers.length; i++) {
            if (printed[i]) continue;
            
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    duplicateFound = true;
                    printed[j] = true;
                    break;
                }
            }
        }
        
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
