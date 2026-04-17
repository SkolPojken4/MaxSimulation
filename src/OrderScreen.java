import java.util.ArrayList;

public class OrderScreen implements HasPosition {

    private int[] pos;

    OrderScreen(int[] pos) {
        this.pos = pos;
    }

    public int[] getPos() {
        return this.pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    private void sendOrder(Order order) {
        OrderSystem orderSystem = OrderSystem.getOrderSystem();
        orderSystem.addOrder(order);
        System.out.println("Order #" + order.getOrderNumber() + " sent to order system.");
    }

    private void createOrder(ArrayList<FoodItem> orderContent) {
        Order order = new Order(orderContent);
        sendOrder(order);
    }

}
