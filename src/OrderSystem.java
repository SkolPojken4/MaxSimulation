import java.util.ArrayList;

public final class OrderSystem {

    private static OrderSystem orderSystem = null;
    private ArrayList<Order> orders;

    private OrderSystem() {
        this.orders = new ArrayList<Order>();
    }

    public static OrderSystem getOrderSystem() {
        if (orderSystem == null) {
            orderSystem = new OrderSystem();
        }
        return orderSystem;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
        System.out.println("Received order #" + order.getOrderNumber());
    }

    public ArrayList<Order> getOrders() {
        return this.orders;
    }

    public void finishOrder(Order order) {
        // Get desk instance, send order and remove from orderSystem.
        Desk desk = Desk.getDesk();
        desk.addFinishedOrder(order);
        this.orders.remove(order);
        System.out.println("Order #" + order.getOrderNumber() + " sent to desk.");
    }

}
