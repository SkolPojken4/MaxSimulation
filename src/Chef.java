import java.util.ArrayList;

public class Chef extends Agent implements OrderObserver {
    public boolean isAvailable = true;
    private Order currentOrder = null;
    private ArrayList<FoodType> itemsToPrepare = new ArrayList<>();
    private FoodType currentItemInProgress = null;

    private int cookingTimer = 0;
    private final int cookingTime = 100;

    private final int[] restPos;
    private final int[] burgerPos = {100, 200};
    private final int[] fryPos = {200, 200};
    private final int[] drinkPos = {300, 200};
    private final int[] deskPos = {350, 300};

    private boolean isWalkingToDesk = false;

    public Chef(int[] startPos, int[] workPos) {
        super(startPos);
        this.restPos = startPos;
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
            this.itemsToPrepare = new ArrayList<>(nextOrder.getOrderContent());
            prepareNextItem();
        }
    }

    private void prepareNextItem() {
        if (!itemsToPrepare.isEmpty()) {
            currentItemInProgress = itemsToPrepare.remove(0);
            cookingTimer = cookingTime;
            isWalkingToDesk = false;

            this.setTarget(getStationPosition(currentItemInProgress));
            System.out.println("Chef is cooking: " + currentItemInProgress);
        } else {
            System.out.println("Order #" + currentOrder.getOrderNumber() + " Delivered");
            this.currentOrder = null;
            this.isAvailable = true;
            this.setTarget(restPos);
        }
    }

    private int[] getStationPosition(FoodType type) {
        switch (type) {
            case BURGER: return burgerPos;
            case FRIES:  return fryPos;
            case DRINK:  return drinkPos;
            default:     return restPos;
        }
    }

    @Override
    public void update() {
        moveTowardsTarget();

        if (currentOrder != null) {
            int[] currentPos = getPos();
            int[] targetPos = getTarget();

            if (currentPos[0] == targetPos[0] && currentPos[1] == targetPos[1]) {
                if (!isWalkingToDesk) {
                    if (cookingTimer > 0) {
                        cookingTimer--;
                    } else {
                        isWalkingToDesk = true;
                        this.setTarget(deskPos);
                    }
                } else {
                    if (itemsToPrepare.isEmpty()) {
4                        Desk.getDesk().addFinishedOrder(currentOrder);
                    }
                    prepareNextItem();
                }
            }
        }
    }
}