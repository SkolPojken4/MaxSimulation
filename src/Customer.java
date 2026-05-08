public class Customer extends Agent {

    private Order order = null;
    private OrderScreen targetScreen = null;
    private Table table;

    public Customer() {
        super();
    }

    public Customer(int[] pos) {
        super(pos);
    }

    public void setTargetScreen(OrderScreen screen) {
        this.targetScreen = screen;
        int[] screenPos = screen.getPos();
        this.setTarget(new int[]{screenPos[0], screenPos[1] - 70});
    }

    @Override
    void update() {
        moveTowardsTarget();

        if (order == null && targetScreen != null &&
                this.getPos()[0] == this.getTarget()[0] && this.getPos()[1] == this.getTarget()[1]) {

            this.order = targetScreen.createOrder();
            System.out.println("Customer arrived at screen and ordered!");

            // Set table as target
            table = RestaurantMain.getAvailableTable();
            if (table != null) {
                table.setAvailable(false);
                int[] tablePos = table.getPos();
                this.setTarget(new int[]{tablePos[0], tablePos[1] + 70});
            }
        }
    }
}
