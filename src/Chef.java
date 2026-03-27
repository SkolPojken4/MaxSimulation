public class Chef extends Agent {
    public boolean isAvailable = true;
    private Order currentOrder = null;

    public void update() {
        if (isAvailable) {
            OrderSystem system = OrderSystem.getOrderSystem();
            Order nextOrder = system.takeNextOrder();

            if (nextOrder != null) {
                this.currentOrder = nextOrder;
                this.isAvailable = false; }
        } else {
            // Logic to cook food
        }
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}