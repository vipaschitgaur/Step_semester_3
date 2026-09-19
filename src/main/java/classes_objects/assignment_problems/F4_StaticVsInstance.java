package classes_objects.assignment_problems;
public class F4_StaticVsInstance {

    // --- Broken version ---
    static class BrokenStudent {
        static String name;
        static String regNo;
        static int attendance;

        BrokenStudent(String name, String regNo, int attendance) {
            this.name = name;
            this.regNo = regNo;
            this.attendance = attendance;
        }
        // name: static means ONE shared slot for all students — wrong, every student needs
        //       their own name.
        // regNo: static means every student's regNo collapses to the same value — wrong,
        //        regNo must be unique per student.
        // attendance: static means updating one student's attendance overwrites everyone's —
        //             wrong, attendance is per-student state.
        // Root cause: static fields belong to the CLASS, not any instance. Every "new" shares
        // the same memory slot instead of getting its own.
    }

    // --- Fixed version ---
    static class SrmStudent {
        private String name;       // instance: unique per student
        private String regNo;      // instance: unique per student
        private int attendance;    // instance: unique per student

        static String university = "SRM KTR";   // static: same for every student, college-wide
        static int admissionCount = 0;           // static: shared counter across all students

        public SrmStudent(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            admissionCount++;
            this.regNo = "RA23110030" + String.format("%03d", admissionCount);
        }

        public void printIdCard() {
            System.out.println(name + " | " + regNo);
        }

        public static void printTotalAdmissions() {
            System.out.println("Students admitted so far: " + admissionCount);
        }
    }

    public static void main(String[] args) {
        // Broken run
        BrokenStudent ravi = new BrokenStudent("Ravi", "RA01", 82);
        BrokenStudent meera = new BrokenStudent("Meera", "RA02", 74);
        System.out.println(ravi.name);   // "Meera" — overwritten
        System.out.println(meera.name);  // "Meera"

        System.out.println();

        // Fixed run
        SrmStudent ravi2 = new SrmStudent("Ravi", 82);
        SrmStudent meera2 = new SrmStudent("Meera", 74);
        ravi2.printIdCard();
        meera2.printIdCard();
        SrmStudent.printTotalAdmissions();
    }
}
