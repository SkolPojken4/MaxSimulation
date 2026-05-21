import java.util.Iterator;

public class Chef extends Agent implements OrderObserver {
    public boolean isAvailable = true;
    private Order currentOrder = null;
    private int cookingTimer = 0;
    private final int cookingTime = 100;

    private int[] restPos;
    private int[] cookingPos;
    private final int[] deskPos = {350, 300};

    public Chef(int[] startPos, int[] workPos) {
        super(startPos);
        this.restPos = startPos;
        this.cookingPos = workPos;
        this.setTarget(restPos);
        OrderSystem.getOrderSystem().addObserver(this);
    }

    @Override
    public void onNewOrderAvailable() {
        if (isAvailable) {
            fetchOrder();
        }
    }

    private void fetchOrder() {
        Order nextOrder = OrderSystem.getOrderSystem().takeNextOrder();
        if (nextOrder != null) {
            this.currentOrder = nextOrder;
            this.isAvailable = false;
            this.cookingTimer = cookingTime;
            this.setTarget(cookingPos);
            System.out.println("Chef picked up order #" + nextOrder.getOrderNumber());
        }
    }

    @Override
    public void update() {
        moveTowardsTarget();

        if (!isAvailable && currentOrder != null) {
            if (getPos()[0] == cookingPos[0] && getPos()[1] == cookingPos[1]) {
                if (cookingTimer > 0) {
                    cookingTimer--;
                } else {
                    this.setTarget(deskPos);

                    if (getPos()[0] == deskPos[0] && getPos()[1] == deskPos[1]) {
                        OrderSystem.getOrderSystem().finishOrder(currentOrder);
                        currentOrder = null;
                        isAvailable = true;
                        this.setTarget(restPos);

                        fetchOrder();
                    }
                }
            }
        }
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }
}