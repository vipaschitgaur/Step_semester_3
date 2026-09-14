package arrays_basics.class_problems;
public class WarehouseInventory {
    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;
        int highestQuantity = -1;
        String highestSection = "";
        int highestItemIndex = -1;
        
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highestQuantity) {
                highestQuantity = sectionA[i];
                highestSection = "Section A";
                highestItemIndex = i + 1;
            }
        }
        
        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highestQuantity) {
                highestQuantity = sectionB[i];
                highestSection = "Section B";
                highestItemIndex = i + 1;
            }
        }
        
        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";
        
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n", 
                          totalA, totalB, status, highestQuantity, highestSection, highestItemIndex);
    }
}
