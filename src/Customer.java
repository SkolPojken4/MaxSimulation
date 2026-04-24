public class Customer extends Agent {

    private int[] targetPos;
    private Order order;
    private boolean hasOrdered = false;
    private OrderScreen targetScreen = null;

    public Customer() {
        super();
        this.targetPos = this.getPos();
    }

    public Customer(int[] pos) {
        super();
        this.targetPos = pos;
    }

    void setTarget(int[] pos) {
        this.targetPos = pos;
    }

    public void setTargetScreen(OrderScreen screen) {
        this.targetScreen = screen;
        this.setTarget(screen.getPos());
    }

    void update() {
        // Move towards targetPos
        if (this.getPos()[0] < targetPos[0]) {
            this.move(1, 0);
        } else if (this.getPos()[0] > targetPos[0]) {
            this.move(-1, 0);
        }

        if (this.getPos()[1] < targetPos[1]) {
            this.move(0, 1);
        } else if (this.getPos()[1] > targetPos[1]) {
            this.move(0, -1);
        }
        if (!hasOrdered && targetScreen != null &&
                this.getPos()[0] == targetPos[0] && this.getPos()[1] == targetPos[1]) {

            this.order = targetScreen.createOrder();
            this.hasOrdered = true;
            System.out.println("Customer arrived at screen and ordered!");
        }
    }
}
