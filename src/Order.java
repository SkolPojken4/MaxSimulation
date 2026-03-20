import java.util.ArrayList;
import java.util.Random;

public class Order {

    private int orderNumber;
    private ArrayList<FoodItem> orderContent;

    Order() {
        setRandOrderNum();
        this.orderContent = new ArrayList<FoodItem>();
    }

    Order(ArrayList<FoodItem> orderContent) {
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

    public void addItem(FoodItem item) {
        orderContent.add(item);
    }

}
