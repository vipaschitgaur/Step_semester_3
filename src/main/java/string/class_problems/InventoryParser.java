package string.class_problems;
public class InventoryParser {
    public static void main(String[] args) {
        InventoryParser parser = new InventoryParser();
        parser.parseInventoryRecord("Wireless Mouse, WM-2201,150");
        parser.parseInventoryRecord("Wireless Mouse, 150");
    }

    public void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        
        if (fields.length == 3) {
            System.out.printf("Product: %s | SKU: %s | Qty: %s\n", 
                              fields[0].trim(), fields[1].trim(), fields[2].trim());
        } else {
            System.out.println("Invalid Record");
        }
    }
}
