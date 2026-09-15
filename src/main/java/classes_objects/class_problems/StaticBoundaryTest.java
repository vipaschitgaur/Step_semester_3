package classes_objects.class_problems;
class BrokenLibraryMember { //[cite: 10]
    // Marking these fields as static means they belong to the class itself and are shared across all instances.[cite: 10]
    // Instantiating a new member overwrites the single shared memory location for name, memberId, and booksIssued, destroying previous data.[cite: 10]
    static String name;
    static String memberId;
    static int booksIssued;

    public BrokenLibraryMember(String n, String m, int b) {
        name = n;
        memberId = m;
        booksIssued = b;
    }
}

class FixedLibraryMember { //[cite: 10]
    String name;
    String memberId;
    int booksIssued;

    static String libraryName = "City Library";
    static int memberCount = 0;

    public FixedLibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
        memberCount++;
        this.memberId = "LM-100" + memberCount;
    }

    public void printMemberCard() {
        System.out.println(this.name + " | " + this.memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}

public class StaticBoundaryTest { //[cite: 10]
    public static void main(String[] args) {
        System.out.println("Broken version:");
        BrokenLibraryMember m1 = new BrokenLibraryMember("Aditi", "1", 0);
        BrokenLibraryMember m2 = new BrokenLibraryMember("Rohan", "2", 0);
        System.out.println(BrokenLibraryMember.name);
        System.out.println(BrokenLibraryMember.name);

        System.out.println("\nFixed version:");
        FixedLibraryMember f1 = new FixedLibraryMember("Aditi", 0);
        FixedLibraryMember f2 = new FixedLibraryMember("Rohan", 0);
        f1.printMemberCard();
        f2.printMemberCard();
        FixedLibraryMember.printTotalMembers();
    }
}
