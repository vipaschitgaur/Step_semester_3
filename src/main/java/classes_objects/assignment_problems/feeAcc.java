package classes_objects.assignment_problems;
class FeeAccount{
    private String regNo;
    private double totalFee;
    private double amountPaid;

    FeeAccount(String RegNo, double total, double paid){
        this.regNo = RegNo;
        this.totalFee = total;
        this.amountPaid = paid;
    }
    void pay(double amount){
        if(amount<0){
            System.out.println("Payment rejected. Needs positive");
            return;
        }        
        this.amountPaid+=amount;
    }

    double getDue(){
        return this.totalFee - this.amountPaid;
    }
} 


public class feeAcc {
    public static void main(String[] args) {
        FeeAccount Plain = new FeeAccount("RA2511003010208", 150000, 150000);
        HostelFeeAccount Hostel = new HostelFeeAccount("RA2511003010208", 200000, 60000);
        ScholarshipFeeAccount Scholarship = new ScholarshipFeeAccount("RA2511003010208", 180000, 0, 20);

        FeeAccount[] accounts = {Plain, Hostel, Scholarship};

         for (FeeAccount acc : accounts) {
            if (acc instanceof ScholarshipFeeAccount) {
                ScholarshipFeeAccount sa = (ScholarshipFeeAccount) acc;
                System.out.println("Scholarship account effective due: Rs " + sa.effectiveDue());
            } else if (acc instanceof HostelFeeAccount) {
                System.out.println("Hostel account due: Rs " + acc.getDue());
            } else {
                System.out.println("Plain account due: Rs " + acc.getDue());
            }
    }
}
}
class HostelFeeAccount extends FeeAccount {
    public HostelFeeAccount(String regNo, double totalFee, double amountPaid) {
        super(regNo, totalFee, amountPaid);
    }
    void payInTwoInstallments(double amount) {
        pay(amount / 2);
        pay(amount / 2);
}
}


class ScholarshipFeeAccount extends FeeAccount {
    private double scholarshipPercent;
    ScholarshipFeeAccount(String RegNo, double total, double paid, double Percent){
        super(RegNo, total,paid);
        this.scholarshipPercent = Percent;
    }
    double effectiveDue(){
        return getDue() * (1 - scholarshipPercent / 100);
    }
}
