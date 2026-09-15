package classes_objects.class_problems;
class CompanyEmployeeRecord { //[cite: 10]
    String name;
    String empId;
    Employee employee;
    ParkingSlot slot;

    static int totalRecords = 0;

    public CompanyEmployeeRecord(String name, String empId, Employee employee) {
        this.name = name;
        this.empId = empId;
        this.employee = employee;
        totalRecords++;
    }

    public String fullProfile() {
        double effectivePay = employee.getSalary();
        if (employee instanceof ManagerEmployee) {
            effectivePay = ((ManagerEmployee) employee).effectiveSalary();
        } else if (employee instanceof InternEmployee) {
            effectivePay = ((InternEmployee) employee).effectiveSalary();
        }
        
        String slotDisplay = (slot != null) ? slot.slotNo : "no parking assigned";
        return name + " | Pay: Rs " + effectivePay + " | Slot: " + slotDisplay;
    }
}

public class CapstoneMiniSystem { //[cite: 10]
    public static void main(String[] args) {
        ManagerEmployee m1 = new ManagerEmployee("E1", "Divya", 70000, 8000);
        Employee e1 = new Employee("E2", "Karan", 40000);
        InternEmployee i1 = new InternEmployee("E3", "Meera", 12000, 10000);

        CompanyEmployeeRecord r1 = new CompanyEmployeeRecord("Divya", "E1", m1);
        CompanyEmployeeRecord r2 = new CompanyEmployeeRecord("Karan", "E2", e1);
        CompanyEmployeeRecord r3 = new CompanyEmployeeRecord("Meera", "E3", i1);

        ParkingSlot s1 = new ParkingSlot("A1", 4, 3);
        ParkingSlot s2 = new ParkingSlot("A2", 5, 4);

        r1.slot = s1;
        r2.slot = s2;

        System.out.println(r1.fullProfile());
        System.out.println(r2.fullProfile());
        System.out.println(r3.fullProfile());
        System.out.println("Total records: " + CompanyEmployeeRecord.totalRecords);
    }
}
