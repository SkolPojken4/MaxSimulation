import java.util.ArrayList;
import java.util.List;

public final class Desk {

    private static Desk desk = null;
    private ArrayList<Order> finishedOrders;
    private List<OrderObserver> observers = new ArrayList<>();

    private Desk() {
        this.finishedOrders = new ArrayList<Order>();
    }

    public static Desk getDesk() {
        if (desk == null) {
            desk = new Desk();
        }
        return desk;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (OrderObserver observer : new ArrayList<>(observers)) {
            observer.onNewOrderAvailable();
        }
    }

    public void addFinishedOrder(Order order) {
        this.finishedOrders.add(order);
        System.out.println("Order #" + order.getOrderNumber() + " received at desk.");
        notifyObservers();
    }

    public ArrayList<Order> getFinishedOrders() {
        return finishedOrders;
    }

    public Order pickUpOrder(int orderNumber) {
        for (Order o : finishedOrders) {
            if (o.getOrderNumber() == orderNumber) {
                finishedOrders.remove(o);
                return o;
            }
        }
        return null;
    }

}
