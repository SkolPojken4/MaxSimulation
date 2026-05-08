import java.lang.reflect.Array;
import java.util.ArrayList;

public class OrderScreen implements HasPosition {

    private int[] pos;
    private final int width;
    private final int height;

    OrderScreen(int[] pos) {
        this.pos = pos;
        this.width = 70;
        this.height = 20;
    }

    public int[] getPos() {
        return this.pos;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int getX() {
        return this.pos[0];
    }

    public int getY() {
        return this.pos[1];
    }

    private void sendOrder(Order order) {
        OrderSystem orderSystem = OrderSystem.getOrderSystem();
        orderSystem.addOrder(order);
        System.out.println("Order #" + order.getOrderNumber() + " sent to order system.");
    }

    public Order createOrder(ArrayList<FoodType> orderContent) {
        Order order = new Order(orderContent);
        sendOrder(order);
        return order;
    }

    // No parameters - randomize content
    Order createOrder() {
        ArrayList<FoodType> orderContent = new ArrayList<>();

        // Random amount of items 1-5
        int itemAmount = (int) (Math.random() * 5) + 1;

        for (int i = 0; i < itemAmount; i++) {
            // Random course type
            int courseType = (int) (Math.random() * 3);
            switch (courseType) {
                case 0:
                    orderContent.add(FoodType.BURGER);
                    break;
                case 1:
                    orderContent.add(FoodType.FRIES);
                    break;
                case 2:
                    orderContent.add(FoodType.DRINK);
                    break;
            }
        }

        return createOrder(orderContent);
    }

}
