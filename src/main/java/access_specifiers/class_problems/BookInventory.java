package access_specifiers.class_problems;
public class BookInventory {
    private int copiesTotal;
    private int copiesAvailable;

    public BookInventory(int copiesTotal) {
        if (copiesTotal <= 0) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.copiesTotal = copiesTotal;
        this.copiesAvailable = copiesTotal;
    }

    public void checkOut() {
        if (this.copiesAvailable > 0) {
            this.copiesAvailable--;
        }
    }

    public void checkIn() {
        if (this.copiesAvailable < this.copiesTotal) {
            this.copiesAvailable++;
        }
    }

    public int getCopiesAvailable() {
        return this.copiesAvailable;
    }

    public static void main(String[] args) {
        System.out.println("--- Testing BookInventory ---");
        BookInventory inventory = new BookInventory(5);
        System.out.println("Initial available copies: " + inventory.getCopiesAvailable());
        inventory.checkOut();
        inventory.checkOut();
        System.out.println("After 2 checkouts: " + inventory.getCopiesAvailable());
        inventory.checkIn();
        System.out.println("After 1 checkin: " + inventory.getCopiesAvailable());
    }
}
