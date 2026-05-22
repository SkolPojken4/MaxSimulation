import java.util.ArrayList;

public class FryStation extends WorkStation {
    private int timer = 0;
    public ArrayList<Fries> readyFries;

    public FryStation(int[] pos) {
        super(200, pos);
        this.readyFries = new ArrayList<>();
    }

    public void startBatch() {
        if (!isBusy) {
            isBusy = true;
            timer = preparationTime;
        }
    }

    public Fries takeFries() {
        if (!readyFries.isEmpty()) {
            return readyFries.remove(0);
        }
        return null;
    }

    @Override
    public void update() {
        if (isBusy) {
            timer--;

            if (timer <= 0) {
                isBusy = false;
                for (int i = 0; i < 10; i++) {
                    readyFries.add(new Fries());
                }
            }
        }
    }
}