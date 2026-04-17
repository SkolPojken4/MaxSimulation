import java.util.ArrayList;

public class FryStation extends WorkStation {
    private int timer = 0;
    private boolean isFrying = false;
    public ArrayList<Fries> readyFries;

    public FryStation() {
        super(200);
        this.readyFries = new ArrayList<>();
    }

    public void startBatch() {
        if (!isFrying) {
            isFrying = true;
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
        if (isFrying) {
            timer--;

            if (timer <= 0) {
                isFrying = false;
                for (int i = 0; i < 10; i++) {
                    readyFries.add(new Fries());
                }
            }
        }
    }
}