package classes_objects.class_problems;
class ParkingSlot { //[cite: 10]
    String slotNo;
    int capacity;
    int occupiedCount;

    public ParkingSlot(String slotNo, int capacity, int occupiedCount) {
        this.slotNo = slotNo;
        this.capacity = capacity;
        this.occupiedCount = occupiedCount;
    }

    public void allot(String vehicleNo) {
        if (occupiedCount < capacity) {
            occupiedCount++;
        }
    }
}

public class ParkingAllocation { //[cite: 10]
    public static ParkingSlot findAvailableSlot(ParkingSlot[] slots) {
        for (ParkingSlot slot : slots) {
            if (slot.occupiedCount < slot.capacity) {
                return slot;
            }
        }
        return null;
    }

    // Passing the ParkingSlot array into these methods passes the memory reference to the array of objects, 
    // not a copied clone of the objects themselves.[cite: 10]
    // Modifying a slot inside the method directly updates the original object in memory.[cite: 10]
    public static void safeAllot(ParkingSlot[] slots, String vehicleNo) {
        ParkingSlot available = findAvailableSlot(slots);
        if (available != null) {
            available.allot(vehicleNo);
            System.out.println(vehicleNo + " allotted to slot " + available.slotNo);
        } else {
            System.out.println("No slots available for " + vehicleNo);
        }
    }

    public static void main(String[] args) {
        ParkingSlot[] availableSlots = {
            new ParkingSlot("A1", 4, 3),
            new ParkingSlot("A2", 5, 5)
        };
        safeAllot(availableSlots, "TN09AB1234");

        ParkingSlot[] fullSlots = {
            new ParkingSlot("A1", 4, 4),
            new ParkingSlot("A2", 5, 5)
        };
        safeAllot(fullSlots, "TN09AB1234");
    }
}
