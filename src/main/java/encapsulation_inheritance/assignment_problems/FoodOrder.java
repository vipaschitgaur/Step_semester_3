package encapsulation_inheritance.class_problems;
public class FoodOrder {
    private String studentName;
    private String dishName;
    private boolean delivered;

    public FoodOrder(String studentName, String dishName) {
        if (studentName == null || studentName.trim().isEmpty() ||
            dishName == null || dishName.trim().isEmpty()) {
            throw new IllegalArgumentException("Student name and dish name cannot be empty or blank.");
        }
        this.studentName = studentName.trim();
        this.dishName = dishName.trim();
        this.delivered = false;
    }

    public void markDelivered() {
        if (this.delivered) {
            System.out.println("Warning: Order already marked delivered!");
        } else {
            this.delivered = true;
            System.out.println("Order delivered successfully.");
        }
    }

    public static void processBatch(String[][] rawOrders) {
        int valid = 0;
        int rejected = 0;

        for (String[] attempt : rawOrders) {
            if (attempt == null || attempt.length < 2) {
                rejected++;
                continue;
            }
            try {
                FoodOrder order = new FoodOrder(attempt[0], attempt[1]);
                valid++;
            } catch (IllegalArgumentException e) {
                rejected++;
            }
        }
        System.out.printf("Valid: %d | Rejected: %d\n", valid, rejected);
    }
}
