public class OrderScreen implements HasPosition {

    int[] pos;

    public int getX() {return this.pos[0];}

    public int getY() {return this.pos[1];}

    OrderScreen(int[] pos) {
        this.pos = pos;
    }

    public int[] getPos() {
        return this.pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

}