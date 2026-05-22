public abstract class WorkStation extends Kitchen implements HasPosition {
    protected int[] pos = new int[2];
    protected int preparationTime;
    protected boolean isBusy;

    public WorkStation(int prepTime, int[] pos) {
        this.preparationTime = prepTime;
        this.pos = pos;
        this.isBusy = false;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        this.isBusy = busy;
    }

    @Override
    public int[] getPos() {
        return pos;
    }

    @Override
    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public abstract void update();
}