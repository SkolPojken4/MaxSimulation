public class DrinkStation extends WorkStation {
    private Chef currentChef = null;
    private int timer = 0;

    public DrinkStation() {
        super(50);
    }

    public boolean startPreparing(Chef chef) {
        if (currentChef == null) {
            currentChef = chef;
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
                // Create drink
                // currentChef.receiveItem(new Drink());
                currentChef = null;
            }
        }
    }
}