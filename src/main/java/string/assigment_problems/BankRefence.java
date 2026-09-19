package string.assigment_problems;
import java.util.*;

public class BankRefence {
    static String normaliseReference(String raw){
        String trimmed = raw.trim();
       if (trimmed.length()<3){
            return trimmed;
        }
        String bankCode = trimmed.substring(0,3).toUpperCase();
        String next = trimmed.substring(3);
        return bankCode+next;
    }


    static String validateAndFormat(String reference){
        if (reference.length()!=14){
            return "Invalid: ref must be 14";
        }
        for (int i =0;i<3;i++){
            if(!Character.isLetter(reference.charAt(i)))
                return "Invalid bank ref";
        }

        for(int i= 3; i< 14;i++){
            if(!Character.isDigit(reference.charAt(i)))
                return "invalid ref, must be digits";
        }
        String BankCOde = reference.substring(0,3);
        String dd = reference.substring(3,5);
        String mm = reference.substring(5,7);
        String yy = reference.substring(7,11);
        String seq = reference.substring(11,14);

        StringBuilder formatted = new StringBuilder();
        formatted.append("[").append(BankCOde).append("] ");
        formatted.append("Date: ").append(dd).append("/").append(mm).append("/").append(yy);
        formatted.append(" | SEQ: ").append(seq);

        return formatted.toString();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = " hdf03022600042";
        String refernece = normaliseReference(input);
        String output = validateAndFormat(refernece);
        System.out.println(output);
        
    }
}
