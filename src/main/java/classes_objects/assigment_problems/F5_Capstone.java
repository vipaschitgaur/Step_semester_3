package classes_objects.assigment_problems;
public class F5_Capstone {

    static class FeeAccount {
        private String regNo;
        private double totalFee;
        private double amountPaid;

        public FeeAccount(String regNo, double totalFee, double amountPaid) {
            this.regNo = regNo;
            this.totalFee = totalFee;
            this.amountPaid = amountPaid;
        }

        public void pay(double amount) {
            if (amount <= 0) {
                System.out.println("Payment rejected: amount must be positive.");
                return;
            }
            amountPaid += amount;
        }

        public double getDue() {
            return totalFee - amountPaid;
        }
    }

    static class HostelFeeAccount extends FeeAccount {
        public HostelFeeAccount(String regNo, double totalFee, double amountPaid) {
            super(regNo, totalFee, amountPaid);
        }

        public void payInTwoInstallments(double amount) {
            pay(amount / 2);
            pay(amount / 2);
        }
    }

    static class HostelRoom {
        String roomNo;
        int beds;
        int occupied;

        public HostelRoom(String roomNo, int beds, int occupied) {
            this.roomNo = roomNo;
            this.beds = beds;
            this.occupied = occupied;
        }

        public void allot(String name) {
            if (occupied < beds) occupied++;
        }
    }

    static class SrmStudent {
        String name;
        String regNo;
        HostelFeeAccount feeAccount;  // object field: composition
        HostelRoom room;              // null until allotted

        static int totalStudents = 0;

        public SrmStudent(String name, String regNo, HostelFeeAccount feeAccount) {
            this.name = name;
            this.regNo = regNo;
            this.feeAccount = feeAccount;
            this.room = null;
            totalStudents++;
        }

        public String fullStatus() {
            String roomStr = (room == null) ? "unallotted" : room.roomNo;
            return name + " | Due: Rs " + feeAccount.getDue() + " | Room: " + roomStr;
        }
    }

    public static void main(String[] args) {
        HostelFeeAccount fa1 = new HostelFeeAccount("R1", 200000, 0);
        fa1.payInTwoInstallments(60000);          // due 140000

        HostelFeeAccount fa2 = new HostelFeeAccount("R2", 200000, 0);
        fa2.payInTwoInstallments(20000);          // due 180000

        HostelFeeAccount fa3 = new HostelFeeAccount("R3", 200000, 0);
        fa3.pay(-500);                            // rejected, due stays 200000

        SrmStudent ravi = new SrmStudent("Ravi", "RA01", fa1);
        SrmStudent anitha = new SrmStudent("Anitha", "RA02", fa2);
        SrmStudent karthik = new SrmStudent("Karthik", "RA03", fa3);

        HostelRoom c214 = new HostelRoom("C-214", 1, 0);
        HostelRoom c507 = new HostelRoom("C-507", 1, 0);

        c214.allot(ravi.name);
        ravi.room = c214;

        c507.allot(anitha.name);
        anitha.room = c507;

        // karthik intentionally left unallotted

        System.out.println(ravi.fullStatus());
        System.out.println(anitha.fullStatus());
        System.out.println(karthik.fullStatus());
        System.out.println("Total students: " + SrmStudent.totalStudents);
    }
}
