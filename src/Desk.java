import java.util.ArrayList;

public final class Desk {

    private static Desk desk = null;
    private ArrayList<Order> finishedOrders;

    private Desk() {
        this.finishedOrders = new ArrayList<Order>();
    }

    public static Desk getDesk() {
        if (desk == null) {
            desk = new Desk();
        }
        return desk;
    }

    public void addFinishedOrder(Order order) {
        this.finishedOrders.add(order);
        System.out.println("Order #" + order.getOrderNumber() + " received at desk.");
    }

}
