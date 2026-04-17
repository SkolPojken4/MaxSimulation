public class Table implements HasPosition {

    public int[] getPos() {
        return this.pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public int getDiameter() {
        return diameter;
    }

    private int[] pos = new int[2];
    private int diameter = 80;

    Table(int[] pos){
        this.pos = pos;
    }

    public int getX() {
        return this.pos[0];
    }

    public int getY() {
        return this.pos[1];
    }

}
