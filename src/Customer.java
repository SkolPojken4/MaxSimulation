public class Customer extends Agent {

    private Order order = null;
    private OrderScreen targetScreen = null;

    public Customer() {
        super();
    }

    public Customer(int[] pos) {
        super();
    }

    public void setTargetScreen(OrderScreen screen) {
        this.targetScreen = screen;
        this.setTarget(screen.getPos());
    }

    @Override
    void update() {
        moveTowardsTarget();

        if (order == null && targetScreen != null &&
                this.getPos()[0] == this.getTarget()[0] && this.getPos()[1] == this.getTarget()[1]) {

            this.order = targetScreen.createOrder();
            System.out.println("Customer arrived at screen and ordered!");
        }
    }
}
