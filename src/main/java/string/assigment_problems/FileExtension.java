package string.assigment_problems;

public class FileExtension{
    static String validateFileExtension(String filename){
        int dotIndex = filename.lastIndexOf(".");
        
        String extension = filename.substring(dotIndex+1);
        if (extension.equalsIgnoreCase("pdf") || 
            extension.equalsIgnoreCase("docx") || 
            extension.equalsIgnoreCase("zip")) {
            return "Accepted";
        }

        return "Rejected — invalid file type";
    
    }
    public static void main(String[] args) {
        System.out.println(validateFileExtension("Assignment1.PDF"));
        System.out.println(validateFileExtension("notes.txt"));
}
}
