public class BurgerStation extends WorkStation {
    private Chef currentChef = null;
    private int timer = 0;

    public BurgerStation(int[] pos) {
        super(100, pos);
    }

    public boolean startPreparing(Chef chef) {
        if (!isBusy) {
            currentChef = chef;
            isBusy = true;
            timer = preparationTime;
            return true;
        }
        return false;
    }

    @Override
    public void update() {
        if (isBusy && currentChef != null) {
            timer--;

            if (timer <= 0) {
                isBusy = false;
                currentChef = null;
            }
        }
    }
}