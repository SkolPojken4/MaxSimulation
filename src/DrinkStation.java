public class DrinkStation extends WorkStation {
    private Chef currentChef = null;
    private int timer = 0;

    public DrinkStation(int[] pos) {
        super(50, pos); // 50 är preparationTime
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