import java.util.ArrayList;
import java.util.Random;

public class Order {

    private int orderNumber;
    private ArrayList<OrderSystem.FoodType> orderContent;

    Order() {
        setRandOrderNum();
        this.orderContent = new ArrayList<OrderSystem.FoodType>();
    }

    Order(ArrayList<OrderSystem.FoodType> orderContent) {
        setRandOrderNum();
        this.orderContent = orderContent;
    }

    private void setRandOrderNum() {
        // Random orderNumber between 1000-9999
        this.orderNumber = new Random().nextInt(9000) + 1000;
    }

    public int getOrderNumber() {
        return this.orderNumber;
    }

    public void addItem(OrderSystem.FoodType item) {
        orderContent.add(item);
    }

}
