public abstract class WorkStation extends Kitchen {
    protected int[] pos = new int[2];
    protected int preparationTime;

    public WorkStation(int prepTime) {
        this.preparationTime = prepTime;
    }

    public abstract void update();
}