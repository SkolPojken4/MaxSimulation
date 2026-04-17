public class BurgerStation extends WorkStation {
    private Chef currentChef = null;
    private int timer = 0;

    public BurgerStation() {
        super(100);
    }

    public boolean startPreparing(Chef chef) {
        if (currentChef == null) {
            currentChef = chef; //Check if there is available chef
            timer = preparationTime;
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        if (currentChef != null) {
            timer--;

            if (timer <= 0) {
                // Food done, gove to chef
                // currentChef.receiveItem()
                // currentChef.receiveItem(new Burger());

                currentChef = null;
            }
        }
    }
}