import java.util.List;
import java.util.ArrayList;

public final class OrderSystem {

    private static OrderSystem orderSystem = null;
    private ArrayList<Order> orders;
    private List<OrderObserver> observers = new ArrayList<>();

    private OrderSystem() {
        this.orders = new ArrayList<Order>();
    }

    static OrderSystem getOrderSystem() {
        if (orderSystem == null) {
            orderSystem = new OrderSystem();
        }
        return orderSystem;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : new ArrayList<>(observers)) {
            observer.onNewOrderAvailable();
        }
    }

    void addOrder(Order order) {
        this.orders.add(order);
        System.out.println("Received order #" + order.getOrderNumber());

        notifyObservers();
    }

    public Order takeNextOrder() {
        if (!orders.isEmpty()) {
            return orders.remove(0); // Hämtar och tar bort den äldsta ordern från listan
        }
        return null;
    }

    ArrayList<Order> getOrders() {
        return this.orders;
    }

    void finishOrder(Order order) {
        // Get desk instance, send order and remove from orderSystem.
        Desk desk = Desk.getDesk();
        desk.addFinishedOrder(order);
        this.orders.remove(order);
        System.out.println("Order #" + order.getOrderNumber() + " sent to desk.");
    }

}
