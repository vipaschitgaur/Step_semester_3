package classes_objects.assigment_problems;

class SrmStudent{
    String regNo;
    double attendance;
    String name;

    SrmStudent(String reg, String name, double att){
        this.attendance = att;
        this.regNo = reg;
        this.name = name;

    }
    boolean isEligible(){
        return this.attendance >= 75;
    }

    void addAttendanceUpdate(int newAttendance){
        this.attendance = newAttendance;
    }

    static double classAverage(SrmStudent[] students){
        double avg=0;
        for (SrmStudent student: students)
            avg += student.attendance;
        return avg / students.length;
    }
}

public class attendanceSystem {
        
    public static void main(String[] args) {
        SrmStudent[] students = {
                new SrmStudent("RA231100301001", "Ravi", 82),
                new SrmStudent("RA231100301002", "Anitha", 68),
                new SrmStudent("RA231100301003", "Karthik", 91),
                new SrmStudent("RA231100301004", "Meera", 74),
                new SrmStudent("RA231100301005", "Suresh", 60)
        };
 
        for (SrmStudent s : students) {
            String status = s.isEligible() ? "Eligible" : "Detained";
            System.out.println(s.name + " - " + s.attendance + "% - " + status);
        }
 
        System.out.println("Class average: " + SrmStudent.classAverage(students) + "%");
    }
}
       
