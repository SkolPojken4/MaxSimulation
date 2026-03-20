public class OrderScreen implements HasPosition {

    private int[] pos;
    private OrderSystem orderSystem = OrderSystem.getOrderSystem();

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
        orderSystem.addOrder(order);
        System.out.println("Order #" + order.getOrderNumber() + " sent to order system.");
    }

}
