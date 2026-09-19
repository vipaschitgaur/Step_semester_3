package arrays_basics.assigment_problems;
public class CustomerVerification {
    public static void main(String[] args) {
        String name = "Sunil";
        String reversed = reverseCustomerName(name);
        
        System.out.println("Input\n\"" + name + "\"");
        System.out.println("Output");
        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversed);
    }

    public static String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
}

