import java.util.Iterator;

public class Chef extends Agent {
    public boolean isAvailable = true;
    private Order currentOrder = null;
    private int numInOrder = 0;
    private FoodItem currentItem = null;

    private int cookingTimer = 0;
    private final int cookingTime = 100; //Looks at

    private Iterator<FoodItem> itemIterator;

    public void update() {
        if (isAvailable) {
            OrderSystem system = OrderSystem.getOrderSystem();
            Order nextOrder = system.takeNextOrder();

            if (nextOrder != null) {
                this.currentOrder = nextOrder;
                this.isAvailable = false;
                this.cookingTimer = cookingTime;
            }
        } else {
            if (cookingTimer != 0) {
                cookingTimer -= 1;
            }
            if (cookingTimer == 0) {
                OrderSystem.getOrderSystem().finishOrder(currentOrder);
                currentOrder = null;
                isAvailable = true;

        }
        // Logic to cook food
    }
}

public Order getCurrentOrder() {
    return currentOrder;
}
}