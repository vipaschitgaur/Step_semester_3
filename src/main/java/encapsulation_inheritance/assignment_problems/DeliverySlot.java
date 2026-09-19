package encapsulation_inheritance.assignment_problems;
public class DeliverySlot {
    private String orderId;
    private String timeSlot;

    public DeliverySlot(String orderId, String timeSlot) {
        this.orderId = orderId;
        this.timeSlot = timeSlot;
    }

    public DeliverySlot(String orderId) {
        this(orderId, "ASAP");
    }

    public boolean isPeakHour() {
        return "12:00-13:00".equals(this.timeSlot) ||
               "13:00-14:00".equals(this.timeSlot) ||
               "19:00-20:00".equals(this.timeSlot) ||
               "20:00-21:00".equals(this.timeSlot);
    }
}

