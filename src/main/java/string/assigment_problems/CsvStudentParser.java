package string.assigment_problems;
public class CsvStudentParser {
    public static void main(String[] args) {
        CsvStudentParser parser = new CsvStudentParser();
        parser.parseStudentRecord("Ananya Verma, RA2211003010123,CSE");
        parser.parseStudentRecord("Ananya Verma,CSE");
    }

    public void parseStudentRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length == 3) {
            System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", 
                              fields[0].trim(), fields[1].trim(), fields[2].trim());
        } else {
            System.out.println("Invalid Record");
        }
    }
}
