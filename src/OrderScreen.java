import java.lang.reflect.Array;
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

    private Order createOrder(ArrayList<OrderSystem.FoodType> orderContent) {
        Order order = new Order(orderContent);
        sendOrder(order);
        return order;
    }

    // No parameters - randomize content
    private Order createOrder() {
        ArrayList<OrderSystem.FoodType> orderContent = new ArrayList<>();

        // Random amount of items 1-5
        int itemAmount = (int) (Math.random() * 5) + 1;

        for (int i = 0; i < itemAmount; i++) {
            // Random course type
            int courseType = (int) (Math.random() * 3);
            switch (courseType) {
                case 0:
                    orderContent.add(OrderSystem.FoodType.BURGER);
                    break;
                case 1:
                    orderContent.add(OrderSystem.FoodType.FRIES);
                    break;
                case 2:
                    orderContent.add(OrderSystem.FoodType.DRINK);
                    break;
            }
        }

        return createOrder(orderContent);
    }

}
