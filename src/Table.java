public class Table implements HasPosition {

    private int[] pos = new int[2];
    private int diameter = 80;
    private boolean isAvailable;

    Table(int[] pos){
        this.pos = pos;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int[] getPos() {
        return this.pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int getDiameter() {
        return diameter;
    }

    public int getX() {
        return this.pos[0];
    }

    public int getY() {
        return this.pos[1];
    }

}
