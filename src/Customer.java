public class Customer extends Agent implements OrderObserver {
    private Order order = null;
    private boolean orderIsReady = false;
    private OrderScreen targetScreen = null;
    private Table table = null;

    private final int[] deskPos = {350, 300};
    private final int[] exitPos = {1020, 340};

    private int eatingTimer = 200;
    private boolean isEating = false;
    private boolean isDone = false;

    public Customer(int[] pos) {
        super(pos);
    }

    @Override
    public void onNewOrderAvailable() {
        if (this.order != null && !orderIsReady) {
            for (Order o : Desk.getDesk().getFinishedOrders()) {
                if (o.getOrderNumber() == this.order.getOrderNumber()) {
                    this.orderIsReady = true;
                    this.setTarget(deskPos);
                    break;
                }
            }
        }
    }

    public void setTargetScreen(OrderScreen screen) {
        this.targetScreen = screen;
        int[] screenPos = screen.getPos();
        this.setTarget(new int[]{screenPos[0], screenPos[1] - 70});
    }

    public boolean hasLeft() {
        return isDone && isAtTarget();
    }

    @Override
    void update() {
        moveTowardsTarget();

        if (order == null && targetScreen != null && isAtTarget()) {
            this.order = targetScreen.createOrder();
            Desk.getDesk().addObserver(this);

            table = RestaurantMain.getAvailableTable();
            if (table != null) {
                table.setAvailable(false);
                setTarget(new int[]{table.getX(), table.getY() + 70});
            }
        }

        if (order != null && !orderIsReady && table == null) {
            table = RestaurantMain.getAvailableTable();
            if (table != null) {
                table.setAvailable(false);
                setTarget(new int[]{table.getX(), table.getY() + 70});
            }
        }

        if (orderIsReady && order != null && isAtTarget()) {
            Order pickedUp = Desk.getDesk().pickUpOrder(order.getOrderNumber());
            if (pickedUp != null) {
                this.orderIsReady = false;

                Desk.getDesk().removeObserver(this);

                if (table == null) {
                    table = RestaurantMain.getAvailableTable();
                    if (table != null) {
                        table.setAvailable(false);
                    }
                }

                if (table != null) {
                    setTarget(new int[]{table.getX(), table.getY() + 70});
                    isEating = true;
                } else {
                    setTarget(exitPos);
                    isDone = true;
                }
            }
        }

        if (isEating && table != null && isAtTarget()) {
            if (eatingTimer > 0) {
                eatingTimer--;
            } else {
                isEating = false;
                isDone = true;
                table.setAvailable(true);
                setTarget(exitPos);
                System.out.println("Customer has eaten");
            }
        }
    }
}