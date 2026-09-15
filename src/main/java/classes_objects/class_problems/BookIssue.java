package classes_objects.class_problems;
public class BookIssue { //[cite: 10]
    String title;
    String borrowerName;
    int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public double fineAmount() {
        return daysOverdue > 0 ? daysOverdue * 5.0 : 0.0; 
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14; 
    }

    // totalFineCollected is static because it calculates a sum across an array of objects, 
    // rather than depending on the instance state of any single BookIssue object.[cite: 10]
    // fineAmount is an instance method because it operates on the specific daysOverdue field of an individual book.[cite: 10]
    public static double totalFineCollected(BookIssue[] issues) {
        double total = 0;
        for (BookIssue issue : issues) {
            total += issue.fineAmount();
        }
        return total;
    }

    public static void main(String[] args) {
        BookIssue[] issues = {
            new BookIssue("Clean Code", "Alice", 18),
            new BookIssue("Effective Java", "Bob", 5),
            new BookIssue("Refactoring", "Charlie", 0),
            new BookIssue("DSA Handbook", "Diana", 21),
            new BookIssue("Design Patterns", "Eve", 9)
        };

        for (BookIssue issue : issues) {
            System.out.printf("%s %d days - %s\n", issue.title, issue.daysOverdue, 
                issue.isSeverelyOverdue() ? "Severely overdue" : "OK");
        }
        System.out.println("Total fine collected: Rs " + totalFineCollected(issues));
    }
}
