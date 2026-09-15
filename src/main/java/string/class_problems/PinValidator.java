package string.class_problems;
public class PinValidator {
    public static void main(String[] args) {
        PinValidator validator = new PinValidator();
        validator.checkPinLength("482");
        validator.checkPinLength("4820");
    }

    public void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }
}
